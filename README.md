# lotto - 구현 기능 정리

## View
### InputView
- 기능 구현
    - [x] 구입 금액을 입력받는다.
    - [x] 당첨 번호를 입력받는다.
    - [x] 보너스 번호를 입력받는다.
- 예외 처리
    - [x] 1,000원 단위가 아니면 예외

### OutputView
- 기능 구현
    - [x] 랜덤 생성된 로또 리스트 출력
    - [x] 로또 결과 출력

---

## Domain
### Lotto
- 기능 구현
    - [x] get으로 정보 가져오는 것
    - [x] toString으로 전체 string 출력
- 예외 처리
    - [x] 로또 번호 범위가 1~45 사이인지 예외 처리
    - [x] 로또 번호 갯수가 6개인지 예외 처리
    - [x] 중복 숫자 있으면 예외 처리 : Set 사용
`
### Rank (ENUM)
- 기능 구현
    - [x] none 부터 1등까지 역순으로 순서
    - [x] name, 맞는 갯수, 보너스 여부, 금액으로 이뤄져 있다.
    - [x] 등수 (해당하는 enum) 내보내는 로직이 있다.

### WinningNumber
- 기능 구현
    - [x] lotto와 bonusNum을 가진다.
    - [x] bonusNum이 1~45 사이의 숫자인지 검증
    - [x] getter 존재

---

## DTO
### ResponseDto
- 기능 구현
    - [x] 통계 결과와 수익률을 변수로 가진다.

---

## Util
### InputParser
- 기능 구현
    - [x] , 으로 번호를 파싱
- 예외 처리
    - [x] 빈칸이 있을 경우 예외

---

## Repository
### LottoRepository
- 기능 구현
    - [x] lotto들을 저장하는 로직
    - [x] get으로 저장된 모든 로또 가져오는 로직
    - [x] lottos 전체를 string으로 내보내는 기능

### StatsRepository
- 기능 구현
    - [x] Map으로 통계(count) 저장하는 로직

---

## Service
### LottoService
- 기능 구현
    - [x] 랜덤 로또 번호 생성 로직
    - [x] 로또 번호 저장하는 로직
    - [x] 등수 계산 & 통계 로직
    - [x] outputView로 내보내기 위해 dto 변환
- 예외 처리
    - [ ]

---

## Controller
### LottoController
- 기능 구현
    - [x] run으로 실행하는 로직
    - [x] 전체 객체 조합하는 로직
    - [x] 금액 받고 로또 출력하는 로직
    - [x] 당첨 번호랑 보너스 번호 받는 로직
    - [x] 통계 결과 출력하는 로직
- 예외 처리
    - [ ]
