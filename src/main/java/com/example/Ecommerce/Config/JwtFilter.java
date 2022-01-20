package com.example.Ecommerce.Config;

import com.example.Ecommerce.Service.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;

        if(httpServletRequest.getServletPath().equals("/index") || httpServletRequest.getServletPath().equals("/login")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            if(authHeader!=null && authHeader.startsWith("Bearer ")){
                try{
                    token = authHeader.substring(7);
                    userName = jwtUtil.extractUsername(token);
                }catch (Exception e){
                    httpServletResponse.setStatus(FORBIDDEN.value());
                    Map<String,String> error = new HashMap<>();
                    error.put("status",String.valueOf(FORBIDDEN.value()));
                    error.put("error","Access Denied");
                    error.put("message","Please login first");
                    new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), error);
                }
            }

            if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
                if(jwtUtil.validateToken(token,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }

            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }


    }
}
