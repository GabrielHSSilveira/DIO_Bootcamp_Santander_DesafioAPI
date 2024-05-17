package me.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Inicializa nossa API RESTful.
 *
 * <p>
 * A anotação {@link OpenAPIDefinition} foi usada para habilitar HTTPS no Swagger UI.
 * Para mais detalhes, consulte o seguinte post no Stack Overflow:
 * https://stackoverflow.com/a/71132608/3072570
 * </p>
 */
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
