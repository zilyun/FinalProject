package com.mbti.finalproject;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.mbti.finalproject.security.CustomAccessDeniedHandler;
import com.mbti.finalproject.security.CustomUserDetailsService;
import com.mbti.finalproject.security.LoginFailHandler;
import com.mbti.finalproject.security.LoginSuccessHandler;

@EnableWebSecurity // 스프링과 시큐리티 결합
@Configuration // 스프링 IOC Container 에게 해당 클래스를 Bean 구성 Class임을 알려주는 것 입니다
public class secuityConfig {
    private DataSource dataSource;
    private LoginFailHandler loginFailHandler;
    private LoginSuccessHandler loginSuccessHandler;
    private CustomUserDetailsService customUserDetailsService;
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    public secuityConfig(LoginFailHandler loginFailHandler,
                         LoginSuccessHandler loginSuccessHandler,
                         DataSource dataSource,
                         CustomUserDetailsService customUserDetailsService,
                         CustomAccessDeniedHandler customAccessDeniedHandler) {

        this.loginSuccessHandler = loginSuccessHandler;
        this.loginFailHandler = loginFailHandler;
        this.dataSource = dataSource;
        this.customUserDetailsService = customUserDetailsService;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, RoleHierarchy roleHierarchy) throws Exception {


        http.headers().frameOptions().disable();

        // 내가 만든 페이지로 이동합니다
        http.formLogin(fo -> fo.loginPage("/user/login")
                .loginProcessingUrl("/user/loginProcess")
                .usernameParameter("userId")
                .passwordParameter("userPassword")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler));

        http.logout(fo -> fo.logoutSuccessUrl("/user/login")
                .logoutUrl("/user/logout")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSION_ID"));

        http.rememberMe(me -> me.rememberMeParameter("remember-me")
                .userDetailsService(customUserDetailsService)
                .tokenValiditySeconds(2419200)
                .tokenRepository(tokenRepository())); // 데이터 베이스에 토큰을 저장합니다

        http.authorizeHttpRequests(au -> au
                        .requestMatchers("/user/list", "/user/delete")
                        .hasAuthority("ROLE_MASTER")

                        .requestMatchers("/user/update", "/user/updateProcess", "/user/info", "/user/attendance", "/user/commute")
                        .hasAnyAuthority("ROLE_MASTER", "ROLE_MEMBER")

                        .requestMatchers("/board/**", "/comment/**")
                        .hasAnyAuthority("ROLE_MASTER", "ROLE_MEMBER")

                        .requestMatchers("/trip/tripBoss").hasAuthority("ROLE_HEAD")
                        .requestMatchers("/trip/updateTravelLeader").hasAuthority("ROLE_HEAD")

                        // 신입사원은 다른 모든 페이지 접근 불가
                        .requestMatchers("/user/newbie/").hasAuthority("ROLE_NEWBIE")  // 신입사원 전용 페이지
                        .requestMatchers("/**").permitAll()
        );

        http.exceptionHandling(ex -> ex.accessDeniedHandler(customAccessDeniedHandler));

        // RoleHierarchy 설정 추가
        http.setSharedObject(RoleHierarchy.class, roleHierarchy);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource); // import javax.sql.DataSource;
        return jdbcTokenRepository;
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_MASTER > ROLE_SUB_MASTER > ROLE_HEAD > ROLE_TEAM > ROLE_MEMBER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy());
        return expressionHandler;
    }

}
