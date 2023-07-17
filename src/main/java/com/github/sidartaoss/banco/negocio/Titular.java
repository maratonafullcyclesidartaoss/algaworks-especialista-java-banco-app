package com.github.sidartaoss.banco.negocio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Titular {

    private static final Logger logger = LoggerFactory.getLogger(Titular.class);

    private String nome;
    private final String cpf;

    public Titular(String nome, String cpf) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome.");
        }
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Informe o CPF.");
        }
        this.nome = nome;
        this.cpf = cpf;
        if (this.nome.length() < 5) {
            logger.warn("Nome do titular '{}' muito curto.", this.nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Titular{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}

