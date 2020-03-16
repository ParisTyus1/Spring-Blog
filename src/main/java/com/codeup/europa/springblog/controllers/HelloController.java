package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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


        @GetMapping("/fruit")
        public String fruit(Model model){
            List <String> fruitBasket = new ArrayList<>();
            fruitBasket.add("pineapple");
            fruitBasket.add("lemon");
            fruitBasket.add("apple");
            fruitBasket.add("starfruit");
            fruitBasket.add("papaya");
            fruitBasket.add("cherry");
            fruitBasket.add("apricot");
            fruitBasket.add("grapes");
            fruitBasket.add("starfruit");
            fruitBasket.add("papaya");
            fruitBasket.add("japanese pear");
            fruitBasket.add("pineapple");
            fruitBasket.add("lemon");
            fruitBasket.add("durian");

            model.addAttribute("fruitBasket", fruitBasket);

            return "fruit";
        }

    }


