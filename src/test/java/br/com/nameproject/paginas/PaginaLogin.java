package br.com.nameproject.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.models.Mensagens;
import br.com.nameproject.configuration.suporte.EnumAmbiente;
import io.qameta.allure.Step;

public class PaginaLogin extends DriverBase {

	public PaginaLogin(WebDriver driver) {
		super(driver);
	}

	@Step("Acessar a página de login")
	public void acessarPaginaLogin(Enum<?> ambiente) {
		if (ambiente.equals(EnumAmbiente.LOCAL))
			navegar(ConfiguracaoAmbiente.Url);	
		else if (ambiente.equals(EnumAmbiente.CLIENTE))
			navegar(ConfiguracaoAmbiente.UrlCliente);	
		screenshot(driver());
		elementoExiste(driver(), By.id("email"), "Erro ao acessar a página de autenticação");
	}
	
	@Step("Acessar a página de cadastrar novo usuário")
	public PaginaCadastro acessarCadastroUsuario() {
		clicar(driver(), By.xpath("//a[contains(text(),'Novo usuário?')]"));
		screenshot(driver());
		return new PaginaCadastro(driver());
	}

	@Step("Realizar login no sistema")
	public PaginaInicial realizarLogin(String usuario, String senha) {		
		inserirTexto(driver(), By.id("email"), usuario);
		inserirTexto(driver(), By.id("senha"), senha);
		screenshot(driver());
		clicar(driver(), By.xpath("//button[contains(text(),'Entrar')]"));
		return new PaginaInicial(driver());
	}
	
	@Step("Verificar se o usuário foi autenticado com sucesso")
	public void verificarUsuarioAutenticadoComSucesso() {
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.LoginRealizadoComSucesso + "')]"), 
			"Ocorreu um erro ao realizar o login no sistema"
		);	
		screenshot(driver());
	}
	
	@Step("realizar validação de login inválido")
	public void validarLoginInvalido(String email, String senha) {
		inserirTexto(driver(), By.id("email"), email);
		inserirTexto(driver(), By.id("senha"), senha);
		clicar(driver(), By.xpath("//button[contains(text(),'Entrar')]"));
		elementoExiste(
			driver(), 
			By.xpath("//div[contains(text(),'" + Mensagens.LoginInvalido + "')]"), 
			"Não foi apresentada mensagem de login inválido"
		);	
		screenshot(driver());
	}
	
	@Step("realizar validação de campos obrigatórios")
	public void validarCamposObrigatorios() {
		clicar(driver(), By.xpath("//button[contains(text(),'Entrar')]"));
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

}