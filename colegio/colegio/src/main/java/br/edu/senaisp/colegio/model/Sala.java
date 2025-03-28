package br.edu.senaisp.colegio.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Sala {

	private String sala;
	private String predio;
	private String nr;

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	
}
