# ✅ 정식 WAVVE APK 분석 준비 완료!

## 🎉 현재 상태

### Allive TV 완전 디컴파일 완료!

**Gradle 프로젝트 생성**: ✅ 완료  
**위치**: `/home/user/webapp/apk_analysis/allive_gradle/`  
**상태**: Android Studio에서 바로 열 수 있는 완전한 프로젝트

---

## 📊 디컴파일 결과

### 프로젝트 구조
```
allive_gradle/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/          # 모든 Java 소스 코드
│   │   │   ├── res/           # 모든 리소스 (layout, drawable, etc.)
│   │   │   ├── assets/        # Asset 파일들
│   │   │   └── AndroidManifest.xml  # 완전한 Manifest
│   │   └── test/              # 테스트 코드
│   └── build.gradle           # 앱 레벨 Gradle 설정
├── build.gradle               # 프로젝트 레벨 Gradle
└── settings.gradle            # Gradle 설정
```

### 주요 정보
```
패키지명: com.hisona.allive
버전: 4.5 (versionCode: 30)
Min SDK: 23 (Android 6.0)
Target SDK: 33 (Android 13)
Compile SDK: 30

주요 기능:
- Android TV Leanback UI
- ExoPlayer 미디어 재생
- Firebase Analytics
- Glide 이미지 로딩
- Native 라이브러리 (liballive.so)
```

### 권한
```xml
✅ INTERNET - 네트워크 통신
✅ WAKE_LOCK - 화면 유지
✅ ACCESS_NETWORK_STATE - 네트워크 상태 확인
✅ READ/WRITE_EXTERNAL_STORAGE - 파일 저장
✅ REQUEST_INSTALL_PACKAGES - APK 설치
✅ READ/WRITE_EPG_DATA - TV 편성표
✅ RECORD_AUDIO - 음성 입력 (선택)
```

---

## 🎯 다음 단계: 정식 WAVVE APK 업로드

### 준비 완료된 것
- [x] JADX 디컴파일러 설치
- [x] Allive TV 완전 분석
- [x] 프로젝트 구조 파악
- [x] 통합 전략 수립

### 필요한 것
- [ ] **정식 WAVVE APK 파일**

---

## 📱 정식 WAVVE APK 획득 방법

### 방법 1: Android 기기에서 추출 (권장)
```bash
# ADB 연결 (USB 디버깅 활성화 필요)
adb devices

# WAVVE 앱 설치 확인
adb shell pm list packages | grep wavve

# APK 경로 찾기
adb shell pm path com.contentsmobile.wavve

# APK 추출
adb pull /data/app/com.contentsmobile.wavve-xxxxx/base.apk wavve_official.apk
```

### 방법 2: APK 사이트에서 다운로드
```
- APKPure
- APKMirror
- APKMonk
```

**주의**: 반드시 정식 WAVVE 앱의 최신 버전을 사용하세요!

### 방법 3: 직접 파일 제공
사용자님이 Android TV에서 사용 중인 WAVVE APK 파일을 직접 제공해주시면 됩니다.

---

## 🔬 WAVVE APK 분석 계획

### 업로드 후 즉시 수행할 작업

#### 1. 완전 디컴파일 (5분)
```bash
cd /home/user/webapp/apk_analysis

# Gradle 프로젝트로 익스포트
./jadx/bin/jadx --export-gradle \
                 --deobf \
                 --show-bad-code \
                 --threads-count 4 \
                 -d wavve_official \
                 wavve_official.apk
```

#### 2. 로그인 관련 코드 추출 (10분)
```bash
# 로그인 관련 클래스 검색
find wavve_official -name "*Login*" -o -name "*Auth*" -o -name "*Credential*"

# SNS SDK 설정 찾기
grep -r "kakao" wavve_official/
grep -r "naver" wavve_official/
grep -r "google" wavve_official/
```

#### 3. API 클라이언트 분석 (10분)
```bash
# Retrofit/OkHttp 설정 찾기
find wavve_official -name "*ApiClient*" -o -name "*ApiService*"
find wavve_official -name "*Interceptor*"

# Base URL 및 엔드포인트 확인
grep -r "apis.wavve.com" wavve_official/
```

