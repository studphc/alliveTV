# 🔧 Gradle 동기화 에러 해결 가이드

## 📋 현재 상황
```
Gradle project sync failed. Basic functionality will not work properly.
```

이 에러는 **의존성 다운로드 실패** 또는 **Gradle 설정 문제**입니다.

---

## ✅ 해결 방법 (순서대로 시도)

### 🔥 **방법 1: Gradle Sync 재시도** (가장 빠름!)

Android Studio 상단:
```
File → Sync Project with Gradle Files
```

또는 우측 상단의 **"Sync Now"** 버튼 클릭

⏱️ 1-3분 대기

---

### 🔥 **방법 2: 캐시 초기화** (90% 해결!)

```
File → Invalidate Caches / Restart
→ "Invalidate and Restart" 클릭
```

Android Studio가 재시작됩니다.
- 재시작 후 자동으로 Gradle 동기화 시작
- ⏱️ 2-4분 소요

---

### 🔥 **방법 3: JDK 설정 확인** (중요!)

#### Step 1: JDK 버전 확인
```
File → Settings (Ctrl+Alt+S)
→ Build, Execution, Deployment
→ Build Tools
→ Gradle
```

**"Gradle JVM"** 항목:
- ✅ **"11"** 또는 **"JDK 11"** 선택
- ❌ "17" 또는 다른 버전이면 변경

#### Step 2: Project SDK 확인
```
File → Project Structure (Ctrl+Alt+Shift+S)
→ Project
```

설정:
- **SDK**: Android API 30 선택
- **Language level**: 8 - Lambdas, type annotations etc.

#### Step 3: SDK Location 확인
```
File → Project Structure
→ SDK Location
```

확인:
- **Android SDK location**: 경로가 설정되어 있는지 확인
- **JDK location**: JDK 11 경로 확인

---

### 🔥 **방법 4: Gradle Wrapper 재다운로드**

하단 **Terminal** 탭 열기 (또는 `Alt+F12`)

#### Windows:
```cmd
gradlew.bat clean
gradlew.bat --refresh-dependencies
```

#### Mac/Linux:
```bash
./gradlew clean
./gradlew --refresh-dependencies
```

⏱️ 2-3분 소요

---

### 🔥 **방법 5: .gradle 폴더 삭제** (강력!)

#### Android Studio에서:

1. 왼쪽 패널 상단을 **"Project Files"** 또는 **"Project"** 뷰로 변경

2. `.gradle` 폴더 우클릭 → **Delete**

3. 그 다음:
   ```
   File → Sync Project with Gradle Files
   ```

#### 또는 수동으로:

**Windows 탐색기:**
```
complete_decompile\.gradle 폴더 삭제
complete_decompile\app\.gradle 폴더 삭제 (있다면)
```

그 다음 Android Studio에서:
```
File → Sync Project with Gradle Files
```

---

### 🔥 **방법 6: 인터넷 연결 확인**

Gradle은 처음 실행 시 많은 파일을 다운로드합니다:
- Gradle 7.2 (약 100MB)
- Android Gradle Plugin 4.2.2
- 각종 라이브러리

**확인 사항:**
- ✅ 인터넷 연결 상태
- ✅ 방화벽/VPN 확인
- ✅ 프록시 설정 (회사망이라면)

---

### 🔥 **방법 7: Gradle 버전 확인**

Gradle 버전이 호환되는지 확인:

`gradle/wrapper/gradle-wrapper.properties` 파일 확인:
```properties
distributionUrl=https\://services.gradle.org/distributions/gradle-7.2-bin.zip
```

현재 설정: **Gradle 7.2** ✅
- Android Gradle Plugin 4.2.2와 호환됨

---

## 🐛 **특정 에러별 해결**

### 에러 1: "Could not download gradle-7.2-bin.zip"

**원인**: 인터넷 연결 또는 다운로드 실패

**해결**:
1. 인터넷 연결 확인
2. VPN 끄기 (사용 중이라면)
3. 다시 시도:
   ```
   File → Sync Project with Gradle Files
   ```

### 에러 2: "Unsupported class file major version"

**원인**: JDK 버전 불일치

**해결**:
```
File → Settings → Build Tools → Gradle
→ Gradle JVM: 11 선택
```

### 에러 3: "SDK location not found"

**원인**: Android SDK 경로 미설정

**해결**:
```
File → Project Structure → SDK Location
→ Android SDK location: (경로 선택)
```

일반적인 경로:
- **Windows**: `C:\Users\[사용자]\AppData\Local\Android\Sdk`
- **Mac**: `~/Library/Android/sdk`
- **Linux**: `~/Android/Sdk`

### 에러 4: "Failed to resolve: com.android.tools.build:gradle:4.2.2"

**원인**: Maven 저장소 접근 실패

**해결**: `build.gradle` 파일에 저장소가 올바른지 확인
```gradle
repositories {
    google()
    mavenCentral()
    // jcenter() 사용하지 말 것 (종료됨)
}
```

---

## 📱 **완전 초기화 방법** (최후의 수단)

모든 방법이 실패했다면:

### Step 1: Android Studio 종료

### Step 2: 캐시 폴더 삭제

**Windows:**
```
C:\Users\[사용자]\.gradle\caches 삭제
```

**Mac/Linux:**
```bash
rm -rf ~/.gradle/caches
```

### Step 3: 프로젝트 로컬 캐시 삭제

`complete_decompile` 폴더에서:
```
.gradle 폴더 삭제
.idea 폴더 삭제
app/build 폴더 삭제
```

### Step 4: Android Studio 재시작 및 프로젝트 열기

```
Open → complete_decompile 폴더 선택
```

---

## ✅ **성공 확인**

Gradle 동기화가 성공하면:

하단에 표시:
```
✓ Gradle sync finished in 2m 34s
```

왼쪽 패널:
- `app` 폴더에 📱 앱 아이콘
- `External Libraries`에 라이브러리들
- 빨간 밑줄 없음

---

## 🎯 **권장 해결 순서**

```
1. File → Sync Project with Gradle Files (1분)
   ↓ 실패 시
2. File → Invalidate Caches / Restart (2분)
   ↓ 실패 시
3. JDK 11로 변경 + Sync (2분)
   ↓ 실패 시
4. .gradle 폴더 삭제 + Sync (3분)
   ↓ 실패 시
5. 완전 초기화 (5분)
```

---

## 💡 **팁**

### Gradle 동기화 진행상황 보기:

하단 **"Build"** 탭:
- 다운로드 중인 파일
- 진행률
- 에러 메시지

### 로그 확인:

```
View → Tool Windows → Build
```

상세 로그에서 정확한 에러 위치 확인 가능

---

## 📞 **추가 도움**

문제가 계속되면:

1. **하단 "Build" 탭의 전체 에러 메시지 복사**
2. **스크린샷 첨부**
3. **다음 정보 제공**:
   - Android Studio 버전
   - JDK 버전: `java -version`
   - 운영체제

---

## 🚀 **지금 바로 시도해보세요!**

**가장 빠른 해결책 (순서대로):**

```
1️⃣ File → Invalidate Caches / Restart
   → "Invalidate and Restart" 클릭
   
⏱️ 2-3분 대기

2️⃣ 재시작 후 자동 동기화 대기

3️⃣ 성공하면 Build → Build APK(s)
```

대부분 **"Invalidate Caches"**로 해결됩니다! 👍
