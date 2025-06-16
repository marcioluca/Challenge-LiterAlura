package com.alura.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.stereotype.Service;

@Service
public class ConverteDados implements IConverteDados{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        mapper.registerModule(new ParameterNamesModule());
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro na desserialização do JSON: " + e.getMessage(), e);
        }
    }
}