#### 4. 통합 계획 수립 (15분)
- Allive TV에 필요한 클래스 목록 작성
- Dependencies 확인 및 추가 계획
- 패키지명 변경 전략 수립

---

## 🔧 통합 전략

### Phase 1: 로그인 모듈 추출 (목표: 1일)
```
1. WAVVE 앱에서 로그인 관련 클래스 복사
   - LoginActivity
   - SnsLoginManager (카카오, 네이버, 구글)
   - CredentialManager
   - TokenManager

2. Allive TV 프로젝트에 통합
   - 패키지명 변경: com.contentsmobile.wavve → com.hisona.allive.wavve
   - AndroidManifest.xml 권한 추가
   - build.gradle에 SNS SDK dependencies 추가
```

### Phase 2: API 클라이언트 통합 (목표: 1일)
```
1. WAVVE API 클라이언트 복사
   - ApiClient
   - ApiService (Retrofit interface)
   - AuthInterceptor

2. WavveSiteProcessor 수정
   - 새로운 API 클라이언트 사용
   - Credential 자동 획득 및 저장
```

### Phase 3: 테스트 및 빌드 (목표: 1일)
```
1. Android Studio에서 빌드
2. 로그인 기능 테스트
3. 실시간 TV 시청 테스트
4. APK 서명 및 배포
```

---

## 📝 필요한 정보 (WAVVE APK에서 추출 예정)

### 1. SNS SDK 설정
```xml
<!-- AndroidManifest.xml 또는 strings.xml에서 -->
<string name="kakao_app_key">YOUR_KAKAO_KEY</string>
<string name="naver_client_id">YOUR_NAVER_ID</string>
<string name="naver_client_secret">YOUR_NAVER_SECRET</string>
<string name="google_client_id">YOUR_GOOGLE_ID</string>
```

### 2. API 엔드포인트
```java
// ApiClient.java
public static final String BASE_URL = "https://apis.wavve.com/";
public static final String LOGIN_ENDPOINT = "/auth/login";
public static final String TOKEN_REFRESH = "/auth/refresh";
```

### 3. Credential 생성 로직
```java
// CredentialManager.java
public String generateCredential(String oauthToken, String provider) {
    // SNS OAuth 토큰 → WAVVE Credential 변환
    // ...
}
```

---

## ✅ 통합 후 기대 효과

```
✅ 정식 WAVVE 앱과 동일한 로그인 방식
✅ 카카오/네이버/구글로 간편 로그인
✅ Credential 자동 획득 및 갱신
✅ 실시간 TV 정상 시청 가능
✅ API 변경에도 안정적으로 작동
```

---

## 🚀 APK 업로드 방법

### 현재 시스템에서 APK 업로드하기

**대기 중**: 사용자님이 WAVVE APK를 제공해주시면 즉시 분석을 시작합니다!

**저장 위치**: `/home/user/webapp/apk_analysis/wavve_official.apk`

---

## 💡 예상 시간표

| 작업 | 예상 시간 | 상태 |
|------|----------|------|
| Allive TV 디컴파일 | 30분 | ✅ 완료 |
| WAVVE APK 업로드 | - | ⏳ 대기 |
| WAVVE APK 디컴파일 | 5분 | 준비 완료 |
| 로그인 코드 추출 | 10분 | 준비 완료 |
| API 클라이언트 분석 | 10분 | 준비 완료 |
| 통합 작업 | 2-3시간 | 준비 완료 |
| 테스트 및 빌드 | 1-2시간 | 준비 완료 |
| **총 예상 시간** | **4-6시간** | 준비 완료 |

---

## 📞 다음 단계

**사용자님께서 정식 WAVVE APK를 업로드해주시면, 즉시 다음 작업을 진행합니다:**

1. ✅ APK 디컴파일
2. ✅ 로그인 메커니즘 완전 분석
3. ✅ Allive TV에 통합
4. ✅ 테스트 및 APK 빌드
5. ✅ 완성된 앱 제공

---

**준비 완료!** 🎯  
WAVVE APK 파일만 제공해주시면 바로 작업을 시작할 수 있습니다!

