package com.yuanjiaoc.cloud.service02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月11日
 */
@SpringBootApplication
@RestController
public class SpringBootHelloWorld02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorld02Application.class, args);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello world 02", HttpStatus.OK);
    }

}
