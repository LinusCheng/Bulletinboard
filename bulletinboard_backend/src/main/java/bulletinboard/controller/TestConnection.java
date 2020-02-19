package bulletinboard.bulletinboard_be.controller;

import bulletinboard.bulletinboard_be.domain.ConnectionTestObj;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


@RestController
@CrossOrigin("*")
public class TestConnection {

    @GetMapping("/testserverconnection")
    public ConnectionTestObj getAllpost(){

        ConnectionTestObj a_i = new ConnectionTestObj();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        a_i.content = "The connection is good";
        a_i.time = dtf.format(now);

        return a_i;
    }

}
