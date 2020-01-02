package br.com.nameproject.scenario.manterconta;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.models.Usuario;
import br.com.nameproject.paginas.PaginaContaAlterar;
import br.com.nameproject.paginas.PaginaContaListar;
import br.com.nameproject.paginas.PaginaInicial;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Conta")
public class CT_ManterConta_AlterarConta_ValidarRegistroDuplicado {
	
	@Rule
	public VideoBase video = new VideoBase();
	public Usuario user = new Usuario();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public PaginaLogin paginaLogin;
	public PaginaInicial paginaInicial;
	public PaginaContaListar paginaListar;
	public PaginaContaAlterar paginaAlterar;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Alterar Conta - Validar Registro Duplicado")
	@Video(name = "Manter Conta - Alterar Conta - Validar Registro Duplicado")
	@Description("Caso de teste para realizar a validação de registro duplicado")
	public void validarRegistroDuplicado() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaInicial = paginaLogin.realizarLogin(user.getEmail(), user.getSenha());
		paginaInicial.resetarMovimentacoes();
		paginaListar = paginaInicial.acessarListaContas();
		paginaAlterar = paginaListar.acessarAlteracaoConta();
		paginaAlterar.validarRegistroDuplicado("Conta mesmo nome");
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}