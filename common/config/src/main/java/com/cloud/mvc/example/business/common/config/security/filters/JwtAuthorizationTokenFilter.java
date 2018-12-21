package com.cloud.mvc.example.business.common.config.security.filters;

import com.cloud.mvc.example.business.common.config.security.service.UserDetailsServiceIml;
import com.cloud.mvc.example.business.common.utils.JwtTokenUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {


    @Value("${jwt.header}")
    private String header;

    @Autowired
    UserDetailsServiceIml serviceIml;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenName = request.getHeader(header);
        if(!Strings.isNullOrEmpty(tokenName) && tokenName.startsWith("Bearer ")){
            String token = tokenName.substring(7);
            String username = jwtTokenUtil.getUserName(token);

            //TODO 控制同时在线客户端数量


            if(!Strings.isNullOrEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null){
                //重新设置认证信息
                UserDetails details = serviceIml.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        details, null, details.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            if(!Strings.isNullOrEmpty(username) && SecurityContextHolder.getContext().getAuthentication() != null){
                //TODO refresh token
            }

        }

        filterChain.doFilter(request, response);

    }
}
