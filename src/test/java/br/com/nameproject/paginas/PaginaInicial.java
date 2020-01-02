package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.models.Mensagens;
import io.qameta.allure.Step;

public class PaginaInicial extends DriverBase {

	public PaginaInicial(WebDriver driver) {
		super(driver);
	}
	
	@Step("Resetar as movimentações")
	public void resetarMovimentacoes() {
		clicar(driver(), By.xpath("//a[contains(text(),'reset')]"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ResetarComSucesso + "')]"), 
			"Erro ao resetar as movimentações!"
		);
		screenshot(driver());
	}

	@Step("Acessar a página de adicionar conta")
	public PaginaContaIncluir acessarAdicionarConta() {
		clicar(driver(), By.xpath("//a[contains(text(),'Contas')]"));
		clicar(driver(), By.xpath("//a[contains(text(),'Adicionar')]"));
		elementoExiste(driver(), By.id("nome"), "Erro ao acessar a página de adicionar conta");
		screenshot(driver());
		return new PaginaContaIncluir(driver());
	}
	
	@Step("Acessar a página de listar contas criadas")
	public PaginaContaListar acessarListaContas() {
		clicar(driver(), By.xpath("//a[contains(text(),'Contas')]"));
		clicar(driver(), By.xpath("//a[contains(text(),'Listar')]"));
		elementoExiste(driver(), By.xpath("//th[contains(text(),'Conta')]"), "Erro ao acessar a página de listar contas");
		screenshot(driver());
		return new PaginaContaListar(driver());
	}
	
	@Step("Acessar a página de criar movimentação")
	public PaginaCriarMovimentacao acessarCriarMovimentacao() {
		clicar(driver(), By.xpath("//a[contains(text(),'Criar Movimentação')]"));
		elementoExiste(driver(), By.id("data_transacao"), "Erro ao acessar a página de criar movimentação");
		screenshot(driver());
		return new PaginaCriarMovimentacao(driver());
	}
	
	@Step("Acessar a página de resumo mensal")
	public PaginaResumoMensal acessarResumoMensal() {
		clicar(driver(), By.xpath("//a[contains(text(),'Resumo Mensal')]"));
		elementoExiste(driver(), By.id("mes"), "Erro ao acessar a página de resumo mensal");
		screenshot(driver());
		return new PaginaResumoMensal(driver());
	}
	
}
