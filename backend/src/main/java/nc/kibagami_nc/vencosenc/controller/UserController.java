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

    @GetMapping
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {

        User user = userMapper.toEntity(dto);
        user.setRegistrationDate(LocalDateTime.now());
        user.setIsActive(true);

        return userMapper.toDto(userRepository.save(user));
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {

        User user = userRepository.findById(id).orElseThrow();
        userMapper.updateEntity(user, dto);

        return userMapper.toDto(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
