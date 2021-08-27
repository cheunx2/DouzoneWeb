package Pack;
/*
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println("check");
   }
}
*/

/*
// ex41) 
class A {
   void m1() {
      System.out.println(1);
   }
}

interface B {
   void m2(); // 함수 원형, 함수 프로토타입
}

interface C{
   void m3();
}

class D extends A implements B, C{
   @Override
   public void m2() {
      System.out.println(2);
   }
   @Override
   public void m3() {
      System.out.println(3);      
   }
} // class는 하나만 상속 가능, interface는 두 개 이상의 다중상속 가능  

@FunctionalInterface // 해당 annotation 사용시 반드시 함수원형이 하나!
interface E{
   void m1();
   // void m2();
}


public class Hello 
{
   public static void main(String[] args) 
   {
      D t1 = new D();
      t1.m1();
      t1.m2();
      t1.m3();
      
      Thread t2 = null; // t2는 객체가 아니다 강조 
      
      String s = null;
      
      StringBuffer sb = null;
   }
}
*/

/*
// ex40) Interface 인터페이스 
interface 한국은행{
   void 입금 ();
   void 출금 ();
   void 이체 (); 
   void 대출 ();
} // 대부분의 interface 안에 구현해야 하는 함수는 한 개

class 하나은행 implements 한국은행{
   @Override
   public void 대출() {
      System.out.println("이자율은 4%입니다.");
   }
   @Override
   public void 이체() {
      
   }
   @Override
   public void 입금() {
   }
   @Override
   public void 출금() {
      
   }
}

class 국민은행 implements 한국은행{
   @Override
   public void 대출() {
      System.out.println("이자율은 3%입니다.");
   }
   @Override
   public void 이체() {
      
   }
   @Override
   public void 입금() {
      
   }
   @Override
   public void 출금() {
      
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      하나은행 t1 = new 하나은행();
      t1.대출();
      
      국민은행 t2 = new 국민은행();
      t2.대출();
   }
}
*/

/*
// ex39) Override 오버라이딩
abstract class 대장장이 {
   void 칼() {
      System.out.println("칼을 제작합니다.");
   }
   
    abstract void 방패();
} // 부모의 기능(칼) 이 있기 때문에 interface 변환 불가

class 나그네1 extends 대장장이 {
   void 방패() {
      System.out.println("방패를 제작합니다.");
   }
}

class 나그네2 extends 대장장이 {
   @Override
   // @ == annotaion 어노테이션 프로그래머 실수 방지 위해 사용
   // 오버라이딩: 부모가 가진 함수를 동일하게 자식에게 부여 
   // 부모 함수와 다른 함수 작성시(오타) 확인 가능 
   void 방패() {
      // TODO Auto-generated method stub
      
   } // => 빈 스코프 상태에서 ctrl + space 
}

public class Hello 
{
   public static void main(String[] args) 
   {
      나그네1 t1 = new 나그네1();
      t1.칼();
      t1.방패();

      나그네2 t2 = new 나그네2();
      t2.칼();
      t2.방패();
   }
}
*/

/*
// ex38) Interface 인터페이스 
interface Animal { 
   abstract void m1(); // abstract 선택사항
} // abstract class 와 달리 완성된 코드가 들어가면 안 됨. 가이드 라인 역할만 

//abstract class Animal { // abstract 함수가 있으면 class 도 abstract 이어야 함
//   abstract void m1(); // abstract == 미완성 코드 
//} // => class가 아님. 자식에 대해 인터페이스 역할을 한다. 

// abstract class를 interface로 변경 가능하다면 변경하는 것이 좋다 

class Tiger implements Animal { // implement == 구현하다 
   // 미완성 코드 상속시 자식 class는 미완성 함수를 반드시 완성 시켜야 함
   public void m1() {      
   } // public 필수 
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Tiger();
      t1.m1();
      
      //Animal t2 = new Animal(); => 미완성 코드라서 error 객체 생성 불가능 
   }
}
*/

/*
// ex37) 다형성
import java.util.Random;

class Animal {
   void cry() { 
      // cry 가 변형되어 ... 이외 다른 다양한 형태의 결과로 나올 수 있다. => 다형성 프로그램
      System.out.println("...");
   }
}  

class Dog extends Animal {
   void cry() {
      System.out.println("멍멍");
   }
}

class Cat extends Animal {
   void cry() {
      System.out.println("야옹");
   }
}

class Snake extends Animal {
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Random rm = new Random();
            
      Animal t0 = new Dog();
      Animal t1 = new Cat();
      Animal t2 = new Snake();
      
      for (int i = 0; i < 10; i++) {
         int num = rm.nextInt(3);
         
         switch (num) {
         case 0:
            t0.cry();
            break;
            
         case 1:
            t1.cry();
            break;
            
         case 2:
            t2.cry();
            break;
         }
         
      }   
      System.out.println("----------------");
      
      Animal[] t3 = new Animal[]{new Dog(), new Cat(), new Snake()};
      
      for (int i = 0; i < 10; i++) {
         t3[rm.nextInt(3)].cry();
      }
   }
}
*/

