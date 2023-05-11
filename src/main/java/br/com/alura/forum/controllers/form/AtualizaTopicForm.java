package br.com.alura.forum.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizaTopicForm {
	
	@NotNull 
	@NotEmpty
	private String titulo;
	
	@NotNull 
	@NotEmpty
	@Length(min = 10)
	private String mensagem;
	
	
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
	
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.setTitulo(this.getTitulo());
		topico.setMensagem(this.getMensagem());
		
		return topico;
	}
	
	
	
}
