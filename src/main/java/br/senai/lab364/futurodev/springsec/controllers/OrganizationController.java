package br.senai.lab364.futurodev.springsec.controllers;

import br.senai.lab364.futurodev.springsec.dtos.organization.RequestOrganizationDTO;
import br.senai.lab364.futurodev.springsec.dtos.organization.ResponseOrganizationDTO;
import br.senai.lab364.futurodev.springsec.services.organizations.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService service;
    @GetMapping
    public List<ResponseOrganizationDTO> findAll() {

        return service.findAll();
    }

    @GetMapping({"{id}"})
    public ResponseOrganizationDTO findById(@PathVariable Long id) {

        return service.findById(id);
    }
    @PostMapping
    public ResponseOrganizationDTO save(@RequestBody RequestOrganizationDTO dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public  ResponseOrganizationDTO update( @PathVariable Long id,@RequestBody RequestOrganizationDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }
}
