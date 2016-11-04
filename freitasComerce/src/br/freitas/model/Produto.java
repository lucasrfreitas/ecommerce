/**
 * 
 */
package br.freitas.model;

/**
 * @author Lucas Freitas
 *
 */
public class Produto {
	
	private int Id;
	private String Descricao;
	private double Preco;
	private String NomeImagem;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	public String getNomeImagem() {
		return NomeImagem;
	}
	public void setNomeImagem(String nomeImagem) {
		NomeImagem = nomeImagem;
	}
}
