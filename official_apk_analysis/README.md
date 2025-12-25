# 정식 WAVVE/TVING APK 분석

## 📋 업로드 방법

### WAVVE 공식 APK 업로드
1. Android 기기에서 APK 추출:
   ```bash
   # ADB 사용
   adb shell pm list packages | grep wavve
   adb shell pm path com.contentswavve.wavve
   adb pull /data/app/~~xxxxx/com.contentswavve.wavve-xxxxx/base.apk wavve-official.apk
   ```

2. 또는 APK 다운로드 사이트에서:
   - APKMirror
   - APKPure
   - APKCombo

### 분석할 내용
- [ ] 로그인 API 엔드포인트
- [ ] SNS 로그인 (카카오/네이버/구글) 플로우
- [ ] Credential 생성 메커니즘
- [ ] API 키 및 인증 헤더
- [ ] 세션 관리 방식

### 통합 방법
1. 로그인 Activity 코드 추출
2. Allive TV의 `WavveSiteProcessor.java`에 통합
3. SNS 로그인 SDK 추가
4. Credential 자동 획득/갱신 구현

