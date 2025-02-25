package com.zero.learns.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = {"/hello"})
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(path = {"/ask"}, method = {RequestMethod.GET})
    public ResponseEntity<String> ask(HttpServletRequest request) {
        logger.info("hello asked. remote address: {}:{}", request.getRemoteAddr(), request.getRemotePort());
        return ResponseEntity.ok("hello, " + request.getRemoteAddr() + ":" + request.getRemotePort());
    }
}
