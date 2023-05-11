package br.com.alura.forum.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicForm {
	
	@NotNull 
	@NotEmpty
	private String titulo;
	@NotNull 
	@NotEmpty
	@Length(min = 10)
	private String mensagem;
	@NotNull 
	@NotEmpty
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico toTopico(CursoRepository cursoRepository) {
		Topico topico = new Topico();
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		topico.setCurso(cursoRepository.findByNome(this.nomeCurso));
		
		return topico;
	}
	
	
}
