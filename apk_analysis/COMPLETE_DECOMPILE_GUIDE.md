# 🔬 완전한 APK 디컴파일 가이드

## 🎯 목표
정식 WAVVE 앱의 로그인 메커니즘을 완전히 추출하여 Allive TV에 통합

---

## 📋 필요한 작업

### 1. Allive TV 완전 디컴파일 (현재 진행)
- [x] 기본 디컴파일 완료 (99%)
- [ ] 전체 리소스 추출 (AndroidManifest.xml, layouts, etc.)
- [ ] Gradle 프로젝트로 익스포트
- [ ] 네이티브 라이브러리 분석 (liballive.so)

### 2. 정식 WAVVE 앱 디컴파일 (준비 중)
- [ ] 정식 WAVVE APK 업로드
- [ ] 완전 디컴파일 (소스 + 리소스)
- [ ] 로그인 관련 코드 추출
  - SNS 로그인 (카카오, 네이버, 구글)
  - Credential 생성 로직
  - 토큰 저장 및 갱신 메커니즘
- [ ] API 호출 방식 분석

### 3. 통합 작업
- [ ] WAVVE 로그인 모듈을 Allive TV에 이식
- [ ] Credential 획득 자동화
- [ ] 앱 재빌드 및 테스트

---

## 🛠️ 완전 디컴파일 명령어

### Option 1: Gradle 프로젝트로 익스포트 (권장)
```bash
jadx --export-gradle \
     --deobf \
     --show-bad-code \
     --no-debug-info \
     --threads-count 4 \
     -d allive_complete \
     allive-v4.5.apk
```

**장점**:
- Android Studio에서 바로 열 수 있음
- build.gradle 파일 자동 생성
- 전체 프로젝트 구조 복원
- 바로 빌드 가능 (일부 수정 필요)

### Option 2: 전체 소스 + 리소스 디컴파일
```bash
jadx --deobf \
     --show-bad-code \
     --add-debug-lines \
     --no-inline-anonymous \
     --threads-count 4 \
     -d allive_full \
     allive-v4.5.apk
```

**장점**:
- 모든 코드 라인에 디버그 정보 추가
- Anonymous 클래스 인라인 안 함 (가독성 향상)
- 난독화 해제 적용

### Option 3: 리소스만 추출
```bash
# APKTool 사용 (더 정확한 리소스 추출)
apktool d allive-v4.5.apk -o allive_resources -f
```

---

## 📱 정식 WAVVE 앱 분석 계획

### 파일 업로드 방법
```bash
# 방법 1: 직접 업로드
# 사용자가 APK 파일을 제공하면 다음 경로에 저장:
/home/user/webapp/apk_analysis/wavve_official.apk

# 방법 2: ADB로 추출 (Android 기기에서)
adb pull /data/app/com.contentsmobile.wavve/base.apk wavve_official.apk
```

### 분석 대상

#### 1. 로그인 관련 클래스
```java
// 예상되는 주요 클래스들
com.contentsmobile.wavve.auth.LoginActivity
com.contentsmobile.wavve.auth.SnsLoginManager
com.contentsmobile.wavve.auth.KakaoLoginHandler
com.contentsmobile.wavve.auth.NaverLoginHandler
com.contentsmobile.wavve.auth.GoogleLoginHandler
com.contentsmobile.wavve.network.ApiClient
com.contentsmobile.wavve.network.AuthInterceptor
```

#### 2. API 통신 코드
```java
// Retrofit/OkHttp 설정
com.contentsmobile.wavve.network.RetrofitBuilder
com.contentsmobile.wavve.network.ApiService
com.contentsmobile.wavve.network.interceptor.*

// 인증 토큰 관리
com.contentsmobile.wavve.auth.TokenManager
com.contentsmobile.wavve.storage.SecureStorage
```

#### 3. Credential 생성 로직
```java
// 토큰 변환 및 저장
com.contentsmobile.wavve.auth.CredentialGenerator
com.contentsmobile.wavve.auth.SessionManager
```

---

## 🔍 추출해야 할 핵심 정보

### 1. SNS 로그인 설정
```
- 카카오 앱 키 (Native App Key)
- 네이버 Client ID/Secret
- 구글 OAuth Client ID
- Redirect URI
```

### 2. API 엔드포인트
```
- 로그인: POST /auth/login
- 토큰 갱신: POST /auth/refresh
- SNS 연동: POST /auth/sns/{provider}
```

