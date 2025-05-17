package br.senai.lab364.futurodev.springsec.repositories;

import br.senai.lab364.futurodev.springsec.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
