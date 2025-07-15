package com.app.controller.study.practice.practice08;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.practice.practice08.Member;

//접속 경로에 따라서 각각 다른 사용자들의 정보를 화면에 표시하세요.
//* view 페이지는 한개만 만들고 자바 측 or 페이지 내에서 jstl 를 활용하여 처리하세요.
//* member 에 있는 type 변수의 값은 basic, manager 둘중에 한개 입니다.
//
//"/practice08/member?auth=basic" 경로로 접속시 basic 타입인 사용자 목록만 표시합니다.
//"/practice08/member?auth=manager" 경로로 접속시 manager 타입인 사용자 목록만 표시합니다.
//"/practice08/member?auth=admin" 경로로 접속시 타입에 상관없이 모든 사용자 목록을 표시합니다.

@Controller
public class Practice08Controller {
	
	@RequestMapping("/practice08/member")
	public String manage_member(@RequestParam String auth, Model model) {
		
		// 필터링 처리가 사전에 된다면, 뒤쪽에 if else 처리 가능
		if (!(auth.equals("basic") || auth.equals("manager") || auth.equals("admin"))) {
			// auth == "basic" "manager" "admin" 이 세개가 아닌경우
			// 파라미터가 잘못된 경우
			return "파라미터가 잘못된 경우 보여줄 페이지";
		}

		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));
		
// 1) 화면(view) jstml 구분해서 처리
		
		model.addAttribute("auth", auth);
		model.addAttribute("memberList", memberList);
		
			// 1번 방식은 memberList를 view에 넘겨서 처리
			// 2번 방식은 view에 넘길 viewMemberList를 만들어서 넘김
	
// 2) 서버에서 화면에 전달할 데이터 분리 -> 전달
		
		List<Member> viewMemberList = new ArrayList<Member>();
		
//		if (auth.equals("basic")) {
//			for (Member m : memberList) {
//				if (m.getType().equals("basic")) {
//					viewMemberList.add(m);
//				}
//			}
//		} else if (auth.equals("manager")) {
//			for (Member m : memberList) {
//				if (m.getType().equals("manager")) {
//					viewMemberList.add(m);
//				}
//			}
//		} else if (auth.equals("admin")) {
//			viewMemberList = memberList;
//		}
		
		if (auth.equals("basic") || auth.equals("manager")) {
			for (Member m : memberList) {
				if (m.getType().equals(auth)) {
					viewMemberList.add(m);
				}
			}
		}  else  {	//auth=admin
			viewMemberList = memberList;
		}
		
		model.addAttribute("viewMemberList", viewMemberList);
			
		return "/practice/practice08/membersView";
	}
		
}
