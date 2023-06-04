package com.firstspringproject.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public record UserDto(
    @NotNull(message = "Nome não pode ser vazio") String name,

    @NotNull(message = "Email não pode ser vazio") @Email(message = "Email inválido") String email) {

}