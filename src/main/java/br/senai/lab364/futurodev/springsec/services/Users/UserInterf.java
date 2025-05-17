package br.senai.lab364.futurodev.springsec.services.Users;

import br.senai.lab364.futurodev.springsec.dtos.UserDTO.RequestUserDTO;
import br.senai.lab364.futurodev.springsec.dtos.UserDTO.ResponseUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.print.attribute.standard.RequestingUserName;
import java.util.List;

public interface UserInterf extends UserDetailsService {
    List<ResponseUserDTO> findAll();
    ResponseUserDTO findById(Long id);
    ResponseUserDTO create(RequestUserDTO dto);
    ResponseUserDTO update(Long id, RequestUserDTO dto);
    void delete(Long id);
}
