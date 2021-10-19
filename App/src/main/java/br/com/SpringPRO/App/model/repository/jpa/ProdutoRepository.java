package br.com.SpringPRO.App.model.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.SpringPRO.App.model.vo.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	// Seguir a conversões para o springboot("findBy","Containing"), executar essa metodo;
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
 
	/* Exemplos de convensão
  * findByNomeContaining
  * findByNomeIsContaining
  * findByNomeContains
  * 
  * findByNomeStartsWith
  * findByNomeEndsWith
  * 
  * FindByNomeNotContaining
  * 
  * */

  @Query("Select p from Produto p Where p.nome Like %:nome%")	
  public Iterable<Produto> searchByNameLike(@Param("nome")String nome);

}


