package org.example.dto;

import java.util.Map;

public class ClienteDTO {

    private String nome;
    private String email;
    private String telefone;

    public ClienteDTO(Map<String, String> cliente) {
        this.nome = cliente.get("nome");
        this.email = cliente.get("email");
        this.telefone = cliente.get("telefone");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
