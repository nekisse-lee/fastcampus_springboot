package com.nekisse.myweb.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.http.MatcherType.ant;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .requestMatchers(new AntPathRequestMatcher("/templates/**"))
                .requestMatchers(new AntPathRequestMatcher("../static/**"))
//                .requestMatchers(new AntPathRequestMatcher("**/*.css"))
//                .requestMatchers(new AntPathRequestMatcher("**/*.js"))
                .requestMatchers(new AntPathRequestMatcher("/**/.html"))
                .requestMatchers(new AntPathRequestMatcher("/**/.css"))
                .requestMatchers(new AntPathRequestMatcher("/**/.js"))
                .antMatchers()
        ;
    }


    /*@Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean();
    }
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
               /* .sessionManagement()
                    .maximumSessions(1)
                    .maxSessionsPreventsLogin(true)
                    .expiredUrl("/duplicated-login")
                    .sessionRegistry(sessionRegistry())*/
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/board")
                    .permitAll()
                .and().authorizeRequests()
                    .antMatchers("/members/**").permitAll()
                    .antMatchers("/members/welcome").permitAll()
                    .antMatchers("/members/login").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers(HttpMethod.POST,"/board/add").hasRole("USER")
                    .antMatchers("/board/writeboard").hasRole("USER")
                    .antMatchers("board/**").permitAll()
                    .antMatchers(HttpMethod.POST, "**/houtissue/add").hasRole("ADMIN")
                    .antMatchers("**/**").permitAll()
                .and().csrf()
                    .ignoringAntMatchers("/**")// //개발시에만 필요 csrf()    h2-console과 연관이있다.(로그인못함)
                .and()
                    .headers().frameOptions().disable() // h2콘솔에서 필요
                .and().formLogin()
                    .loginPage("/login")
                    .usernameParameter("memberId")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login");  //post 방식으로 전달
    }


}
