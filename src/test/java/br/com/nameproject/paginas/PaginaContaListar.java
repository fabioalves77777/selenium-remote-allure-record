package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.nameproject.configuration.base.TableBase;
import br.com.nameproject.configuration.models.Mensagens;
import io.qameta.allure.Step;

public class PaginaContaListar extends TableBase {

	public PaginaContaListar(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Método para acessar a tela de alteração da conta com o nome "Conta para alterar"
	 */
	@Step("Acessar a página de alterar conta")
	public PaginaContaAlterar acessarAlteracaoConta() {			
		int index = 0;
		for (WebElement tr : retornarTrs()) {
			if(retornarTd(tr, 0).getText().contains("Conta para alterar")) {
				clicar(retornarButtonLink(retornarTd(tr, 1), 0));
				break;
			}
			verificarUltimoRegistro(index++, "Não foi encontrada a conta com o nome 'Conta para alterar'");
		}	
		screenshot(driver());
		return new PaginaContaAlterar(driver());		
	}
	
	/**
	 * Método para validar exclusão de conta em uso da conta com o nome "Conta com movimentacao"
	 */
	@Step("realizar validação de exclusão de conta com movimentações")
	public void validarExclusaoContaComMovimentacao() {			
		int index = 0;
		for (WebElement tr : retornarTrs()) {
			if(retornarTd(tr, 0).getText().contains("Conta com movimentacao")) {
				clicar(retornarButtonLink(retornarTd(tr, 1), 1));
				break;
			}
			verificarUltimoRegistro(index++, "Não foi encontrada a conta com o nome 'Conta com movimentacao'");
		}	
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaComMovimentacoes + "')]"), 
			"Não foi apresentada mensagem de exclusão de conta não permitida!"
		);
		screenshot(driver());		
	}
	
	/**
	 * Método para validar exclusão de conta em uso da conta com o nome "Conta com movimentacao"
	 */
	@Step("realizar a exclusão de conta")
	public void realizarExclusaoConta(String[] contas) {
		for (int i = 0; i < retornarTrs().size(); i++) {			
			for (String conta : contas) {				
				if(retornarTd(retornarTr(i), 0).getText().equals(conta)) {
					clicar(retornarButtonLink(retornarTd(retornarTr(i), 1), 1));	
					i = 0;
				}				
			}
		}	
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.ContaRemovidaComSucesso + "')]"), 
			"Não foi apresentada mensagem de exclusão realizada com sucesso!"
		);
		screenshot(driver());				
	}
	
}