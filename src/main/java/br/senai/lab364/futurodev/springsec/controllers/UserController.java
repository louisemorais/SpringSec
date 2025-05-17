package br.senai.lab364.futurodev.springsec.controllers;

import br.senai.lab364.futurodev.springsec.dtos.UserDTO.RequestUserDTO;
import br.senai.lab364.futurodev.springsec.dtos.UserDTO.ResponseUserDTO;
import br.senai.lab364.futurodev.springsec.services.Users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<ResponseUserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseUserDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUserDTO create(@RequestBody RequestUserDTO dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ResponseUserDTO update(@PathVariable Long id, @RequestBody RequestUserDTO dto) {
        return service.update(id,dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
