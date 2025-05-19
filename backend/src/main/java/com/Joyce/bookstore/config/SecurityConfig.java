package com.Joyce.bookstore.config;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig {
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
