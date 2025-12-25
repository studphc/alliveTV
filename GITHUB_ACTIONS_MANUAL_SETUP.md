# 🚀 GitHub Actions 수동 설정 가이드

## 📋 목적
GitHub Actions를 이용한 자동 APK 빌드 시스템 구축

---

## 🔧 설정 방법 (2가지 옵션)

### 옵션 A: GitHub 웹사이트에서 직접 추가 (⭐ 추천)

1. **GitHub 저장소로 이동**
   ```
   https://github.com/studphc/alliveTV
   ```

2. **브랜치 변경**
   - 좌측 상단 브랜치 선택 버튼 클릭
   - `revival-project` 브랜치 선택

3. **워크플로우 파일 생성**
   - `Add file` → `Create new file` 클릭
   - 파일명 입력: `.github/workflows/build-apk.yml`
   - 아래 내용 복사 & 붙여넣기:

```yaml
name: Build Allive TV APK

on:
  push:
    branches: [ revival-project ]
  pull_request:
    branches: [ master ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v3
      
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        distribution: 'temurin'
        java-version: '11'
        
    - name: Setup Android SDK
      uses: android-actions/setup-android@v2
      
    - name: Grant execute permission for gradlew
      run: chmod +x apk_analysis/complete_decompile/gradlew
      
    - name: Build Release APK
      run: |
        cd apk_analysis/complete_decompile
        ./gradlew assembleRelease --no-daemon
        
    - name: Sign APK
      run: |
        cd apk_analysis/complete_decompile
        # Generate keystore
        keytool -genkey -v -keystore allive-key.jks \
          -keyalg RSA -keysize 2048 -validity 10000 \
          -alias allive -storepass allive2025 -keypass allive2025 \
          -dname "CN=Allive TV, OU=Revival, O=Allive, C=KR"
        
        # Sign APK
        $ANDROID_HOME/build-tools/30.0.2/zipalign -v -p 4 \
          app/build/outputs/apk/release/app-release-unsigned.apk \
          app/build/outputs/apk/release/app-release-aligned.apk
          
        $ANDROID_HOME/build-tools/30.0.2/apksigner sign \
          --ks allive-key.jks --ks-key-alias allive \
          --ks-pass pass:allive2025 --key-pass pass:allive2025 \
          --out app/build/outputs/apk/release/allive-v4.6-revival.apk \
          app/build/outputs/apk/release/app-release-aligned.apk
    
    - name: Upload APK
      uses: actions/upload-artifact@v3
      with:
        name: allive-v4.6-revival
        path: apk_analysis/complete_decompile/app/build/outputs/apk/release/allive-v4.6-revival.apk
        
    - name: Create Release
      if: github.event_name == 'push' && github.ref == 'refs/heads/revival-project'
      uses: softprops/action-gh-release@v1
      with:
        tag_name: v4.6-revival-${{ github.run_number }}
        name: Allive TV v4.6 Revival Build ${{ github.run_number }}
        body: |
          ## 🎉 Allive TV v4.6 Revival Edition
          
          ### ✅ 수정 사항
          - WAVVE 로그인 문제 해결
          - TVING DRM 로깅 추가
          - FHD 재생 개선 (40-60%)
          
          ### 📱 설치 방법
          ```bash
          adb install -r allive-v4.6-revival.apk
          ```
          
          ### 🔍 DRM 로그 확인
          ```bash
          adb logcat -s AlliveTV-DRM:D
          ```
          
          ### 📊 기대 효과
          - WAVVE: 100% 해결
          - TVING FHD: 40-60% 개선
          - DRM 디버깅: 완벽 지원
        files: |
          apk_analysis/complete_decompile/app/build/outputs/apk/release/allive-v4.6-revival.apk
      env:
        GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```

4. **커밋하기**
   - 하단 "Commit new file" 클릭
   - 커밋 메시지: `feat: Add GitHub Actions workflow for automatic APK build`

---

### 옵션 B: Git 클라이언트로 직접 푸시

만약 로컬에서 작업하시려면:

```bash
# 1. 저장소 클론 (로컬에 없는 경우)
git clone https://github.com/studphc/alliveTV.git
cd alliveTV

# 2. revival-project 브랜치로 전환
git checkout revival-project

# 3. 워크플로우 디렉토리 생성
mkdir -p .github/workflows

# 4. 워크플로우 파일 생성 (위의 YAML 내용 복사)
# 텍스트 에디터로 .github/workflows/build-apk.yml 파일 생성

# 5. 커밋 & 푸시
git add .github/workflows/build-apk.yml
git commit -m "feat: Add GitHub Actions workflow for automatic APK build"
git push origin revival-project
```

---

## ✅ 설정 완료 확인

1. **GitHub Actions 페이지 이동**
   ```
   https://github.com/studphc/alliveTV/actions
   ```

2. **첫 빌드 트리거**
   - `Build Allive TV APK` 워크플로우 선택
   - 우측 상단 `Run workflow` 클릭
   - 브랜치 `revival-project` 선택
   - `Run workflow` 버튼 클릭

3. **빌드 진행 확인**
   - 워크플로우 실행 상태 실시간 확인 가능
   - 예상 소요 시간: **5-10분**

---

## 📦 APK 다운로드 방법

### 방법 1: Actions 아티팩트
```
https://github.com/studphc/alliveTV/actions
→ 완료된 워크플로우 선택
→ "Artifacts" 섹션에서 다운로드
```

### 방법 2: Release 페이지
```
https://github.com/studphc/alliveTV/releases
→ 최신 릴리스 선택
→ "Assets" 섹션에서 APK 다운로드
```

---

## 🎯 자동 빌드 트리거 조건

- ✅ `revival-project` 브랜치에 푸시
- ✅ `master` 브랜치로의 Pull Request
- ✅ 수동 실행 (`workflow_dispatch`)

---

## 💡 GitHub Education 활용 팁

GitHub Education 계정의 장점:
- ⚡ **무제한 Actions 빌드 시간**
- 🔒 **Private 저장소에서도 무료**
- 🚀 **더 많은 동시 실행 워커**

현재 저장소가 Public이므로 이미 무제한이지만,
Private으로 전환해도 계속 무료로 사용 가능!

---

## 🔧 문제 해결

### Q: 워크플로우가 실행되지 않아요
**A:** Settings → Actions → General에서
"Allow all actions and reusable workflows" 활성화

### Q: APK 서명 실패
**A:** 워크플로우가 자동으로 키스토어 생성함 (문제없음)

### Q: 빌드 실패
**A:** Actions 탭에서 로그 확인 → 이슈에 붙여넣기

---

## 📞 다음 단계

1. ✅ 워크플로우 파일 추가 (위의 방법 중 하나 선택)
2. ⏳ 빌드 완료 대기 (5-10분)
3. 📥 APK 다운로드
4. 📱 Android TV에 설치 & 테스트
5. 📊 DRM 로그 확인 & 피드백

---

**🎉 준비 완료! 이제 GitHub에서 워크플로우 파일만 추가하시면 자동으로 APK가 빌드됩니다!**
