package br.com.nameproject.scenario.mantercadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.models.Usuario;
import br.com.nameproject.paginas.PaginaCadastro;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Cadastro")
public class CT_ManterCadastro_ValidarRegistroDuplicado {

	@Rule
	public VideoBase video = new VideoBase();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public Usuario user = new Usuario();
	public PaginaLogin paginaLogin;
	public PaginaCadastro paginaCadastro;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Validar Registro Duplicado")
	@Video(name = "Manter Cadastro - Validar registro duplicado")
	@Description("Caso de teste para realizar a validação de registro duplicado")
	public void validarRegistroDuplicado() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaCadastro = paginaLogin.acessarCadastroUsuario();	
		paginaCadastro.validarRegistroDuplicado(user.getNome(), user.getEmail(), user.getSenha());
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}