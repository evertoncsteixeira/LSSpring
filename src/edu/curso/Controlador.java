package edu.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class Controlador {
	
	@Autowired
	ApplicationContext ctx;

	@RequestMapping(value="/pets", method=RequestMethod.GET,
			produces = {"application/JSON"} )
	public List<Pet> listarNomes() {

		Pet p1 = new Pet();
		Pet p2 = new Pet();
		Pet p3 = new Pet();
		
		p1.setNome("Toto");
		p2.setNome("Mia");
		p3.setNome("Puma");
		

		List<Pet> lista =  Arrays.asList(p1,p2,p3);
		
		return lista;
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET,
			produces = {"application/JSON"} )
	public List<Pet> listarTodos() {

//		Pet p1 = new Pet();
//		Pet p2 = new Pet();
//		Pet p3 = new Pet();
//		
//		p1.setId("0001");
//		p1.setNome("Toto");
//		p1.setEspecie("Cachorro");
//		p1.setRaca("Pudle");
//		
//		p2.setId("0002");
//		p2.setNome("Mia");
//		p2.setEspecie("Gato");
//		p2.setRaca("Persa");
//		
//		p3.setId("0003");
//		p3.setNome("Puma");
//		p3.setEspecie("Cachorro");
//		p3.setRaca("Labrador");
//		
//
//		List<Pet> lista =  Arrays.asList(p1,p2,p3);
		
		List<Pet> lista = (List<Pet>) ctx.getBean("produzPet");	
		return lista;		
	}
	
	@RequestMapping(value="/adicionarPet", method=RequestMethod.POST,
			consumes = {"application/JSON"} )
	public ResponseEntity<String> adicionarPet(@RequestBody Pet p) { 
		List<Pet> lista = (List<Pet>)ctx.getBean("produzPet");
		lista.add(p);
		return ResponseEntity.ok("Ok");
	}
}
