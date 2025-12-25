#!/bin/bash

echo "======================================"
echo "WAVVE API 테스트 스크립트"
echo "======================================"
echo ""

# 기존 API 키 (만료되었을 가능성 높음)
OLD_API_KEY="E5F3E0D30947AA5440556471321BB6D9"

# 테스트 1: 로그인 엔드포인트 테스트
echo "📡 Test 1: 로그인 엔드포인트 테스트"
echo "URL: https://apis.wavve.com/login"
echo ""

curl -X POST "https://apis.wavve.com/login" \
  -H "Content-Type: application/json" \
  -H "User-Agent: Mozilla/5.0 (Linux; Android 10; Android TV) AppleWebKit/537.36" \
  -d "{
    \"apikey\": \"$OLD_API_KEY\",
    \"credential\": \"none\",
    \"device\": \"pc\",
    \"drm\": \"wm\",
    \"partner\": \"pooq\",
    \"pooqzone\": \"none\",
    \"region\": \"kor\",
    \"targetage\": \"all\",
    \"type\": \"credential\",
    \"id\": \"test\",
    \"password\": \"\",
    \"pushid\": \"\",
    \"profile\": \"\"
  }" \
  -w "\n\nHTTP Status: %{http_code}\n" \
  2>/dev/null

echo ""
echo "======================================"
echo ""

# 테스트 2: 프로필 엔드포인트 테스트
echo "📡 Test 2: 프로필 엔드포인트 테스트"
echo "URL: https://apis.wavve.com/profiles"
echo ""

curl -X GET "https://apis.wavve.com/profiles?limit=10&offset=0&orderby=new&apikey=$OLD_API_KEY&credential=test&device=pc&drm=wm&partner=pooq&pooqzone=none&region=kor&targetage=all" \
  -H "User-Agent: Mozilla/5.0 (Linux; Android 10; Android TV) AppleWebKit/537.36" \
  -w "\n\nHTTP Status: %{http_code}\n" \
  2>/dev/null

echo ""
echo "======================================"
echo ""

# 테스트 3: EPG 엔드포인트 테스트
echo "📡 Test 3: EPG (편성표) 엔드포인트 테스트"
echo "URL: https://apis.wavve.com/live/epgs"
echo ""

curl -X GET "https://apis.wavve.com/live/epgs?apikey=$OLD_API_KEY&device=pc&drm=wm&partner=pooq&region=kor&targetage=all" \
  -H "User-Agent: Mozilla/5.0 (Linux; Android 10; Android TV) AppleWebKit/537.36" \
  -w "\n\nHTTP Status: %{http_code}\n" \
  2>/dev/null

echo ""
echo "======================================"
echo "테스트 완료!"
echo "======================================"
