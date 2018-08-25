package examples.boot.jpaexam.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/boards")
                    .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/boards/writeform").hasRole("USER")
                    .antMatchers(HttpMethod.POST,"/boards").hasRole("USER")
                    .antMatchers("/boards/**").permitAll()
                    .antMatchers("/members/joingform").permitAll()
                    .antMatchers(HttpMethod.POST,"/members").permitAll()
                    .antMatchers("/members/welcome").permitAll()
                    .antMatchers("/members/**").hasRole("USER")
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().fullyAuthenticated()
                .and().csrf()  //개발시에만 필요 csrf()    h2-console과 연관이있다.(로그인못함)
                .ignoringAntMatchers("/**")
                .and().
                headers().frameOptions().disable() ///개발시에만 필요 csrf()    h2-console과 연관이있다.
                .and().formLogin()
                .loginProcessingUrl("/users/login")
                .loginPage("/users/login").
                usernameParameter("email").
                passwordParameter("password");


    }

}
