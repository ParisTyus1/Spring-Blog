package com.codeup.europa.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "dice/roll-diced";

    }


    @GetMapping("/roll-dice/{guess}")
    public String rollDiceGuess(@PathVariable int guess, Model model) {
    String message;
    int random = (int) (Math.ceil(Math.random()) * 6);

    if (random == guess){
        message = "You guessed random number";
    }else {
        message = "Sorry, Try Again";
    }
    model.addAttribute("message", message);
    model.addAttribute("guess", guess);
    model.addAttribute("random", random);

    return "dice/roll-dice";
    }

}