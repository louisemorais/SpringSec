package br.senai.lab364.futurodev.springsec.dtos.LoginDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseLoginDTO{
    private String type;
    private String token;
}
