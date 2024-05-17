package me.dio.handler;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHandler extends UserExceptionHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public User create(User user) {
        validateUserData(user);
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Invalid user data provided", e);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user", e);
        }
    }

    public User update(Long id, User user) {
        findById(id); // Verifica se o usuário existe
        user.setId(id); // Garante que o ID passado é o mesmo do usuário
        validateUserData(user);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

    private void validateUserData(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
    }
}


