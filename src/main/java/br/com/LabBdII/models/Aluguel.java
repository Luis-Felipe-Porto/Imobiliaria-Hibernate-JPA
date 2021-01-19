package br.com.LabBdII.models;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Aluguel implements EntidadeBase{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataVencimento;
	private Double valorPago;
	private Date dataPagamento;
	private String obs;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	private Locacao locacao;
	
    public Aluguel(Date dataVencimento, Double valorPago, Date dataPagamento, String obs, Locacao locacao) {
		super();
		this.dataVencimento = dataVencimento;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.obs = obs;
		this.locacao = locacao;
	}
    public Aluguel() {
    	
    }
	@Override
    public Integer getId() {
        return id;
    }
	public Integer getIdLocacao() {
		return id;
	}
	public void setIdLocacao(Integer idLocacao) {
		this.id = idLocacao;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	@Override
	public String toString() {
		return "Aluguel [idLocacao=" + id + ", dataVencimento=" + dataVencimento + ", valorPago=" + valorPago
				+ ", dataPagamento=" + dataPagamento + ", obs=" + obs + "]";
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	
}
