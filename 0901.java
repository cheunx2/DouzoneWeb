package Pack;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println("check");
   }
}
*/

// ex72)
public class Hello extends Application
{
   @Override
   public void start(Stage arg0) throws Exception {
      VBox root = new VBox();
      root.setPrefSize(400,300); 
      
      Button btn1 = new Button("테스트1");
      root.getChildren().add(btn1);
      
      Button btn2 = new Button("테스트2");
      root.getChildren().add(btn2);
      
      Scene scene = new Scene(root);
      arg0.setScene(scene);
      arg0.setTitle("Server");
      arg0.show();
   }

   public static void main(String[] args) 
   {
      launch();
      System.out.println("Exit");
   }
}

/*
// ex71)
// jfx 다운로드 program files > java 에 압축 풀기
// 프로젝트 우클릭 > Properties > Jave Build Path > Libraries > Modulepath 클릭 > Add External JARs... > 다운 받은 파일로 들어가서 >
// lib > ctrl + a에서 ctrl 눌러서 src 제외 하고 열기 > open > apply

// --module-path "C:\Program Files\Java\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib"
// --add-modules javafx.controls,javafx.fxml

// 프로젝트 우클릭 - Run as - run configurations - Arguments - VM arguments에 위에 두 줄 복붙 -apply -run
// class에 extends Application ctrl + space 자바 어쩌구 클릭 하고 
// 스코프 안에 들어가서 ctrl + space 해서 엔터 => start 함수 생김
public class Hello extends Application
{
   @Override
   public void start(Stage arg0) throws Exception {
      System.out.println(2);
      arg0.show();
      System.out.println(3);
      
   }
   
   public static void main(String[] args) 
   {
      System.out.println(1);
      Launch();
      System.out.println(4);
   }
}
*/

/*
// ex70)
public class Hello 
{
   public static void main(String[] args) 
   {
      Thread t = new Thread() {
         public void run() { // 함수 호출이 아니고 스레드 시작 
            System.out.println(1);
         }
      };
      t.start();
      
      new Thread() {
         public void run() {
            System.out.println(2);
         }
      }.start();
   }
}
*/

/*
// ex69)
// Window-Show View-Other-Debug 디렉토리-Debug-우클릭 Terminate and Remove
class Tiger extends Thread {
   public void run() {
      System.out.println("Tiger start");
      Thread t = new Lion();
      t.start();
      Scanner sc = new Scanner(System.in);
      sc.nextInt(); // 블록킹 함수 
      System.out.println("Tiger end");
   }
}

class Lion extends Thread {
   public void run() {
      System.out.println("Lion start");
      Scanner sc = new Scanner(System.in);
      sc.nextInt(); // 블록킹 함수 
      System.out.println("Lion end");
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println("main start");
      Thread t = new Tiger();
      t.start();
      Scanner sc = new Scanner(System.in);
      sc.nextInt(); // 블록킹 함수 
      System.out.println("main end");
   }
}
// case 1) 입력 1 - end 입력 2 - end 입력 3 - end 
// main, Lion Tiger end  순서는 OS 마음대로
// case 2) 입력 1 - 입력 2 - end end - 입력3 - end
// end 출력하기 전에 다른 Scanner 호출 code line 으로 넘어가서 나중에 출력 됨  
*/

/*
// ex68) Thread 스레드
class Tiger extends Thread{
   public void run() {
      System.out.println(1);
      
      for (int i = 0; i < 10; i++) {
         System.out.println("호랑이" + i);
         try {Thread.sleep(0); } catch (Exception e) {}
         // 0초가 아니라 쉴 수 있는 한도내에서 가장 짧게 쉬어라
      }
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Thread t = new Tiger();
      t.start(); 
      // 부모함수(Thread) 에 있는 함수 start
      // 1이 출력 되는 것으로 보아 start 내부에서 run 함수 실행 
      System.out.println(2);
      // => 스레드가 생성 되었다. 
      // 1이 먼저 나올지 2가 먼저 나올지는 운영체제가 지정한다 
      
      for (int i = 0; i < 10; i++) {
         System.out.println("코끼리" + i);
         try {Thread.sleep(0); } catch (Exception e) {}
      } 
      System.out.println("main Exit");
   }
}
*/

/*
// ex67)
class A {
   void start() {
      System.out.println("start call");
      run();
   }
   
   void run() {
      System.out.println("A run call");
   }
}

class B extends A {
   void run() {
      System.out.println("Start Thread");
      System.out.println("B run call");
      System.out.println("End Thread");
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      A a = new B();
      a.start();
   }
}
*/

