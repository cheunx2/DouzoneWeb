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

// ex8) 변수를 활용한 사칙연산
public class Hello 
{
   public static void main(String[] args) 
   {
      int a = 17, b = 3;
      a = 40;
      b= 4; // 변수 활용시 변수만 바꿔주면 나머지 코드 수정 불필요
      System.out.println(a + b);
      System.out.println(a - b);
      System.out.println(a * b);
      System.out.println(a / b);
      System.out.println(a % b);
      
      System.out.println(a > b);
      System.out.println(a < b);
      System.out.println(a <= b);
      System.out.println(a >= b);
      System.out.println(a == b);
      System.out.println(a != b);
      
      System.out.println(a > b * 6); 
      System.out.println(a > b * 7 || a - 10 > b);
      // 연산 우선순위 : 산술 비교 논리
      
   }
}

/*
// ex7)
public class Hello 
{
 public static void main(String[] args) 
 {
    // (1)
    int a;
    a = 10; 
    System.out.println(a);
    
    // (2)
    int b,c,d;
    b = 1;
    c = 2;
    d = 3;
    System.out.println(b);
    System.out.println(b+""+c+""+d);
    
    // (3) 선언과 동시에 초기값 설정
    int e = 10;
    int f = 20, g = 30;
    int h, i = 40, j; // => i에 40, h는 값을 못 받음
    h = 50;
    j = 60;
    System.out.println(e);
    System.out.println(h);
    System.out.println(i);
    System.out.println(j);
    
    //(4)
   int a10 = 10;
   System.out.println(a10);
   a10 = 20;
   System.out.println(a10);
   
   //(5) swap a, b = b, a
   int aa = 88, bb = 99;
   int temp;
   System.out.println(aa + " " + bb);
   temp = aa; // 88
   aa = bb; // 99
   bb = temp; // 88 
   System.out.println(aa + " " + bb + " " + temp);
   
   int cc = 100;
   int dd = 200;
   int tt = cc;
   cc = dd;
   dd = tt;
   System.out.println(cc+ " " +dd+ " " +tt);
 }
}
*/

/*
// ex6) 리터럴 타입
public class Hello 
{
 public static void main(String[] args) 
 {
    // 8가지 표준 타입
    byte apple = 127; // 8 bit (1 byte) - Range: -128 ~ 127
    System.out.println(apple);
    System.out.println(Byte.MIN_VALUE); // -128 
    System.out.println(Byte.MAX_VALUE); //127
    short banana = 32767; //16 bit
    System.out.println(banana);
    System.out.println(Short.MIN_VALUE);
    System.out.println(Short.MAX_VALUE);
    int orange = 2147483647; // 32 bit
    System.out.println(orange);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
    long mango = 222222; // 64 bit
    System.out.println(mango);
    System.out.println(Long.MIN_VALUE);
    System.out.println(Long.MAX_VALUE);
    
    float tiger = 3.14f; // 32 bit - 4byte 실수 메모리
    System.out.println(tiger);
    double lion = 3.14; // 64 bit - 8byte 실수 메모리 
    System.out.println(lion);
    
    //char cat = 1234; 이런식으로 사용하지 않음. 숫자 ㄴㄴ
    char cat = '한'; // 2byte 
    System.out.println((int)Character.MIN_VALUE);
    System.out.println((int)Character.MAX_VALUE);
    boolean dog = true;// 1byte - true or false 
    boolean chicken = false;
 }
}
*/

/*
// ex5)
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println(10); // 숫자 출력       
      System.out.println('한'); // 문자 출력 (바이트와 관련 없음)       
      System.out.println("호랑이"); // 문자열 출력 
      System.out.println("1000"); // 문자열 1000 출력
      
      System.out.println(10 + 20 ); // 숫자 + 숫자 => 숫자
      System.out.println(10 + "호랑이"); // 숫자 + 문자열 => 문자열
      System.out.println("호랑이" + 10); // 문자열 + 숫자 => 문자열
      System.out.println("호랑이" + "코끼리"); // 문자열 + 문자열 => 문자열
      System.out.println(10 + "호랑이" + 20); // 숫자 + 문자열 + 숫자 => 문자열
      System.out.println(10 + 20 + "호랑이"); // 숫자 + 숫자 + 문자열 => 문자열
      System.out.println("호랑이" + 10 + 20); // 문자열 + 숫자 + 숫자 => 문자열
      
      System.out.println(10 + " " + 20); // 숫자 + 공백 + 숫자 => 문자열
   }
}
*/

/*
// ex4) 논리연산자 
public class Hello 
{
   public static void main(String[] args) 
   {
      // 논리or 하나라도 true 이면 true
      System.out.println(false||false);
      System.out.println(false||true);
      System.out.println(true||false);
      System.out.println(true||true);
      
      // 논리and 모두 true 이면 true
      System.out.println(false&&false);
      System.out.println(false&&true);
      System.out.println(true&&false);
      System.out.println(true&&true);
      
      System.out.println(false||false||true);
      System.out.println(false||(false||true));      
      System.out.println(false||true||true);
      
      System.out.println((3 > 2)||false||(6 >= 3));
      System.out.println(!true); // 부정연산자
      System.out.println(!(3>2));
   }
}
*/

/*
// ex3) 비교연산자
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println(5 < 3);
      System.out.println(5 > 3);
      System.out.println(5 == 3);
      System.out.println(5 <= 3);
      System.out.println(5 >= 3);
      System.out.println(5 != 3);
   }
}
*/

/*
// ex2) 산술연산자
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println(20 + 3);
      System.out.println(20 - 3);
      System.out.println(20 * 3);
      System.out.println(20 / 3); // 몫
      System.out.println(20 % 3); // 나머지 
      System.out.println(3 + 2 * 4); // 내가 작성한 순서와 무관한 결과 연산 순서가 있음 
      System.out.println((3 + 2) * 4); // 괄호를 통해 연산 우선 순위 정해줄 수 있다. 
   }
}
*/

/*
// ex1)
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println("ttt");
   }
}
*/