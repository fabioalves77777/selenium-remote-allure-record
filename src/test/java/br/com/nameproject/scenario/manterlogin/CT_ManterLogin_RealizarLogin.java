package br.com.nameproject.scenario.manterlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.models.Usuario;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Login")
public class CT_ManterLogin_RealizarLogin {

	@Rule
	public VideoBase video = new VideoBase();
	public Usuario user = new Usuario();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public PaginaLogin paginaLogin;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Realizar Login")
	@Video(name = "Manter Login - Realizar Login")
	@Description("Caso de teste para realizar o login no sistema")
	public void realizarLogin() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaLogin.realizarLogin(user.getEmail(), user.getSenha());
		paginaLogin.verificarUsuarioAutenticadoComSucesso();
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}