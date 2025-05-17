package br.senai.lab364.futurodev.springsec.services.Users;

import br.senai.lab364.futurodev.springsec.dtos.UserDTO.RequestUserDTO;
import br.senai.lab364.futurodev.springsec.dtos.UserDTO.ResponseUserDTO;
import br.senai.lab364.futurodev.springsec.models.User;
import br.senai.lab364.futurodev.springsec.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserInterf {
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASS = "admin";

    private final PasswordEncoder encoder;
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }

        if (username.equals(DEFAULT_USER)) {
            return User.builder()
                    .id(0L)
                    .name("ROOT")
                    .username(DEFAULT_USER)
                    .password(encoder.encode(DEFAULT_PASS))
                    .role("ADMIN").build();
        }

        throw new UsernameNotFoundException(username);
    }

    @Override
    public List<ResponseUserDTO> findAll() {
        return repository.findAll().stream().map(
                u -> ResponseUserDTO.builder()
                        .id(u.getId())
                        .name(u.getName())
                        .username(u.getUsername())
                        .role(u.getRole())
                        .build()
        ).toList();
    }

    @Override
    public ResponseUserDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow();
        return ResponseUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    @Override
    public ResponseUserDTO create(RequestUserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        user = repository.save(user);
        return findById(user.getId());
    }

    @Override
    public ResponseUserDTO update(Long id, RequestUserDTO dto) {
        User user = repository.findById(id).orElseThrow();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        user = repository.save(user);
        return findById(user.getId());
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}
