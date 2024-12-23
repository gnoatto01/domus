package com.br.soluctions.attos.domus.utils;

import org.springframework.stereotype.Service;

@Service
public class RemoverParametrosJson {
    public String removerParametros(String dados, String nomeDados) {
        dados = dados.replaceAll("[{}]", "");

        dados = dados.replaceAll("\"", "");

        dados = dados.replaceAll(":", "");

        dados = dados.replaceAll("Bearer", "");

        dados = dados.replaceAll(nomeDados, "");

        return dados;
    }
}
