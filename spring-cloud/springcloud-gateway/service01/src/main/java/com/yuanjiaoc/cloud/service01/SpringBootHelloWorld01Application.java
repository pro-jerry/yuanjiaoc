package com.yuanjiaoc.cloud.service01;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月11日
 */
@SpringBootApplication
@RestController
public class SpringBootHelloWorld01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorld01Application.class, args);
    }

    @GetMapping("/gate/hello")
    public ResponseEntity<String> hello(HttpServletRequest request,
            @RequestHeader("Content-Length") String contentLength) {
        String date = request.getHeader("name");
        return new ResponseEntity<>("gate hello world", HttpStatus.OK);
    }

    @GetMapping("/rule/hello")
    public ResponseEntity<String> mypathHello() {
        return new ResponseEntity<>("rule hello world", HttpStatus.OK);
    }

}
