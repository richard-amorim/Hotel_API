package com.senai.pessoal_richard.enums;

public enum Perfil {

    ADMINISTRADOR("Administrador", "adm"),
    GERENTE("Gerente", "ger"),
    CLIENTE("Cliente", "cli");

    private final String descricao;
    private final String sigla;

    Perfil(String descricao, String sigla) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }


}

