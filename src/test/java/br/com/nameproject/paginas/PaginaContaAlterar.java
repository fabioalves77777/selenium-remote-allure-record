package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.nameproject.configuration.base.TableBase;
import br.com.nameproject.configuration.models.Mensagens;
import io.qameta.allure.Step;

public class PaginaContaAlterar extends TableBase {

	public PaginaContaAlterar(WebDriver driver) {
		super(driver);
	}
	
	@Step("realizar a alteração do nome da conta")
	public void realizarAlteracaoConta(String conta) {
		limparTexto(driver(), By.id("nome"));
		inserirTexto(driver(), By.id("nome"), conta);
		clicar(driver(), By.xpath("//button[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaAlteradaComSucesso + "')]"), 
			"Não foi apresentada mensagem de conta alterada com sucesso!"
		);
		validarAlteracaoConta(conta);
		screenshot(driver());			
	}

	@Step("realizar validação de campos obrigatórios")
	public void validarCamposObrigatorios() {
		limparTexto(driver(), By.id("nome"));
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
		limparTexto(driver(), By.id("nome"));			
		inserirTexto(driver(), By.id("nome"), nome);
		clicar(driver(), By.xpath("//button[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaJaIncluida + "')]"), 
			"Não foi apresentada mensagem de registro duplicado"
		);	
		screenshot(driver());
	}
	
	public void validarAlteracaoConta(String conta) {
		for (int index = 0; index < retornarTrs().size(); index++) {
			String nomeConta = retornarTd(retornarTr(index), 0).getText();	
			if(nomeConta.equals(conta)) return;
			verificarUltimoRegistro(index, "Conta não foi alterada corretamente");
		}
	}
	
}