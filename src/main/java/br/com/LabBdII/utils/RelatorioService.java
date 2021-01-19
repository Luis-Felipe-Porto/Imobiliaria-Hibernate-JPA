package br.com.LabBdII.utils;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;



@SuppressWarnings("deprecation")
public class RelatorioService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_RELATORIOS = "/relatorios";
 
	private String caminhoArquivoRelatorio = null;
	@SuppressWarnings("rawtypes")
	private JRExporter exporter = null;
	private File arquivoGerado = null;

	public String gerarRelatorio(HashMap<String, Object> paramsRelatorio,String nomeRelatorioJasper,String tipoExportar) throws JRException{
		String caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
		
		String caminhoArquivosJasper = caminhoRelatorio + File.separator+nomeRelatorioJasper+".jasper";
		
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);

		JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, paramsRelatorio,ConnetionFactory.getConnection());
		
		if (tipoExportar.equalsIgnoreCase("pdf")) {
			exporter = new JRPdfExporter();
		}else if (tipoExportar.equalsIgnoreCase("xls")) {
			exporter = new JRXlsExporter();
		}
		
		caminhoArquivoRelatorio = caminhoRelatorio + File.separator + "RelatorioImobiliaria." + tipoExportar;
		arquivoGerado = new File(caminhoArquivoRelatorio);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
		
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
		

		exporter.exportReport();
		return caminhoArquivoRelatorio;
	}
	
}
