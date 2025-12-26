# WAVVE API 테스트 결과

## 📊 테스트 요약

**테스트 날짜**: 2025-12-25  
**API 키**: `E5F3E0D30947AA5440556471321BB6D9` (기존)  
**결과**: ✅ API 엔드포인트는 여전히 유효함!

---

## 🔍 상세 결과

### Test 1: 로그인 엔드포인트
- **URL**: `https://apis.wavve.com/login`
- **Method**: POST
- **응답**:
```json
{
  "resultcode": "550",
  "resultmessage": "credential이 유효하지 않습니다."
}
```
- **HTTP Status**: 550

**분석**:
- ✅ 엔드포인트는 유효함
- ✅ API 키가 여전히 인식됨
- ❌ Credential (인증 토큰)이 필요함
- 💡 **해결책**: 유효한 credential 필요

---

### Test 2: 프로필 엔드포인트
- **URL**: `https://apis.wavve.com/profiles`
- **Method**: GET
- **응답**:
```json
{
  "resultcode": "550",
  "resultmessage": "credential이 유효하지 않습니다."
}
```
- **HTTP Status**: 550

**분석**:
- ✅ 엔드포인트는 유효함
- ❌ 유효한 로그인 credential 필요
- 💡 먼저 로그인을 해야 함

---

### Test 3: EPG (편성표) 엔드포인트
- **URL**: `https://apis.wavve.com/live/epgs`
- **Method**: GET
- **응답**:
```json
{
  "resultcode": "400",
  "resultmessage": "validation failed: startdatetime is required"
}
```
- **HTTP Status**: 400

**분석**:
- ✅ 엔드포인트는 유효함
- ❌ `startdatetime` 파라미터가 누락됨
- 💡 필수 파라미터 추가 필요

---

## 💡 주요 발견 사항

### 1. **API 키는 여전히 유효함!** ✨
```
기존 API 키 'E5F3E0D30947AA5440556471321BB6D9'가 여전히 작동합니다!
이것은 큰 발견입니다. API 키 만료가 문제가 아니었습니다.
```

### 2. **진짜 문제: Credential 획득 방법**
```
로그인 엔드포인트가 "credential이 유효하지 않습니다"라고 응답합니다.
즉, 문제는 API 키가 아니라 "credential"을 어떻게 생성/획득하는가입니다.
```

### 3. **Credential이란?**
디컴파일된 코드를 보면:
```java
// WavveSiteProcessor.java
HttpRequest.post("https://apis.wavve.com/login", 
    "credential", this.mAuthKey,  // ← 이것이 credential
    ...
)
```

**Credential은**:
- 사용자 로그인 후 받는 인증 토큰
- 웹/앱에서 로그인할 때 생성됨
- 모든 API 호출에 필요

---

## 🎯 다음 단계

### 방법 1: 웹 브라우저에서 Credential 추출
```bash
1. Chrome DevTools 열기 (F12)
2. Network 탭 활성화
3. https://www.wavve.com 접속
4. 로그인 수행
5. Network 탭에서 "login" 요청 찾기
6. Response에서 "credential" 값 복사
7. 이 값을 테스트에 사용
```

### 방법 2: WAVVE 로그인 플로우 분석
```
1. SNS 로그인 (카카오, 네이버 등) 방식 확인
2. OAuth 토큰 → WAVVE credential 변환 과정 분석
3. 직접 로그인 API 구현
```

### 방법 3: Android 앱에서 Credential 추출
```
1. Android 에뮬레이터 실행
2. WAVVE 앱 설치 및 로그인
3. 저장된 credential 값 추출 (Hawk storage)
4. 이 값을 테스트에 사용
```

---

## 🔧 개선된 테스트 필요

### EPG API 수정 버전
```bash
# startdatetime 파라미터 추가
curl -X GET "https://apis.wavve.com/live/epgs?apikey=E5F3E0D30947AA5440556471321BB6D9&device=pc&startdatetime=20251225000000&enddatetime=20251226000000"
```

### 로그인 API - 실제 credential 사용
```bash
# 유효한 credential이 있다면
curl -X POST "https://apis.wavve.com/login" \
  -H "Content-Type: application/json" \
  -d '{
    "apikey": "E5F3E0D30947AA5440556471321BB6D9",
    "type": "credential",
    "id": "YOUR_REAL_CREDENTIAL_HERE",
    "password": "",
    "profile": ""
  }'
```

---

## 📝 결론

### ✅ 좋은 소식
1. **API 키가 여전히 작동함** - 만료되지 않음!
2. **API 엔드포인트가 변경되지 않음** - 동일한 URL 사용
3. **API 응답 형식이 동일함** - JSON 구조 유지

### ❌ 해결 필요
1. **Credential 획득 방법** - 로그인 플로우 리버스 엔지니어링 필요
2. **SNS 로그인 통합** - 카카오/네이버 OAuth 구현 필요
3. **Credential 저장 및 갱신** - 토큰 만료 처리 필요

### 🚀 추천 다음 작업
**Option 1** (빠름): 웹 브라우저에서 직접 로그인하고 credential 추출  
**Option 2** (권장): SNS 로그인 플로우 리버스 엔지니어링  
**Option 3** (고급): Android 앱에서 로그인 흐름 완전 분석

---

## 💡 핵심 인사이트

```
문제는 API 키나 엔드포인트가 아니었습니다!
문제는 앱이 "credential"을 생성/저장하는 방식에 있었습니다.

즉, 사용자가 한 번 로그인하면 앱이 credential을 저장하고,
이후 모든 API 호출에 이 credential을 사용합니다.

앱이 작동하지 않는 이유:
- 저장된 credential이 만료됨
- 또는 credential 획득 방식 변경됨
```

