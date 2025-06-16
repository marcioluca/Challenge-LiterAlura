package com.alura.LiterAlura.service;

import com.alura.LiterAlura.dto.DadosLivro;
import com.alura.LiterAlura.dto.DadosResultado;
import com.alura.LiterAlura.model.Autor;
import com.alura.LiterAlura.model.Idioma;
import com.alura.LiterAlura.model.Livro;
import com.alura.LiterAlura.repository.AutorRepository;
import com.alura.LiterAlura.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

public class LivroService {
    private LivroRepository repository;
    private AutorService autorService;
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    public LivroService(LivroRepository repository, AutorRepository autorRepository) {
        this.repository = repository;
        this.autorService = new AutorService(autorRepository);
    }

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Optional<DadosLivro> getDadosLivro(String nomeLivro) {
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));
        DadosResultado resposta = converte.obterDados(json, DadosResultado.class);
        if (resposta.resultados().isEmpty()) {
            System.out.println("Não foi possível encontrar o livro.");
            return Optional.empty();
        }
        return Optional.ofNullable(resposta.resultados().get(0));
    }
    public Livro salvarLivro(DadosLivro dadosLivro) {
        Autor autor = autorService.criarOuBuscarAutor(dadosLivro.autores().get(0));

        Livro livro = new Livro(dadosLivro);
        livro.setAutor(autor);

        autorService.salvarAutor(livro);

        return livro;
    }

    public List<Livro> obterLivrosPeloIdioma(Idioma idioma) {
        return repository.obterLivrosPeloIdioma(idioma);
    }
}
