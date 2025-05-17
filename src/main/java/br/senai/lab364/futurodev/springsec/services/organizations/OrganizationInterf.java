package br.senai.lab364.futurodev.springsec.services.organizations;

import br.senai.lab364.futurodev.springsec.dtos.organization.RequestOrganizationDTO;
import br.senai.lab364.futurodev.springsec.dtos.organization.ResponseOrganizationDTO;

import java.util.List;

public interface OrganizationInterf {
    List<ResponseOrganizationDTO> findAll();
    ResponseOrganizationDTO findById(Long id);
    ResponseOrganizationDTO create(RequestOrganizationDTO dto);
    ResponseOrganizationDTO update(Long id, RequestOrganizationDTO dto);
    void delete(Long id);
}
