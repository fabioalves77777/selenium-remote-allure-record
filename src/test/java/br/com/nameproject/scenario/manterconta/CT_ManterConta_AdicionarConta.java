package br.com.nameproject.scenario.manterconta;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.automation.remarks.video.annotations.Video;

import br.com.nameproject.configuration.base.DriverBase;
import br.com.nameproject.configuration.base.VideoBase;
import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.models.Conta;
import br.com.nameproject.configuration.models.Usuario;
import br.com.nameproject.paginas.PaginaContaIncluir;
import br.com.nameproject.paginas.PaginaInicial;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Conta")
public class CT_ManterConta_AdicionarConta {
	
	@Rule
	public VideoBase video = new VideoBase();
	public Usuario user = new Usuario();
	public Conta conta = new Conta();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public PaginaLogin paginaLogin;
	public PaginaInicial paginaInicial;
	public PaginaContaIncluir paginaIncluir;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Adicionar Conta")
	@Video(name = "Manter Conta - Adicionar conta")
	@Description("Caso de teste para realizar a inclusão de uma nova conta")
	public void adicionarNovaConta() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaInicial = paginaLogin.realizarLogin(user.getEmail(), user.getSenha());
		paginaIncluir = paginaInicial.acessarAdicionarConta();
		paginaIncluir.realizarInclusaoConta(conta.getNomes());
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}