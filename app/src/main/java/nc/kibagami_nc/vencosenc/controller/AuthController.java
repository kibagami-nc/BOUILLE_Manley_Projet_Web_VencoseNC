package nc.kibagami_nc.vencosenc.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.UserDto;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.mapper.UserMapper;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // POST /api/auth/login -> verifie email + mot de passe et renvoie l'utilisateur
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
