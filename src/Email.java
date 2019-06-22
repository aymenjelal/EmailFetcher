import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class Email {

    public static void main(String[] args)throws InterruptedException,IOException{

        System.setProperty("webdriver.gecko.driver","c:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();

        String appUrl = "http://www.gmail.com";

        driver.get(appUrl);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));

        email.sendKeys("aymen2jelal@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

        Thread.sleep(4000);
        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div/div[1]/div/div[1]/input"));

        password.sendKeys("password");

        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        List<WebElement> unreadEmails = driver.findElements(By.className("zE"));

        File file = new File("UnreadEmails.txt");
        FileWriter fileWriter = new FileWriter(file);
        for (WebElement unreadEmail:unreadEmails) {

            //System.out.println(unreadEmail.getText());
            String sender = unreadEmail.findElement(By.className("yW")).getText();
            String subject = unreadEmail.findElement(By.className("y6")).getText();


                fileWriter.write("Sender:- ");
                fileWriter.write(sender);
                fileWriter.write(" Subject:- ");
                fileWriter.write(subject);
                fileWriter.write("\n");
        }

        fileWriter.flush();
        fileWriter.close();
        Thread.sleep(7000);
        driver.quit();
    }
}
