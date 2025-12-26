# Allive TV Revival Project 로드맵

## 🎯 프로젝트 목표
Allive TV v4.5의 WAVVE 로그인 문제를 해결하고 Android TV용 스트리밍 앱을 부활시킵니다.

---

## 📋 진행 상황

### ✅ Phase 1: 분석 및 조사 (완료)
- [x] APK 다운로드 및 디컴파일
- [x] 소스코드 분석 (8,017 클래스, 99% 성공)
- [x] WAVVE API 엔드포인트 확인
- [x] TVING DRM 구조 분석
- [x] 하드코딩된 API 키 발견
- [x] 문제 원인 파악
- [x] 분석 보고서 작성

**결과물**:
- `APK_ANALYSIS_REPORT.md`
- 디컴파일된 소스코드 (83개 핵심 파일)
- 원본 APK 파일

---

### 🔄 Phase 2: WAVVE API 리버스 엔지니어링 (진행 중)

#### 2.1 공식 앱 분석
- [ ] Charles Proxy 설정
- [ ] 공식 WAVVE Android TV 앱 설치
- [ ] 네트워크 트래픽 캡처
- [ ] 최신 API 엔드포인트 확인
- [ ] 새로운 API 키 추출
- [ ] 인증 플로우 분석

**필요한 도구**:
```bash
- Charles Proxy (macOS/Windows)
- Android TV 에뮬레이터 또는 실제 기기
- WAVVE 공식 앱
- SSL 인증서 설치
```

#### 2.2 API 테스트
- [ ] Postman/Insomnia로 API 테스트
- [ ] 로그인 엔드포인트 테스트
- [ ] 프로필 목록 가져오기 테스트
- [ ] EPG 데이터 가져오기 테스트
- [ ] 스트리밍 URL 획득 테스트

---

### 🛠️ Phase 3: 소스코드 수정

#### 3.1 새 Android Studio 프로젝트 생성
- [ ] Android Studio 프로젝트 초기화
- [ ] Gradle 설정 (dependencies)
- [ ] 패키지 구조 생성 (`com.revival.allive`)

#### 3.2 핵심 파일 마이그레이션
- [ ] `WavveSiteProcessor.java` 수정
  - API 키 업데이트
  - 엔드포인트 업데이트
  - 인증 로직 수정
- [ ] `TvingSiteProcessor.java` 검토
- [ ] `PlayerActivity.java` 업데이트
- [ ] `SettingsData.java` 구조 확인
- [ ] `HttpRequest.java` 업데이트

#### 3.3 리소스 파일 추가
- [ ] `AndroidManifest.xml` 설정
- [ ] `res/` 디렉토리 구조 생성
- [ ] 이미지 및 레이아웃 파일 추가
- [ ] `strings.xml` 업데이트

---

### 🧪 Phase 4: 테스트 및 디버깅

#### 4.1 로컬 테스트
- [ ] Android Studio에서 빌드
- [ ] 에뮬레이터에서 실행
- [ ] WAVVE 로그인 테스트
- [ ] 채널 목록 로드 테스트
- [ ] 스트리밍 재생 테스트

#### 4.2 실제 기기 테스트
- [ ] Android TV 기기에 설치
- [ ] 전체 기능 테스트
- [ ] 버그 수정

---

### 📦 Phase 5: 빌드 및 배포

#### 5.1 APK 빌드
- [ ] Release 빌드 설정
- [ ] ProGuard/R8 설정
- [ ] APK 서명
- [ ] APK 최적화

#### 5.2 배포
- [ ] GitHub Releases에 업로드
- [ ] README 업데이트
- [ ] 설치 가이드 작성
- [ ] 변경 사항 문서화

---

## 🚀 즉시 시작 가능한 작업

### Option A: Charles Proxy로 WAVVE API 분석
```bash
1. Charles Proxy 다운로드 및 설치
2. Android TV 에뮬레이터 실행
3. 네트워크 프록시 설정
4. WAVVE 공식 앱 실행 및 로그인
5. 트래픽 캡처 및 분석
```

### Option B: Android Studio 프로젝트 생성
```bash
1. Android Studio 설치
2. 새 프로젝트 생성 (Empty Activity)
3. 디컴파일된 소스 파일 복사
4. Gradle dependencies 설정
5. 초기 빌드 테스트
```

### Option C: API 직접 테스트
```bash
# 현재 알고 있는 정보로 API 테스트
curl -X POST "https://apis.wavve.com/login" \
  -H "Content-Type: application/json" \
  -d '{
    "apikey": "E5F3E0D30947AA5440556471321BB6D9",
    "type": "credential",
    "id": "YOUR_AUTH_KEY",
    "password": "",
    "profile": ""
  }'
```

---

## 📊 우선순위

| 작업 | 우선순위 | 난이도 | 예상 시간 |
|------|---------|--------|----------|
| Charles Proxy 분석 | 🔴 높음 | 중간 | 2-4시간 |
| API 키 추출 | 🔴 높음 | 중간 | 1-2시간 |
| WavveSiteProcessor 수정 | 🔴 높음 | 낮음 | 1시간 |
| Android Studio 프로젝트 | 🟡 중간 | 중간 | 3-5시간 |
| 전체 빌드 및 테스트 | 🟡 중간 | 높음 | 5-8시간 |
| TVING FHD 문제 | 🟢 낮음 | 매우 높음 | 불가능 |

---

## 🎓 학습 자료

### WAVVE API
- [WAVVE 공식 사이트](https://www.wavve.com)
- Charles Proxy 사용법
- Android TV 개발 가이드

### Android 개발
- [Android Developer Documentation](https://developer.android.com)
- ExoPlayer 가이드
- Widevine DRM 이해

---

## 💬 다음 단계 선택

어떤 작업부터 시작하시겠습니까?

1. **Charles Proxy 분석 준비** - API 분석 도구 설정
2. **Android Studio 프로젝트 생성** - 개발 환경 구축
3. **API 직접 테스트** - 현재 정보로 테스트
4. **문서화 작업** - 추가 분석 및 문서 작성

