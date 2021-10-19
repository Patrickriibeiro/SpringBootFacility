package br.com.SpringPRO.App.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produto") // ira criar uma tabela com esse nome;
public class Produto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //utilizará como estratégia a geração AUTO_INCREMENT, ex : 1,2,3....
	private int Id;
	
	@NotBlank // valor não pode ser branco;
	private String nome;
	
	@Min(0)
	private Double preco;
	
	@Min(0) // valor minimo que pode ser inserido;
	@Max(1) // valor maximo que pode ser inserido;
	private Double desconto;
	
	public Produto(String nome,double preco,double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

}
