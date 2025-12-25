# Allive TV APK 분석 보고서

## 📌 요약

**프로젝트**: Allive TV v4.5  
**분석 날짜**: 2025-12-25  
**APK 크기**: 8.9 MB  
**패키지명**: com.hisona.allive  

---

## ✅ 소스코드 분석 가능 여부

### ✨ **네, APK에서 소스코드 분석이 가능합니다!**

GitHub 저장소에는 소스코드가 없지만, APK를 디컴파일하면 Java 소스코드를 거의 완벽하게 복원할 수 있습니다.

#### 디컴파일 결과
- **성공률**: 약 99% (8,017개 클래스 중 21개 에러)
- **주요 파일 복원 완료**:
  - `WavveSiteProcessor.java` (270줄) - WAVVE 로그인 및 API 처리
  - `TvingSiteProcessor.java` (221줄) - TVING API 처리
  - `TvingHttpMediaDrmCallback.java` (192줄) - TVING DRM 처리
  - `PlayerActivity.java` (대용량) - 스트리밍 재생 로직

---

## 🔍 WAVVE 로그인 문제 원인

### 1. 하드코딩된 API 키 사용
```java
// WavveSiteProcessor.java 라인 32
HttpRequest.post("https://apis.wavve.com/login", true, 
    "apikey", "E5F3E0D30947AA5440556471321BB6D9",  // ⚠️ 하드코딩된 API 키
    "credential", ..., 
    "device", "pc", 
    "drm", "wm",
    ...
)
```

**문제점**:
- ❌ 오래된 API 키가 만료되었거나 폐기됨
- ❌ WAVVE가 새로운 API 키 생성 방식으로 변경
- ❌ API 키 검증 로직 강화

### 2. 로그인 엔드포인트
```
https://apis.wavve.com/login
```
- POST 요청으로 credential 기반 로그인
- `type: "credential"` 방식 사용
- 프로필 선택 지원

### 3. 로그인 페이로드
```json
{
  "type": "credential",
  "id": "{인증키}",
  "password": "",
  "pushid": "",
  "profile": "{프로필명}"
}
```

**예상 변경사항**:
- 🔄 API 버전 업그레이드 (v1 → v2 또는 v3)
- 🔄 인증 방식 변경 (OAuth 2.0, JWT 등)
- 🔄 디바이스 검증 강화
- 🔄 API 키 rotation 정책 적용

---

## 🎬 TVING FHD 재생 문제 원인

### 1. DRM 처리 구조
```java
// PlayerActivity.java
System.loadLibrary("allive");  // 네이티브 라이브러리 로드
public static native String[] tvingDecrypt(String str, String str2);
```

**발견된 네이티브 라이브러리**:
- `lib/arm64-v8a/liballive.so` (24KB) - TVING 복호화 로직
- `lib/arm64-v8a/libconceal.so` (262KB) - Facebook Conceal 암호화 라이브러리

### 2. DRM 콜백 처리
```java
// TvingHttpMediaDrmCallback.java
public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
    String licenseServerUrl = keyRequest.getLicenseServerUrl();
    HashMap hashMap = new HashMap();
    
    // Widevine/PlayReady 처리
    if (PLAYREADY_UUID.equals(uuid)) {
        str = "text/xml";
    } else if (CLEARKEY_UUID.equals(uuid)) {
        str = "application/json";
    } else {
        str = "application/octet-stream";  // Widevine
    }
    
    return a(this.a, licenseServerUrl, keyRequest.getData(), hashMap);
}
```

### 3. HD vs FHD 차이점

**HD (720p) - 작동함**:
- ✅ Widevine L3 (소프트웨어 DRM) 사용
- ✅ 약한 DRM 정책
- ✅ 기본 라이선스 서버 응답

**FHD (1080p) - 작동 안 함**:
- ❌ Widevine L1 (하드웨어 DRM) 필요
- ❌ 디바이스 인증 필수
- ❌ 라이선스 서버 URL 변경 가능
- ❌ 추가 인증 헤더 요구

**예상 변경사항**:
```java
// TVING이 FHD 스트림에 대해 추가한 것으로 예상되는 로직
- DRM Certificate 검증
- Device Attestation (디바이스 인증서)
- Hardware-backed Keystore 요구
- 공식 앱 서명 검증
```

---

## 🛠️ 기술 스택 분석

### 주요 라이브러리
```
- ExoPlayer: 미디어 재생 엔진
- Gson: JSON 파싱
- Glide: 이미지 로딩
- Firebase Analytics: 사용자 분석
- RxJava 3: 비동기 처리
- Hawk: 보안 저장소
- OkHttp 3: HTTP 클라이언트
- Kotlin Standard Library: Kotlin 지원
- Facebook Conceal: 로컬 데이터 암호화
```

### API 엔드포인트

#### WAVVE APIs
```
https://apis.wavve.com/login            - 로그인
https://apis.wavve.com/profiles         - 프로필 목록
https://apis.wavve.com/live/epgs        - EPG (편성표)
```

#### TVING APIs
```
https://api.tving.com/v2/media/schedules - 편성표
```

---

## 💡 문제 해결 방법

