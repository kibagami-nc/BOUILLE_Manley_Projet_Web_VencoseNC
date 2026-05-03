package nc.kibagami_nc.vencosenc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nc.kibagami_nc.vencosenc.dto.UserDto;
import nc.kibagami_nc.vencosenc.entity.User;
import nc.kibagami_nc.vencosenc.mapper.UserMapper;
import nc.kibagami_nc.vencosenc.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Recupere tous les utilisateurs et les renvoie en DTO
    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    // Cherche un utilisateur par son id (exception s'il n'existe pas)
    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    // Cree un utilisateur (date d'inscription auto + compte actif par defaut)
    @Override
    public UserDto create(UserDto dto) {

        User user = userMapper.toEntity(dto);
        user.setRegistrationDate(LocalDateTime.now());
        user.setIsActive(true);

        return userMapper.toDto(userRepository.save(user));
    }

    // Recupere un utilisateur existant et met a jour ses champs
    @Override
    public UserDto update(Long id, UserDto dto) {

        User user = userRepository.findById(id).orElseThrow();
        userMapper.updateEntity(user, dto);

        return userMapper.toDto(userRepository.save(user));
    }

    // Supprime un utilisateur par son id
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
