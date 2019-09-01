package no.rubato.security;

import no.rubato.service.CustomBandDetailsService;
import no.rubato.service.CustomPersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static no.rubato.security.SecurityConstants.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig {

    @Order(1)
    @Configuration
    public static class UserConfiguration extends WebSecurityConfigurerAdapter {


        @Autowired
        private JwtAuthenticationEntryPoint unauthorizedHandler;
        @Autowired
        private CustomPersonDetailsService customPersonDetailsService;

        @Bean
        public JwtAuthenticationFilter jwtAuthenticationFilter() {
            return new JwtAuthenticationFilter();
        }

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(customPersonDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }


        @Override
        @Bean(BeanIds.AUTHENTICATION_MANAGER)
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable()
                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    //Frontend will handle the session, so the backend will be stateless
                    .and()
                    .authorizeRequests()
                    .antMatchers(SIGN_UP_URLS).permitAll()
                    .anyRequest()
                    .authenticated();
            http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }


    ////inner class

    @Order(2)
    @Configuration
   public static class BandSecurityConfig extends WebSecurityConfigurerAdapter{


        @Autowired
        private JwtAuthenticationEntryPoint unauthorizedHandler;
        @Autowired
        private CustomBandDetailsService customBandDetailsService;

        @Bean
        public JwtAuthenticationFilter jwtAuthenticationFilter() {
            return new JwtAuthenticationFilter();
        }

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(customBandDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }


        @Override
        @Bean(BeanIds.AUTHENTICATION_MANAGER)
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }




        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.cors().and().csrf().disable()
                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    //Frontend will handle the session, so the backend will be stateless
                    .and()
                    .headers().frameOptions().sameOrigin() //To enable H2 Databases
                    .and()
                    .authorizeRequests()
                    .antMatchers(SIGN_UP_BAND).permitAll()
                    .anyRequest()
                    .authenticated();
            http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }
}
