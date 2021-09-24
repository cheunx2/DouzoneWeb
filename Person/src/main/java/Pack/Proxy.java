package Pack;

import org.apache.ibatis.session.SqlSession;

interface Delegate{
	int delegate(SqlSession session);
}

class Proxy{
	static void command(Dao dao, Delegate d) {
		SqlSession session = dao.ssf.openSession();
		try {
			if(d.delegate(session)>0)
				session.commit();
		}catch(Exception e) { e.printStackTrace();
		}finally { session.close();}
	}
}
