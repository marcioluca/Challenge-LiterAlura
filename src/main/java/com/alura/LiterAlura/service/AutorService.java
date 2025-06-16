package com.alura.LiterAlura.service;

import com.alura.LiterAlura.dto.DadosAutor;
import com.alura.LiterAlura.model.Autor;
import com.alura.LiterAlura.model.Livro;
import com.alura.LiterAlura.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

public class AutorService {
    private AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Optional<Autor> find(Long id) {
        return repository.findById(id);
    }

    public Autor criarOuBuscarAutor(DadosAutor dadosAutor) {
        Optional<Autor> optionalAutor = repository.findFirstByNomeContainingIgnoreCase(dadosAutor.nome());

        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();
            return autor;
        }
        return new Autor(dadosAutor);
    }

    public void salvarAutor(Livro livro) {
        Autor autor = livro.getAutor();
        autor.getLivros().add(livro);
        repository.save(autor);
    }

    public List<Autor> obterAutoresVivosEmDeterninadoAno(Integer ano) {
        return repository.obterAutoresVivosEmDeterninadoAno(ano);
    }
}
