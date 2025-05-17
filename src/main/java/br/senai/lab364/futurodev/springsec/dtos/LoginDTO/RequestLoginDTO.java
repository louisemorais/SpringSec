package br.senai.lab364.futurodev.springsec.dtos.LoginDTO;

import lombok.Data;

@Data
public class RequestLoginDTO{
    private String username;
    private String password;
}
