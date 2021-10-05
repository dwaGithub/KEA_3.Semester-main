package edu.kea.trash_api.contollers;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TrashController {

    List<String> sins = Arrays.asList("Pride", "Greed", "Lust", "Envy", "Gluttony", "Wrath", "Sloth");

    @GetMapping("/")
    public String frontpage(){
        return "Hello there";
    }

    @GetMapping("/clock")
    public Date clock(){
        return new Date();
    }

    @GetMapping("/deadlysins")
    public String deadlySins(){

        return sins.get(6);
    }

    @PostMapping("/rubbishbin")
    public String throwOutRubbish(@RequestBody String rubbish) {
        System.out.println(rubbish);
        return "Threw it out for you.";
    }

}

}
