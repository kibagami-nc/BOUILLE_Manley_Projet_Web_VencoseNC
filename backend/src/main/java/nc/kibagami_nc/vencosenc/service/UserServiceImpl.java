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

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDto create(UserDto dto) {

        User user = userMapper.toEntity(dto);
        user.setRegistrationDate(LocalDateTime.now());
        user.setIsActive(true);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto update(Long id, UserDto dto) {

        User user = userRepository.findById(id).orElseThrow();
        userMapper.updateEntity(user, dto);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
