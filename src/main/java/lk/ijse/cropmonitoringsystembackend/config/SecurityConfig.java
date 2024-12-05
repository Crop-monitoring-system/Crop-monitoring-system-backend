//package lk.ijse.cropmonitoringsystembackend.config;
//
//
//import lk.ijse.cropmonitoringsystembackend.service.UserRegService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//
//@RequiredArgsConstructor
//
//
//public class SecurityConfig {
//    private final UserRegService userService;
//    private final JWTConfig jwtConfigFilter;
//
//  //Config filter chain
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      http.csrf(AbstractHttpConfigurer::disable)
//              .authorizeRequests( req ->
//                      req.requestMatchers("api/v1/auth/**").permitAll()
//                              .anyRequest()
//                              .authenticated())
//              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//              .authenticationProvider(authenticationProvider())
//              .addFilterBefore(jwtConfigFilter, UsernamePasswordAuthenticationFilter.class);
//      return http.build();
//  }
//
//
//  //Password encoder
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//  }
//  //Auth provider
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider dap =
//                new DaoAuthenticationProvider();
//        dap.setUserDetailsService(userService.userDetailsService());
//        dap.setPasswordEncoder(passwordEncoder());
//        return dap;
//    }
//
//
//    //AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//}
