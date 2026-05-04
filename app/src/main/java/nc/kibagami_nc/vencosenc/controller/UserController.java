package nc.kibagami_nc.vencosenc.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.UserDto;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.mapper.UserMapper;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /*
     * Utilisation du UserDto.java pour l'affichage, suppression, modification et création
     */

    // GET /api/user -> renvoie la liste de tous les utilisateurs
    @GetMapping
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    // POST /api/user -> cree un nouvel utilisateur (date d'inscription auto + actif par defaut)
    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {

        User user = userMapper.toEntity(dto);
        user.setRegistrationDate(LocalDateTime.now());
        user.setIsActive(true);

        return userMapper.toDto(userRepository.save(user));
    }

    // GET /api/user/{id} -> renvoie un utilisateur par son id
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    // PUT /api/user/{id} -> modifie un utilisateur existant
    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {

        User user = userRepository.findById(id).orElseThrow();
        userMapper.updateEntity(user, dto);

        return userMapper.toDto(userRepository.save(user));
    }

    // DELETE /api/user/{id} -> supprime l'utilisateur correspondant
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping()
}
