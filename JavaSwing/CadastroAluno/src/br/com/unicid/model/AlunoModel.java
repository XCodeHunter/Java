package br.com.unicid.model;

import java.util.Date;


public class AlunoModel {

	private Integer RGM;
	private String nome;
	private Date dataNascimento;
	private Long cpf;
	private String email;
	private Long celular;
	
	public AlunoModel(int RGM, String nome, Date dataNascimento, long cpf, String email, long celular) {
		this.RGM =  RGM;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
	}
	
	public Integer getRGM() {
		return RGM;
	}
	public void setRGM(Integer rGM) {
		RGM = rGM;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long celular) {
		this.celular = celular;
	}
	
}
