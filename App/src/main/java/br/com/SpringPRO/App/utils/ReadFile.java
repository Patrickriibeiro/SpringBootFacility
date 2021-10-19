package br.com.SpringPRO.App.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.SpringPRO.App.model.vo.RtcVO;

@RestController
@RequestMapping("/test")
public class ReadFile {
	
	@GetMapping("/readfile")
	public List<RtcVO> readFile() {
		
		String path = "C:/Users/Patrick/OneDrive/Documentos/tcp";
		String fileName = "rtc_det_202107.txt";
		String anoMes = "202107";
		String[] valores;
		List<String> evs = Arrays.asList("2654237", "2936550", "3004210", "182110", "221105", "180255", "221113");
		List<RtcVO> listaRtc = new ArrayList<RtcVO>();

		// BiPredicate<String,String> listaFiltrada = (valor,ev) -> valor.contains(ev) ?
		// true : false;

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path, fileName)));
			br.readLine();
			String line = null; // Pulando primeira linha.

			while ((line = br.readLine()) != null) {
				valores = line.split(";");
				RtcVO rtc = new RtcVO();

				if (evs.contains(valores[5]) && valores[8].contains("SINISTRO_RETIDO") && valores[1].contains(anoMes)) {
					rtc.setTipoRegistro(valores[0]);
					rtc.setAnoMes(valores[1]);
					rtc.setCodigoCompanhia(valores[2]);
					rtc.setCodigoSucursal(valores[3]);
					rtc.setCodCarteiraTec(valores[4]);
					rtc.setCodigoEstruturaVenda(valores[5]);
					rtc.setCodigoEstruturaApoio(valores[6]);
					rtc.setCodigoAcaoApoio(valores[7]);
					rtc.setLinha(valores[8]);
					rtc.setValor(valores[9]);
					rtc.setFlagColetico(valores[10]);
					rtc.setCodigoOrigem(valores[11]);
					rtc.setCodigoTipoMovimento(valores[12]);
					rtc.setNomeTabelaNegocio(valores[13]);
					rtc.setCodigoOperacaoNegocio(valores[14]);
					rtc.setCodigoOperacaoDocumento(valores[15]);
					rtc.setNumeroApolice(16 < valores.length ? valores[16] : "0");
					rtc.setNumeroEndosso(17 < valores.length ? valores[17] : "0");
					rtc.setNumeroSinistro(18 < valores.length ? valores[18] : "0");
					rtc.setNomeSegurado(19 < valores.length ? valores[19] : "0");
					rtc.setDataAvisoSinistro(20 < valores.length ? valores[20] : "0");
					rtc.setDataInicioVigenciaSegurado(21 < valores.length ? valores[21] : "0");
					rtc.setDataFimVigenciaSegura(22 < valores.length ? valores[22] : "0");
					rtc.setNumeroContrato(23 < valores.length ? valores[23] : "0");

					listaRtc.add(rtc);
				}
			}
		} catch (IOException e) {
			System.out.println("Arquivo não existe : " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Valor não preenchido com sucesso" + e);
		}
		System.out.println("Arquivo lido com sucesso");
		System.out.println("Tamanho da lista de arquivo : " + listaRtc.size());
		return listaRtc;
	}

}
