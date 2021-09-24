package Pack;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dao {
	SqlSessionFactory ssf;

	Dao(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	@RequestMapping("/insertPerson")
	String insert(final Info item) {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				return session.insert("insertPerson", item);
			}
		});
		return "finish";
	}

	@RequestMapping("/selectPerson")
	String select(Model model) {
		Proxy.command(this, new Delegate() {
			public int delegate(SqlSession session) {
				List<Integer> mm = session.selectList("selectPerson");
				model.addAttribute("mmm", mm);
				return 0;
			}
		}); 
		return "ListView";
	}
}