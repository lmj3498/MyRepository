package com.mycompany.myweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Event;
import com.mycompany.myweb.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	  
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/list")
	public String list(Model model, HttpSession session){
		logger.info("service list 실행1");
		String sid = (String) session.getAttribute("login");
		List<Event> list = eventService.getList(sid);
		model.addAttribute("eventList",list);
		logger.info("service list 실행2");
		return "event/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		logger.info("eventForm 실행");
		return "event/registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(Event event, HttpSession session){
		logger.info("event 등록 성공");
		try{
			String sid = (String)session.getAttribute("login");
			event.setSid(sid);
			
			String savedfile = new Date().getTime()+event.getPhoto().getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);//저장할 파일의 절대 파일 시스템 경로를 얻는다.
			logger.info(realpath);
			event.getPhoto().transferTo(new File(realpath));//클라이언트에서 저장한 파일을 해당 경로(realpath)에 저장 실제 파일을 저장
			event.setEsavedfile(savedfile);
			
			event.setEmimetype(event.getPhoto().getContentType());//저장할 파일의 mime type 얻어냄.
			int result = eventService.write(event);		
			return "redirect:/event/list";
		
		}catch(Exception e){
			e.printStackTrace();
			return "event/registerForm";
		}
	}
	@RequestMapping(value="/info")
	public String info(int eid, Model model){
		logger.info("이벤트 세부정보 form실행");
		Event event = eventService.info(eid);
		model.addAttribute("event",event);
		return "event/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int eid, Model model){
		logger.info("이벤트 수정폼 form실행");
		Event event = eventService.info(eid);
		model.addAttribute("event",event);
		 return "event/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Event event, HttpSession session){
		try{
			String sid = (String)session.getAttribute("login");
			event.setSid(sid);
			
			String savedfile = new Date().getTime()+event.getPhoto().getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);//저장할 파일의 절대 파일 시스템 경로를 얻는다.
			logger.info(realpath);
			event.getPhoto().transferTo(new File(realpath));//클라이언트에서 저장한 파일을 해당 경로(realpath)에 저장 실제 파일을 저장
			event.setEsavedfile(savedfile);
			
			event.setEmimetype(event.getPhoto().getContentType());//저장할 파일의 mime type 얻어냄
			eventService.modify(event);
			
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/event/modify";
		}
		return "redirect:/event/list";
	}
	@RequestMapping("/showPhoto")
	public void showPhoto(String esavedfile, HttpServletRequest request, HttpServletResponse response){
		try{
			String fileName = esavedfile;
			
			/* 브라우저에서 보여주지 않고 강제로 다운로드 할 경우
			fileName = URLEncoder.encode(fileName, "UTF-8"); //fileName(한글) UTF-8형식으로 변환
			response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");//첨부화일 만들기(다운로드)
			*/		
			
			String mimeType = request.getServletContext().getMimeType(esavedfile);
			response.setContentType(mimeType);//Content-Type 설정
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/"+fileName);
			InputStream is = new FileInputStream(filePath);
			byte[] values =new byte[1024];
			int byteNum = -1;
			while ((byteNum = is.read(values)) != -1 ) {
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
