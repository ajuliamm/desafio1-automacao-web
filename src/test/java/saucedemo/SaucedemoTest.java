package saucedemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes automatizados da funcionalidades de Login e Compra de item")
public class SaucedemoTest {

    private String URL = "https://www.saucedemo.com/";

    @Test
    @DisplayName("Realizar login com dados válidos")
    public void testLoginComDadosValidos(){
        //abrir o chrome
        WebDriver browser = new ChromeDriver();
        //abrir o site 
        browser.get(URL);
        //Enviar dados válidos para login 
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
    }

    @Test
    @DisplayName("Adicionar item no carrinho e Finalizar compra")
    public void testAddItemNoCarrinhoEFinalizarCompra(){
        WebDriver browser = new ChromeDriver();
        browser.get(URL);

        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();

        browser.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        browser.findElement(By.id("shopping_cart_container")).click();
        browser.findElement(By.id("checkout")).click();

        browser.findElement(By.id("first-name")).sendKeys("João");
        browser.findElement(By.id("last-name")).sendKeys("Silva");
        browser.findElement(By.id("postal-code")).sendKeys("115840-862");
        browser.findElement(By.id("continue")).click();

        browser.findElement(By.id("finish")).click();

    }
    
}
