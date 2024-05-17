package me.dio.controller.dto;

import me.dio.domain.model.Account;

import java.math.BigDecimal;

/**
 * DTO para representar dados de conta.
 */

public record AccountDto(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {


    /**
     * Construtor para converter de modelo para DTO.
     */
    public AccountDto(Account model) {
        this(model.getId(), model.getNumber(), model.getAgency(), model.getBalance(), model.getLimit());
    }

    /**
     * Método para converter de DTO para modelo.
     */

    public Account toModel() {
        Account model = new Account();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setAgency(this.agency);
        model.setBalance(this.balance);
        model.setLimit(this.limit);
        return model;
    }
}
