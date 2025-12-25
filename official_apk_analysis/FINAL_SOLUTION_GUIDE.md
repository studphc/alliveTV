# Allive TV 문제 해결 가이드

**작성일:** 2025-12-25  
**대상 앱:** Allive TV v4.5  
**문제:** WAVVE 로그인 실패, TVING FHD 재생 불가

---

## 📋 목차

1. [현재 상황 요약](#현재-상황-요약)
2. [WAVVE 로그인 문제 해결](#wavve-로그인-문제-해결)
3. [TVING FHD 문제 분석](#tving-fhd-문제-분석)
4. [코드 수정 가이드](#코드-수정-가이드)
5. [빌드 및 배포](#빌드-및-배포)

---

## 현재 상황 요약

### ✅ 완료된 분석

1. **Allive TV v4.5 APK** - 완전 디컴파일 완료 (8,017 클래스)
2. **WAVVE Official v7.2.20** - 완전 디컴파일 완료 (10,964 클래스)
3. **TVING Official v25.51.01** - 완전 디컴파일 완료 (8,679 클래스)

### ❌ 발견된 문제

#### WAVVE:
- ❌ 만료된 API 키 사용
- ❌ SnsLoginDialogFragment에서 TVING URL 로드 (버그)
- ❌ WebViewClient가 TVING 도메인에서 쿠키 추출 (버그)

#### TVING:
- ❌ FHD 스트림은 Widevine L1 (하드웨어 DRM) 필요
- ✅ HD 스트림은 Widevine L3 (소프트웨어 DRM)로 정상 작동
- ❌ 유료 콘텐츠 인증 로직 부족

---

## WAVVE 로그인 문제 해결

### 🎯 핵심 원인

**정식 WAVVE 앱 (v7.2.20) 분석 결과:**

#### 1. API 키 변경
```java
// Allive TV (OLD)
VALUE_APIKEY = "E5F3E0D30947AA5440556471321BB6D9"

// WAVVE Official (NEW)
VALUE_APIKEY = "6A87455D54481A536DFB8AD397C5EC4D"
```

#### 2. 잘못된 로그인 URL
```java
// Allive TV의 SnsLoginDialogFragment.java (라인 65) - 버그!
webView.loadUrl("https://user.tving.com/oauth/oauthLogin.tving?...");  // ❌ TVING URL!

// 올바른 URL (WAVVE Official)
URL_LOGIN_LANDING = "https://member.wavve.com/tv/signin";  // ✅ WAVVE URL
```

#### 3. 잘못된 쿠키 추출 도메인
```java
// Allive TV의 C1091y.java (라인 24-25) - 버그!
if (url.contains("https://www.tving.com/")) {
    String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
}

// 올바른 코드 (WAVVE)
if (url.contains("https://www.wavve.com/")) {
    String cookie = CookieManager.getInstance().getCookie("https://www.wavve.com/");
}
```

### ✅ 해결 방법

**필요한 수정:** 3개 파일, 예상 소요 시간 10-30분

---

## 코드 수정 가이드

### 📁 파일 위치

```
apk_analysis/complete_decompile/app/src/main/java/com/hisona/allive/
├── WavveSiteProcessor.java         # API 키 수정
├── SnsLoginDialogFragment.java     # 로그인 URL 수정
└── C1091y.java                      # WebViewClient 쿠키 도메인 수정
```

### 1️⃣ WavveSiteProcessor.java

**파일:** `/home/user/webapp/apk_analysis/complete_decompile/app/src/main/java/com/hisona/allive/WavveSiteProcessor.java`

**찾기 (FIND):**
```java
"E5F3E0D30947AA5440556471321BB6D9"
```

**바꾸기 (REPLACE):**
```java
"6A87455D54481A536DFB8AD397C5EC4D"
```

**참고:** 파일 내 여러 곳에서 사용될 수 있으니 모두 교체하세요.

---

### 2️⃣ SnsLoginDialogFragment.java

**파일:** `/home/user/webapp/apk_analysis/complete_decompile/app/src/main/java/com/hisona/allive/SnsLoginDialogFragment.java`

**라인 65 근처 찾기:**
```java
this.f2663P.loadUrl("https://user.tving.com/oauth/oauthLogin.tving?target=naver&from=pc&rtUrl=https://www.tving.com/main.do?retRef=Y&source=https://user.tving.com/&csite=&isAuto=false");
```

**바꾸기:**
```java
this.f2663P.loadUrl("https://member.wavve.com/tv/signin");
```

---

### 3️⃣ C1091y.java (WebViewClient)

**파일:** `/home/user/webapp/apk_analysis/complete_decompile/app/src/main/java/com/hisona/allive/C1091y.java`

**라인 24-25 근처 찾기:**
```java
if (str.contains("https://www.tving.com/")) {
    String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
```

**바꾸기:**
```java
if (str.contains("https://www.wavve.com/")) {
    String cookie = CookieManager.getInstance().getCookie("https://www.wavve.com/");
```

**추가 작업:**
- 쿠키에서 `credential` 값을 추출하여 저장
- `WavveSiteProcessor.mAuthKey`에 credential 저장

---

## 빌드 및 배포

### 🔨 빌드 단계

```bash
cd /home/user/webapp/apk_analysis/complete_decompile

# 1. Gradle Wrapper 권한 부여
chmod +x gradlew

# 2. Release APK 빌드
./gradlew assembleRelease

# 3. 빌드된 APK 위치
# app/build/outputs/apk/release/app-release-unsigned.apk
```

### 🔑 APK 서명 (필수)

```bash
# keystore 생성 (처음 한 번만)
keytool -genkey -v -keystore allive-release-key.keystore \
  -alias allive -keyalg RSA -keysize 2048 -validity 10000

# APK 서명
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 \
  -keystore allive-release-key.keystore \
  app/build/outputs/apk/release/app-release-unsigned.apk allive

# Zipalign (최적화)
zipalign -v 4 app/build/outputs/apk/release/app-release-unsigned.apk \
  allive-v4.5-fixed.apk
```

### 📱 설치

```bash
# ADB를 통한 설치
adb install -r allive-v4.5-fixed.apk

# 또는 USB 드라이브에 복사하여 Android TV에서 직접 설치
```

---

## TVING FHD 문제 분석

### ❌ FHD 재생 불가 원인

#### 1. DRM 보안 레벨 차이
```
HD (720p)  → Widevine L3 (소프트웨어 DRM) ✅ 작동
FHD (1080p) → Widevine L1 (하드웨어 DRM) ❌ 작동 안 함
```

#### 2. Widevine L1 요구사항
- ✅ 하드웨어 보안 모듈 (Trusted Execution Environment)
- ✅ 장치 인증서 (Device Certificate)
- ✅ 공식 앱 서명 (App Signature)
- ✅ Google PlayReady 라이선스

#### 3. 네이티브 라이브러리
```
Allive TV: liballive.so, libconceal.so
TVING Official: 웹뷰 기반, DRM 로직은 웹에서 처리
```

### 🤔 해결 가능성

**난이도: ⭐⭐⭐⭐⭐ (거의 불가능)**

**이유:**
1. 하드웨어 DRM 우회는 사실상 불가능
2. TVING 서버에서 장치 인증서 검증
3. 공식 앱 서명 필요
4. Google Play Integrity API 검증

**권장 해결책:**
- ✅ 공식 TVING 앱 사용 (FHD 시청)
- ✅ Allive TV는 HD 시청 전용

---

## 🧪 테스트 체크리스트

### WAVVE 로그인 테스트
- [ ] 앱 실행
- [ ] WAVVE 채널 선택
- [ ] 로그인 버튼 클릭
- [ ] WebView에서 https://member.wavve.com/tv/signin 로드 확인
- [ ] SNS 로그인 (네이버, 카카오, 구글)
- [ ] 로그인 성공 후 채널 재생 확인

### WAVVE API 테스트 (선택 사항)
```bash
# credential 추출 (브라우저 DevTools → Application → Cookies)
YOUR_CREDENTIAL="<웹에서_추출한_credential>"

# API 호출 테스트
curl "https://apis.wavve.com/profiles?apikey=6A87455D54481A536DFB8AD397C5EC4D&credential=${YOUR_CREDENTIAL}&device=ott_skya&partner=pooq&region=kor&targetage=all"
```

---

## 📊 예상 성공률

| 문제 | 해결 가능성 | 난이도 | 예상 소요 시간 |
|------|------------|--------|--------------|
| WAVVE 로그인 | ✅ 95% | ⭐⭐☆☆☆ | 30-60분 |
| TVING FHD | ❌ 5% | ⭐⭐⭐⭐⭐ | 불가능 |
| TVING HD | ✅ 100% | ⭐☆☆☆☆ | 이미 작동 중 |

---

## 🎯 최종 결론

### ✅ 즉시 실행 가능한 해결책

**WAVVE 로그인 복구:**
1. 3개 파일 수정 (API 키, URL, 쿠키 도메인)
2. APK 리빌드
3. 설치 및 테스트

**예상 결과:** ✅ WAVVE 로그인 성공, 실시간 TV 시청 가능

### ❌ 해결 불가능한 문제

**TVING FHD:**
- Widevine L1 (하드웨어 DRM) 필요
- 공식 앱만 가능
- **대안:** 공식 TVING 앱 사용

---

## 📞 지원

문제가 발생하면:
1. GitHub Issues: https://github.com/studphc/alliveTV/issues
2. 로그 수집: `adb logcat | grep -i allive`
3. 상세 오류 메시지 첨부

---

**작성:** Claude AI Developer Assistant  
**버전:** 1.0  
**최종 업데이트:** 2025-12-25
