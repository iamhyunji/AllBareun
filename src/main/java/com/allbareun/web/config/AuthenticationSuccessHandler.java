 package com.allbareun.web.config;

import java.io.IOException;
import java.security.Principal;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;


public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	Principal principal;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		HttpSession session = request.getSession();
		
		if(session != null) {
			
			User authUser =  (User) SecurityContextHolder
									.getContext()
									.getAuthentication()
									.getPrincipal();
			
			String uid = authUser.getUsername();
			
			// 세션에 필요한 정보를 담기
	         session.setAttribute("email", principal.getName());
	         System.out.println( principal.getName());
	         Set<String> authoritise = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	         
	         authentication.getAuthorities();
	         
	         SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
	         if(savedRequest != null) {
	             String returnURL = savedRequest.getRedirectUrl();
	             redirectStrategy.sendRedirect(request, response, returnURL);
	          }
	         else if(authoritise.contains("ROLE_ADMIN")){
	        	 redirectStrategy.sendRedirect(request, response, "/admin/index");
	         }
	         else if(authoritise.contains("ROLE_USER")){
	        	 redirectStrategy.sendRedirect(request, response, "/index");
	         }
	         else {
	        	 //throw new IllegalStateException();
	        	super.onAuthenticationSuccess(request, response, authentication); 
	         }
		}
		
	}
	
	
	
}
