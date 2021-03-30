package com.adaptadorDemo;

import java.io.File;
import com.adaptadorDemo.service.IAdaptadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdaptadorDemoApplication implements CommandLineRunner {


	@Autowired
	IAdaptadorService adaptadorService;

	public static void main(String[] args) {

		SpringApplication.run(AdaptadorDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//adaptadorService = new AdaptadorServiceImp();
		File archivo = new File("usuarios.xml");
		adaptadorService.convertir(archivo);


	}
}
