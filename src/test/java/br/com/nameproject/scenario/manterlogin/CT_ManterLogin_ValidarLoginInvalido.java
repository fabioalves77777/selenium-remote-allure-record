package br.com.nameproject.scenario.manterlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Login")
public class CT_ManterLogin_ValidarLoginInvalido {

	@Rule
	public VideoBase video = new VideoBase();
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
	@Story("Validar login inválido")
	@Video(name = "Manter Login - Validar login inválido")
	@Description("Caso de teste para realizar a validação de login inválido")
	public void validarLoginInvalido() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaLogin.validarLoginInvalido("logininvalido@logininvalido.com", "logininvalido");
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}