package Pack;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		SqlSession session = ssf.openSession();

		try {
			List<Integer> mm = session.selectList("test04");
			for (Integer item : mm) {
				System.out.print(item+" ");
			}System.out.println();
		} catch (Exception e){ e.printStackTrace();
		} finally { session.close(); }
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
				userdao.insert(7777);
				userdao.select();
				userdao.update(7777);
				userdao.select();
				userdao.delete(7776);
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
