# 🏗️ Allive TV Revival - 빌드 가이드

## 📋 개요
WAVVE 로그인 문제를 수정한 Allive TV v4.5+ 빌드 가이드입니다.

## ✅ 수정 완료 사항
- ✅ **WAVVE 로그인 URL 수정** (SnsLoginDialogFragment.java)
- ✅ **WAVVE 쿠키 도메인 수정** (C1091y.java)
- ✅ **Gradle 프로젝트 구성 완료**

## 🛠️ 빌드 환경 요구사항

### 필수 도구
- **Java JDK**: 11 이상
- **Android SDK**: API 30 (Android 11)
- **Gradle**: 6.7.1 이상
- **Android Studio**: Arctic Fox (2020.3.1) 이상 (선택사항)

### SDK 설정
```bash
# Android SDK 경로 설정 (Linux/Mac)
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools

# SDK 설치 (sdkmanager 사용)
sdkmanager "platforms;android-30" "build-tools;30.0.2"
```

## 🚀 빌드 방법

### 방법 1: Gradle 커맨드라인 빌드 (추천)

```bash
# 1. 프로젝트 디렉토리로 이동
cd /home/user/webapp/apk_analysis/complete_decompile

# 2. Gradle Wrapper 실행 권한 부여
chmod +x gradlew

# 3. 의존성 다운로드 및 빌드
./gradlew assembleRelease

# 4. 생성된 APK 확인
ls -lh app/build/outputs/apk/release/
```

**예상 출력:**
```
app-release-unsigned.apk  (약 8-10MB)
```

### 방법 2: Android Studio 빌드

1. **Android Studio 실행**
2. **Open an Existing Project** 선택
3. `/home/user/webapp/apk_analysis/complete_decompile` 폴더 선택
4. **Build → Build Bundle(s) / APK(s) → Build APK(s)** 클릭
5. 빌드 완료 후 APK 위치 확인

### 방법 3: 디버그 빌드 (개발/테스트용)

```bash
cd /home/user/webapp/apk_analysis/complete_decompile
./gradlew assembleDebug

# 생성된 APK
ls -lh app/build/outputs/apk/debug/app-debug.apk
```

## 🔐 APK 서명 (설치용)

생성된 APK는 **unsigned**이므로 Android TV에 설치하려면 서명이 필요합니다.

### Keystore 생성
```bash
keytool -genkey -v -keystore allive-release-key.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias allive-key \
  -dname "CN=Allive TV, OU=Revival Project, O=Allive, L=Seoul, ST=Seoul, C=KR" \
  -storepass allive2025 -keypass allive2025
```

### APK 서명
```bash
# 1. zipalign (정렬)
$ANDROID_HOME/build-tools/30.0.2/zipalign -v -p 4 \
  app/build/outputs/apk/release/app-release-unsigned.apk \
  app/build/outputs/apk/release/app-release-unsigned-aligned.apk

# 2. apksigner (서명)
$ANDROID_HOME/build-tools/30.0.2/apksigner sign \
  --ks allive-release-key.jks \
  --ks-key-alias allive-key \
  --ks-pass pass:allive2025 \
  --key-pass pass:allive2025 \
  --out app/build/outputs/apk/release/allive-v4.5-fixed.apk \
  app/build/outputs/apk/release/app-release-unsigned-aligned.apk

# 3. 서명 확인
$ANDROID_HOME/build-tools/30.0.2/apksigner verify \
  app/build/outputs/apk/release/allive-v4.5-fixed.apk
```

## 📱 설치 방법

### ADB를 통한 설치
```bash
# Android TV 연결 후
adb connect <Android_TV_IP>:5555

# 기존 앱 제거 (선택사항)
adb uninstall com.hisona.allive

# 새 APK 설치
adb install -r app/build/outputs/apk/release/allive-v4.5-fixed.apk

# 앱 실행
adb shell am start -n com.hisona.allive/.MainActivity
```

### USB 드라이브를 통한 설치
1. APK를 USB 드라이브에 복사
2. Android TV에 USB 삽입
3. 파일 관리자 앱으로 APK 설치
4. **알 수 없는 출처 허용** 활성화 필요

## 🧪 테스트 체크리스트

### WAVVE 로그인 테스트
- [ ] 설정 → SNS 로그인 실행
- [ ] WAVVE 로그인 페이지 표시 확인 (이전: TVING 페이지)
- [ ] 로그인 후 쿠키 정상 획득 확인
- [ ] WAVVE 채널 목록 로드 확인
- [ ] 실시간 스트리밍 재생 확인

### TVING 테스트
- [ ] TVING 로그인 정상 작동 확인
- [ ] HD 채널 재생 확인 (정상 작동)
- [ ] FHD 채널 재생 확인 (여전히 문제 가능)

## 🐛 문제 해결 (Troubleshooting)

### 빌드 오류: SDK not found
```bash
# local.properties 파일 생성
echo "sdk.dir=/path/to/Android/Sdk" > local.properties
```

### 빌드 오류: Gradle version mismatch
```bash
# Gradle Wrapper 버전 확인
./gradlew --version

# 필요 시 Gradle 업그레이드
./gradlew wrapper --gradle-version=6.7.1
```

### 의존성 다운로드 실패
```bash
# Gradle 캐시 클리어
./gradlew clean --refresh-dependencies
```

### 설치 오류: INSTALL_FAILED_UPDATE_INCOMPATIBLE
```bash
# 기존 앱 완전히 제거 후 재설치
adb uninstall com.hisona.allive
adb install app/build/outputs/apk/release/allive-v4.5-fixed.apk
```

## 📊 변경사항 요약

| 파일 | 라인 | 변경 전 | 변경 후 |
|-----|------|---------|---------|
| SnsLoginDialogFragment.java | 65 | `https://user.tving.com/oauth/...` | `https://www.wavve.com/member/login` |
| C1091y.java | 24 | `uri.contains("https://www.tving.com")` | `uri.contains("https://www.wavve.com")` |
| C1091y.java | 25 | `getCookie("https://www.tving.com/")` | `getCookie("https://www.wavve.com/")` |

## 🔮 다음 단계 (향후 개선)

### 우선순위 높음
- [ ] WAVVE API credential 자동 갱신 로직 추가
- [ ] 로그인 에러 핸들링 개선
- [ ] 버전 번호 업데이트 (4.5 → 4.6)

### 우선순위 중간
- [ ] TVING FHD DRM 문제 분석 (정식 APK 필요)
- [ ] UI/UX 개선
- [ ] 안정성 테스트

### 우선순위 낮음
- [ ] 코드 난독화 (ProGuard)
- [ ] 자동 업데이트 기능 추가

## 📞 지원 및 문의

- **GitHub Issues**: https://github.com/studphc/alliveTV/issues
- **프로젝트 브랜치**: `revival-project`

---

**참고**: 이 프로젝트는 WAVVE/TVING의 공식 지원을 받지 않는 비공식 애플리케이션입니다. 
정식 유료 구독이 필요하며, 서비스 약관을 준수해야 합니다.
