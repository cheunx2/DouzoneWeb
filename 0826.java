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
// ex24) 숫자를 문자열로 문자열을 숫자로 
public class Hello 
{
   public static void main(String[] args) 
   {
      int a = 100;
      String s1 = Integer.toString(a);
      System.out.println(0+s1);
      
      String s2 = ""+a;
      System.out.println(0+s2);
      
      int b = Integer.parseInt(s2);
      System.out.println(0+b);
   }
}
*/

/*
// ex23) 클래스 안에서 동일명의 함수라도 인수 개수가 다르거나 타입이 다르면 사용 가능 
//=> 함수 오버로딩(재정의) 
class Tiger{   
   void method01() {
      System.out.println(1);
   }
   
   void method01(int a) {
      System.out.println(2);
   }
   
   void method01(String a) {
      System.out.println("2-1");
   }
   
   void method01(int a, int b) {
      System.out.println(3);
   }
   
   int getAreaRect(int w, int h) {
      return w*h;
   } // 직사각형 넓이 
   
   int getAreaRect(int len) {
      return len*len;
   } // 정사각형 넓이 => 인수가 다르지만 같은 기능이므로 오버로당 
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      t1.method01();
      t1.method01(1);
      t1.method01("");
      t1.method01(1, 2);
      
      System.out.println("넓이는 "+t1.getAreaRect(2, 10)+"입니다.");
      System.out.println("넓이는 "+t1.getAreaRect(5)+"입니다.");
   }
}
*/

/*
// ex22) continue, break
public class Hello 
{
   public static void main(String[] args) 
   {
      for(int i = 0; i < 10; i++) {
         if(i < 3) {
            continue; // 만나면 i++로 
         }
         System.out.println(i);
         if(i == 7) {
            break; // 자기를 감싸고 있는 반복문중 가장 가까운 반복문을 탈출
         }
      }
      System.out.println("호랑이");
      
      int num = 0;
      while(true) {
         num++;
         if(num % 2 != 0) {
            System.out.println("홀수 "+num);
            continue; // while 조건으로 감 
         }
         if(num == 10) {
            System.out.println("짝수 "+num);
            break;
         }
      }
   }
}
*/

/*
// ex21) return 
class Tiger{
   int m1(int a, int b) {
      if(a > b) {
         return 100;
      }else {
         System.out.println("호랑이");
         return 0;
      }
   }
   
   void m2() {
      System.out.println(1);
      return ; // => 함수 실행 중단
      //System.out.println(2); => Unreachable Code 
   }
   
   void m3(int num) {
      for (int i = 0; i < 10; i++) {
         if(i == num) {
            System.out.println("found");
            return ; // 함수 종료하고 싶을 때 
         }
      }
      System.out.println("검색 데이터를 찾지 못하였습니다.");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      System.out.println(t1.m1(4, 5));
      t1.m1(5, 4);
      t1.m3(4);
      t1.m3(15);
   }
}
*/

/*
// ex20
class Tiger{
   String m1() {
      return "독수리"; 
   }
   
   Lion m2() {
      //return new Lion();
      Lion t = new Lion();
      return t;
   }
   
   Lion m3(Lion t) {
      return t;
   }
}

class Lion{
   void show() {
      System.out.println(1000);
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t1 = new Tiger();
      String s1 = t1.m1();
      System.out.println(s1);
      System.out.println(t1.m1());
      
      Lion t2 = t1.m2();
      t2.show();
      
      Lion t3 = t1.m3(new Lion());
      t3.show();

      t1.m3(new Lion()).show();
   }
}
*/

/*
// ex19)
class Tiger{
   // *** int a, b는 불가능 ***
   void m1(int a, int b) {
      System.out.println(a+""+b);
      System.out.println(a * b + a);
   }
   
   void m2(int a, char b, boolean c, float d, String e) {
      System.out.println(a+" "+b+" "+c+" "+d+" "+e);
   }
   
   void m3(Lion a) {
      System.out.println(a.hashCode());
      a.sound();
   } 
}

class Lion{
   void sound() {
      System.out.println("어흥");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      String s1 = "호랑이11111111111111111111111111111"; // 자바에서 만들어 준 표준 클래스 
      System.out.println(s1);
      System.out.println(s1.length());
      
      Tiger t1 = new Tiger();
      t1.m1(3, 4);
      t1.m2(10, '한', true, 3.14f, "호랑이");
      
      Lion t2 = new Lion();
      
      t1.m3(t2);
      
      System.out.println(t2.hashCode());
      t1.m3(new Lion());
      // => 괄호에서 해도 같은 의미 Lion a = new Lion();
      
   }
}
*/