/*
// ex36) 난수 발생
public class Hello 
{
   public static void main(String[] args) 
   {
      Random rm = new Random();
      // Random ctrl + space import java.util.Random;
      
      System.out.println(rm.nextInt());
      
      for (int i = 0; i <10; i++) {
         System.out.println(rm.nextInt(10)); // 0~9 사이 랜덤한 수 
      }
   }
}
*/

/*
// ex35) Array 배열
public class Hello 
{
   public static void main(String[] args) 
   {
      int a = 10;
      
      int[] ar = new int[5];
      int[] br = new int[]{1,2,3,4,5};
      int[] cr = {10,20,30,40,50};
      
      System.out.println(ar.length);
      
      for (int i = 0; i < br.length; i++) {
         System.out.print(br[i]+" ");
      }
      System.out.println(); // 줄바꿈
      System.out.println("호랑이");
      
      // for each문
      // i 보다는 x, data, value 많이 사용함
      for (int x : cr) {
         System.out.print(x+" ");
      }
      System.out.println();
      
      // br[i] => i == 인덱스 : 유효범위 0~4(배열의 길이 -1)
      cr[4] = 200;
      // cr[5] = 300; 유효범위를 넘어섰기 때문에 실행기 에러 
      
      int num = 3;
      ar[num] = 500;
      ar[num * 3 - 5] = 600; // 연산값이 유효범위 안에 있다면 작동
      
      ar[2] = 3;
      ar[ar[2]] = 999;
      
      System.out.println(ar[2]+" "+ar[3]);
      
      ar[ar[3] - 998 ] = 888;
      
      for (int x : ar) {
         System.out.print(x+" ");
      }
      System.out.println();
      
      boolean[] dr = {true, true, false, false};
      
      for (boolean x : dr) {
         System.out.print(x+" ");
      }
      System.out.println("");
      System.out.println("----------------");
      
      String[] ss = new String[4];
      
      ss[0] = "호랑이";
      ss[1] = "독수리";
      ss[2] = "강아지";
      ss[3] = "고양이";
      
      for (int i = 0; i < ss.length; i++) {
         System.out.print(ss[i]+" ");
      }
      System.out.println("");
      
      String[] st = new String[]{"해바라기", "장미", "무궁화"}; // 약식 
      
      String s1 = "호랑이"; // 약식
      String s2 = new String("독수리"); // 정석 
      
      String[] su = new String[]{new String("해바라기"), new String("장미"), new String("튤립")};
      
      for (String x : st) {
         System.out.print(x+" ");
      }
      System.out.println("");
      
      for (String x : su) {
         System.out.print(x+" ");
      }
      System.out.println("");
   }
}
*/

/*
// ex34) Up Casting
class Animal {
   void cry() {
      System.out.println("...");
   }
}

class Dog extends Animal {
   void cry() {
      System.out.println("멍멍");
   }
}

class Cat extends Animal {
   void cry() {
      System.out.println("야옹");
   }
}

class Snake extends Animal {
}

class Zoo {
//   void sound(Dog t) {
//      t.cry();
//   }
//   
//   void sound(Cat t) {
//      t.cry();
//   }
//   
//   void sound(Snake t) {
//      t.cry();
//   }
   void sound(Animal t) {
      t.cry();
   } // SOLID 원칙(개방 폐쇄 원칙) 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.  
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Dog();
      Animal t2 = new Cat();
      Animal t3 = new Snake();
      
      t1.cry();
      t2.cry();
      t3.cry();
      
      Dog t4 = new Dog();
      Cat t5 = new Cat();
      Snake t6 = new Snake();
      
      t4.cry();
      t5.cry();
      t6.cry();
      
      System.out.println("--------------------");
      
      Zoo t7 = new Zoo();
      t7.sound(new Dog());
      t7.sound(new Cat());
      t7.sound(new Snake());
   }
}
*/

