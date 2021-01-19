package br.com.LabBdII.models;
import javax.persistence.*;

@Entity
public class Imovel implements EntidadeBase{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoImovel;
	private String endereco;
	private String bairro;
	private Double CEP;
	private Double metragem;
	private Integer dormitorios;
	private Integer banheiros;
	private Integer suites;
	private Integer vagasGaragem;
	private Double valorAluguelSugerido;
	private String obs;
	
	
    public Imovel(String tipoImovel, String endereco, String bairro, Double cEP, Double metragem, Integer dormitorios,
			Integer banheiros, Integer suites, Integer vagasGaragem, Double valorAluguelSugerido, String obs) {
		super();
		this.tipoImovel = tipoImovel;
		this.endereco = endereco;
		this.bairro = bairro;
		CEP = cEP;
		this.metragem = metragem;
		this.dormitorios = dormitorios;
		this.banheiros = banheiros;
		this.suites = suites;
		this.vagasGaragem = vagasGaragem;
		this.valorAluguelSugerido = valorAluguelSugerido;
		this.obs = obs;
	}
    public Imovel() {
    	
    }
	@Override
    public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Double getCEP() {
		return CEP;
	}

	public Double getMetragem() {
		return metragem;
	}
	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}
	public Integer getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}
	public Integer getBanheiros() {
		return banheiros;
	}
	public void setBanheiros(Integer banheiros) {
		this.banheiros = banheiros;
	}
	public Integer getSuites() {
		return suites;
	}
	public void setSuites(Integer suites) {
		this.suites = suites;
	}
	public Integer getVagasGaragem() {
		return vagasGaragem;
	}
	public void setVagasGaragem(Integer vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}
	public Double getValorAluguelSugerido() {
		return valorAluguelSugerido;
	}
	public void setValorAluguelSugerido(Double valorAluguelSugerido) {
		this.valorAluguelSugerido = valorAluguelSugerido;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "Imovel [id=" + id + ", tipoImovel=" + tipoImovel + ", endereco=" + endereco + ", bairro=" + bairro
				+ ", CEP=" + CEP + ", metragem=" + metragem + ", dormitorios=" + dormitorios + ", banheiros="
				+ banheiros + ", suites=" + suites + ", vagasGaragem=" + vagasGaragem + ", valorAluguelSugerido="
				+ valorAluguelSugerido + ", obs=" + obs + "]";
	}
	
}