/*
// ex18) 함수 
class Tiger
{
   // method == function in java
   
   // (1) 기본형식, return x 인수 x
   void merry() {
      System.out.println("멍");
   } // => 함수: 자주 사용되는 코드 저장해놓고 불러서(call) 사용하는 것 
   
   // (2) 인수 *void == return 값이 없다, return x 인수 o
   void happy(int num) {
      for(int i = 0; i < num; i++) {
         System.out.println("왕");         
      }
   }
   
   // (3) int 를 return 하는 함수, return o 인수 x
   int turtle(){
      return 15;
   }
   
   // (4) return o 인수 o
   int fish(int num){
      int n = num*3;
      return n;
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t = new Tiger(); // new ctrl + space enter
      
      for (int i = 0; i < 10; i++) {
         t.merry();            
      }
      System.out.println("-------------------------");
      t.happy(3); // =>인수 전달 | happy => parameter 받음
      
      System.out.println("-------------------------");
      int num = t.turtle();
      System.out.println(num);
      System.out.println(t.turtle());
      System.out.println("-------------------------");
      int city = t.fish(7);
      System.out.println(city);
      System.out.println(t.fish(345));
   }
}
*/

/*
// ex17) 클래스 
class Tiger // 클래스 이름은 첫 글자가 대문자 암묵적인 규칙
{
   // (1) field == 클래스 단에서 선언 되는 변수, member
   int a;
   int b = 20;
   int c, d = 30;
   
   // (2) 생성자
   // (3) method
}

public class Hello 
{
   public static void main(String[] args) 
   {
      // 객체를 만드는 것 인스턴스 화 => new
      Tiger t1 = new Tiger(); // 앞이 Tiger 면 뒤에도 반드시 Tiger! 
      Tiger t2 = new Tiger();
      
      t1.a = 100;
      t1.c = t1.a + 30;
      System.out.println(t1.a);
      System.out.println(t1.b);
      System.out.println(t1.c);
      System.out.println(t2.c); // t1.c != t2.c
      System.out.println(t1.d);
      
      System.out.println(t1.hashCode()); 
      System.out.println(t2.hashCode()); 
      
      Tiger t3;
      t3 = t2;
      System.out.println(t3.hashCode()); // t2와 t3는 메모리를 공유한다. 참조
      
      t3.a = 999;
      System.out.println(t2.a); // 같은 주소를 사용하기 때문에 t3.a를 바꾸면 t2.a도 변함
   }
}
*/

/*
// ex16)
public class Hello 
{
   public static void main(String[] args) 
   {
      int a = 10, b;
      b = a++; // 대입한 뒤에 +1
      System.out.println(a+" "+b);
      
      int c = 10, d;
      d = ++c; // 대입 전에 +1
      System.out.println(c+" "+d);
      
      int a1 = 10, a2= 10;
      System.out.println(a1++);
      System.out.println(++a2);
   }
}
*/

/*
// ex15)
public class Hello 
{
   public static void main(String[] args) 
   {
      // 타입 변수 대입 연산자 리터럴
      int a = 10;
      int b = 20;
      short c = 30;

      // 대입 연산자는 항상 타입이 동일 해야 한다
      b = (int)c;
      c = (short)a;
      
      int num = 10;
      num = num + 3;
      num += 3;
      
      int a1 = 0, a2 = 0;
      a1 = a2 + 3;
      
      int t = +1; // t 랑 r 은 같음 
      int r = 1;
      int u = -1;
      
      if(t==r) {
         System.out.println("same");
      }
      
      int k = 0;
      k += 3;
      System.out.println(k);
      k =+ 3; // 대입 연산자 쓰려다 나는 오타. 에러 안 뜨니까 유의!
      System.out.println(k);
      
      int d = 0;
      d++; // 속도 빠름
      System.out.println(d);
      ++d; // 속도 빠름
      System.out.println(d);
      d+=1; // 컴파일 속도 빠름 
      System.out.println(d);
      d = d + 1; // add 가 실행 되어서 속도가 느림 
      System.out.println(d);
   }
}
*/

/*
// ex14) 콜라츠 추측
public class Hello 
{
   public static void main(String[] args) 
   {
      // (1)
      int n = 77;
      int cnt = 0;
      while(true) {
         n=(n%2==0) ? n/2 : n*3+1; // 괄호 생략가능, ? : 앞뒤로 공백 주기 
         //if(n%2==0) {
            //n = n/2;
         //}else {
            //n =n*3+1;
         //}
         System.out.println(n);
         if(n==1) {
            System.out.println("탈출직전 "+ n);
            System.out.println(cnt);
            break;
         }
         cnt++;
      }
      
      // (2)
      int n2 = 1234;
      int r;
      int sum = 0;
      
      while(true) {
         r = n2 % 10;
         n2 /= 10;
         sum += r;
         System.out.println(sum +" "+ r +" "+ n2);
         if(n2==0) {
            break;
         }
      }
      System.out.println(sum);
   }
}
*/

/*
// ex13) while
public class Hello 
{
   public static void main(String[] args) 
   {
      // for 반복 횟수 프로그래머가 지정, while 반복 횟수를 모를 때   
      int num = 0;
      //while(true) {
         //System.out.println(num+" "+"This is test.");
         //num++;
      //}
      while(num<10) {
         num++;
      }
      System.out.println("호랑이"); // => 반복횟수를 알아서 for문에서도 동일한 코드 가능
      
      int a = 0;
      while(true) {
         System.out.println(a);
         a++;
         if(a==5) {
            break;
         }
      }
   }
}
*/

