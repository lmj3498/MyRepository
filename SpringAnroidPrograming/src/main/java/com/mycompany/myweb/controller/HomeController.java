package com.mycompany.myweb.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Food;
import com.mycompany.myweb.dto.Light;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String index() {
		
		logger.info("index() 실행");
		return "index";
	}
	
	//Light
	/*@RequestMapping("/lightList")
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
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request,HttpServletResponse response) {
		try{
			
			//브라우저에서 보여주지 않고 강제로 다운로드
			fileName = URLEncoder.encode(fileName,"UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
			
			
				String mimeType = request.getServletContext().getMimeType(fileName);
				response.setContentType(mimeType);
				
				OutputStream os = response.getOutputStream();
				String filePath = request.getServletContext().getRealPath("/resources/image/"+fileName);
				InputStream is = new FileInputStream(filePath);
				
				byte[] values = new byte[1024];
				int byteNum = -1;
				while((byteNum = is.read(values)) != -1){
					os.write(values, 0, byteNum);
				}
				
				os.flush();
				is.close();
				os.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
        
	}*/
	
	//Food
	@RequestMapping("/foodList")
	public String foodList(Model model) {
		
		List<Food> list = new ArrayList<>();
        list.add(new Food("food01.png","food01_large.png","음식01","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food02.png","food02_large.png","음식02","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food03.png","food03_large.png","음식03","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food04.png","food04_large.png","음식04","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food05.png","food05_large.png","음식05","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food01.png","food01_large.png","음식01","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food02.png","food02_large.png","음식02","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food03.png","food03_large.png","음식03","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food04.png","food04_large.png","음식04","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food("food05.png","food05_large.png","음식05","35000Won","Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		
        model.addAttribute("list",list);
        
        return "foodList";
	}
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request,HttpServletResponse response) {
		try{
				//이미지 파일에 대한 확장명을 응답에 넣어줌
				String mimeType = request.getServletContext().getMimeType(fileName);
				response.setContentType(mimeType);
				
				//출력하고 싶은 이미지를 아웃풋 스트림으로 만듬 
				OutputStream os = response.getOutputStream();
				
				//출력하고 싶은 서버의 이미지를 인풋 스트림으로 뽑음(절대 경로를 찾고 스트림화)
				String filePath = request.getServletContext().getRealPath("/resources/image/"+fileName);
				InputStream is = new FileInputStream(filePath);
				
				byte[] values = new byte[1024];
				int byteNum = -1;
				//이미지 파일을 values 크기만큼 읽으며, 동시에 바로 아웃풋 스트림으로 출력
				while((byteNum = is.read(values)) != -1){
					os.write(values, 0, byteNum);
				}
				
				os.flush();
				is.close();
				os.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
        
	}
}
