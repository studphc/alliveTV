# 📤 APK 업로드 가이드

## 방법 1: 파일 업로드 (권장)

APK 파일을 준비하신 후 알려주시면 분석을 시작하겠습니다.

**필요한 파일**:
- `wavve-official.apk` (WAVVE 공식 앱)
- `tving-official.apk` (선택사항 - TVING FHD 분석용)

## 방법 2: APK 다운로드 URL 제공

APKMirror, APKPure 등에서 최신 버전 URL을 알려주시면 직접 다운로드하겠습니다.

예시:
```
https://www.apkmirror.com/apk/contents-wavve-corp/wavve/...
```

## 방법 3: 직접 추출 (Android 기기)

### Android 기기에서 APK 추출
```bash
# 1. ADB 연결
adb devices

# 2. WAVVE 패키지 찾기
adb shell pm list packages | grep -i wavve

# 3. APK 경로 확인
adb shell pm path com.contentswavve.wavve

# 4. APK 추출
adb pull /data/app/.../base.apk wavve-official.apk
```

## 📊 분석 예상 시간

- **APK 다운로드**: 1-2분
- **완전 디컴파일**: 5-10분
- **로그인 코드 분석**: 10-20분
- **통합 방법 설계**: 20-30분
- **총 소요 시간**: 약 40-60분

## 🎯 분석 후 결과물

1. **로그인 메커니즘 완전 문서화**
2. **API 엔드포인트 및 파라미터**
3. **SNS 로그인 통합 가이드**
4. **Allive TV 수정 코드**
5. **빌드 가능한 Android Studio 프로젝트**

---

**준비되셨으면 APK 파일을 공유해 주세요!** 🚀

