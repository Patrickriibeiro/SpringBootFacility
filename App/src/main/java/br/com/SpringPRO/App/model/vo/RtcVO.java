package br.com.SpringPRO.App.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RtcVO {
	private String tipoRegistro;
	private String anoMes;
	private String codigoCompanhia;
	private String codigoSucursal;
	private String codCarteiraTec;
	private String codigoEstruturaVenda;
	private String codigoEstruturaApoio;
	private String codigoAcaoApoio;
	private String linha;
	private String valor;
	private String flagColetico;
	private String CodigoOrigem;
	private String codigoTipoMovimento;
	private String nomeTabelaNegocio;
	private String codigoOperacaoNegocio;
	private String codigoOperacaoDocumento;
	private String numeroApolice;
	private String numeroEndosso;
	private String numeroSinistro;
	private String nomeSegurado;
	private String dataAvisoSinistro;
	private String dataInicioVigenciaSegurado;
	private String dataFimVigenciaSegura;
	private String NumeroContrato;

}
