package com.smk.pay.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/17 15:42
 */
@SpringBootApplication
@ServletComponentScan
public class PloutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PloutoApplication.class, args);
    }
}
