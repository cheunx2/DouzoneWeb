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

// ex51)
public class Hello 
{
   static StringBuffer hexaToBinary(int n) {
      String s = Integer.toBinaryString(n);
      System.out.println(s);
      System.out.println(s.length());
      
      while(s.length()<28) {
         s = "0" + s;
      }
      
      System.out.println(s);
      
      StringBuffer s1 = new StringBuffer(s);
      s1.insert(4, "한");
      System.out.println(s1);
      
      for (int i =0; i<7; i++) {
         System.out.println((7-i)*4);
         s1.insert((7-i)*4, " ");
      }
      return s1;
   }

   public static void main(String[] args) 
   {
      // 1 0010 1011 0011 1100 0100 1101
      int a = 0x12b3c4d;
      int b = 19610701; 
      
      System.out.println(a);
      
      if(a == b) {
         System.out.println(1);
      }
      
      System.out.println(hexaToBinary(a));
      System.out.println(hexaToBinary(b));
   }
}

// 진법


/*
// ex50) 문자열
class Tiger {
   
}

public class Hello 
{
   public static void main(String[] args) 
   {
      String s = "무궁화 꽃이 피었습니다.";
      String r = "꽃 꽃 꽃 꽃";
      System.out.println(s.length());
      
      // char charAt(int index)
      System.out.println(s.charAt(4));
      
      System.out.println(s.indexOf("꽃"));
      
      int n = s.indexOf("꽃");
      if(n != -1) {
         System.out.println(n+"번째 글자 입니다.");
      }else {
         System.out.println("not found");
      }
      
      // 해당되는 문자열 전체 변환 
      System.out.println(s.replace("꽃이", "나무가"));
      System.out.println(r.replace("꽃", "나무")); 
      
      // 원본 데이터에는 변화가 없음 
      // *** String은 원본 데이터 변경이 불가 ***
      System.out.println(s);
      System.out.println(r);
      
      r = "대한민국";
      System.out.println(r);
      // 데이터 수정이 아니라 기존 객체 삭제 후 다시 선언한 것임 
      
      System.out.println(s.substring(5)); // == s[5:]
      System.out.println(s.substring(3,6)); // == s[3:6]
      
      // trim 좌우 공백 제거 
      String s2 = "   App   le   ";
      System.out.print(s2.trim());
      System.out.println("-");
      
      String s3 = "ApPle";
      System.out.println(s3.toUpperCase());
      System.out.println(s3.toLowerCase());
      
      // 아스키 코드(byte)를 문자열로 변환
      // 데이터를 받았을 때 
      byte[] data = new byte[] {65, 97};
      String s4 = new String(data, 0, data.length);
      System.out.println(s4);
      
      // 데이터를 전송할 때 
      String s5 = "Banana";
      byte[] data1 = s5.getBytes();
      for (byte value : data1) {
         System.out.print(value+(char)value+" ");
      }
      System.out.println();
   }
}
*/

/*
// ex49)
class Tiger {
   void m1(int a, int b) {
      if(a > b) {
         System.out.println(1);
      }else {
         return; 
      }
      System.out.println(2);
   }
   
   void m2(int a, int b) {
      try {
         if(a > b) {
            System.out.println(1);
         }else {
            return; // return 이 있어도 finally 실행 됨  
         }         
      } catch (Exception e) {
      } finally {         
         System.out.println(2);
      }
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      try {
         int a = 10 / 0;
      }catch (Exception e) {
         
      }finally {
         System.out.println(1);
      }// Exception 여부와 무관하게 finally 실행 됨 
      
      Tiger t1 = new Tiger();
      t1.m1(10,0);
      System.out.println("-------");
      t1.m1(0,10);
      System.out.println("-------");
      t1.m2(10,0);
      System.out.println("-------");
      t1.m2(0,10);
   }
}
*/

/*
// ex48) try catch 문 한 줄로 처리 
public class Hello 
{
   public static void main(String[] args) 
   {
      for (int i = 0; i < 5; i++) {
         System.out.println(i);
         try {Thread.sleep(2000); } catch (Exception e) {} // 1000 == 1초
      }
   }
}
*/

/*
// ex47) throw try catch
class Tiger {
   void m1() {
      System.out.println(1);

      try {
         throw new Exception();// 예외를 떠넘김         
      } catch (Exception e) {
         System.out.println("예외 발생");
      }
   }

   void m2() throws Exception{
      System.out.println(2);

      throw new Exception();         
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      t1.m1();
      
      // *** Unhandled Exception => 무조건 try catch!!! ***
      try {
         t1.m2();
      } catch (Exception e) {
         System.out.println(3);
      }
   }
}
*/

