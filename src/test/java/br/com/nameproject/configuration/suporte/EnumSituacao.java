package br.com.nameproject.configuration.suporte;

public enum EnumSituacao {

	ATIVAR("ATIVAR"), INATIVAR("INATIVAR");

	EnumSituacao(String situacao) {
		this.situacao = situacao;
	}

	private String situacao;

	public String get() {
		return this.situacao;
	}
	
}
