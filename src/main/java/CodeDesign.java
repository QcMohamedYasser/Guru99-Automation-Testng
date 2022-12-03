import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CodeDesign {
    WebDriver driver;
 public CodeDesign(WebDriver driver)
{
    this.driver=driver;
}


public void nav(){
     driver.navigate().to("http://live.techpanda.org/index.php/");}

    public void log()
    {
        driver.findElement(By.id("email")).sendKeys("hamoya40@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Mohamed123");
        driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    }
    public void acc(){
     driver.findElement(By.xpath("//div[@class=\"footer\"]//div[4]//li[1]//a[@title=\"My Account\"]")).click();
    }
    public void nav_acc()
    {
     nav();
     acc();
    }
    public WebElement mob()
{
  return           driver.findElement(By.className("level0"));
}

}
