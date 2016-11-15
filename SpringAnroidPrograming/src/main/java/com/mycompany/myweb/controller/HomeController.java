package com.mycompany.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Light;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String index() {
		
		logger.info("index() 실행");
		return "index";
	}
	
	@RequestMapping("/lightList")
	public String lightList(Model model) {
		
		List<Light> list = new ArrayList<>();
        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명01","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명02","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명03","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명04","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명05","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명06","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명07","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명08","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명09","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명10","주방을 밝히는데 사용하면 좋습니다. 어두운 주방을 밝혀보세요~"));
		
        model.addAttribute("list",list);
        
        return "lightList";
	}
}
