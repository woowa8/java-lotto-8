# 미션 - 로또 (2차 풀이)

## View
### InputView
- [x] 사용자의 입력을 받는다. (Console.readLine()을 이용)
- [x] 잘못된 입력이 들어올 경우, `[ERROR]`로 시작하는 구체적인 Exception을 발생시킨다
- [x] 에러가 발생할 경우, 입력을 다시 받아야 한다
- [x] StackOverflow 방지를 위해 재귀가 아닌 반복을 이용한다.
- [x] Supplier를 사용한다.

### OutputView
- [x] 양식대로 출력한다.
- [x] 첫 번째 출력은 구매한 로또를 출력한다.
- [x] 두 번째 출력은 결과 통계를 출력한다.

## Domain
### Lotto
- [x] 제공하는 단일 클래스이므로, 필드를 추가하지 않는다.
- [x] 생성자에서 오름차순으로 정렬하기
- [x] 예외 처리
  - [x] 갯수가 6개인지 예외처리
  - [x] 1~45 범위인지 예외처리
  - [x] 다 다른지 예외처리 (Set)

### BonusNumber
- [x] 추가로 입력하는 number 구현
- [x] 예외 처리
    - [x] 1~45 범위인지 예외처리

### WinningStats
- [x] 수익률, 갯수등 통계를 처리으로 Map을 가짐
- [x] 기능 구현
  - [x] 수익률 계산하는로직
  - [x] 각 map에 몇 개 있는지 보기 위해 add, getCount

### WinningInfo (ENUM)
- [x] 등수 정보, 몇개 맞아야 하는지, 보너스 번호 맞는지, 금액을 저장하기 위한 ENUM
- [x] 기능 구현
    - [x] 주입을 위한 생성자
    - [x] 각 정보 가져오기 위한 getter
    - [x] 매칭을 위한 등수 정하는 method

### WinningNumber
- [x] 이 로또가 몇등인지를 보기 위한 method
- [x] 기능 구현
    - [x] lotto와 bonusNumber를 가짐
    - [x] 등수 체크하는 로직
    - [x] 등수 체크해서 WinningStats에 넣는 로직

## Util

### InputParser
- [x] , 로 로또를 자르기 위한 method
- [x] 기능 구현
    - [x] ,로 파싱하는 기능
    - [x] 파싱 후 number가 아니면 예외 처리

## Service

### LottoService
- [x] 각 도메인을 조립하기 위한 service
- [x] 기능 구현
    - [x] 로또 출력을 위한 purchase method
    - [x] 계산과 통계를 위한 method