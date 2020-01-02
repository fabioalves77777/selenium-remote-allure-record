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
public class CT_ManterCadastro_RealizarCadastro {

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
	@Story("Cadastrar Usuário")
	@Video(name = "Manter Cadastro - Cadastrar Usuário")
	@Description("Caso de teste para realizar o cadastramento do usuário")
	public void realizarCadastroUsuario() {		
		paginaLogin.acessarPaginaLogin(configuracao.getAmbiente());
		paginaCadastro = paginaLogin.acessarCadastroUsuario();	
		paginaCadastro.cadastrarUsuario(user.getNome(), user.getEmailCadastro(), user.getSenha());
		paginaCadastro.verificarUsuarioCadastradoComSucesso();
	}
	
	@After
	public void tearDown() {
		driver.fecharNavegador();
	}
	
}
