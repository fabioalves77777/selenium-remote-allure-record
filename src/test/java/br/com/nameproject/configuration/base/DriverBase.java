package br.com.nameproject.configuration.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.suporte.EnumNavegador;

public class DriverBase extends AcaoBase {

	private WebDriver driver;

	public DriverBase(WebDriver driver) {
		this.driver = driver;
	}

	public DriverBase(ConfiguracaoAmbiente configuracao) {
		try {
			driverInstance(configuracao);
		} catch (MalformedURLException e) {
        	Assert.fail("Invalid grid URL");
        } catch (Exception e) {
        	Assert.fail(e.getMessage());
        }
	}

	public void navegar(String url) {
		this.driver.navigate().to(url);
	}

	public WebDriver driver() {
		return this.driver;
	}

	public void fecharNavegador() {
		this.driver.quit();
	}
	
	/**
	 * Método para instanciar o driver Remoto
	 */
	public void driverInstance(ConfiguracaoAmbiente configuracao) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();	
		if (configuracao.getNavegador().equals(EnumNavegador.FIREFOX)) {	
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            this.driver = new RemoteWebDriver(new URL(configuracao.nodeUrl), capabilities);
            this.driver.manage().window().maximize();
		} else if (configuracao.getNavegador().equals(EnumNavegador.CHROME)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			this.driver = new RemoteWebDriver(new URL(configuracao.nodeUrl), capabilities);
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			Assert.fail("Navegador informado não faz parte da configuração");
		}
	}

}
