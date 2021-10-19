package br.com.SpringPRO.App.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.SpringPRO.App.model.vo.ClienteVO;

@RestController
@RequestMapping("/v1/cursoudemy/clientes")
public class ClienteController {
	
	@GetMapping(path = "/qualquer")
	public ClienteVO obterCliente() {
		return new ClienteVO(28,"Pedro","123.456.789-00");
	}
	
	@GetMapping("/{id}") //@PathVariable = Pega o valor direto da url.
	public ClienteVO obterClientePorIdVariable(@PathVariable int id) {
		return new ClienteVO(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping("/ObterClientePorParam")//@RequestParam = Pega o valor por parametros "?". defaultValue = define o valor padrão caso o usuário não preencha. 
	//Required significa que o parametro não é obrigatorio
	public ClienteVO obterClientePorIdParam(@RequestParam(name = "id" ,defaultValue = "1" , required = false) int id) {
		return new ClienteVO(id, "Maria", "987.654.321-00");
	}
	
	@GetMapping("/ObterClienteBody") //@RequestParam = Pega o valor pelo corpo da requisição , via json.
	public void obterClientePorIdBody (@RequestBody ClienteVO cliente) {
	}
		
	
	
	/*@PostMapping(path = "/post")
	public String post() {
		return "Requisição post";
	}

	@PutMapping(path = "/put")
	public String put() {
		return "Requisição put";
	}
	
	@PatchMapping(path = "/patch")
	public String patch() {
		return "Requisição patch";
	}
	
	@DeleteMapping(path = "/delete")
	public String delete() {
		return "Requisição delete";
	} */
}
