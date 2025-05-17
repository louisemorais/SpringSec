package br.senai.lab364.futurodev.springsec.dtos.UserDTO;

import lombok.Data;

@Data
public class RequestUserDTO{
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
}
