package br.com.nameproject.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nameproject.scenario.manterconta.CT_ManterConta_AdicionarConta;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_AdicionarConta_ValidarCamposObrigatorios;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_AdicionarConta_ValidarRegistroDuplicado;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_AlterarConta;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_AlterarConta_ValidarCamposObrigatorios;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_AlterarConta_ValidarRegistroDuplicado;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_ExcluirConta;
import br.com.nameproject.scenario.manterconta.CT_ManterConta_ExcluirConta_ValidarContaComMovimentacao;



@RunWith(Suite.class)
@SuiteClasses({
	CT_ManterConta_AdicionarConta_ValidarCamposObrigatorios.class,
	CT_ManterConta_AdicionarConta_ValidarRegistroDuplicado.class,
	CT_ManterConta_AdicionarConta.class,
	CT_ManterConta_AlterarConta_ValidarCamposObrigatorios.class,
	CT_ManterConta_AlterarConta_ValidarRegistroDuplicado.class,
	CT_ManterConta_AlterarConta.class,
	CT_ManterConta_ExcluirConta_ValidarContaComMovimentacao.class,
	CT_ManterConta_ExcluirConta.class
})
public class TestSuite_003_ManterConta {

}
