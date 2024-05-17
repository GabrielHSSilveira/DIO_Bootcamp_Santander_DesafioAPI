package me.dio.validator;

import me.dio.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    /**
     * Valida os dados de um usuário.
     *
     * @param user O usuário a ser validado
     * @throws IllegalArgumentException Se os dados do usuário forem inválidos
     */
    public void validate(User user) {
        validateName(user.getName());
    }

    /**
     * Valida o nome de um usuário.
     *
     * @param name O nome a ser validado
     * @throws IllegalArgumentException Se o nome for inválido (null ou vazio)
     */
    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
    }
}
