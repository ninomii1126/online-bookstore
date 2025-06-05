package com.Joyce.bookstore.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("🛡️ JwtAuthenticationFilter running...");

        String authHeader = request.getHeader("Authorization");
        System.out.println("🔍 authHeader: " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // ❗ 沒帶 token，就直接放行，保持匿名
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7); // 去掉 "Bearer "

        try {
            String username = jwtUtils.validateTokenAndGetUsername(token);
            if (username != null) {
                // 從 token 抽出角色資訊
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(jwtUtils.getKey()) // 你需要公開這個方法（見下面）
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String role = (String) claims.get("role");

                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (JwtException e) {
            // token 無效，也直接略過，不設認證
            logger.warn("JWT 無效：{}");

        }

        filterChain.doFilter(request, response);
    }
}
