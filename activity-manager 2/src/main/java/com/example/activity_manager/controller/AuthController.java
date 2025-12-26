/**
 * Clasa controller pentru autentificare
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
