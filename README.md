<p align="right"><img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/></p>

# Spring Boot - Estudo de Arquitetura
Este projeto implementa uma estrutura modular para uma montadora de veículos utilizando Spring Boot. Ele segue os princípios do SOLID e Design Patterns para garantir escalabilidade e manutenção eficiente do código
Este projeto é um estudo sobre a arquitetura do **Spring Boot**, abordando conceitos essenciais como injeção de dependências, camadas da aplicação e diferentes tipos de requisições HTTP.
Se quiser ver com mais detalhes algumas anotações sobre o estudo desse curso que fiz, basta acessar esse link:  🚀 [Acesse o Notion aqui](https://www.notion.so/Curso-Spring-Boot-Expert-1aeea5c6578e80b9bc34dd51e2faef02?pvs=4)
## 📌 Tecnologias Utilizadas
- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Spring Web
- Banco de dados H2 (em memória para testes)


## 📂 Arquitetura do Projeto


api: Contém os controladores e anotações personalizadas para os motores dos veículos.

configuration: Contém as configurações das entidades relacionadas ao veículo.

todos: Implementa funcionalidades como envio de e-mails e validação de dados.


O projeto segue a arquitetura tradicional do **Spring Boot**, dividida nas seguintes camadas:

### 1️⃣ **Controller (Camada de Apresentação)**
Responsável por receber e processar requisições HTTP.


### 2️⃣ **Service (Camada de Negócio)**
Aqui fica a lógica de negócio e regras da aplicação.


### 3️⃣ **Repository (Camada de Persistência)**
Interface responsável pela comunicação com o banco de dados.



## 🔄 Funcionalidades
- **POST** →  Ligação de um carro (Ex: `POST /clientes`)
O TesteFabricaController recebe uma chave via requisição POST e utiliza um motor elétrico para ligar um carro HondaHRV.
Exemplo de requisição:
```http
POST /teste-fabrica
Content-Type: application/json

{
  "codigo": "1234"
}
```
#### **Resposta esperada**:

```json
{
  "status": "Ligado"
}
```

## Uso de Anotação Personalizada

O projeto utiliza uma anotação personalizada `@Eletrico` para injeção do tipo correto de motor.

### **Exemplo de uso**:

```java
@Autowired
@Eletrico
private Motor motor;
```

A anotação `@Target(ElementType.FIELD)` permite que essa anotação seja aplicada apenas a atributos.

## Uso de Bean Validation

O projeto aplica validações usando `javax.validation`, garantindo a integridade dos dados recebidos nas requisições. Exemplo:

```java
public class Chave {
    @NotNull
    @Size(min = 4, max = 10)
    private String codigo;
}
```

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

## Aplicação de SOLID e Design Patterns

O projeto segue princípios de boas práticas:

- **S**: Separação clara de responsabilidades.
- **O**: Facilidade de extensão através de interfaces.
- **L**: Substituição de subclasses sem impactar o funcionamento.
- **I**: Uso de interfaces específicas (`TodoRepository`).
- **D**: Inversão de dependência.

Além disso, utiliza o **Factory Method** para a criação de objetos como motores, facilitando a manutenção e extensão do código.

## Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone <git clone https://github.com/luciaamalia/ArquiteturaSpringCourse.git>
   ```
2. Navegue até a pasta do projeto e execute:
   ```sh
   mvn spring-boot:run
   ```
3. Acesse `http://localhost:8080/teste-fabrica` e teste as funcionalidades.

---

Este `README.md` fornece um resumo detalhado do projeto e seu funcionamento. Sinta-se à vontade para contribuir ou sugerir melhorias!





---
📚 **Esse README foi criado para estudo
