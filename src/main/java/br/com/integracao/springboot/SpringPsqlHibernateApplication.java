package br.com.integracao.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses={br.com.integracao.springboot.controller.UsuarioController.class, br.com.integracao.springboot.model.Usuario.class})
public class SpringPsqlHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPsqlHibernateApplication.class, args);
	}

}
