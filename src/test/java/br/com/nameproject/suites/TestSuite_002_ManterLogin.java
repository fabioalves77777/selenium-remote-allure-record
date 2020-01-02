package br.com.nameproject.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nameproject.scenario.manterlogin.CT_ManterLogin_ValidarLoginInvalido;
import br.com.nameproject.scenario.manterlogin.CT_ManterLogin_RealizarLogin;
import br.com.nameproject.scenario.manterlogin.CT_ManterLogin_ValidarCamposObrigatorios;

@RunWith(Suite.class)
@SuiteClasses({
	CT_ManterLogin_ValidarCamposObrigatorios.class,
	CT_ManterLogin_ValidarLoginInvalido.class,
	CT_ManterLogin_RealizarLogin.class
})
public class TestSuite_002_ManterLogin {

}
