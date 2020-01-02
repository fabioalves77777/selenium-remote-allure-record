package br.com.nameproject.configuration.models;

import br.com.nameproject.configuration.suporte.Utilitario;

public class Conta {

	public Conta() {
		this.nomes = new String[] {
			"Água " + Utilitario.retornaDataHora(), 
			"Luz " + Utilitario.retornaDataHora(), 
			"Telefone " + Utilitario.retornaDataHora(),
			"Internet " + Utilitario.retornaDataHora(),
			"Cartão " + Utilitario.retornaDataHora(),
			"Outros " + Utilitario.retornaDataHora(),
			"Deletável " + Utilitario.retornaDataHora()
		};
	}

	public String[] nomes;

	public String[] getNomes() {
		return nomes;
	}

	public void setNomes(String[] nomes) {
		this.nomes = nomes;
	}
	
}