/*
// ex33)
class Animal {
   void m1() {
      System.out.println(1);
   }
   
   void m3() {
      System.out.println(31);
   }
}

class Tiger extends Animal {
   void m2() {
      System.out.println(2);
   }
   
   void m3() {
      System.out.println(32);
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Animal();
      Tiger t2 = new Tiger();
      
      // 상속 관계에서만 가능 
      // 문법 객체명 = new 메모리;
      
      Animal t3 = new Tiger();  
      // 문법: 부모, 메모리: 부모, 자식 => Up Casting
      // 자식 class method 확인 후 없으면 부모 class method 사용
      
      // Tiger t4 = new Animal();
      // 문법: 부모, 자식 메모리: 부모 => Down Casting
      // 메모리가 모자라서 터짐. 자바에서 허용 안 함 
      
      t3.m1();
      t3.m3();
   }
}
*/

/*
// ex32)
class Animal {
   Animal(){
      System.out.println("Animal call");
   }
   
   Animal(int n){
      System.out.println(n);
   }
}

class Tiger extends Animal {
   Tiger(){
      // 현재 라인에 코드 한 줄 생략 되어있음 
      super(); // => 위에서 생략된 코드. 부모 생성자 call 명령어   
      System.out.println("Tiger call");
   }
   
   Tiger(int num) {
      super(num + 100);
      System.out.println(num);
   }
   
   Tiger(int a, int b){
      super(a * b);
      System.out.println("세 번째 생성자");
      // super(); 에러 뜸 항상 첫 줄에 있어야 한다 
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      Tiger t2 = new Tiger(100);
      Tiger t3 = new Tiger(3, 4);
   }
}
*/

/*
// ex31) 상속
// 부족한 기능을 추가하기 위해서 
// 공통된 기능을 각각 추가하지 않고 상위에 올려 상속으로 처리 
// is a 관계 
// has a 관계 
// 자식 -> 부모
class Animal {
   void m2() {
      System.out.println("function 2 call");
   }
   
   void m3() {
      System.out.println(31);
   }
   
} // 부모

class Tiger extends Animal {
   void m1() {
      System.out.println("function 1 call");
   }
   
   void m3() {
      System.out.println(32);
   }
   
   void m4() {
      m3();
      super.m3();
      System.out.println(4);
   } // 부모 class m3 함수를 사용하고 싶다면 우회해서 사용 가능 
} // 자식 

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Animal();
      Tiger t2 = new Tiger();
      
      t2.m1();
      t2.m2(); // 우선적으로 본인 class 검색 후 없으면 부모 단에서 검색
      t2.m3(); // 부모 자식 모두 같은 함수가 있지만 자식 class 먼저 검색하기 때문에 32 나옴 
      t2.m4();
   }
}
*/

/*
// ex30) Math 함수 
public class Hello 
{
   public static void main(String[] args) 
   {
      // 절댓값
      System.out.println(Math.abs(-10)); // 10
      System.out.println(Math.abs(5)); // 5 
      System.out.println(Math.abs(0)); // 0
      System.out.println("------------------------------------");
      
      // 올림값
      System.out.println(Math.ceil(0.84)); // 1.0
      System.out.println(Math.ceil(-0.84));// -0.0      
      System.out.println("------------------------------------");

      // 버림값
      System.out.println(Math.floor(1.84)); // 1.0
      System.out.println(Math.floor(-2.84)); // -3.0
      System.out.println("------------------------------------");
      
      // 최대값
      System.out.println(Math.max(7,8)); // 8
      System.out.println(Math.max(7.4,7.5)); // 7.5
      System.out.println("------------------------------------");
      
      // 최소값
      System.out.println(Math.min(7,8)); // 7
      System.out.println(Math.min(7.4,7.5)); // 7.4
      System.out.println("------------------------------------");
      
      // 랜덤값
      System.out.println(Math.random());
      System.out.println(Math.random());
      System.out.println(Math.random());
      System.out.println("------------------------------------");
      
      // 가까운 정수의 값
      System.out.println(Math.rint(3.9)); // 4.0
      System.out.println(Math.rint(3.5)); // 4.0
      System.out.println(Math.rint(3.3)); // 3.0
      System.out.println(Math.rint(-3.9)); // -4.0
      System.out.println(Math.rint(-3.5)); // -4.0
      System.out.println(Math.rint(-3.3)); // -3.0
      System.out.println("------------------------------------");
      
      // 반올림값
      System.out.println(Math.round(-3.3)); // -3
      System.out.println(Math.round(-3.7)); // -4
      System.out.println(Math.round(3.3)); // 3
   }
}
*/

