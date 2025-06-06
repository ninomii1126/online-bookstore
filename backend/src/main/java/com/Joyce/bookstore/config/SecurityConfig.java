package com.Joyce.bookstore.config;

import com.Joyce.bookstore.security.CustomAccessDeniedHandler;
import com.Joyce.bookstore.security.CustomAuthenticationEntryPoint;
import com.Joyce.bookstore.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    public SecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler,
                          CustomAuthenticationEntryPoint customAuthenticationEntryPoint,
                          JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()) // 關閉 CSRF
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 無狀態 Session
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // ✅ 所有請求預設匿名通過（不設認證）
                )
                .anonymous(Customizer.withDefaults()) // ✅ 允許匿名用戶存在
                .exceptionHandling(ex -> ex
                        .accessDeniedHandler(customAccessDeniedHandler) // 權限不足時回應
                        .authenticationEntryPoint(customAuthenticationEntryPoint) // 未登入時回應
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // 加入自定義 filter

        return http.build();
    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://localhost:8080"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true); // Allow credentials
//
//        UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",configuration);
//
//        return source;
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
//        http.exceptionHandling(c -> c.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
//                .cors(c->c.configurationSource(corsConfigurationSource()))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/getBooks").permitAll() // Allow public access
//                        .anyRequest().authenticated() // Require authentication for other endpoints
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(c->c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(req->req.anyRequest().permitAll());
//
//        return http.build();
//
//    }

}
