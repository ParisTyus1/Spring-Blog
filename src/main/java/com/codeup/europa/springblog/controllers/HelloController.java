package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
class HelloController {
        @GetMapping("/hello")
        @ResponseBody
        public String hello() {
            return "Konnichiha from Spring!";
        }


//        @GetMapping("/hello/{name}")
//        @ResponseBody
//        public String sayHello(@PathVariable String name) {
//            return "Guten Tag " + name + "!";
//        }

        @GetMapping("/hello/{name}")
        public String sayHello(@PathVariable String name, Model model) {
            model.addAttribute("name", name);
            return "hello";
        }

        @GetMapping("/join")
        public String showJoinForm() {
            return "join";
        }

        @PostMapping("/join")
        public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
            model.addAttribute("cohort", "Welcome to " + cohort + "!");
            return "join";
        }
    }


