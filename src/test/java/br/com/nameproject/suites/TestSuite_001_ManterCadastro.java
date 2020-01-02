package br.com.nameproject.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nameproject.scenario.mantercadastro.CT_ManterCadastro_RealizarCadastro;
import br.com.nameproject.scenario.mantercadastro.CT_ManterCadastro_ValidarCamposObrigatorios;
import br.com.nameproject.scenario.mantercadastro.CT_ManterCadastro_ValidarRegistroDuplicado;

@RunWith(Suite.class)
@SuiteClasses({
	CT_ManterCadastro_ValidarCamposObrigatorios.class,
	CT_ManterCadastro_ValidarRegistroDuplicado.class,
	CT_ManterCadastro_RealizarCadastro.class
})
public class TestSuite_001_ManterCadastro {

}
