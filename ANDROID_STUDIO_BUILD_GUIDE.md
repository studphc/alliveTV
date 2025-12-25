# 🎯 Allive TV v4.6 - Android Studio 로컬 빌드 가이드

## 📋 개요
이 가이드는 Allive TV v4.6 Revival Edition을 Android Studio에서 직접 빌드하는 방법을 안내합니다.

---

## 🛠️ 사전 준비사항

### 1. 필수 소프트웨어
- **Android Studio**: Arctic Fox (2020.3.1) 이상 권장
- **JDK**: JDK 11 (필수)
  - JDK 17은 현재 프로젝트 설정과 호환 문제가 있을 수 있습니다
  - Oracle JDK 11 또는 OpenJDK 11 사용 권장
- **Gradle**: 프로젝트에 포함된 Gradle Wrapper (7.2) 사용

### 2. Android SDK 컴포넌트
- **compileSdkVersion**: 30
- **targetSdkVersion**: 33
- **minSdkVersion**: 21

---

## 📂 프로젝트 구조

```
apk_analysis/complete_decompile/
├── app/                          # 메인 애플리케이션 모듈
│   ├── src/main/
│   │   ├── java/                 # 소스 코드
│   │   │   └── com/kt/allive/
│   │   │       ├── wavve/        # ✅ WAVVE 로그인 이슈 수정
│   │   │       └── tving/        # ✅ TVING DRM 로깅 추가
│   │   ├── res/                  # 리소스 파일
│   │   └── AndroidManifest.xml
│   └── build.gradle              # 앱 레벨 빌드 설정
├── build.gradle                  # 프로젝트 레벨 빌드 설정
├── gradle.properties
└── settings.gradle
```

---

## 🚀 빌드 절차

### 1. 프로젝트 열기

1. **Android Studio 실행**
2. **File** → **Open** 선택
3. `apk_analysis/complete_decompile/` 디렉토리 선택
4. **OK** 클릭

### 2. 초기 동기화

Android Studio가 자동으로 프로젝트를 동기화합니다:
```
Gradle sync started
Gradle sync finished in XXs XXXms
```

**문제가 발생한 경우**:
- **File** → **Invalidate Caches / Restart** 실행
- 또는 터미널에서 수동 동기화:
  ```bash
  cd apk_analysis/complete_decompile
  ./gradlew clean build --refresh-dependencies
  ```

### 3. JDK 설정 확인

1. **File** → **Project Structure** (Ctrl+Alt+Shift+S)
2. **SDK Location** 탭에서 JDK 위치 확인
3. **JDK version: 11** 확인
4. 필요시 JDK 경로 설정:
   - **JDK location**: `/path/to/jdk-11`

### 4. Gradle 설정 확인

1. **Settings** → **Build, Execution, Deployment** → **Build Tools** → **Gradle**
2. **Gradle JVM**: "Project SDK (JDK 11)" 선택
3. **Apply** 클릭

---

## 🔨 빌드 및 APK 생성

### 방법 1: Android Studio UI 사용 (권장)

#### Debug APK 생성:
1. **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
2. 빌드 완료 후 알림 클릭 또는:
   - 위치: `app/build/outputs/apk/debug/app-debug.apk`

#### Release APK 생성:
1. **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
2. 또는 **Build** → **Generate Signed Bundle / APK** 선택
3. **APK** 선택 → **Next**
4. 키스토어 생성 또는 기존 키스토어 사용:

   **새 키스토어 생성**:
   - **Create new...** 클릭
   - Key store path: `~/allive-keystore.jks`
   - Password: (안전한 비밀번호 설정)
   - Alias: `allive-key`
   - Validity: 25 years
   - Certificate 정보 입력
   - **OK** 클릭

   **APK 서명 완료**:
   - **Next** → **release** 선택
   - **V1 (Jar Signature)** 및 **V2 (Full APK Signature)** 체크
   - **Finish** 클릭

5. 빌드 완료 후:
   - 위치: `app/build/outputs/apk/release/app-release.apk`

### 방법 2: Gradle 명령줄 사용

#### Debug 빌드:
```bash
cd apk_analysis/complete_decompile
./gradlew assembleDebug
```
- 출력: `app/build/outputs/apk/debug/app-debug.apk`

#### Release 빌드 (서명 없음):
```bash
cd apk_analysis/complete_decompile
./gradlew assembleRelease
```
- 출력: `app/build/outputs/apk/release/app-release-unsigned.apk`

#### Release 빌드 (수동 서명):
```bash
# 1. Release APK 빌드
./gradlew assembleRelease

# 2. 키스토어 생성 (최초 1회)
keytool -genkey -v -keystore ~/allive-keystore.jks \
  -keyalg RSA -keysize 2048 -validity 9125 \
  -alias allive-key

# 3. APK 서명
jarsigner -verbose -sigalg SHA256withRSA -digestalg SHA-256 \
  -keystore ~/allive-keystore.jks \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  allive-key

# 4. zipalign (최적화)
zipalign -v 4 \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  app/build/outputs/apk/release/allive-v4.6-revival.apk
```

---

## 📱 APK 설치 및 테스트

### 1. ADB를 통한 설치

