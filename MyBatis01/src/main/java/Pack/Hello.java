package Pack;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

class Person{
	String name; // 필드 => property
	int age;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

/*
// Bean 사용시 지켜야 할 약속
// 1. 디폴트 생성자만 존새
// 2. 반드시 setter getter 함수가 있어야 한다 

public class Hello{
	public static void main(String[] args) {
		SqlSessionFactory ssf = null;
		SqlSession session = null;
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(is);

		session = ssf.openSession();

		try {
			Person p = new Person();
			p.setName("독수리");
			p.setAge(99);
			
//			List<Person> mm = session.selectList("test08");
//			
//			for (Person p : mm) {
//				System.out.println(p.getName()+" "+p.getAge());
//			}
			if(session.update("test07",p)>0) {
				session.commit();
			}
		} catch (Exception e1){
			e1.printStackTrace();
		} finally {
			session.close();
		}
		
	}
}
*/


// AOP 패턴
interface Delegate{
	int delegate(SqlSession session);
}

class Proxy{
	static void command(UserDao dao, Delegate d) {
		SqlSession session = dao.ssf.openSession();
		try {
			if(d.delegate(session)>0)
				session.commit();
		}catch(Exception e) { e.printStackTrace();
		}finally { session.close();}
	}
}

class UserDao{
	SqlSessionFactory ssf;

	UserDao(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) { e.printStackTrace(); }
	}

	void select() {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				List<Integer> mm = session.selectList("test04");
				for (Integer item : mm) {
					System.out.print(item+" ");
				}System.out.println();
				return 0;
			}
		}); 
	}

	void insert(final int num) {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				return session.insert("test01", num);
			}
		});
	}
	void delete (final int num) {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				return session.delete("test02", num);
			}
		});
	}
	void update(final int num) {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				return session.update("test03", num);
			}
		});
	}
}

public class Hello{
	public static void main(String[] args) {
		UserDao userdao = new UserDao();
				userdao.select();
	}
}


/*
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		SqlSessionFactory ssf = null;
		SqlSession session = null;

		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(is);
		System.out.println(2);

		session = ssf.openSession();

		try {
			int result = session.insert("test01", 9999);
			//int result = session.delete("test02", 9999);
			//int result = session.update("test03", 9999);
			if(result > 0) {
				session.commit();
			}
			List<Integer> mm = session.selectList("test04");
					for (Integer item : mm) {
						System.out.print(item+" ");
					}System.out.println();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(3);
	}
}
 */
