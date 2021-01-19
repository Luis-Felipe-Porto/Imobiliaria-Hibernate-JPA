package br.com.LabBdII.models;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCliente;
	private Double CPF;
	private Double telefone1;
	private Double telefone2;
	private String email;
	private Date DataNascimento;
	
	public Cliente(String nomeCliente, Double cPF, Double telefone1, Double telefone2, String email,
			Date dataNascimento) {
		super();
		this.nomeCliente = nomeCliente;
		CPF = cPF;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.email = email;
		DataNascimento = dataNascimento;
	}
	public Cliente() {
		
	}
	public Integer getIdCliente() {
		return id;
	}
	public void setIdCliente(Integer idCliente) {
		this.id = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Double getCPF() {
		return CPF;
	}

	public Double getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(Double telefone1) {
		this.telefone1 = telefone1;
	}
	public Double getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(Double telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomeCliente=" + nomeCliente + ", CPF=" + CPF + ", telefone1=" + telefone1
				+ ", telefone2=" + telefone2 + ", email=" + email + ", DataNascimento=" + DataNascimento + "]";
	}
	
	
	
}
