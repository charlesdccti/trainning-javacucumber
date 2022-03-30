package com.charles.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class InserirContasSteps {

	private WebDriver driver;
	
	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		System.setProperty("webdriver.chrome.driver", "/Users/charles/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
	}

	@Quando("informo o usuário {string}")
	public void informoOUsuário(String string) {
	    driver.findElement(By.id("email")).sendKeys(string);
	}

	@Quando("a senha {string}")
	public void aSenha(String string) {
		driver.findElement(By.name("senha")).sendKeys(string);
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
	    driver.findElement(By.tagName("button")).click();
	}

	@Então("visualizo a página inicial")
	public void visualizoAPáginaInicial() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, a!", texto);
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
	    driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
	    driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
	    driver.findElement(By.id("nome")).sendKeys(string);
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
	    driver.findElement(By.tagName("button")).click();
	}

	@Então("a conta é inserida com sucesso")
	public void aContaÉInseridaComSucesso() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}
	
	@Então("sou notificado que o nome da conta é obrigatório")
	public void souNotificadoQueONomeDaContaÉObrigatório() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Informe o nome da conta", texto);
	}
	
	@Então("sou notificado que já existe uma conta com esse nome")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Já existe uma conta com esse nome!", texto);  
	}
	
	@Entao("recebo a mensagem {string}")
	public void receboAMensagem(String string) {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	    Assert.assertEquals(string, texto);
	}
	
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = "@funcionais")
	public void fecharBrowser() {
		driver.quit();
		System.out.println("terminando");
	}
	
	
}























