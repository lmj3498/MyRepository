package com.mycompany.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	
	@RequestMapping("list")
	public String list(){
		return "photoboard/list";
	}
	
	
}
