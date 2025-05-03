package br.senai.lab364.futurodev.springsec.repositories;

import br.senai.lab364.futurodev.springsec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
