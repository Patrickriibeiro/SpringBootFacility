package br.com.SpringPRO.App.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;

import br.com.SpringPRO.App.model.vo.RtcVO;

@RestController
@RequestMapping("/test")
public class CreateCsv {

	@GetMapping("/excel")
	public void createCsv() {

		String path = "C:/Users/Patrick/OneDrive/Documentos/tcp";
		String fileName = "rtc_det_202107.csv";
		File file = new File(path , fileName);
		ReadFile readFile = new ReadFile();
		try {
			
			FileWriter outputfile = new FileWriter(file);
			
			CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

			
			
			String[] header = { "TIPO-REGISTRO", "ANO-MES", "CODIGO-COMPANHIA","CODIGO-SUCURSAL","COD-CARTEIRA-TEC","CODIGO-ESTRUTURA-VENDA"
					            ,"CODIGO-ESTRUTURA-APOIO","CODIGO-ACAO-APOIO","LINHA","VALOR","FLAG-COLETIVO","CODIGO-ORIGEM"
					            ,"CODIGO-TIPO-MOVIMENTO","NOME-TABELA-NEGOCIO","CODIGO-OPERACAO-NEGOCIO","CODIGO-OPERACAO-DOCUMENTO"
					            ,"NUMERO-APOLICE","NUMERO-ENDOSSO","NUMERO-SINISTRO","NOME-SEGURADO","DATA-AVISO-SINISTRO","DATA-INICIO-VIGENCIA-SEGURADO"
					            ,"DATA-FIM-VIGENCIA-SEGURADO","NUMERO-CONTRATO"};
			System.out.println("Escrevendo o header do excel.");
	        writer.writeNext(header);
	        
	        List<RtcVO> rtc = readFile.readFile();
	        for (RtcVO valores : rtc) {
				String[] data = { valores.getTipoRegistro(), valores.getAnoMes(),valores.getCodigoCompanhia(),valores.getCodigoSucursal()
						,valores.getCodCarteiraTec(),valores.getCodigoEstruturaVenda(),valores.getCodigoEstruturaApoio(),valores.getCodigoAcaoApoio()
						,valores.getLinha(),valores.getValor(),valores.getFlagColetico(),valores.getCodigoOrigem(),valores.getCodigoTipoMovimento(),valores.getNomeTabelaNegocio()
						,valores.getCodigoOperacaoNegocio(),valores.getCodigoOperacaoDocumento(),valores.getNumeroApolice(),valores.getNumeroEndosso(),valores.getNumeroSinistro()
						,valores.getNomeSegurado(),valores.getDataAvisoSinistro(),valores.getDataInicioVigenciaSegurado(),valores.getDataFimVigenciaSegura(),valores.getNumeroContrato()};   
				System.out.println("Escrevendo valores excel.");
				writer.writeNext(data);
	        }
	        
	        writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
