//package com.cloud.mvc.example.basic.gateway.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler 包装失败信息到DeniedException
// *
// */
//@Slf4j
//@Component
//public class AccessDeniedHandler extends OAuth2AccessDeniedHandler {
//
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response,
//                       AccessDeniedException authException) throws IOException, ServletException {
//		log.info("授权失败，禁止访问 {}", request.getRequestURI());
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("UTF-8");
//		PrintWriter printWriter = response.getWriter();
//		printWriter.append("授权失败，禁止访问");
//	}
//}
