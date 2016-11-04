/**
 * 
 */
package br.freitas.model;

import java.util.Date;

/**
 * @author Lucas Freitas
 *
 */
public class Pedido {
	private String Id;
	private Date Data;
	private Double ValorTotal;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public Double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		ValorTotal = valorTotal;
	}
	
	
}
