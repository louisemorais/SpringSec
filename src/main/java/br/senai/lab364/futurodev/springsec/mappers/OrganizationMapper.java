package br.senai.lab364.futurodev.springsec.mappers;

import br.senai.lab364.futurodev.springsec.dtos.organization.RequestOrganizationDTO;
import br.senai.lab364.futurodev.springsec.dtos.organization.ResponseOrganizationDTO;
import br.senai.lab364.futurodev.springsec.models.Organization;

import java.util.List;

public class OrganizationMapper {
    private OrganizationMapper() {}
    public static Organization toEntity(Organization entity, RequestOrganizationDTO dto) {
        entity.setName(dto.name());
        entity.setContact(dto.contact());
        return entity;
    }

    public static ResponseOrganizationDTO toResponseDTO(Organization entity){
        return new ResponseOrganizationDTO(
                entity.getId(),
                entity.getName(),
                entity.getContact()
        );
    }

    public static List<ResponseOrganizationDTO> toResponseDtos(List<Organization> entities) {
        return entities.stream().map(OrganizationMapper::toResponseDTO).toList();
    }
}
