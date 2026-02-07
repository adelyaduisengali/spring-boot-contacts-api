package com.example.as4.service.impl;

import com.example.as4.model.dto.UserDTO;
import com.example.as4.model.entity.User;
import com.example.as4.repository.UserRepository;
import com.example.as4.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        // create: id должен быть null (автоинкремент)
        User entity = toEntity(dto);
        entity.setId(null);

        User saved = repo.save(entity);
        return toDto(saved);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        return toDto(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return repo.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));

        existing.setFullName(dto.getFullName());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());

        User saved = repo.save(existing);
        return toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Contact not found with id: " + id);
        }
        repo.deleteById(id);
    }

    // ===== mappers =====
    private UserDTO toDto(User u) {
        return UserDTO.builder()
                .id(u.getId())
                .fullName(u.getFullName())
                .phoneNumber(u.getPhoneNumber())
                .email(u.getEmail())
                .address(u.getAddress())
                .build();
    }

    private User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }
}
