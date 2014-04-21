package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tarefa_id_seq")
	@SequenceGenerator(name = "tarefa_id_seq", sequenceName = "tarefa_id_seq")
	@Column(columnDefinition = "serial")
	private Long id;
	@Column(nullable=false)
	@NotNull(message="{campo.obrigatorio}") @Pattern(regexp="^[A-Za-z ]*$",message="{campo.so.letras}") @Size(min=5,max=100,message="{campo.tamanho.entre}")
	private String titulo;
	@Column(nullable=false, columnDefinition="text")
	@NotNull(message="{campo.obrigatorio}") @Size(min=10,message="{campo.tamanho.minimo}")
	private String descricao;
	private boolean finalizado;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}
