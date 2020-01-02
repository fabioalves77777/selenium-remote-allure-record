package br.com.nameproject.scenario.mantercadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.paginas.PaginaCadastro;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Cadastro")
public class CT_ManterCadastro_ValidarCamposObrigatorios {

	@Rule
	public VideoBase video = new VideoBase();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public PaginaLogin paginaLogin;
	public PaginaCadastro paginaCadastro;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Validar Campos Obrigatórios")
	@Video(name = "Manter Cadastro - Validar campos obrigatórios")
	@Description("Caso de teste para realizar a validação de campos obrigatórios")
	public void validarCamposObrigatorios() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaCadastro = paginaLogin.acessarCadastroUsuario();	
		paginaCadastro.validarCamposObrigatorios();
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}