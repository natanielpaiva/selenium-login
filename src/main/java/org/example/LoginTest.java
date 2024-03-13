package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    public static void main(String[] args) {
        // Inicializando o WebDriver
        WebDriver driver = new ChromeDriver();

        // Navegando até a página de login
        driver.get("https://exemplo-login.vercel.app/");

        // Preenchendo o campo de usuário
        WebElement usernameInput = driver.findElement(By.cssSelector("input[placeholder='Usuário']"));
        usernameInput.sendKeys("@natanieltech");

        // Preenchendo o campo de senha
        WebElement passwordInput = driver.findElement(By.cssSelector("input[placeholder='Senha']"));
        passwordInput.sendKeys("mesiga");

        // Clicando no botão de login
        WebElement loginButton = driver.findElement(By.className("Login_loginButton__TEYoE"));
        loginButton.click();

        // Esperando até que a próxima página seja carregada
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe("https://exemplo-login.vercel.app/home"));

        // Verificando se o login foi bem-sucedido
        if (driver.getCurrentUrl().equals("https://exemplo-login.vercel.app/home")) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha no login!");
        }

        // Fechando o navegador
        driver.quit();
    }
}