### 3. 인증 플로우
```
1. SNS 로그인 → OAuth 토큰 획득
2. OAuth 토큰 → WAVVE API 호출
3. WAVVE 서버 → Credential 발급
4. Credential 저장 (SharedPreferences/Hawk)
5. 모든 API 호출에 Credential 사용
```

---

## 💻 디컴파일 실행

### Step 1: Allive TV 완전 디컴파일
```bash
cd /home/user/webapp/apk_analysis

# Gradle 프로젝트로 익스포트
./jadx/bin/jadx --export-gradle \
                 --deobf \
                 --show-bad-code \
                 --threads-count 4 \
                 -d allive_gradle \
                 allive-v4.5.apk

# 결과: allive_gradle/ 디렉토리에 완전한 Android 프로젝트 생성
```

### Step 2: 정식 WAVVE APK 업로드 대기
```bash
# 사용자가 APK를 업로드하면:
# /home/user/webapp/apk_analysis/wavve_official.apk

# 즉시 디컴파일:
./jadx/bin/jadx --export-gradle \
                 --deobf \
                 --show-bad-code \
                 --threads-count 4 \
                 -d wavve_official_gradle \
                 wavve_official.apk
```

---

## 🔧 통합 전략

### 방법 1: 로그인 모듈만 이식 (권장)
```
1. WAVVE 앱에서 로그인 관련 클래스만 추출
2. Allive TV의 기존 구조 유지
3. 로그인 부분만 교체
4. Credential 획득 자동화
```

**장점**:
- 빠른 구현 (1-2일)
- 기존 앱 안정성 유지
- 최소한의 변경

### 방법 2: 전체 앱 재구축
```
1. WAVVE 앱의 네트워크 레이어 전체 이식
2. Allive TV의 UI와 결합
3. 완전히 새로운 앱 빌드
```

**장점**:
- 최신 WAVVE API 완벽 지원
- 장기적으로 안정적
- 모든 기능 사용 가능

---

## 📊 예상 파일 구조

### Allive TV Gradle 프로젝트
```
allive_gradle/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/hisona/allive/
│   │       │   ├── WavveSiteProcessor.java    # 수정 대상
│   │       │   ├── MainActivity.java
│   │       │   └── ...
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── drawable/
│   │       │   └── values/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

### WAVVE Official 프로젝트
```
wavve_official_gradle/
├── app/
│   └── src/
│       └── main/
│           └── java/com/contentsmobile/wavve/
│               ├── auth/                      # 복사할 부분
│               │   ├── LoginActivity.java
│               │   ├── SnsLoginManager.java
│               │   └── CredentialManager.java
│               ├── network/                   # 복사할 부분
│               │   ├── ApiClient.java
│               │   └── AuthInterceptor.java
│               └── ...
```

---

## ✅ 체크리스트

### Allive TV 디컴파일
- [ ] Gradle 프로젝트 익스포트
- [ ] AndroidManifest.xml 확인
- [ ] 리소스 파일 완전성 검증
- [ ] build.gradle dependencies 확인
- [ ] 네이티브 라이브러리 (.so) 추출

### WAVVE Official 분석 (APK 업로드 후)
- [ ] APK 업로드 완료
- [ ] 완전 디컴파일
- [ ] 로그인 관련 클래스 위치 파악
- [ ] SNS SDK 설정 추출
- [ ] API 클라이언트 코드 추출
- [ ] Credential 생성 로직 이해

### 통합 작업
- [ ] 로그인 모듈 복사
- [ ] 패키지명 변경
- [ ] Dependencies 추가
- [ ] AndroidManifest.xml 권한 추가
- [ ] 테스트 빌드
- [ ] 실제 로그인 테스트

---

## 🎯 최종 목표

```
✅ Allive TV는 유지하되, WAVVE 정식 앱의 로그인 기능만 통합
✅ 사용자가 카카오/네이버/구글로 로그인
✅ 자동으로 Credential 획득 및 저장
✅ WAVVE 실시간 TV 시청 가능
✅ TVING도 동일하게 작동 (HD까지)
```

---

## 📝 다음 단계

1. **지금**: Allive TV Gradle 프로젝트 생성
2. **사용자 제공**: 정식 WAVVE APK 업로드
3. **분석**: WAVVE 로그인 메커니즘 추출
4. **통합**: 로그인 모듈 이식
5. **빌드**: 새 APK 생성 및 테스트

