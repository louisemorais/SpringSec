package br.senai.lab364.futurodev.springsec.services.Logins;

import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.RequestLoginDTO;
import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.ResponseLoginDTO;

public interface LoginInterf {
    ResponseLoginDTO authenticate(RequestLoginDTO dto);
}
