# Java e estilo

- Java 21, Spring Boot 4.2, Maven (`./mvnw`).
- Pacote raiz `br.com.uninter.baozistore`.
- Controller: `@RestController` + `@RequestMapping` no plural (`/clientes`), injeção por construtor com `@RequiredArgsConstructor`.
- Repositório: interface vazia estendendo `JpaRepository<Entidade, Long>`.
- Entidade: `@Entity`, `@Id @GeneratedValue(strategy = IDENTITY)`, Lombok `@Getter @Setter`, campos no singular.
- Campo monetário: `BigDecimal`. Data: `LocalDate` (ISO `yyyy-MM-dd`).
- Nome de variável e método em português, como o resto do projeto; sem abreviação obscura.
- Comentário só quando explica o porquê; o código já diz o quê.