/*
// ex66) 제네릭 Generic
//class A {
//   private int data;
//   
//   public int getData() {
//      return data;
//   }
//   public void setData(int data) {
//      this.data = data;
//   }
//}
//
//class B {
//   private String data;
//   public String getData() {
//      return data;
//   }
//   public void setData(String data) {
//      this.data = data;
//   }
//}
//
//class C {
//   private float data;
//   public float getData() {
//      return data;
//   }
//   public void setData(float data) {
//      this.data = data;
//   }
//}

class A<T> {
   private T data;
   public T getData() {
      return data;
   }
   public void setData(T data) {
      this.data = data;
   }
} // <T> =>외부에서 타입을 지정한다. 제네릭 문법 
// 기계어로 변환시 타입별 class 가 생성되기 때문에 <T> 사용이 코드라인에는 영향을 미치지 않는다. 

public class Hello 
{
   public static void main(String[] args) 
   {
      A<String> a = new A<String>();
      a.setData("호랑이");
      System.out.println(a.getData());
      
      A<Integer> b = new A<Integer>();
      b.setData(100);
      System.out.println(b.getData());
   }
}
*/

/*
// ex65) 데코레이션 패턴
class Coffee {
   int price = 30;
   int payment() {
      System.out.println("Order coffee");
      return price;
   }
}

class Sugar extends Coffee {
   int price = 20;
   Coffee coffee;
   Sugar (Coffee c){
      this.coffee = c;
   }
   
   int payment() {
      System.out.println("Add sugar");
      return price + coffee.payment();
   }
}

class Cream extends Coffee{
   int price = 10;
   Coffee coffee; // 곧 사라질 객체를 백업 받음 
   Cream (Coffee c){
      this.coffee = c;
   }
   
   int payment() {
      System.out.println("Add cream");
      return price + coffee.payment();
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Coffee order = new Coffee();
      
      order = new Sugar(order);
      order = new Sugar(order);
      
      order = new Cream(order);
      order = new Cream(order);
      order = new Cream(order);
      
      System.out.println(order.payment());
   }
}
*/

/*
// ex64)
class A {
   int num = 10;
   int run() {
      System.out.println("A Run");
      return num;
   }
}

class B extends A{
   int num = 20;
   A a; // 곧 사라질 객체를 백업 받음 
   B (A a){
      this.a = a;
   }
   
   int run() {
      System.out.println("B run");
      return num + a.run();
   }
}

class C extends A{
   int num = 30;
   A a; // 곧 사라질 객체를 백업 받음 
   C (A a){
      this.a = a;
   }
   
   int run() {
      System.out.println("C run");
      return num + a.run();
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      A a = new A();
      a = new B(a);
      System.out.println(a.run());
      System.out.println("---------------------------");
      
      a = new C(a);
      System.out.println(a.run());
   }
}
*/

/*
// ex63-2)
class AA {}
class BB extends AA {}
class CC extends AA {}
public class Hello 
{
   public static void main(String[] args) 
   {
      AA a1 = new BB();
      System.out.println(a1.hashCode());
      a1 = new CC();
      System.out.println(a1.hashCode());
      
      AA a2 = a1;
      a1 = new BB();
      System.out.println(a1.hashCode());
      System.out.println(a2.hashCode());
   }
}
*/

/*
// ex63-1)
class AA {}
class BB extends AA {}
class CC extends AA {}
public class Hello 
{
   public static void main(String[] args) 
   {
      AA a1 = new BB();
      System.out.println(a1.hashCode());
      a1 = new CC();
      System.out.println(a1.hashCode());
      a1 = new BB();
      System.out.println(a1.hashCode());
   }
}
*/

/*
// ex62) 파일 입출력 
// 위치 찾기
// Package Explorer - 프로젝트 우클릭 - properties - Resource - Location 아이콘 클릭
 public class Hello 
 {
    public static void main(String[] args) {
      try {
         Writer w = new FileWriter("test01.txt");
         
         w.write("apfel");
         w.write("\n\n"); // \n == 개행 
         w.write("Halo");
         w.write("\n----------------------------------------\n");
         
         for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
               w.write((i + j) % 2== 0 ? "O " : "X ");
            }
            w.write("\n");
         }
         
         w.close(); // *** 항상 닫아주기 ***
         System.out.println("파일 입출력 종료");
         
      } catch (Exception e) {
      }
      
      try {
         Reader r = new FileReader("test02.txt"); // ANSI 자동으로 변환 됨 
         //Reader r = new FileReader("test02.txt", StandardCharsets.UTF_8);

         while(true) {
            int data = r.read();
            if (data == -1) {
               break;
            }
            System.out.print((char)data);
         }
         r.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 }
 */

