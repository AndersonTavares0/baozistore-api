# Java e estilo

- Use Java 21, Spring Boot 4.2 e Maven Wrapper (`./mvnw`) dentro do pacote raiz `br.com.uninter.baozistore`.
- Extraia regras de negócio com duas ou mais decisões (como validação de referências e estoque) para classes em `service` anotadas com `@Service` e `@Transactional`.
- Anote controllers com `@RestController`, `@RequestMapping` no plural (`/clientes`) e `@RequiredArgsConstructor` para injeção por construtor.
- Declare repositórios estendendo `JpaRepository<Entidade, Long>`, mantendo apenas consultas derivadas estritamente necessárias (como `existsByCliente_Id`).
- Modele entidades com `@Entity`, `@Id @GeneratedValue(strategy = GenerationType.IDENTITY)` e Lombok `@Getter @Setter`; mapeie chaves estrangeiras com relações JPA (`@ManyToOne(fetch = FetchType.LAZY)`) e exponha IDs via DTO (`record`).
- Use `BigDecimal` para valores monetários e `LocalDate` (`yyyy-MM-dd`) para datas.
- Escreva nomes de variáveis, métodos e mensagens de domínio em português claro, sem abreviações obscuras.
- Escreva comentários apenas para explicar o porquê de uma decisão não óbvia.
