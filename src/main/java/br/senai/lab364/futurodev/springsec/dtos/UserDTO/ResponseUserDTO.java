package br.senai.lab364.futurodev.springsec.dtos.UserDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserDTO{
    private Long id;
    private String name;
    private String username;
    private String role;
}
