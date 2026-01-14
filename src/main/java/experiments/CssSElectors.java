package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSElectors {
    
    WebDriver driver = new ChromeDriver();


    @Test
    public void selectorHomePage(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(3);
        hideBanner();
        pause(3);
        hideFooter();
        pause(3);
        driver.navigate().to("https://demoqa.com/elements");
        pause(3);
        driver.navigate().back();
        pause(3);
        driver.navigate().refresh();
        pause(3);
        driver.quit();
    }

    @Test
    public void selectorsCssTests(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement footer = driver.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        WebElement divElements = driver.findElement(By.cssSelector(".card-up"));
        pause(3);
        divElements.click();
        WebElement radioButton = driver.findElement(By.cssSelector("#item-2"));
        radioButton.click();
        WebElement radioButtonYes = driver.findElement(By.cssSelector("label[for='yesRadio'"));
        radioButtonYes.click();
        pause(3);
        driver.navigate().back();
        driver.navigate().back();
        WebElement divWidgets = driver.findElement(By.cssSelector("div[class='category-cards'] " +
                "[class='card mt-4 top-card']:nth-child(4)"));
        divWidgets.click();


    }

    public void pause(int time){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display ='none'");
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    }


