package maquina1995.webservice.reactive.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import maquina1995.webservice.reactive.configuracion.constant.SwaggerConstants;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguracion {

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(SwaggerConstants.PROJECT_CONTROLLER_PATH))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {

		final Contact contacto = new Contact(SwaggerConstants.PROJECT_CONTACT_NAME, SwaggerConstants.CONTACT_URL,
				SwaggerConstants.CONTACT_EMAIL);

		return new ApiInfoBuilder().title(SwaggerConstants.PROJECT_TITLE)
				.description(SwaggerConstants.PROJECT_DESCRIPTION)
				.version(SwaggerConstants.PROJECT_API_VERSION)
				.contact(contacto)
				.build();
	}
}
