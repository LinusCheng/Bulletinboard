package bulletinboard.bulletinboard_be.config.security;

import bulletinboard.bulletinboard_be.api.request.LoginRequest;
import bulletinboard.bulletinboard_be.api.response.LoginResponse;
import bulletinboard.bulletinboard_be.config.SpringApplicationContext;
import bulletinboard.bulletinboard_be.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.jsonwebtoken.*;
import bulletinboard.bulletinboard_be.config.security.SecurityConstrants;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException {

        try{
            LoginRequest creds = new ObjectMapper()
                    .readValue( req.getInputStream() , LoginRequest.class );
//            System.out.println("In LoginRequest creds = new ObjectMapper()");

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPw(),
                            new ArrayList<>()
                    ));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(
            HttpServletRequest req, HttpServletResponse res,
            FilterChain chain, Authentication auth) throws IOException, ServletException {

        String userName = ((User) auth.getPrincipal()).getUsername();

        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis()+ SecurityConstrants.EXPIRATION_TIME))
                .signWith( SignatureAlgorithm.HS512 , SecurityConstrants.TOKEN_SECRET)

                .compact();

        //!!
//        UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
//        userService.
        //This returns data in header
//        res.addHeader(SecurityConstrants.HEADER_STRING, SecurityConstrants.TOKEN_PREFIX+token);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(userName);
        loginResponse.setToken(token);
        loginResponse.setExpirationIn(SecurityConstrants.EXPIRATION_TIME);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr   = Obj.writeValueAsString(loginResponse);
        res.getWriter().append(jsonStr);

    }
}