/*
// ex29)
class Tiger{
   void myMain() {
      Tiger t = new Tiger();
      t.m1();
      m1();
   }
   void m1() {
      System.out.println("Tiger m1 call");
   }
   
}

public class Hello  
{
   static int num = 10;
   
   Hello(){}
   
   static void m1() {
      System.out.println("Hello m1 call");
   }
   
   public static void main(String[] args) 
   {
      System.out.println(num);
      // static 함수 안에서는 반드시 static member만 사용 가능
      
      m1();
      // m2(); => static 함수가 아니라서 객체 필요 따라서 에러 남
      
      Hello h = new Hello();
      
      h.m1();
      h.m2();
      Hello.m1();
      // Hello.m2(); 에러
      
      Tiger t = new Tiger();
      
      t.myMain();
      
   }
   // void main == entry point. 운영체제가 call 
   // static 이 없으면 객체가 필요 => 운영체제가 call 할 수 없음 
   
   void m2() {
      System.out.println("Hello m2 call");
   }
}
*/

/*
// ex28) static (초기값을 주는 것이 원칙)
class Tiger{
   int num1;
   
   static int num2 = 100; // => 객체간 전역(공용)변수 사용하고자 할 때    
   static void m1() {
      System.out.println("static function call");
      // 실제 컴파일 되었을 때 실행 되어 class 안에 존재하지 않음
   } // static 함수를 사용한다 => 객체 생성하지 않고 사용하겠다 비용 부담 절감
     // 예) Math.abs(-10);
}

// 파일 입출력, 함수 호출, 함수 인수가 많을 때, 객체 생성 비용이 크다(메모리 사용량, 작동 시간)

public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println(Tiger.num2); 
      // 처음부터 메모리 존재! 객체 생성하지 않아도 사용 가능 
      
      Tiger t1 = new Tiger();
      Tiger t2 = new Tiger();
      
      System.out.println(t1.num2); 

      t1.num2 = 200;
      
      System.out.println(t1.num2); 
      System.out.println(Tiger.num2); 
      // class명으로 호출하는 것이 원칙 객체명으로 호출도 가능하지만 지양해야 함
      
      Tiger.m1();
      
      System.out.println(Math.abs(-10));
   }
}
*/

/*
// ex27) 자동차 프로그램
class Car{
   int fuel = 100;
   String name;
   
   Car(){
      System.out.println("default call");
      name = "무명";
   }
   
   Car(String n, int f){
      fuel = f;
      name = n;
      System.out.println("인수가 들어있는 생성자 입니다.");
   }
   
   void move() {
      System.out.println(name+"이(가) 주행중입니다.");
      fuel -= 30;
   }
   
   void stop() {
      fuel -= 10;
   }

   void show() {
      System.out.println(fuel);
   }
   
   void inject() {
      fuel += 100;
   }
   
   void inject(int f) {
      fuel += f;
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Car car1 = new Car();
      Car car2 = new Car("꼬마 자동차", 200);
      
      car1.move();
      car1.show();
      car2.move();
      car2.show();
   }
}
*/

/*
// ex26) 생성자 1
class Tiger{
   Tiger(int a, int b) {
   }
   Tiger(){} //=> default 생성자는 사용 유무와 무관하게 처음에 만들어 놓는 습관! 
}

public class Hello 
{   
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      // Tiger(){} 가 없으면 인수가 없는 생성자가 없어서 에러 뜸 
      Tiger t2 = new Tiger(10, 20);
   }
}
*/

/*
// ex25) 생성자
// (1) 생성자는 함수이다.
// (2) 함수명은 클래스명과 반드시 동일해야 한다.
// (3) 생성자 함수는 return 값을 가질 수 없다. 따라서 void 불필요
// (4) 생성자 함수도 오버 로딩이 가능하다.
// (5) 생성자 함수는 객체가 생성 될 때 단 한 번 호출되며 임의로 호출 불가
// (6) 멤버 method 초기화를 위헤 생성자가 사용 된다. 
// (7) 생성자 함수를 만들지 않으면 자동으로 default 생성자가 만들어진다.

class Tiger{
   int age;
   String name;
   
   Tiger() {      
      System.out.println("생성자 call");
      age = 20;
      name = "홍길동";
   } //=> default 생성자
   
   Tiger(int a, String n) {
      age = a;
      name = n;
   } // member 선언시 초기화 하지 않고 생성사를 사용하는 이유 => 오버 로딩 
   
   void showInfo() {
      System.out.println(age+" "+name);
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger(); 
      // new Tiger() => 생성자 함수 호출 
      Tiger t2 = new Tiger();
      // 객체가 생성 될 때마다 호출 됨
      // 자바는 소멸자 존재는 하나 사용 X 자바가 알아서 함
      Tiger t3 = new Tiger(100, "독수리");
      Tiger t4 = new Tiger(200, "앵무새");
      
      t1.showInfo();
      t2.showInfo();
      t3.showInfo();
      t4.showInfo();
   } 
}
*/