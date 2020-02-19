package bulletinboard.bulletinboard_be.config;

import bulletinboard.bulletinboard_be.config.security.AuthenticationFilter;
import bulletinboard.bulletinboard_be.config.security.SecurityConstrants;
import bulletinboard.bulletinboard_be.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.lang.reflect.Array;
import java.util.Arrays;
//import sun.security.util.SecurityConstants;


//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .cors()
            .and()
            .csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET , "/testserverconnection").permitAll()
                .antMatchers(HttpMethod.GET , "/api/post").permitAll()


                .antMatchers(HttpMethod.DELETE , "/api/post/**").permitAll()
                .antMatchers(HttpMethod.POST , "/api/post").permitAll()
                .antMatchers(HttpMethod.POST , "/api/post/*").permitAll()

                .antMatchers(HttpMethod.GET , "/api/avatar").permitAll()

                .antMatchers(HttpMethod.GET , "/api/user").permitAll()
                .antMatchers(HttpMethod.GET , "/api/user/**").permitAll()

                .antMatchers(HttpMethod.DELETE , "/api/user/*").permitAll()


                .antMatchers(HttpMethod.GET , "/api/tokencheck").permitAll()
                .antMatchers(HttpMethod.GET , "/api/tokencheck/**").permitAll()





//                .antMatchers(HttpMethod.GET , "/api/avatar").hasRole()



                .antMatchers(HttpMethod.POST , "/api/login").permitAll()
                .antMatchers(HttpMethod.POST , SecurityConstrants.SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
            .and()

//                .addFilter()


                .addFilter(  getAuthenticationFilter() )

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


//            .addFilter(new AuthenticationFilter(authenticationManager()));


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);





    }


//    public JWT


    public AuthenticationFilter getAuthenticationFilter() throws Exception{
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/api/login");

        return filter;
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        final CorsConfiguration configuration = new CorsConfiguration();

//        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        return source;

    }


}
