package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{a}/and/{b}")
    @ResponseBody
    public String add(@PathVariable int a, int b) {
        return "" + (a+b);
    }

    @RequestMapping(path = "/subtract/{a}/and/{b}")
    @ResponseBody
    public String subtract(@PathVariable int a, int b) {
        return "" + (b-a);
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiply(@PathVariable int a, int b) {
        return "" + (a*b);
    }

    @RequestMapping(path = "/add/{a}/and/{b}")
    @ResponseBody
    public double divde(@PathVariable double a, double b) {
        return (a/b);
    }




}