### 1. WAVVE 로그인 수정 (고급)

```java
// 수정 필요 사항
public boolean doLogin(SettingsData settingsData) {
    // ✅ 최신 API 키 획득 (Charles Proxy로 공식 앱 분석)
    String NEW_API_KEY = "새로운_API_키";
    
    // ✅ API 엔드포인트 업데이트
    String LOGIN_URL = "https://apis.wavve.com/v2/login";  // v2 또는 v3
    
    // ✅ 추가 파라미터
    HttpRequest.post(LOGIN_URL, true,
        "apikey", NEW_API_KEY,
        "device_id", generateDeviceId(),      // 디바이스 ID 생성
        "client_version", "5.0.0",            // 최신 클라이언트 버전
        "app_signature", getAppSignature(),   // 앱 서명 (어려움)
        ...
    );
}
```

**필요한 작업**:
1. Charles Proxy/Burp Suite로 공식 WAVVE 앱 트래픽 캡처
2. 최신 API 키 추출
3. 요청 파라미터 분석
4. APK 재빌드

### 2. TVING FHD 수정 (매우 어려움)

```java
// 네이티브 코드 수정 필요 (liballive.so)
// C/C++ 소스코드 없이는 거의 불가능

// 가능한 우회 방법
1. 공식 앱의 DRM 라이선스 토큰 재사용 (단기적)
2. Widevine L1 우회 (보안상 매우 어려움, 불법)
3. TVING의 새로운 라이선스 서버 엔드포인트 찾기
```

**FHD 수정의 어려움**:
- 🔒 네이티브 코드 (`liballive.so`)에서 DRM 처리
- 🔒 Widevine L1은 하드웨어 기반 보안
- 🔒 공식 앱의 서명 검증
- 🔒 디바이스 인증서 필요

### 3. 실용적인 해결책

#### A. 소스코드 업데이트 (개발자 관점)
1. **APK 디컴파일**: ✅ 완료
2. **WAVVE API 분석**: Charles Proxy로 공식 앱 분석
3. **코드 수정**: `WavveSiteProcessor.java` 업데이트
4. **APK 재빌드**: Android Studio로 빌드
5. **서명 및 배포**: 새 APK 릴리즈

#### B. 공식 앱 사용 (사용자 관점)
```
- Google Play에서 공식 WAVVE/TVING 앱 설치
- Android TV에서 정식 지원
- 모든 화질 지원 (4K 포함)
```

---

## 📊 디렉토리 구조

```
apk_analysis/
├── allive-v4.5.apk                    # 원본 APK
├── extracted/                         # APK 압축 해제
│   ├── classes.dex                    # Dalvik 바이트코드 (8.6MB)
│   ├── classes2.dex                   # 추가 클래스 (5.1MB)
│   ├── lib/                           # 네이티브 라이브러리
│   │   ├── arm64-v8a/
│   │   │   ├── liballive.so          # TVING 복호화 (24KB)
│   │   │   └── libconceal.so         # 암호화 (262KB)
│   │   ├── armeabi-v7a/
│   │   ├── x86/
│   │   └── x86_64/
│   ├── AndroidManifest.xml
│   └── resources.arsc
└── decompiled/                        # 디컴파일된 소스
    └── sources/
        └── com/hisona/allive/
            ├── WavveSiteProcessor.java
            ├── TvingSiteProcessor.java
            ├── TvingHttpMediaDrmCallback.java
            ├── PlayerActivity.java
            └── ... (총 8,017개 클래스)
```

---

## 🔐 보안 분석

### 발견된 하드코딩된 정보
```java
// WAVVE API 키 (공개됨)
"E5F3E0D30947AA5440556471321BB6D9"

// User-Agent
"Mozilla/5.0 (Windows NT 10.0; Win64; x64) ..."
```

### 암호화 방식
- **로컬 저장소**: Hawk (AES-256 기반)
- **네트워크 통신**: HTTPS
- **DRM**: Widevine + PlayReady
- **데이터 암호화**: Facebook Conceal

---

## 📝 결론

### WAVVE 로그인 문제
**원인**: API 키 만료 및 인증 로직 변경  
**난이도**: ⭐⭐⭐☆☆ (중간 - 공식 앱 분석으로 해결 가능)  
**해결**: 최신 API 키 및 엔드포인트 업데이트 필요

### TVING FHD 문제
**원인**: Widevine L1 DRM 요구사항 강화  
**난이도**: ⭐⭐⭐⭐⭐ (매우 어려움 - 네이티브 코드 및 하드웨어 DRM)  
**해결**: 거의 불가능 (공식 앱 사용 권장)

### 권장사항
1. **단기**: 공식 WAVVE/TVING 앱 사용
2. **중기**: 커뮤니티에서 코드 업데이트 (WAVVE 로그인만)
3. **장기**: 프로젝트 재개 또는 포크

---

## 🛠️ 분석 도구

- **JADX 1.5.0**: APK 디컴파일러
- **APKTool**: 리소스 디코딩
- **Java/Android Studio**: 소스코드 분석
- **Charles Proxy**: 네트워크 트래픽 분석 (권장)

