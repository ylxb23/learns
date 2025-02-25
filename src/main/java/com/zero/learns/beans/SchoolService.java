package com.zero.learns.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @since 2024/11/13 16:35
 */
@Component
public class SchoolService {
    @Autowired
    private ManService manService;

    public ManService getMan() {
        return manService;
    }
}
