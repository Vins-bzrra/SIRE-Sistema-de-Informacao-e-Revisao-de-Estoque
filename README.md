```markdown
# SIRE: Sistema de Informação e Revisão de Estoque

## Visão Geral

O **SIRE (Sistema de Informação e Revisão de Estoque)** é uma solução avançada de gerenciamento de estoque desenvolvida em Java com a framework Spring Boot. Esse sistema oferece controle e monitoramento eficientes para diversos tipos de ativos, desde equipamentos de TI até móveis e outros itens corporativos.

Recursos como registro de movimentação, histórico de aquisição, análise de alterações e autenticação de usuários tornam o SIRE uma ferramenta poderosa para organizações que buscam gerenciar seu estoque de forma eficaz.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **PostgreSQL** (ou outro banco de dados de sua escolha)
- **JWT** para autenticação
- **Hibernate** para mapeamento objeto-relacional
- **BCrypt** para criptografia de senhas
- **Maven** para gerenciamento de dependências

## Estrutura do Projeto

O projeto segue uma estrutura modular e orientada a objetos, composta pelas seguintes classes principais:

- **Item**: Classe abstrata que representa um item genérico do inventário.
- **OthersItems**: Classe que herda de `Item` e representa um tipo específico de item.
- **ITItems**: Classe que herda de `Item` e representa outro tipo de item.
- **FurnitureItems**: Classe que herda de `Item` e representa móveis.
- **ItemMovementHistory**: Classe que registra o histórico de movimentações de itens.
- **ItemChange**: Classe que registra as mudanças nos atributos dos itens.
- **ItemAcquisition**: Classe que registra as aquisições de itens.
- **User**: Classe que representa os usuários do sistema.

## Configuração

O SIRE utiliza o banco de dados PostgreSQL por padrão. Você pode configurar a conexão com o banco de dados no arquivo `application.properties`. Certifique-se de ter o PostgreSQL instalado e configurado corretamente.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/inventario
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Instalação

Para construir o projeto, utilize o Maven. Execute o seguinte comando no diretório raiz:

```shell
mvn clean install
```

Após a construção bem-sucedida, você pode executar o aplicativo Spring Boot:

```shell
java -jar target/sire.jar
```

O aplicativo estará disponível em `http://localhost:8080`.

## Uso

O Sistema de Informação e Revisão de Estoque oferece uma API acessível por meio das rotas especificadas nas classes. A autenticação é necessária para acessar as rotas protegidas.

## Licença

Este projeto é distribuído sob a licença Apache License 2.0. Consulte o arquivo LICENSE.md para obter mais informações.

## Contato

- Vinícius Bezerra - vbzrra12@gmail.com
