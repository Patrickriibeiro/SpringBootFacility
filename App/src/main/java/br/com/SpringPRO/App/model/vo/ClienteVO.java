package br.com.SpringPRO.App.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteVO {
	
	private int id;
	private String nome;
	private String Cpf;

}