/*
// ex12) 
public class Hello 
{
   public static void main(String[] args) 
   {
      // 합산 프로그램
      int sum = 0;
      for (int i = 1; i <= 10; i++) {
         sum += i;
      }
      System.out.println(sum);
      
      int n = 7;
      for (int i = 0; i <= 9; i++) {
         System.out.println(n+" * "+i+" = "+(i*n));
      }
   }
}
*/

/*
// ex11) 제어문(for문)
public class Hello 
{
   public static void main(String[] args) {      
      int num = 10;
      num = num + 3;
      System.out.println(num);
      num = num + 1;
      System.out.println(num);
      num++;
      System.out.println(num);
      num--;
      System.out.println(num);
      ++num;
      System.out.println(num);
      --num;
      System.out.println(num);

      for (int i = 0; i < 3; i++) {
         System.out.println("호랑이" + i);
      } // 조건문 false 일 때 루프 탈출
      
      // 쓰면 안 되는 코드!
      // (1) i 에는 0 또는 1만 넣어야 함
      // (2) 부등호 부호는 < 
      // (3) i++, i-- 만 넣기 
      // => 의도는 for문 안에서 구현하기. 위 조건을 어길시 디버깅이 어려움
      
      //for (int i = 5; i > 4; i = i + 3) {
      //}
      
      // 형식 1 5 == 반복 횟수!!
      for (int i = 0; i < 5; i++) {
      }
      
      // 형식 2
      for (int i = 1; i <= 5; i++) {   
      }
      
      // 형식 3 음수, 양수 좌표값 제어시 사용 반복횟수 == 5*2+1 
      int n = 5;
      for (int i = -n; i <= n; i++) {
      }
   }
}
*/

/*
// ex10) 제어문(switch문)
public class Hello 
{
   public static void main(String[] args) 
   {
      // (1) case 뒤에는 변수가 올 수 없음
      // (2) switch 에는 변수 가능
      // (3) default break 는 생략 가능
      // (4) 의도적인 경우 break 생략 가능
      // (4-1) 생략시 다음 case 분기 속 명령어 실행 됨
      // (5) case 분기에서 실행되는 문장이 여러줄이면 블록 처리함

      int num = 10;

      switch(num){
      case 10:
         System.out.println(1);
         //break;
      case 20:{
         System.out.println(2);
         System.out.println(100);
      }break;
      case 30:
         System.out.println(3);
         break;
      default: // case에 모두 해당이 안 되면 default 값으로 
         System.out.println(4);
         break;
      }

      int jumsu = 83;
      int q = jumsu/10;
      
      switch(q) {
      case 9:
         System.out.println("A학점 입니다.");
         break;
      case 8:
         System.out.println("B학점 입니다.");
      break;
      case 7:
         System.out.println("C학점 입니다.");
      break;
      case 6:
         System.out.println("D학점 입니다.");
      break;
      case 5:
         System.out.println("F학점 입니다.");
      break;
      }
      // if else 실행 시간이 일정하기 않고, 오래 걸릴 수 있음. 3개 이상인 경우 switch로 변경
   }
}
*/

/*
// ex9) 제어문 (if문)
public class Hello 
{
   public static void main(String[] args) 
   {
      // (1) if문
      System.out.println(1);
      if(true) // 괄호 안에 참 거짓 판별 되는 식 
      {
         System.out.println(2);
      }; // 세미콜론 들어가는 것이 원칙이나 생략가능
      if(false)
      {
         System.out.println(3); // 노란색 줄은 이클립스 자체 경고 
      };
      System.out.println(4);

      // (2) if else문
      if(true) {
         System.out.println(5);
      }else {
         System.out.println(6);
      }; // 삼항연산으로 변환 가능하다면 삼항연산을 하는 것이 원칙 
      
      // (3) 삼항연산
      int a = 10, b = 5;
      int c;

      if(a>b) {
         c = 7;
      }else {
         c = 8;
      } // if, else 로 들어가는 변수가 같다면 삼항 연산
      System.out.println(c);

      c = a>b ? 7:8; // 조건 ? true 일 때 : false 일 때;
      System.out.println(c);

      if(a>b) {
         System.out.println("호랑이");
      }else {
         System.out.println("코끼리");
      };
      
      System.out.println(a>b ? "호랑이":"코끼리"); 
      // 명시적인 변수가 아니라도 삼항연산자 사용 가능
      
      // (4) else if문  
      int num = 83;
      
      if(num>=90) {
         System.out.println("A학점 입니다.");
      }else if(num>=80) {
         System.out.println("B학점 입니다.");         
      }else if(num>=70) {
         System.out.println("C학점 입니다.");
      }else if(num>=60) {
         System.out.println("D학점 입니다.");
      }else {
         System.out.println("F학점 입니다.");
      }
      // switch 문으로 변경 가능 하다면 switch문으로 사용 하는 것이 좋음
   }
}
*/