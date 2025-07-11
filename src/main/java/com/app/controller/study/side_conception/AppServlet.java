package com.app.controller.study.side_conception;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppServlet {
	//Spring	
	//Dispatcher Servlet
	
	//웹에서 요청이 들어 왔을때!
	//최전방 인포데스크 직원
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//어떤 주소로 요청을 했는지? 주소 확인!
		String requestURI = request.getRequestURI(); // 요청 들어온 주소
		
		if(requestURI.equals("/board/faq")) {
			Controller1 con1 = new Controller1();
			con1.process(request, response);
		}
		
		if(requestURI.equals("/member/mypage")) {
			Controller2 con2 = new Controller2();
			MyView myView = con2.process(request, response);
			myView.render(request, response);
		}
		
		
		if(requestURI.equals("접속경로비교")) {
			// 3-1) ModelAndView 활용
			Controller3 con3 = new Controller3();
			MyModelAndView mav = con3.process(request, response);
			// viewName, model: Map<Stirng, Object> 들어있음 
			
			// viewName 옮겨 담기
			MyView myView = new MyView();
			myView.viewName = mav.viewName;	//mav에 저장된 viewName 활용
			myView.render(request, response, mav.model); //mav에 저장된 model map 전달
		}
		
		
		// -----------------------viewResolver 설정 시점---------------------------------------
		MyViewResolver myViewResolver = new MyViewResolver();		
		
		if(requestURI.equals("접속경로비교")) {
			// 3-2) ModelAndView 활용 + paraMap 전달 + viewResolver
			Controller3 con3 = new Controller3();
			
			//request에 담겨있는 parameter 값들을 전달하기 위해, Map<String,String> 형태로 변환 
			//request -> map
			
			Enumeration<String> paramNames = request.getParameterNames(); //파라미터 이름(key 값)들만
			Map<String,String> paramMap = new HashMap<String,String>();
			
			while(paramNames.hasMoreElements()) {
				//key값 획득 (파라미터 이름)
				String name = paramNames.nextElement();
				
				paramMap.put(name,request.getParameter(name));
			}
				
			//paraMap 전달
			MyModelAndView mav = con3.process(paramMap);
			
			// viewName 옮겨 담기
			MyView myView = new MyView();
			
			//myView.viewName = mav.viewName; //mav에 저장된 viewName 활용			
			myView.viewName = myViewResolver.viewResolve(mav.viewName);	
			
			
			myView.render(request, response, mav.model); //mav에 저장된 model map 전달
		}			
		
		
		if(requestURI.equals("접속경로비교")) {
			Controller4 con4 = new Controller4();
			
			MyModel myModel = new MyModel();
			String viewName = con4.process(myModel);
			
			//myModel 데이터
			//viewName 스트링 값으로 view 이름 정보
			
			MyView myView = new MyView();			
			myView.viewName = myViewResolver.viewResolve(viewName);
			myView.render(request, response, myModel.model);
		}
		
		
		
		if(requestURI.equals("접속경로비교")) {
			Controller4 con4 = new Controller4();
			
			MyModel myModel = new MyModel();
			
			//request에 담겨있는 parameter 값들을 전달하기 위해, Map<String,String> 형태로 변환 
			//request -> map
			
			Enumeration<String> paramNames = request.getParameterNames(); //파라미터 이름(key 값)들만
			Map<String,String> paramMap = new HashMap<String,String>();
			
			while(paramNames.hasMoreElements()) {
				//key값 획득 (파라미터 이름)
				String name = paramNames.nextElement();
				
				paramMap.put(name,request.getParameter(name));
			}
			
			String viewName = con4.process(myModel, paramMap);	// model, paramMap
			
			MyView myView = new MyView();			
			myView.viewName = myViewResolver.viewResolve(viewName);
			myView.render(request, response, myModel.model);
		}
		
		
		
	}
}
