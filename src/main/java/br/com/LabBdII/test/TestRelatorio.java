package br.com.LabBdII.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import br.com.LabBdII.utils.RelatorioService;
import net.sf.jasperreports.engine.JRException;

public class TestRelatorio {

	public static void main(String[] args) {

		try {
			

			RelatorioService rel = new RelatorioService();
			HashMap<String, Object> params = new HashMap<>();
			
			params.put("NOME_CLIENTE", "Felipe");
			String file = rel.gerarRelatorio(params, "jasper_A4", "pdf");
			try {
				Desktop.getDesktop().open(new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
