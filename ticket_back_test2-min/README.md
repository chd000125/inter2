# ticket_back_test2

```
{
  "uid": 111,
  "uname": "홍길동",
  "ptitle": "테스트",
  "pplace": "테스트장",
  "pprice": 1000,
  "pid": 222,
  "pdate": "2025-04-04T07:31:00",
  "pallSpot": 20
}
```
## 필독
post 형식 이렇게 하셔야하는데
데이터 이름 rId 처럼 중간에 대문자 들어가면 입력안돼요

##  수정사항
```
{C, R, U, D}
좌석 선택 창 - > 받은 정보 저장 {C} 및 출력 {R}
좌석 선택 버튼 -> rSpot 데이터 업데이트 {U}
예매 정보 확인 -> 출력 {R} 및 rPhone, rEmail 업데이트 {U}
예매 확인 버튼 -> rSpotStatus, rTime 업데이트 {U} 및 티켓 생성 {C}
Auto               ->시간(10분?)이 지났는데 rSpotStatus이 null이라면 삭제 {D}
```

