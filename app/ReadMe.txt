환경
Android Studio 4.0.1
SDK Android 10.0+ R 30

MainActivity.java
첫 번째 상품을 고를 수 있는 Activity로 2개의 상품을 등록해놨고, 각 상품의 이름과 가격을 기재했습니다.
또한 상품을 선택할 수 있도록 CheckBox를 2개 만들어놨고, 상품을 선택하지 않으면 장바구니와 구매하기를 눌러도
이동하지 않도록 만들었습니다.

ShoppingBasket.java
MainActivity에서 상품을 선택하고 장바구니 버튼을 누르면 이동하고, 선택된 상품들을 장바구니에 다시 표시합니다.
장바구니 Activity에서도 상품 중에 선택할 수 있고, 아무것도 선택하지 않으면 구매하기 버튼은 눌리지 않도록 했습니다.
홈으로 가기 버튼은 CheckBox를 선택하지 않거나 아무 CheckBox를 선택하더라도 누르면 바로 MainActivity로 돌아가도록
했습니다.

Purchase.java
MainActivity와 Shoppingbasket에서 상품을 선택하고 구매하기를 누르면 이동하는 Activity입니다.
선택한 상품의 이름과 가격을 기재하고 가격의 합계가 자동적으로 표시되고, 주소와 핸드폰 번호를 입력하는데,
5자리 이상 기재해야 결제 버튼이 눌리도록 구현했습니다. 홈으로 가기 버튼을 누르면 "결제가 취소되었습니다."라는
문구가 출력됩니다.

