package br.senai.lab364.futurodev.springsec.services.Logins;

import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.RequestLoginDTO;
import br.senai.lab364.futurodev.springsec.dtos.LoginDTO.ResponseLoginDTO;
import br.senai.lab364.futurodev.springsec.services.Users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@RequiredArgsConstructor
public class Login implements LoginInterf {

    private final PasswordEncoder encoder;
    private final UserService userService;

    @Override
    public ResponseLoginDTO authenticate(RequestLoginDTO dto) {
        UserDetails user = userService.loadUserByUsername(dto.getUsername());
        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UsernameNotFoundException(user.getUsername());
        }

        String token = dto.getUsername() + ":" + dto.getPassword();
        token = Base64.getEncoder().encodeToString(token.getBytes());

        return ResponseLoginDTO.builder().type("Basic").token(token).build();
    }
}
