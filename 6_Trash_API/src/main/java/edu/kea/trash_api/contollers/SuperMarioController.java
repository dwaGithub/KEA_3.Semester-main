package edu.kea.trash_api.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperMarioController {

    @GetMapping("/supermario/characters")
    public String characters() {
        return "Marioooooo";
    }
}