/*
// ex61) 이중 for문
public class Hello 
{
   public static void main(String[] args) 
   {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 4; j++) {
            System.out.print("["+ i +" " + j + "]");
         }
         System.out.println();
      }
      
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 6; j++) {
            if ((i + j)% 2 == 0) {
               System.out.print("O ");
            }else {
               System.out.print("X ");
            }
         }
         System.out.println();
      }
   }
}
*/

/*
// ex60) 싱글톤 패턴: 클래스에 객체를 하나만 셍상힌디.
// 객체 생성시 마다 비용 부담이 늘어나는데 이를 절약할 수 있다. 
class Tiger {
   private static Tiger instance = null;
   private Tiger(){} // 객체 생성 방지 
   int num ;
   
   static Tiger getInstance() {
      if(instance == null) {   
         System.out.println(1);
         instance = new Tiger();
      }
      return instance;
   }
   
   void m1() {
      System.out.println(1000);
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      //Tiger t1 = new Tiger(); => error 
      //Tiger t2 = new Tiger();
      
      Tiger t1 = Tiger.getInstance();
      Tiger t2 = Tiger.getInstance();
      
      System.out.println(t1.hashCode()); // hashcode 같음 같은 객체 바라보고 있다
      System.out.println(t2.hashCode());
      
      t1.m1();
      t2.m1();
      
      System.out.println(t2.num);
      t1.num = 2000;
      System.out.println(t2.num); 
      // 같은 객체를 사용하기 때문에 t1.num 바꿨을 떄 t2.num도 변경됨
   }
}
*/

/*
// ex59)
class Tiger {
   private String name;
   private int age;
   
   String getName() {
      return name;
   }
   
   void setName(String name) {
      this.name = name;
   }
   
   int getAge() {
      return age;
   }
   
   void setAge(int age) {
      this.age = age;
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {

   }
}
*/

/*
// ex58)
class Tiger {
   private int a; // 데이터 은닉, 클래스 내부에서만 사용 가능 
   public int b; // default int b; default 가 생략 됨. public이 가장 유사함 

   // private, setter, getter 한 쌍으로 주로 사용 됨 
   private int num;

   // setter 
   public void setNum(int num) { // set(private 변수 이름)
      this.num = num;
   }
   
   // getter
   public int getNum() {
      return this.num;
   }
   
   void m1() {
      a = 100;
      b = 200;
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      Tiger t = new Tiger();
      t.b = 10;
      // t.a = 20; private 이라 밖에서 사용 불가 
      t.setNum(100);
   }
}
*/

/*
// ex57)
interface Test1{
   void m1();
}

interface Test2{
   int m1();
}

class Tiger {
   void m2(Test1 t) {
      t.m1();
   }
   
   void m3(Test2 t) {
      System.out.println(t.m1());
   }
}

public class Hello 
{
   public static void main(String[] args) 
   {
      // (1-1)
      Test1 t1 = ()->{
         System.out.println(1);
      };
      
      Tiger tiger = new Tiger();
      tiger.m2(t1);
      
      // (1-2) 축약버전 
      tiger.m2(()->{
         System.out.println(2);
      });
      
      // (2-1)
      tiger.m3(()->{
         return 100;
      });
      
      // (2-2)
      tiger.m3(()->100);

      // (3)
      LinkedList<Integer> mm = new LinkedList<Integer>();
      
      mm.removeIf(temp-> {
         return temp % 2==0;
      });
      mm.removeIf(temp-> temp % 2==0);      
   }
}
*/

/*
// ex56) lambda 람다 함수 
interface Test1{
   void m1();
}

interface Test2{
   void m1(int num);
}

interface Test3{
   int m1();
}

interface Test4{
   String m1(int num, String txt);
}

public class Hello 
{
   public static void main(String[] args) 
   {
      // (1)
      Test1 t1 = new Test1() {
         @Override
         public void m1() {
            System.out.println(1);
         }
      };
      t1.m1();
      
      // (2)
      Test1 t2 = ()->{
         System.out.println(2);
      };
      t2.m1();
      
      // (3) 람다함수에서는 타입 생략
      Test2 t3 = (n)->{
         System.out.println(n);
      };
      t3.m1(100);
      
      // (4)
      Test3 t4 = ()-> {
         System.out.println(3);
         return 100;
      };
      System.out.println(t4.m1());
      
      // (5)
      Test4 t5 = (age, name)-> {
         return age+name;
      };
      System.out.println(t5.m1(27, "강아름")); 
      
      // (6) 스코프 안에 return 한 줄 있을 때 return, 스코프 생략 가능 각각 생략은 안 됨
      Test3 t6 = ()-> 100;
      System.out.println(t4.m1());
   }
}
*/

