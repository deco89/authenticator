package com.abfonseca.library_20.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Nome é obrigatório")
    @NotNull(message = "Nome é obrigatório")
    private String firstName;
    @NotEmpty(message = "Sobrenome é obrigatório")
    @NotNull(message = "Sobrenome é obrigatório")
    private String lastName;
    @Email(message = "Email deve ser como exemplo -> seunomezinho@email.com(.br)")
    @NotEmpty(message = "Email é obrigatório")
    @NotNull(message = "Email é obrigatório")
    private String email;
    @NotEmpty(message = "Senha é obrigatória")
    @NotNull(message = "Senha é obrigatória")
    @Size(min = 8, message = "A senha precisa ter no mínimo que letras")
    private String password;

}
