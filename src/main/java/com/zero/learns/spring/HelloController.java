package com.zero.learns.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = {"/hello"})
public class HelloController {

    @RequestMapping(path = {"/ask"}, method = {RequestMethod.GET})
    public ResponseEntity<String> ask(HttpServletRequest request) {
        return ResponseEntity.ok("hello, " + request.getRemoteAddr() + ":" + request.getRemotePort());
    }
}
