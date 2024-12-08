package com.br.soluctions.attos.domus.dtos;

import java.util.Date;

public record MembroDePatrulhaDto (String nome, String sobrenome, Date nascimento, String genero, String cpf, String rg, String celular, String nivelEscolar, String instituicaoEnsino, String religiao, String igrejaPertence, String nomePastor, String alergia, String disturbio, String restricaoAtividadesFisicas, Boolean sabeNadar, String medicacaoContinua, char tipoSanguineo, char fatorRh, String planoSaude, String hospitalAtendimento, String informacoesAdicionais, String tamanhoCamiseta, String tamanhoColete, String nomePai, String telefonePai, String nomeMae, String telefoneMae, String emailContato, String religiaoPais, String igrejaFamilia, String telefoneAdicional,String logradouro, String bairro, String cidade, String cep, Boolean ativadeExterna, Boolean atividadeInterna) {
    
}
