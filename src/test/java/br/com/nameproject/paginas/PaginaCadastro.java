package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.models.Mensagens;
import io.qameta.allure.Step;

public class PaginaCadastro extends DriverBase {

	public PaginaCadastro(WebDriver driver) {
		super(driver);
	}

	@Step("realizar o cadastro do novo usuário")
	public void cadastrarUsuario(String nome, String email, String senha) {
		inserirTexto(driver(), By.id("nome"), nome);
		inserirTexto(driver(), By.id("email"), email);
		inserirTexto(driver(), By.id("senha"), senha);
		screenshot(driver());
		clicar(driver(), By.xpath("//input[@class='btn btn-primary']"));				
	}
	
	@Step("Verificar se o usuário foi cadastrado com sucesso")
	public void verificarUsuarioCadastradoComSucesso() {
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.UsuarioCadastrado + "')]"), 
			"Ocorreu um erro ao realizar o cadastro do usuário"
		);	
		screenshot(driver());
	}
	
	@Step("realizar validação de campos obrigatórios")
	public void validarCamposObrigatorios() {
		clicar(driver(), By.xpath("//input[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'Nome é um " + Mensagens.CampoObrigorio + "')]"), 
			"Não foi apresentada mensagem de nome obrigatório"
		);	
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'Email é um " + Mensagens.CampoObrigorio + "')]"), 
			"Não foi apresentada mensagem de email obrigatório"
		);
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'Senha é um " + Mensagens.CampoObrigorio + "')]"), 
			"Não foi apresentada mensagem de senha obrigatória"
		);
		screenshot(driver());
	}
	
	@Step("realizar validação de registro duplicado")
	public void validarRegistroDuplicado(String nome, String email, String senha) {
		inserirTexto(driver(), By.id("nome"), nome);
		inserirTexto(driver(), By.id("email"), email);
		inserirTexto(driver(), By.id("senha"), senha);
		clicar(driver(), By.xpath("//input[@class='btn btn-primary']"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.EmailJaUtilizado + "')]"), 
			"Não foi apresentada mensagem de registro duplicado"
		);	
		screenshot(driver());
	}

}
