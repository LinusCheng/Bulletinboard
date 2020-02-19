//package bulletinboard.bulletinboard_be.controller;
//
////import bulletinboard.bulletinboard_be.api.request.LoginRequest;
////import bulletinboard.bulletinboard_be.config.security.JwtTokenProvider;
////import bulletinboard.bulletinboard_be.dao.UserDAO;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@CrossOrigin("*")
////@RequestMapping("/api")
//public class LoginController {
//
////    @Autowired
////    AuthenticationManager authenticationManager;
////
////    @Autowired
////    UserDAO userDAO;
////
////    @Autowired
////    PasswordEncoder passwordEncoder;
//
////    @Autowired
////    JwtTokenProvider tokenProvider;
//
//
////    @GetMapping("/login")
//////    @CrossOrigin("*")
////    public String logintest(){
////        return "Test Login";
////    }
//
//
////    @PostMapping("/login")
////    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
////
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        loginRequest.getUsername(),
////                        loginRequest.getPw()
////                )
////        );
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////
////        String jwt = tokenProvider.generateToken(authentication);
////        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
////    }
//
//
//
//}
