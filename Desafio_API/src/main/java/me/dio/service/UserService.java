package me.dio.service;

import me.dio.domain.model.User;

public interface UserService extends CrudService<Long, User> {
    public User create(User user) {
        // Validação dos dados de entrada
        validateUserData(user);

        // Lógica para criar o usuário no banco de dados
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            // Tratamento de violação de restrição de integridade
            throw new IllegalArgumentException("Invalid user data provided", e);
        } catch (Exception e) {
            // Outros erros inesperados
            throw new RuntimeException("Error creating user", e);
        }
    }

    private void validateUserData(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
}
