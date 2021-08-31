package Pack;

import java.util.*;

/*
public class Hello 
{
   public static void main(String[] args) 
   {
      System.out.println("check");
   }
}
*/

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

/*
// ex52)
public class Hello 
{
   public static void main(String[] args) 
   {
      LinkedList<Integer> mm = new LinkedList<Integer>();
      // int short 등등 Tiger와 같이 만든 자료혐도 가능
      
      // C(reat)URD
      mm.add(10);
      
      System.out.println(mm.size());
      
      for (int i = 0; i < 10; i++) {
         mm.add(i*10 + 1);
      }
      
      // CR(ead)UD
      // 1. 
      System.out.println(mm);
      
      // 2. 
      int size = mm.size(); // 함수를 계속 출력하지 않는 방향으로 
      for (int j = 0; j < size; j++) {
         int data = mm.get(j);
         System.out.print(data + " ");
      } System.out.println("");
      
      // 3. x, data, item, value
      for (Integer x : mm) {
         System.out.print(x + " ");
         System.out.println("");      
      }
      
      // CRU(pdate)D
      mm.set(5, 999);
      System.out.println(mm);
      
      // CRUD(elete)
      mm.remove(5);
      System.out.println(mm);
   }
}
*/

/*
// ex51) 비트 연산자 
public class Hello 
{
   static StringBuffer hexaToBinary(int n) {
      String s = Integer.toBinaryString(n);
      //System.out.println(s);
      //System.out.println(s.length());
      
      while(s.length()<28) {
         s = "0" + s;
      }
      //System.out.println(s);
      StringBuffer s1 = new StringBuffer(s);
      // s1.insert(4, "한");
      //System.out.println(s1);
      
      for (int i =0; i<7; i++) {
         //System.out.println((7-i)*4);
         s1.insert((7-i)*4, " ");
      }
      return s1;
   }

   public static void main(String[] args) 
   {
      // 1 0010 1011 0011 1100 0100 1101
      int a = 0x0000cd5a;
      int b = 0x0000ff00; 
      
      //System.out.println(a);
//      if(a == b) {
//         System.out.println(1);
//      }
      
      System.out.println(hexaToBinary(a));
      System.out.println(hexaToBinary(b));
      System.out.println(hexaToBinary(a & b));
      System.out.println(hexaToBinary((a & b) >> 8));
      System.out.println((a & b) >> 8); 
      // 내가 원하는 자리에 1 넣고 16진법 변환 , & 연산 
      System.out.println("--------------");
      
      System.out.println(hexaToBinary((a & 0x000f800) >> 11));
      System.out.println((a & 0x000f800) >> 11);
      System.out.println(hexaToBinary((a & 0x00007e0) >> 5));
       System.out.println((a & 0x00007e0) >> 5);
       System.out.println(hexaToBinary(a & 0x000001f));
       System.out.println(a & 0x000001f);
       System.out.println("--------------");
        
       int c1 = 25;
       int c2 = 42;
       int c3 = 26;
       int c4;
       
       c4 = (c3 | (c2 << 5)| (c1 << 11));
       System.out.println(Integer.toHexString(c4));
       
       char c5 = 0x00dc;// 0000 0000 1101 1100
       int mask = 0x0080;
       String[] electro = new String[]{"TV", "에어컨", "전자레인지", "전기장판",
          "에어 프라이어", "가스레인지", "가전제품", "가전제품_1"};
       
//       for (int i = 0; i < 8; i++) {   
//          //System.out.println(hexaToBinary(c5));
//          //System.out.println(hexaToBinary((int)Math.pow(2,7-i)));
//          //System.out.println(c5&(int)Math.pow(2,7-i));
//          if ((c5&(int)Math.pow(2,7-i)) > 0) {             
//             System.out.println("가전제품 "+((int)i+1)+"번: ON");
//          }else {
//             System.out.println("가전제품 "+((int)i+1)+"번: OFF");             
//          }
//      }
       
//       for (int i = 0; i < electro.length; i++) {
//          //System.out.println(mask >> i);
//         if((c5 & (mask >> i)) > 0) {
//            System.out.println(electro[i]+" is ON");
//         }else {
//            System.out.println(electro[i]+" is OFF");
//         }
//      }
       
       for (int i = 0; i < electro.length; i++, mask >>= 1) {
          System.out.println((c5 & mask) > 0 ? 
                electro[i]+" is ON" : electro[i]+" is OFF");
       }
    }
}
*/