package br.com.LabBdII.models;

import java.util.Date;


import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Locacao implements EntidadeBase{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	private Imovel imovel;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	private Cliente inquilino;
	private Double valorAluguel;
	private Double percentualMulta;
	private Integer diaVencimento;
	private Date dataInicio;
	private Date dataFim;
	private boolean ativo;
	private String obs;
	
	
	
	public Locacao( Imovel imovel, Cliente inquilino, Double valorAluguel, Double percentualMulta,
			Integer diaVencimento, Date dataInicio, Date dataFim, boolean ativo, String obs) {
		super();
		this.imovel = imovel;
		this.inquilino = inquilino;
		this.valorAluguel = valorAluguel;
		this.percentualMulta = percentualMulta;
		this.diaVencimento = diaVencimento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.ativo = ativo;
		this.obs = obs;
	}
	@Override
    public Integer getId() {
        return id;
    }
    public Locacao() {}
    
	public void setId(Integer id) {
		this.id = id;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public Cliente getInquilino() {
		return inquilino;
	}
	public void setInquilino(Cliente inquilino) {
		this.inquilino = inquilino;
	}
	public Double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public Double getPercentualMulta() {
		return percentualMulta;
	}
	public void setPercentualMulta(Double percentualMulta) {
		this.percentualMulta = percentualMulta;
	}
	public Integer getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "\nLocacao [\nid=" + id + ",\n imovel=" + imovel + ",\n inquilino=" + inquilino + ",\n valorAluguel="
				+ valorAluguel + ",\n percentualMulta=" + percentualMulta + ",\n diaVencimento=" + diaVencimento
				+ ",\n dataInicio=" + dataInicio + ",\n dataFim=" + dataFim + ",\n ativo=" + ativo + ",\n obs=" + obs + "]\n";
	}
	
}
