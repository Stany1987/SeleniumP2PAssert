
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class P2PB {
        @Test
        public void FirstP2PTest() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            driver.get("https://next.privat24.ua/money-transfer/card");
            driver.manage().window().fullscreen();
            By numberCardSender = By.xpath("//input[@data-qa-node='numberdebitSource']");
            By dataCardSender = By.xpath("//input[@data-qa-node='expiredebitSource']");
            By cvvCardSender = By.xpath("//input[@data-qa-node='cvvdebitSource']");
            By firstNameCardSender = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
            By lastNameCardSender = By.xpath("//input[@data-qa-node='lastNamedebitSource']");

            By numberCardRecipient = By.xpath("//input[@data-qa-node='numberreceiver']");
            By firstNameCardRecipient = By.xpath("//input[@data-qa-node='firstNamereceiver']");
            By lastNameCardRecipient = By.xpath("//input[@data-qa-node='lastNamereceiver']");
            By amount = By.xpath("//input[@data-qa-node='amount']");
            By currency = By.xpath("//button[@data-qa-value='UAH']");
            By currencyUSD = By.xpath("//button[@data-qa-value='USD']");
            By coment = By.xpath("//span[@data-qa-node='toggle-comment']");
            By comentEnter = By.xpath("//textarea[@data-qa-node='comment']");

            By confirButton = By.xpath("//button[@class='sc-VigVT hcHAAV']");
            By basket = By.xpath("//button[@class='sc-VigVT hcHAAV']");


            driver.findElement(numberCardSender).sendKeys("4006895689048337");
            driver.findElement(dataCardSender).sendKeys("0323");
            driver.findElement(cvvCardSender).sendKeys("480");
            driver.findElement(firstNameCardSender).sendKeys("Peter");
            driver.findElement(lastNameCardSender).sendKeys("Edwards");

            driver.findElement(numberCardRecipient).sendKeys("4558032855841715");
            driver.findElement(firstNameCardRecipient).sendKeys("Luis ");
            driver.findElement(lastNameCardRecipient).sendKeys("Myers");
            driver.findElement(amount).sendKeys("700");
            driver.findElement(currency).click();
            driver.findElement(currencyUSD).click();
            driver.findElement(coment).click();
            driver.findElement(comentEnter).sendKeys("НА ЗСУ");

            driver.findElement(confirButton).click();
            driver.findElement(basket).click();

            Assertions.assertEquals("Переказ власних коштів. НА ЗСУ", driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());
            Assertions.assertEquals("4006 **** **** 8337", driver.findElement(By.xpath("//td[@data-qa-node='card']")).getText());
            Assertions.assertEquals("4558 **** **** 1715", driver.findElement(By.xpath("//span[@data-qa-node='cardB']")).getText());
            Assertions.assertEquals("700 USD", driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());
            Assertions.assertEquals("Про комісії", driver.findElement(By.xpath("//a[@class='sc-caSCKo gVhIWz']")).getText());

        }
    }

