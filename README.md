# Spring Boot - Estudo de Arquitetura

Este projeto é um estudo sobre a arquitetura do **Spring Boot**, abordando conceitos essenciais como injeção de dependências, camadas da aplicação e diferentes tipos de requisições HTTP.
Se quiser ver com mais detalhes anotações sobre o estudo desse curso que fiz, basta acessar esse link:  🚀 [Acesse o Notion aqui](https://www.notion.so/Curso-Spring-Boot-Expert-1aeea5c6578e80b9bc34dd51e2faef02?pvs=4)
## 📌 Tecnologias Utilizadas
- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Spring Web
- Banco de dados H2 (em memória para testes)

## 📂 Arquitetura do Projeto

O projeto segue a arquitetura tradicional do **Spring Boot**, dividida nas seguintes camadas:

### 1️⃣ **Controller (Camada de Apresentação)**
Responsável por receber e processar requisições HTTP.


### 2️⃣ **Service (Camada de Negócio)**
Aqui fica a lógica de negócio e regras da aplicação.


### 3️⃣ **Repository (Camada de Persistência)**
Interface responsável pela comunicação com o banco de dados.



## 🔄 Tipos de Requisições HTTP
- **GET** → Buscar informações (Ex: `GET /clientes`)
- **POST** → Criar novos registros (Ex: `POST /clientes`)
- **PUT** → Atualizar um registro existente (Ex: `PUT /clientes/{id}`)
- **DELETE** → Remover um registro (Ex: `DELETE /clientes/{id}`)

## ⚙️ Injeção de Dependências no Spring
### **1️⃣ Qualificadores (`@Qualifier`)**
Usado para diferenciar implementações de uma mesma interface.
```java
@Service
@Qualifier("versaoA")
public class ServicoA implements MeuServico {}
```

### **2️⃣ Definição de Bean (`@Primary`)**
Define a implementação padrão caso existam várias.
```java
@Primary
@Service
public class ServicoPadrao implements MeuServico {}
```

### **3️⃣ Injeção via Construtor (Recomendada)**
Melhor prática para garantir imutabilidade e facilitar testes.
```java
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
```

## 🛠️ Registro de Beans no Spring
O Spring gerencia os componentes automaticamente, mas também podemos definir manualmente.
```java
@Configuration
public class ConfiguracaoApp {
    @Bean
    public MeuServico meuServico() {
        return new MeuServicoImpl();
    }
}
```


## 🚀 Como Rodar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/luciaamalia/ArquiteturaSpringCourse.git
   ```
2. Configure o banco de dados no `application.yml`
3. Execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

---
📚 **Esse README foi criado para estudo
