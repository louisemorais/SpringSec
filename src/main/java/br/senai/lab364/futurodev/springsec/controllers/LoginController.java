package br.senai.lab364.futurodev.springsec.controllers;

import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.RequestLoginDTO;
import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.ResponseLoginDTO;
import br.senai.lab364.futurodev.springsec.services.Logins.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

    private final Login service;

    @PostMapping
    public ResponseLoginDTO login(@RequestBody RequestLoginDTO dto) {
        return service.authenticate(dto);
    }
}
