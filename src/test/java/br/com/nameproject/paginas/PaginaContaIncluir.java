package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.nameproject.configuration.base.TableBase;
import br.com.nameproject.configuration.models.Mensagens;
import io.qameta.allure.Step;

public class PaginaContaIncluir extends TableBase {

	public PaginaContaIncluir(WebDriver driver) {
		super(driver);
	}
	
	@Step("realizar a inclusão de uma nova conta")
	public void realizarInclusaoConta(String[] contas) {
		for (String conta : contas) {
			inserirTexto(driver(), By.id("nome"), conta);
			clicar(driver(), By.xpath("//button[@class='btn btn-primary']"));
			elementoExiste(
				driver(), 
				By.xpath("//div[contains(text(),'" + Mensagens.ContaAdicionadaComSucesso + "')]"), 
				"Não foi apresentada mensagem de conta adicionada com sucesso!"
			);
			validarInclusaoConta(conta);
			screenshot(driver());
			clicar(driver(), By.xpath("//a[contains(text(),'Contas')]"));
			clicar(driver(), By.xpath("//a[contains(text(),'Adicionar')]"));			
		}	
	}
	
	@Step("Acessar a página de listar contas criadas")
	public PaginaContaListar acessarListaContas() {
		clicar(driver(), By.xpath("//a[contains(text(),'Contas')]"));
		clicar(driver(), By.xpath("//a[contains(text(),'Listar')]"));
		elementoExiste(driver(), By.xpath("//th[contains(text(),'Conta')]"), "Erro ao acessar a página de listar contas");
		screenshot(driver());
		return new PaginaContaListar(driver());
	}

	@Step("realizar validação de campos obrigatórios")
	public void validarCamposObrigatorios() {
		clicar(driver(), By.xpath("//button[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaObrigatorio + "')]"), 
			"Não foi apresentada mensagem de nome da conta obrigatório"
		);			
		screenshot(driver());
	}
	
	@Step("realizar validação de registro duplicado")
	public void validarRegistroDuplicado(String nome) {
		inserirTexto(driver(), By.id("nome"), nome);
		clicar(driver(), By.xpath("//button[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaJaIncluida + "')]"), 
			"Não foi apresentada mensagem de registro duplicado"
		);	
		screenshot(driver());
	}
	
	public void validarInclusaoConta(String conta) {		
		int index = 0;
		for (WebElement tr : retornarTrs()) {
			String nomeConta = retornarTd(tr, 0).getText();	
			if(nomeConta.equals(conta)) return;
			verificarUltimoRegistro(index++, "Conta não foi adicionada corretamente");
		}
	}
	
}
