package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TigerCtrl {
	@RequestMapping("/")
	String home() {
		System.out.println("��Ʈ�ѷ� �ٳ� �� 1");
		return "index";
	}
	
	@RequestMapping("/goTiger")
	String tiger() {
		System.out.println("��Ʈ�ѷ� �ٳ� �� 2");
		return "Tiger";
	}
}
