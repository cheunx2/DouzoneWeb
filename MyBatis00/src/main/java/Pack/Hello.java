package Pack;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
			System.out.println(result);
			if(result>0) {
				session.commit();
			}
			session.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(3);
	}
}