/*
// ex46) Try Catch => Exception 발생시 프로그램 종료하지 않고 끝까지 실행하게 도와줌 
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println(1);
      
      try {
         int a = 10 / 0;         
      } catch (Exception e) {
         System.out.println(3);
         e.printStackTrace();// Error 메세지 출력
      } // Exception은 발생시 프로그램 중단이 목적이 아니라 프로그래머에게 알리는 것이 목적
      
      System.out.println(2);
      
      int[]ar = {1, 2, 3};
   
      try {
         ar[3] = 10;
      } catch (Exception e) {
         System.out.println(3); // 배열 범위 초과         
         e.printStackTrace();
      }
      
      String s = "무궁화 꽃이 피었습니다.";
      System.out.println(s.length());
      s = null;
      
      try {
         s.length();
      } catch (Exception e) {
         System.out.println(4); // Null point exception
         e.printStackTrace();
      }
   
   }
}
*/

/*
//ex45-5) Injection 
class Baduk {
   AI ai;
   
   Baduk(){
      System.out.println("대국을 시작합니다.");
   }
   Baduk(AI ai) {
      this.ai = ai;
   }
   void play() {
      ai.play();
   }
   void stop() {
      ai.stop();
   }
}

interface AI{
   void play();
   void stop();
}

//구글에서 만들었음 
class Alphago implements AI {
   @Override
   public void play() {
      System.out.println("인공지능은 알파고 입니다.");
   }
   
   @Override
   public void stop() {
      System.out.println("알파고가 계산 중 입니다.");
   }
   
}

//아마존에서 만들었음
class Betago implements AI{
   @Override
   public void play() {
      System.out.println("인공지능은 베타고 입니다.");
   }
   
   @Override
   public void stop() {
      System.out.println("베타고가 계산 중 입니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Baduk baduk1 = new Baduk(new Alphago());
      baduk1.play();
      baduk1.stop();
      
      Baduk baduk2 = new Baduk(new Betago());
      baduk2.play();
      baduk2.stop();
   }
}
*/

/*
// ex45-4)
class Baduk {
   Baduk(){
      System.out.println("대국을 시작합니다.");
   }
   
   void play(AI ai) {
      ai.play();
   }
   
   void stop(AI ai) {
      ai.stop();
   }
}

interface AI{
   void play();
   void stop();
}

//구글에서 만들었음 
class Alphago implements AI {
   @Override
   public void play() {
      System.out.println("인공지능은 알파고 입니다.");
   }
   
   @Override
   public void stop() {
      System.out.println("알파고가 계산 중 입니다.");
   }
   
}

//아마존에서 만들었음
class Betago implements AI{
   @Override
   public void play() {
      System.out.println("인공지능은 베타고 입니다.");
   }
   
   @Override
   public void stop() {
      System.out.println("베타고가 계산 중 입니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Baduk baduk = new Baduk();
      baduk.play(new Alphago());
      baduk.play(new Betago());
   }
}
*/

/*
//ex45-3) 인공지능이 바뀐다면 어떻게 할 것인가? 
class Baduk {
   Baduk(){
      System.out.println("대국을 시작합니다.");
   }
   
   void play(AI ai) {
      ai.play();
   }
}

interface AI{
   void play();
}

//구글에서 만들었음 
class Alphago implements AI {
   @Override
   public void play() {
      System.out.println("인공지능은 알파고 입니다.");
   }
}

//아마존에서 만들었음
class Betago implements AI{
   @Override
   public void play() {
      System.out.println("인공지능은 베타고 입니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Baduk baduk = new Baduk();
      baduk.play(new Alphago());
      baduk.play(new Betago());
   }
}
*/

/*
//ex45-2) 인공지능이 바뀐다면 어떻게 할 것인가? 
class Baduk {
   Baduk(){
      System.out.println("대국을 시작합니다.");
   }
   
   void play(Alphago alphago) {
      alphago.play();
   }
   
   void play(Betago betago) {
      betago.play();
   }
} // 새로운 인공지능이 생길 때마다 업데이트 필요

// 구글에서 만들었음 
class Alphago{
   void play() {      
      System.out.println("인공지능은 알파고 입니다.");
   }
}

// 아마존에서 만들었음
class Betago{
   void play() {      
      System.out.println("인공지능은 베타고 입니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Baduk baduk = new Baduk();
      baduk.play(new Alphago());
      baduk.play(new Betago());
   }
}
*/

/*
// ex45-1) 인공지능이 바뀐다면 어떻게 할 것인가? 
class Baduk {
   Baduk(){
      System.out.println("대국을 시작합니다.");
   }
   
   void play() {
      System.out.println("인공지능은 알파고 입니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Baduk baduk = new Baduk();
      baduk.play();
   }
}
*/

/*
// ex44-2)
interface Animal {
   void m1();
}

class Zoo {
   void sound(Animal t) {
      t.m1();
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Animal() {
         @Override
         public void m1() {
            System.out.println(1);
         }
      };
      t1.m1();
      
      Zoo t2 = new Zoo();
      t2.sound(new Animal() {
         @Override
         public void m1() {
            System.out.println(2);
         }
      });
   }
}
*/