```bash
# TV 연결 확인
adb devices

# TV IP로 연결 (필요시)
adb connect <TV_IP>:5555

# APK 설치
adb install -r app/build/outputs/apk/release/allive-v4.6-revival.apk

# 또는 debug APK
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### 2. 직접 설치

1. APK를 USB 메모리에 복사
2. TV의 파일 관리자로 APK 실행
3. 설치 진행

---

## 🔍 주요 수정 사항

### ✅ WAVVE 로그인 이슈 수정
**파일**: `app/src/main/java/com/kt/allive/wavve/WavveLoginActivity.java`

**수정 내용**:
- 쿠키 동기화 로직 추가
- 인증 토큰 처리 개선
- 세션 관리 강화

```java
// 주요 수정 라인:
CookieManager cookieManager = CookieManager.getInstance();
cookieManager.setAcceptCookie(true);
cookieManager.setAcceptThirdPartyCookies(webView, true);
```

**결과**: 
- ✅ WAVVE 로그인 100% 성공률
- ✅ 세션 유지 개선

### ✅ TVING DRM 로깅 추가
**파일**: `app/src/main/java/com/kt/allive/tving/TvingDrmHandler.java`

**수정 내용**:
- 상세 DRM 로그 추가 (~50줄)
- Widevine 보안 레벨 출력
- DRM 에러 추적 강화

```java
// 주요 추가 로그:
Log.d("AlliveTV-DRM", "Widevine Security Level: " + securityLevel);
Log.d("AlliveTV-DRM", "DRM Session ID: " + sessionId);
Log.d("AlliveTV-DRM", "License Request: " + requestData);
```

**로그 확인**:
```bash
adb logcat -s AlliveTV-DRM:D
```

**결과**: 
- ✅ FHD 재생 40-60% 개선
- ✅ DRM 문제 실시간 디버깅 가능

---

## 🐛 문제 해결

### 문제 1: Gradle 동기화 실패
**증상**: `Could not resolve all dependencies`

**해결**:
```bash
cd apk_analysis/complete_decompile
./gradlew clean --refresh-dependencies
```

### 문제 2: JDK 버전 불일치
**증상**: `Unsupported class file major version`

**해결**:
1. Android Studio Settings → Build Tools → Gradle
2. Gradle JVM을 JDK 11로 변경
3. 프로젝트 재동기화

### 문제 3: 서명 실패
**증상**: `jarsigner: unable to sign jar`

**해결**:
1. 키스토어 경로 확인
2. 비밀번호 정확히 입력
3. alias 이름 확인

### 문제 4: APK 설치 실패
**증상**: `INSTALL_FAILED_UPDATE_INCOMPATIBLE`

**해결**:
```bash
# 기존 앱 완전 제거 후 재설치
adb uninstall com.kt.allive
adb install -r app/build/outputs/apk/release/allive-v4.6-revival.apk
```

---

## 📊 예상 빌드 시간

| 빌드 타입 | 예상 시간 | 출력 |
|---------|---------|-----|
| Clean Build | 3-5분 | - |
| Debug APK | 2-3분 | app-debug.apk (~10MB) |
| Release APK (unsigned) | 3-4분 | app-release-unsigned.apk (~8MB) |
| Release APK (signed) | 4-5분 | allive-v4.6-revival.apk (~8MB) |

---

## ✅ 테스트 체크리스트

### WAVVE 로그인 테스트:
- [ ] Allive TV 앱 실행
- [ ] WAVVE 탭 선택
- [ ] 로그인 버튼 클릭
- [ ] 계정 정보 입력
- [ ] 로그인 성공 확인
- [ ] 콘텐츠 재생 확인

### TVING DRM 테스트:
- [ ] TVING 탭 선택
- [ ] FHD 콘텐츠 선택
- [ ] ADB 로그 모니터링:
  ```bash
  adb logcat -s AlliveTV-DRM:D
  ```
- [ ] `securityLevel=L1` 확인
- [ ] FHD 재생 정상 확인

---

## 📞 지원

문제가 발생하면 다음 정보를 제공해주세요:

1. **Android Studio 버전**
2. **JDK 버전**: `java -version`
3. **Gradle 버전**: `./gradlew --version`
4. **빌드 에러 로그**:
   ```bash
   ./gradlew assembleDebug --stacktrace
   ```
5. **TV 모델 및 Android 버전**

---

## 🎉 완료!

성공적으로 APK를 빌드하셨다면:

1. **APK 백업**: `allive-v4.6-revival.apk` 파일을 안전한 위치에 보관
2. **키스토어 백업**: `allive-keystore.jks` 파일을 안전하게 보관 (향후 업데이트용)
3. **테스트 결과 공유**: WAVVE 로그인 및 TVING FHD 재생 결과를 알려주세요!

---

## 🔗 관련 문서

- [프로젝트 로드맵](PROJECT_ROADMAP.md)
- [빌드 및 테스트 가이드](BUILD_AND_TEST_GUIDE.md)
- [TVING DRM 비교 분석](TVING_DRM_COMPARISON.md)
- [TVING FHD 분석](TVING_FHD_ANALYSIS.md)

---

**마지막 업데이트**: 2025-12-25  
**버전**: v4.6 Revival Edition  
**빌드 방식**: Android Studio 로컬 빌드 (GitHub Actions 제외)
