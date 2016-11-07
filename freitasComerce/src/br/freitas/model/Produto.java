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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + Id;
		result = prime * result + ((NomeImagem == null) ? 0 : NomeImagem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (Id != other.Id)
			return false;
		if (NomeImagem == null) {
			if (other.NomeImagem != null)
				return false;
		} else if (!NomeImagem.equals(other.NomeImagem))
			return false;
		if (Double.doubleToLongBits(Preco) != Double.doubleToLongBits(other.Preco))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Produto [Id=" + Id + ", Descricao=" + Descricao + ", Preco=" + Preco + ", NomeImagem=" + NomeImagem
				+ "]";
	}
	
	
}
