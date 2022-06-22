/*
 * import java.time.LocalDate; import java.time.LocalDateTime;
 * 
 * import
 * org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
 * import org.springframework.boot.context.properties.ConfigurationProperties;
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import io.swagger.v3.oas.models.info.Contact;
 * 
 * @Configuration
 * 
 * @ConfigurationProperties("app.api")
 * 
 * @ConditionalOnProperty(name="app.api.swagger.enable", havingValue = "true",
 * matchIfMissing = false) public class SwaggerConfig {
 * 
 * private String version; private String title; private String description;
 * private String basePackage; private String contactName; private String
 * contactEmail;
 * 
 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
 * .select() .apis(RequestHandlerSelectors.basePackage(basePackage))
 * .paths(PathSelectors.any()) .build() .directModelSubstitute(LocalDate.class,
 * java.sql.Date.class) .directModelSubstitute(LocalDateTime.class,
 * java.util.Date.class) .apiInfo(apiInfo()); }
 * 
 * private ApiInfo apiInfo() { return new ApiInfoBuilder() .title(title)
 * .description(description) .version(version) .contact(new Contact(contactName,
 * null, contactEmail)) .build(); }
 */