/*
// ex55-2) Set
public class Hello 
{
   public static void main(String[] args) 
   {
      Set<String> set = new HashSet<String>(Arrays.asList("Java","JDBC"));
      
      set.add("Java"); // 중복이라 추가 안 됨 
      System.out.println(set);
   }
}
*/

/*
// ex55-1) List
class Board {
   String subject;
   String content;
   String writer;
   
   Board(String subject, String content, String writer){
      this.content = content;
      this.subject = subject;
      this.writer = writer;
   }
}
public class Hello 
{
   public static void main(String[] args) 
   {
      List<Integer> t = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
      
//      t.remove(1);
//      System.out.println(t); // index 1 삭제 
       
      t.remove(Integer.valueOf(1));
      System.out.println(t); // value 1 삭제
      
      // ArrayList 
      // 크기가 고정되어 사용 도중 변경 불가한 다른 배열과 달리 자동으로 저장용량 늘어난다. 
      // 초기 용량 == 10 
      List<String> list = new ArrayList<String>(Arrays.asList("a","b","c")); 
      System.out.println("총 객체 수: "+ list.size());
      System.out.println("2 번째 들어있는 객체: "+ list.get(2));
      
      // Vector ArrayList 와 내부 구조는 동일하나 동기화 된 메소드로 구성 되어
      // 객체 변환시 안전 => Thread is Safe. 스레드 안전함
      List<Board> b = new Vector<Board>();
      
      b.add(new Board("제목", "내용", "작가"));
      b.add(new Board("제목1", "내용1", "작가1"));
      b.add(new Board("제목2", "내용2", "작가2"));
      
      b.remove(1);
      
      int size = b.size();
      for (int i = 0; i < size; i++) {
         Board board = b.get(i);
         System.out.println(board.subject+" "+board.content+" "+board.writer);
      }
      
      // LinkedList 인접 참조를 링크하여 체인처럼 관리 
      // 중간에 객체 추가나 삭제시 앞 뒤 참조 링크만 수정 
      // 데이터 업데이트가 많은 경우 ArrayLink 보다 효율적 
   }
}
*/

/*
// ex54) Iterator
public class Hello 
{
   public static void main(String[] args) 
   {
      LinkedList<Integer> mm = new LinkedList<Integer>();
      
      mm.add(33);
      mm.add(44);
      mm.add(77);
      
      for (int i = 0; i < 10; i++) {
         mm.add(i*2);
      }
      
      mm.add(101);
      mm.add(102);
      mm.add(103);
      
      System.out.println(mm);
      
// (1)
//      int size = mm.size();
//      for (int i = 0; i < size;) {
//         int num = mm.get(i);
//         
//         if (num % 2 == 0) {
//            mm.remove(i);
//            size = mm.size();
//         }else {
//            i++;
//         }
//      }

// (2)
//      for (Iterator<Integer> it = mm.iterator(); it.hasNext();) {
//         Integer num = it.next();
//         if(num%2 ==0) {
//            it.remove();
//         }
//      } // 다음 데이터가 있을 때까지 돈다 
      
// (3)
//      mm.removeIf(new Predicate<Integer>() {
//         @Override
//         public boolean test(Integer num) {
//            return num % 2 == 0;
//         }
//      });

// (4) 람다함수
      mm.removeIf(num -> num % 2 == 0);
      System.out.println(mm);
   }
}
*/

/*
// ex53)
public class Hello 
{
   public static void main(String[] args) 
   {
      LinkedList<Integer> mm = new LinkedList<Integer>();
      
      for (int i = 0; i < 10; i++) {
         mm.add(i*10+i);
      }
      System.out.println(mm);
      
      int size = mm.size();
      for (int i = 0; i < size; i++) {
         int num = mm.get(i);
         //System.out.println(num);

         if (num == 44) {
            System.out.println(i+"번째 찾았다.");
            break;
         }
         if (i == size - 1) {
            System.out.println("Not Found");
         }
      }
      
      for (int i = 0; i < size; i++) {
         int num = mm.get(i);
         if (num == 55) {
            mm.remove(i);
            System.out.println("55 has been removed");
            System.out.println(mm);
            break;
         }
         if (i == size - 1) {
            System.out.println("Not Found");
         }
      }
   }
}
*/