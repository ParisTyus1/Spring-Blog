package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String add(@PathVariable int a,@PathVariable int b) {
        return "" + (a + b);
    }

    @RequestMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    public String subtract(@PathVariable int a,@PathVariable int b) {
        return "" + (b - a);
    }

    @RequestMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiply(@PathVariable int a,@PathVariable int b) {
        return "" + (a * b);
    }

    @RequestMapping("/divide/{a}/by/{b}")
    @ResponseBody
    public String divide(@PathVariable double a, @PathVariable double b) {
        return "" + (a / b);
    }




}
