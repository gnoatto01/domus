package com.br.soluctions.attos.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.br.soluctions.attos.domus.dtos.MembroDePatrulhaDto;
import com.br.soluctions.attos.entities.MembroDePatrulha;
import com.br.soluctions.attos.repositories.MembroDePatrulhaRepository;

@Service
public class MembroDePatrulhaService {
    private MembroDePatrulhaRepository membroDePatrulhaRepository; 

    public MembroDePatrulhaService(MembroDePatrulhaRepository membroDePatrulhaRepository){
        this.membroDePatrulhaRepository = membroDePatrulhaRepository; 
    }

    public MembroDePatrulha registrarNovoMembroDePatrulha(MembroDePatrulhaDto mDePatrulhaDto){
        var membroExistente = membroDePatrulhaRepository.findByNome(mDePatrulhaDto.nome()); 

        if(membroExistente.isPresent()){
            throw new DataIntegrityViolationException("Membro de patrulha já existe na base de dados");
        }

        var membroPatrulha = new MembroDePatrulha(); 

        membroPatrulha.setNome(mDePatrulhaDto.nome());
        membroPatrulha.setSobrenome(mDePatrulhaDto.sobrenome());
        membroPatrulha.setNascimento(mDePatrulhaDto.nascimento());
        membroPatrulha.setGenero(mDePatrulhaDto.genero());
        membroPatrulha.setRg(mDePatrulhaDto.rg());
        membroPatrulha.setCpf(mDePatrulhaDto.cpf());
        membroPatrulha.setNivelEscolar(mDePatrulhaDto.nivelEscolar());
        membroPatrulha.setInstituicaoDeEnsino(mDePatrulhaDto.instituicaoEnsino());
        membroPatrulha.setIgrejaAQualPertence(mDePatrulhaDto.igrejaPertence());
        membroPatrulha.setNomeDoPastor(mDePatrulhaDto.nomePastor());
        membroPatrulha.setCelular(mDePatrulhaDto.celular());
        membroPatrulha.setAlergia(mDePatrulhaDto.alergia());
        membroPatrulha.setDisturbio(mDePatrulhaDto.disturbio());
        membroPatrulha.setRestricaoAtividadesFisicas(mDePatrulhaDto.restricaoAtividadesFisicas());
        membroPatrulha.setSabeNadar(mDePatrulhaDto.sabeNadar());
        membroPatrulha.setMedicacaoContinua(mDePatrulhaDto.medicacaoContinua());
        membroPatrulha.setTipoSanguineo(mDePatrulhaDto.tipoSanguineo());
        membroPatrulha.setFatorRh(mDePatrulhaDto.fatorRh());
        membroPatrulha.setPlanoDeSaude(mDePatrulhaDto.planoSaude());
        membroPatrulha.setHospitalDeAtendimento(mDePatrulhaDto.hospitalAtendimento());
        membroPatrulha.setInformacoesAdicionais(mDePatrulhaDto.informacoesAdicionais());
        membroPatrulha.setTamanhoDaCamiseta(mDePatrulhaDto.tamanhoCamiseta());
        membroPatrulha.setTamanhoDoColete(mDePatrulhaDto.tamanhoColete());
        membroPatrulha.setNomeDoPai(mDePatrulhaDto.nomePai());
        membroPatrulha.setTelefoneDoPai(mDePatrulhaDto.telefonePai());
        membroPatrulha.setNomeDaMae(mDePatrulhaDto.nomeMae());
        membroPatrulha.setTelefoneDaMae(mDePatrulhaDto.telefoneMae());
        membroPatrulha.setEmailParaContato(mDePatrulhaDto.emailContato());
        membroPatrulha.setReligiaoPais(mDePatrulhaDto.religiaoPais());
        membroPatrulha.setIgrejaDaFamilia(mDePatrulhaDto.igrejaFamilia());
        membroPatrulha.setTelefoneAuxiliar(mDePatrulhaDto.telefoneAdicional()); 
        membroPatrulha.setLogradouro(mDePatrulhaDto.logradouro());
        membroPatrulha.setBairro(mDePatrulhaDto.bairro());
        membroPatrulha.setCidade(mDePatrulhaDto.cidade());
        membroPatrulha.setCep(mDePatrulhaDto.cep());
        membroPatrulha.setAtivadeExterna(mDePatrulhaDto.ativadeExterna());
        membroPatrulha.setAtividadeInterna(mDePatrulhaDto.atividadeInterna());

        return membroDePatrulhaRepository.save(membroPatrulha); 
        
    }
}
