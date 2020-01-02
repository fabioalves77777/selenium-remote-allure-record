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
import br.com.nameproject.paginas.PaginaContaListar;
import br.com.nameproject.paginas.PaginaInicial;
import br.com.nameproject.paginas.PaginaLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Manter Conta")
public class CT_ManterConta_ExcluirConta_ValidarContaComMovimentacao {
	
	@Rule
	public VideoBase video = new VideoBase();
	public Usuario user = new Usuario();
	public ConfiguracaoAmbiente configuracao;
	public DriverBase driver;	
	public PaginaLogin paginaLogin;
	public PaginaInicial paginaInicial;
	public PaginaContaListar paginaListar;
	
	@Before
	public void inicialize() {
		configuracao = new ConfiguracaoAmbiente();
		driver = new DriverBase(configuracao);
		paginaLogin = new PaginaLogin(driver.driver());
	}
	
	@Test
	@Story("Excluir Conta - Validar Exclusão de Conta com Movimentações")
	@Video(name = "Manter Conta - Excluir Conta - Validar Exclusão de Conta com Movimentações")
	@Description("Caso de teste para realizar a validação de exclusão de conta com movimentações")
	public void validarExclusaoContaEmUsoMovimentacoes() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaInicial = paginaLogin.realizarLogin(user.getEmail(), user.getSenha());
		paginaInicial.resetarMovimentacoes();
		paginaListar = paginaInicial.acessarListaContas();
		paginaListar.validarExclusaoContaComMovimentacao();		
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}