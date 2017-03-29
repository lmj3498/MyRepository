package com.mycompany.myweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.DetailOrder;
import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.ExtraOrder;
import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.Order;
import com.mycompany.myweb.dto.OrderItem;
import com.mycompany.myweb.service.ExtraOrderService;
import com.mycompany.myweb.service.ExtraService;
import com.mycompany.myweb.service.MenuService;
import com.mycompany.myweb.service.OrderItemService;
import com.mycompany.myweb.service.OrderService;
import com.mycompany.myweb.service.StoreService;

//이명진
@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ExtraOrderService extraOrderService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	ExtraService extraService;
	
	@Autowired
	StoreService storeService;
	
	//주문 전체 내역 페이지
	//(idex.jsp->index.js{showPageList(1)}->orderModal.js{showPageList(1)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->list.jsp[json객체파싱]->orderModal.jsp로 화면 드로잉)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String pageNo, Model model, HttpSession session){
		logger.info("주문 전체 리스트 시작");
		//그냥 맨처음 주문 리스트 보는 경우와 주문하고 나서 리스트를 보는 경우를 다뤄야 함
		String ogid = null; int resultprice = 0;
		
		//주문 중에 있을 때(이 부분이 흐름상 불필요한 부분이라 파악되므로 추후 수정예정)
		if((String) session.getAttribute("ogid")!=null){
			
			if((Integer) session.getAttribute("resultprice")==null){//주문취소하는 경우
				logger.info("주문 취소!");
				session.setAttribute("ogid",null);
			}else{//주문 완료하는 경우
				//총 금액 order_total 테이블의 ogtotalprice에 resultprice 넣어주기
				resultprice = (Integer) session.getAttribute("resultprice"); logger.info("결제 총 금액: "+resultprice);
				if(resultprice != 0){
					ogid = (String) session.getAttribute("ogid"); 
					orderService.modifyOgprice(ogid, resultprice); 
				}
			}
		}//맨처음 주문 리스트 보는 경우(ogid에 대해 아무것도 처리 안함)	
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		int rowsPerPage = 5;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> list = orderService.listAll(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list", list);
		
		return "order/list";
	}
	
	//주문 1개 상세 내역 페이지
	//(orderModal.jsp에서 상세클릭->orderModal.js{detailOrderList(ogid)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->detailList.jsp[json객체파싱]->detailListModal.jsp로 화면 드로잉)
	//주문내역 상세보기(1개 주문 당)(검토 완료)
	@RequestMapping(value="/detailList", method=RequestMethod.GET)
	public String detailList(String ogid, Model model, HttpSession session){
		logger.info("주문 상세 리스트 시작");
		
		//가격은 구매가 마칠 때 총 금액 구해서 업데이트 해줘야 됨
		
		//주문 당 모든 품목의 중간 정보를 검색하여 리스트 확보, 주문 당 모든 상세 정보 담기 위한 리스트 최종 변수 
		List<OrderItem> orderItems = orderItemService.allOrderItemByOgid(ogid);
		List<DetailOrder> detailOrders = new ArrayList<>();
		
		for(int i=0;i<orderItems.size();i++){
			DetailOrder detailOrder = new DetailOrder();//1개 품목의 상세 정보를 담기위한 리스트 변수
			String xname = "";//1개 품목의 모든 사이드 이름 변수
			int itemOneprice = 0;//1개 품목의 총 금액 임시변수
			
			//주문당 1개 품목의 (메뉴명, 사이드, 수량, 가격) -> 구해서 같이 넘겨야 됨
			Menu menu = menuService.info(orderItems.get(i).getMid());//메뉴명 검색 후 메뉴정보 확보
			detailOrder.setMname(menu.getMname());//1개 품목의 메뉴명 정보를  1개 품목 상세 정보 리스트에 메뉴명 임시저장
			if(menu.getHot_ice() == null){//1개 품목의 핫_아이스 정보를  1개 품목 상세 정보 리스트에 임시저장
				detailOrder.setHot_ice("");
			}else{
				detailOrder.setHot_ice(menu.getHot_ice());
			}
			detailOrder.setSameItemCount(orderItems.get(i).getOrdercount());//1개 품목의 수량 정보를  1개 품목 상세 정보 리스트에 임시저장
			
			itemOneprice += menu.getMprice();//1개 품목의 총 금액 임시변수에 메뉴 단일가격을 더함
			//1개 품목의 사이드메뉴 정보를  1개 품목 상세 정보 리스트에 임시저장
			List<ExtraOrder> extraOrders = extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid());
			for(int j=0;j<extraOrders.size();j++){
				Extra extra = new Extra();
				extra =	extraService.info(extraOrders.get(j).getXid());//사이드 메뉴명 검색 후 정보 확보
				xname += extra.getXname()+" ";//1개 품목의 사이드 명 이름 더하기
				itemOneprice += extra.getXprice();//1개 품목의 총 금액 임시변수에 사이드 메뉴가격을 더함
			}
			detailOrder.setXname(xname);//1개 품목의 사이드 정보를  1개 품목 상세 정보 리스트에 최종 임시저장
			
			itemOneprice = itemOneprice*detailOrder.getSameItemCount();//1개 품목의 총 금액 임시변수에 품목의 수량을 곱한 동일 품목의 총 금액 저장
			detailOrder.setSameItemPrice(itemOneprice);//1개 품목의 총 금액 변수에 임시변수 저장
			
			detailOrder.setOghowpay(orderService.searchOne(ogid).getOghowpay());//1개 품목의 결제 방법 변수에 정보 저장
			
			logger.info("메뉴명:"+detailOrder.getMname());
			logger.info("핫_아이스:"+detailOrder.getHot_ice());
			logger.info("수량:"+detailOrder.getSameItemCount());
			logger.info("사이드:"+detailOrder.getXname());
			logger.info("가격:"+detailOrder.getSameItemPrice());
			logger.info("결제방법:"+detailOrder.getOghowpay());
			
			detailOrders.add(i,detailOrder);//1개 주문의 동일 메뉴정보를 더함
			
		}
		model.addAttribute("detailList", detailOrders);//Modal.jsp & AJAX통신에 결과값 전달
		
		//1개 주문 모든 품목 총 주문금액 연산
		int resultprice=0;
		for(int i=0;i<detailOrders.size();i++){
			resultprice += detailOrders.get(i).getSameItemPrice();
		}
			
		//1주문 총 금액 세션저장, Modal.jsp & AJAX통신에 결과값 전달
		session.setAttribute("resultprice", resultprice);
		model.addAttribute("resultprice", resultprice);
		
		return "order/detailList";
	}
	
	//주문 전체 기간 페이지
	//(orderModal.jsp에서 기간클릭->orderModal.js{termList(pageNo)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->termList.jsp[json객체파싱]->termListModal.jsp로 화면 드로잉)

	//주문내역 기간보기(날짜 정확하게 검색하기 위한 수정 필요)
	@RequestMapping(value="/termList", method=RequestMethod.GET)
	public String termList(String term1, String term2, String pageNo, Model model, HttpSession session) throws ParseException{
		logger.info("문자열 기간1: "+term1);
		logger.info("문자열 기간2: "+term2);
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = transFormat.parse(term1);
		Date date2 = transFormat.parse(term2);
		
		logger.info("날짜 기간1: "+date1);
		logger.info("날짜 기간2: "+date2);
		
		
		/*SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = transFormat.parse(term1);
		Date date2 = transFormat.parse(term2);
		*/
		
		/*Date date1 = transFormat.parse(term1);
		Date date2 = transFormat.parse(term2);
		
		logger.info(""+date1);
		logger.info(""+date2);
		*/
		
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String)session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		}else{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 5;
		int pagesPerGroup = 5;
		int totalBoardNo = orderService.getCount();
		int totalPageNo = totalBoardNo/rowsPerPage+((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup+((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup+1;
		int startPageNo = (groupNo-1)*pagesPerGroup+1;
		int endPageNo = startPageNo + pagesPerGroup-1;
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Order> termList = orderService.listTerm(intPageNo, rowsPerPage, date1, date2);
	
		logger.info("termList: "+termList);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("termList", termList);
		
		return "order/termList";
	}
	
	//주문 전체 시작 페이지(메인 메뉴)
	//(orderModal.jsp에서 주문클릭->orderModal.js{btnNewOrder()->orderMenuList(mgroup)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->menuList.jsp[json객체파싱]->orderForm1Modal.jsp로 화면 드로잉)
	//---------------------------------------------------------------------------------------------------------------
	
	//주문의 시작! 폼 및 카페 당 메뉴리스트 페이지(검토 완료)
	@RequestMapping(value="/menuList")
	public String orderForm(String mgroup, Model model, HttpSession session){
		logger.info("ogid: "+session.getAttribute("ogid"));
		//새로운 ogid 여기서 부터 생성되야 함
		//ogid(문자열) 만들기(sid+현재시간+랜덤 숫자)(안겹치게 하기 위해서)
		String sid = (String) session.getAttribute("login");
		
		String ogid= null; ogid = (String) session.getAttribute("ogid");
		if(ogid == null){
			long time = System.currentTimeMillis(); double random = Math.random();
			ogid = ""+sid+time+random;
			session.setAttribute("ogid", ogid);		
			logger.info("ogid: "+session.getAttribute("ogid"));
			//Order_Total 테이블을 추가해야 함
			//위의 두 데이터는 임의의 테스트 데이터(user_id, oghowpay)
			Order order = new Order();	
			ogid = (String) session.getAttribute("ogid");	
			order.setOgid(ogid);
			order.setOgtotalprice(0);//우선 0으로 초기화 -> 주문이 완료되면 수정되게 함
			order.setUser_id("user1");//임의 데이터!
			order.setSid(sid);
			order.setOghowpay("카드 결제");//임의 데이터!
			orderService.addOrder(order);
		}
		//---------------------------------------------------
		//String sid = (String) session.getAttribute("login");
		if(mgroup.equals("전체")) mgroup = null;
		List<Menu> menuList = menuService.listByMgroup(sid, mgroup);
		model.addAttribute("list", menuList);
		
		return "order/menuList";
	}
	
	//주문 1개 시작 페이지(사이드 메뉴)
	//(orderForm1Modal.jsp에서 메뉴클릭->orderModal.js{newOrderSideForm(mid)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->menuInfo.jsp[json객체파싱]->orderForm2Modal.jsp로 화면 드로잉)
	//주문하기(진행 중)(검토 필요)(중요)
	@RequestMapping(value="/sideList",method=RequestMethod.GET)
	public String orderForm2(int mid, Model model, HttpSession session){
		logger.info("주문 품목을 위한 흐름1");
		Menu orderMenu = menuService.infoByMid(mid);
		
		logger.info("메뉴 그룹 : "+orderMenu.getMgroup());
		model.addAttribute("orderMenu", orderMenu);//javascript 흐름 완료를 위해 model에 넣어주기
		session.setAttribute("orderMenu", orderMenu);//1품목에 대한 메뉴 정보 세션에 넣어주기
		
		
		return "order/menuInfo";
	}
		
	//주문 전체 담기 기능(메인-사이드 -> 주문 모두 담을 때까지 반복)
	//(orderForm2Modal.jsp에서 담기클릭->orderModal.js{newOrderSave()}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->confirmItem.jsp[json객체파싱]->orderForm1Modal.jsp로 되돌아 감)
	//주문하기(진행 중)(검토 필요)(중요)
	@RequestMapping(value="/sideList",method=RequestMethod.POST)
	public String orderItems2(
			int ordercount,
			String orderSize, String orderSyrup, String orderShot,
			HttpSession session, Model model){
		logger.info("주문 품목을 위한 흐름2");
		//현재 주문되고 있는 menu 정보는 sesstion에 저장되어 있음(중요) : "orderMenu"
		Menu menu = (Menu) session.getAttribute("orderMenu");
		
		//사이드 이름들에 대한 사이드들이 뭔지 찾기 위해
		Extra extra1 = extraService.infoByXname(orderSize);
		Extra extra2 = extraService.infoByXname(orderSyrup);
		Extra extra3 = extraService.infoByXname(orderShot);
		int xid1 = extra1.getXid();
		int xid2 = extra2.getXid();
		int xid3 = extra3.getXid();
			
		//------------------------------------------------------------
		//주문시작할 때 session에 저장되는 ogid 얻기
		String ogid = (String) session.getAttribute("ogid");
		
		//Order_Item 테이블에 메뉴 추가하는 부분
		orderItemService.addOrderItem(ogid, menu.getMid(), ordercount);
		//Order_Item 테이블에서 메뉴 다시 찾는 부분
		List<OrderItem> orderItems = orderItemService.searchOrderItemsByOgidMid(ogid,menu.getMid());
		logger.info("orderItems size : "+orderItems.size());
		
		////Extra_Order 테이블찾고 없으면 사이드 넣음
		//메뉴(mname)가 같은 경우 하나의 메뉴에 xname1,2,3들이 중복되어 삽입되는 에러 안나도록 코드 수정(중요!)
		for(int i=0;i<orderItems.size();i++){
			if(extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid()).size() == 0){
				logger.info(""+extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid()));
				logger.info("사이드 잘 담김");
				//Extra_Order 테이블을 추가하는 부분
				extraOrderService.addExtraOrder(xid1,orderItems.get(i).getOid());
				extraOrderService.addExtraOrder(xid2,orderItems.get(i).getOid());
				extraOrderService.addExtraOrder(xid3,orderItems.get(i).getOid());
			}else{
				logger.info(""+orderItems.get(i).getOid());
				logger.info(""+extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid()));
				logger.info("사이드 찾는 중이거나 실패");
				continue;
			}
		}
		model.addAttribute(ogid);
		return "order/confirmItem";
	}
	
	//주문 전체 결제 기능
	//(orderForm1Modal.jsp에서 결제완료 클릭->orderModal.js{resultOrder()}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->orderResult.jsp[json객체파싱]->AJAX통신{주문완료}->orderModal.js{showPageList(1)})
	//결제 완료하기(중요)
	@RequestMapping(value="/orderpay",method=RequestMethod.GET)
	public String orderpay(Model model, HttpSession session){
		logger.info("주문 흐름 3");
		logger.info("ogid: "+session.getAttribute("ogid"));
		String ogid = (String) session.getAttribute("ogid");
		
		
		//1주문당 (품목, 수량, 사이드, 가격) -> 구해서 같이 넘겨야 됨
		//가격은 구매가 마칠 때 총 금액 구해서 업데이트 해줘야 됨
		List<OrderItem> orderItems = orderItemService.allOrderItemByOgid(ogid);
		List<DetailOrder> detailOrders = new ArrayList<>();
				
		 //int resultprice = 0;
		for(int i=0;i<orderItems.size();i++){
			DetailOrder detailOrder = new DetailOrder();
			String xname = "";//1품목 모든 사이드 이름들 
			int itemOneprice = 0;//1품목 총 금액 //int itemprice = 0;
					
			Menu menu = menuService.info(orderItems.get(i).getMid());//메뉴명
			detailOrder.setMname(menu.getMname());//1품목 메뉴명 보존하기
			logger.info("품목:"+detailOrder.getMname());
					
			detailOrder.setSameItemCount(orderItems.get(i).getOrdercount());//1품목 수량 보존하기
			logger.info("수량:"+detailOrder.getSameItemCount());
					
			itemOneprice += menu.getMprice();
					
			//주문 품목에 대한 모든 사이드 찾기
			List<ExtraOrder> extraOrders = extraOrderService.allExtraOrderByoneOid(orderItems.get(i).getOid());
			for(int j=0;j<extraOrders.size();j++){
				Extra extra = new Extra();
				extra =	extraService.info(extraOrders.get(j).getXid());
				xname += extra.getXname()+" ";//1품목 사이드 이름 더하기
				itemOneprice += extra.getXprice();//1품목 사이드 가격 더하기
			}
			detailOrder.setXname(xname);//더해진 사이드 이름들 보존하기
			logger.info("사이드 이름들:"+detailOrder.getXname());
					
			//1품목의 총 금액
			itemOneprice = itemOneprice*detailOrder.getSameItemCount();
			detailOrder.setSameItemPrice(itemOneprice);//1품목 총 금액 보존하기
			logger.info("가격:"+detailOrder.getSameItemPrice());
					
			detailOrder.setOghowpay(orderService.searchOne(ogid).getOghowpay());//결제 방법
					
			detailOrders.add(i,detailOrder);
		}
		model.addAttribute("detailOrders", detailOrders);
			
		int resultprice=0;
		for(int i=0;i<detailOrders.size();i++){
				resultprice += detailOrders.get(i).getSameItemPrice();
		}
				
		//1주문 총 금액 저장 및 JSP에 보내기 및 order_total ogprice 최신화
		session.setAttribute("resultprice", resultprice);
		model.addAttribute("resultprice", resultprice);
		orderService.modifyOgprice(ogid, resultprice);
		
		session.setAttribute("ogid",null);
		logger.info(""+(String) session.getAttribute("ogid")); 
		
		return "order/orderResult";
	}
	
	//주문 전체 취소 기능
	//(orderForm1Modal.jsp에서 결제취소 클릭->orderModal.js{cancelOrder()}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->confirmItem.jsp[json객체파싱]->AJAX통신{주문취소}->orderModal.js{showPageList(1)})
	//결제 취소하기(중요)
	@RequestMapping(value="/ordercancel",method=RequestMethod.GET)
	public String ordercansel(Model model, HttpSession session){
		String ogid = (String) session.getAttribute("ogid");
		orderService.removeByOgid(ogid);
		logger.info("결제 취소 완료");
		
		session.setAttribute("ogid",null);
		model.addAttribute("ogid", "cancel");
		logger.info("ogid: "+(String) session.getAttribute("ogid")); 
		return "order/confirmItem";
	}

	//주문 삭제 기능
	//detailListModal.jsp에서 삭제클릭->orderModal.js{deleteOrder(ogid)}->AJAX통신->여기로)
	//(Service->DAO->Service->여기로->confirmItem.jsp[json객체파싱]->AJAX통신{주문삭제}->orderModal.js{showPageList(1)})
	//결제 삭제하기(중요)
	@RequestMapping(value="/orderdelete",method=RequestMethod.GET)
	public String orderdelete(String ogid, Model model, HttpSession session){
		logger.info("ogid: "+ogid);
		orderService.removeByOgid(ogid);
		logger.info("결제 삭제 완료");
		
		session.setAttribute("ogid",null);
		model.addAttribute("ogid", "delete");
		logger.info("ogid: "+(String) session.getAttribute("ogid")); 
		
		return "order/confirmItem";
	}	
	
	//-----------------------------------------------------밑에는 추후 예정
	/*
	
	//메뉴 키워드(이름) 검색(1차 검토 완료)
	@RequestMapping(value="/someMenuSearchMname",method=RequestMethod.POST)
	public String someMenuSearchMname(String pageNo, Model model,HttpSession session, String mname){
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
			
		int rowsPerPage = 4;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.listByMname(intPageNo, rowsPerPage, mname);
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "order/orderSearchMname";
	}*/	
	
	
	
}