/*
// ex44-1)
interface Animal {
   void m1();
}

class Tiger implements Animal {
   @Override
   public void m1() {
      System.out.println(1);
   }
}

class Zoo {
   void m1(Animal t) {
      t.m1();
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      t1.m1();
      
      Animal t2 = new Tiger();
      t2.m1();
      
      //Animal t3 = new Animal(); 미완성 객체로 객체 생성 시도 했기 때문에 에러 
      Animal t3 = new Animal() {
         @Override
         public void m1() {
            System.out.println(2);
         }
      }; // 익명 클래스 
      t3.m1();
      
      new Animal() {
         @Override
         public void m1() {
            System.out.println(3);
         } 
      }.m1(); // 익명 객체
      
      Zoo t4 = new Zoo();
      t4.m1(new Animal() {
         @Override
         public void m1() {
            System.out.println(4);
         }
      }); // 함수 인수로 코드 전달
   }
}
*/

/*
// ex43-5)
class Tiger {
   Tiger() {
      System.out.println(1);
   }
   
   Tiger(int a) {
      this();
      System.out.println(a);
   }
   
   Tiger(int a, int b) {
      this(a+b);// 생성자 호출 
      System.out.println(a+" "+b);
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger(10,20);
   }
}
*/

/*
// ex43-4) this 다른 클래스에 인수 전달 목적으로 사용
class Tiger {
   void m1() {
      Lion t = new Lion();
      if (t.marry(this)) {
         System.out.println("감사합니다.");
      }else {
         System.out.println("ㅠㅠ");         
      }
   }
   
   int m2() {
      int money = 50;
      System.out.println("제가 가지고 있는 재산은 "+money+"입니다.");
      return money;
   }
   
   String m3() {
      return "온순";
   }
}

class Lion {
   boolean marry(Tiger t) {
      if(t.m2() >= 80) {         
         return true; 
      }else {
         String s = t.m3();
         
         switch(s) {
         case"온순":
            return true; 
         case"난폭":
            return false;
         }return false;
      }
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      t1.m1();
   }
}
*/

/*
// ex43-3)chaining 
class Tiger {
   Tiger m1() {
//      return new Tiger();
      
//      Tiger t = new Tiger();
//      return t;
      
      System.out.println(1);
      return this; // this == Tiger 
   }
   
   Tiger m2() {
      System.out.println(2);
      return this;
   }
   
   void m3() {
      System.out.println(3);
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      Tiger t2 = t1.m1();
      
      System.out.println(t1.hashCode());
      System.out.println(t2.hashCode());
      // t1, t2 동일함
      
      t2.m2();
      System.out.println("----------------------");
      t1.m1().m2();
      System.out.println("----------------------");
      t1.m1().m2().m1().m2().m3(); // 체이닝
      System.out.println("----------------------");
       t1.m1().m2().m3(); // 코드 사이에 다른 코드 난입 불가 
       System.out.println("----------------------");
      t1.m1();
      t1.m2();
      System.out.println("호랑이"); // 코드가 난입 되었다. 
      t1.m3();
   }
}
*/

/*
// ex43-2)
class Tiger {
   // Tiger this;
   Tiger(Tiger t){
      // this = t;
   }
   
   int a, b;
   int size;
   
   Tiger(int a, int b, int size) {
      this.a = a; // 멤버 a = 전달 인수 a
      this.b = b;
      this.size = size;
   }
   
   void show() {
      System.out.println(this.a+" "+this.b);
   } // == 우클릭 - source - generate constructor using field
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger(10, 20, 30);
      int num = 10;
      num = num; // 자기 대입 의미 없는 코드 
      t1.show();
   }
}
*/

/*
// ex43-1) this (self 랑 비슷한 개념 같음) 
class Tiger {
//  생략된 코드 
//   Tiger this;
//   Tiger (Tiger t, int a, int b){
//      this = t;
//  }
   
   Tiger (int a, int b){
      System.out.println("this: "+this.hashCode());
   }
   
   void m1(int a, String b, Tiger c) {
      System.out.println(1);
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger(10, 20);
      System.out.println(t1.hashCode());
      
      Tiger t2 = new Tiger(30, 40);
      System.out.println(t2.hashCode());
   }
}
*/

/*
// ex42) final
final class Animal {
   final int NUM = 10;
   // final + 변수 == 대입이 마지막이다. value 변경 불가. 상수  
   // final 변수는 대문자 사용이 관례

   final void m1 () {
   } // final + 함수 == 오버 라이딩이 마지막 
} // final + class == 상속 금지 

//class Tiger extends Animal {
//   void m1() {
//   }  Cannot override the final method from Animal
//} The type Tiger cannot subclass the final class Animal

public class Hello 
{
   public static void main(String[] args) 
   {
      Animal t1 = new Animal();
      // t1.NUM = 20; => error
      
      System.out.println(Math.PI);
   }
}
*/