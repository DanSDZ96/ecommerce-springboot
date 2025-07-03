package org.schiano.e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Accesso pubblico senza login";
    }

    @GetMapping("/admin/test")
    public String adminEndpoint() {
        return "Accesso ADMIN consentito";
    }

}
