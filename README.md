# LiterAlura 📚

Projeto desenvolvido em Java com Spring Boot como **conclusão do Challenge da Alura: LiterAlura**.  
O desafio propôs construir uma aplicação que consome dados de uma API pública de livros, processa as informações e as persiste em banco de dados, explorando conceitos fundamentais do ecossistema Spring.

---

## 🚀 Tecnologias usadas

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- Jackson (JSON)
- PostgreSQL
- Maven

---

## 🔧 Configuração

### Pré-requisitos

- Java JDK 17+
- Maven
- PostgreSQL 
- IDE (IntelliJ, VSCode, Eclipse...)

### application.properties

Configure as credenciais do banco no `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📥 Executando o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/literalura.git
cd literalura
```

### 2. Instale as dependências

```bash
mvn clean install
```

### 3. Rode a aplicação

```bash
mvn spring-boot:run
```

A aplicação inicia na porta `8080`.

---

## 🌐 Fonte dos dados

Os livros são buscados da [API do Gutendex](https://gutendex.com/), que fornece dados públicos de obras literárias.

Exemplo de endpoint usado:

```
https://gutendex.com/books?search=nome-do-livro
```

---

## 🧠 Estrutura do projeto

```text
.
├── dto
│   ├── DadosAutor.java
│   ├── DadosLivro.java
│   └── DadosResultado.java
├── model
│   ├── Autor.java
│   ├── Livro.java
│   └── Idioma.java
├── repository
│   ├── AutorRepository.java
│   └── LivroRepository.java
├── service
│   ├── AutorService.java
│   └── LivroService.java
├── util
│   ├── ConsumoApi.java
│   ├── IConverteDados.java
│   └── ConverteDados.java
├── Principal.java
└── LiterAluraApplication.java
```

---

## ✅ Conclusão

Este projeto é a **entrega final do Challenge da Alura - LiterAlura**.

Durante o desafio, foi possível colocar em prática:

- Consumo de APIs REST com Spring Web
- Manipulação e mapeamento de JSON com Jackson
- Criação de entidades, repositórios e serviços com Spring Data JPA
- Validação e persistência em banco de dados
- Enumeração customizada e tratamento de erros de desserialização
- Organização por camadas e boas práticas de projeto Java

O **LiterAlura** representa uma simulação prática de um projeto real, integrando múltiplas habilidades essenciais para o desenvolvimento back-end com Java.

---

## ✍️ Como contribuir

1. Faça um fork
2. Crie uma branch nova: `git checkout -b feature/nova-funcionalidade`
3. Faça commit das suas alterações: `git commit -m 'feat: adiciona nova funcionalidade'`
4. Push na sua branch: `git push origin feature/nova-funcionalidade`
5. Abra um Pull Request

---

## 🧑‍💻 Autor

**Márcio Lucas**

- [GitHub](https://github.com/marcioluca)
- [Linkedin](https://www.linkedin.com/in/marcio-lucas-dev/)

---

## 📜 Licença

Este projeto está sob a licença MIT.