package com.fila.filaprioridade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FilaprioridadeApplication {

	public static Object[] secaoFilas = new Object[2];
	static Filas filas1 = new Filas();
	static Filas filas2 = new Filas();

	public static void main(String[] args) {
		secaoFilas[0] = filas1;		
		secaoFilas[1] = filas2;

		SpringApplication.run(FilaprioridadeApplication.class, args);
	}

	@GetMapping("/")
	public String start() {
			return "Servidor iniciado...";
	}

	@GetMapping("/allFilas")
	public ResponseEntity<Object> allFilas() {
			return ResponseEntity.status(HttpStatus.OK).body(secaoFilas);
	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody Item res) {
			if (filas1.getIndex() <= filas2.getIndex()) {
				filas1.addToFila(res);
				System.out.println();
				return ResponseEntity.status(HttpStatus.OK).body("User added to filas1 with ID: " + res.id);
			} else {
				filas2.addToFila(res);
				return ResponseEntity.status(HttpStatus.OK).body("User added to filas2 with ID: " + res.id);
			}
	}	

}
