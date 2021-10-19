package br.com.SpringPRO.App.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.SpringPRO.App.model.repository.jpa.ProdutoRepository;
import br.com.SpringPRO.App.model.vo.Produto;

@RestController
@RequestMapping("/v1/cursoudemy/produtos")
public class ProdutorController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/novoproduto")
	//@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public Produto novoProduto(@RequestParam(value = "nome", defaultValue = "vazio") String nome,
			@RequestParam("preco") Double preco,
			@RequestParam(value = "desconto", defaultValue = "0", required = false) Double desconto) {
		
		Produto produto = new Produto(nome, preco, desconto);
		produtoRepository.save(produto);

		return produto;
	}
	
	@GetMapping("/obtertodosprodutos") // Nesse metodo está retornando todos os produtos do banco de dados;
	public Iterable<Produto> obterProduto() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/pagina/{numeroPagina}/{qtdePagina}") // Pesquisa Paginada no banco;
	public Iterable<Produto> obterProdutosPorPaginas(@PathVariable int numeroPagina,@PathVariable int qtdePagina){
		if(qtdePagina >=5) qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, 2);	
		return produtoRepository.findAll(page);
	}
	
	@GetMapping("/obterprodutoporid/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id){
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/alterandoproduto")
	public Produto alterarProdutor(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;		
	}
	
	@DeleteMapping("/deletando/{id}")
	public void excluirProduto(@PathVariable Integer id) {
		produtoRepository.deleteById(id);
	}
	
	@GetMapping("/nome/{partenome}")
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String nome){
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	@PostMapping("/novoprodutovalidacao") //@ResponseBody A anotação @ResponseBody informa a um controlador que o objeto retornado 
	//é serializado automaticamente em JSON e passado de volta para o objeto HttpResponse .
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);

		return produto;
	}

}
