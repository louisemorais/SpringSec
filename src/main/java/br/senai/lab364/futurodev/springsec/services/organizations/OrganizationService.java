package br.senai.lab364.futurodev.springsec.services.organizations;

import br.senai.lab364.futurodev.springsec.dtos.organization.RequestOrganizationDTO;
import br.senai.lab364.futurodev.springsec.dtos.organization.ResponseOrganizationDTO;
import br.senai.lab364.futurodev.springsec.mappers.OrganizationMapper;
import br.senai.lab364.futurodev.springsec.models.Organization;
import br.senai.lab364.futurodev.springsec.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements OrganizationInterf {
    private final OrganizationRepository repository;

    @Override
    public List<ResponseOrganizationDTO> findAll() {
        List<Organization> entities =repository.findAll();
        return OrganizationMapper.toResponseDtos(entities);
    }

    @Override
    public ResponseOrganizationDTO findById(Long id) {
        Organization entity = repository.findById(id).orElseThrow();
        return OrganizationMapper.toResponseDTO(entity);
    }

    @Override
    public ResponseOrganizationDTO create(RequestOrganizationDTO dto) {
        Organization organization = OrganizationMapper.toEntity(new Organization(), dto);
        return OrganizationMapper.toResponseDTO(repository.save(organization));
    }

    @Override
    public ResponseOrganizationDTO update(Long id, RequestOrganizationDTO dto) {
        Organization organization = repository.findById(id).orElse(null);
        OrganizationMapper.toEntity(organization, dto);
        return OrganizationMapper.toResponseDTO(repository.save(organization));
    }


    @Override
    public void delete(Long id) {
        Organization organization = repository.findById(id).orElse(null);
        repository.delete(organization);
    }
}
