import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Add_products_from_store extends OPenBrowser{

    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 3)
    public void TEST3_verify_add_products_from_store(){
        soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav();
        driver.findElement(By.className("level0")).click();
        driver.findElement(By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]//li[3]//button[@class=\"button btn-cart\"]")).click();
        driver.findElement(By.xpath("//input[@class=\"input-text qty\"]")).clear();
        driver.findElement(By.xpath("//input[@class=\"input-text qty\"]")).sendKeys("1000");
        driver.findElement(By.xpath("//button[@class=\"button btn-update\"]")).click();
        String error_msg= driver.findElement(By.xpath("//li[@class=\"error-msg\"]")).getText();
        System.out.println(error_msg);
        driver.findElement(By.id("empty_cart_button")).click();
        String empty=driver.findElement(By.xpath("//div[@class=\"page-title\"]")).getText();
        System.out.println(empty);

    }

}
