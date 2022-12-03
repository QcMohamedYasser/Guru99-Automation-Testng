import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseProductUsingEmail extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 8)
    public void Purchase(){
        soft=new SoftAssert();
        design=new CodeDesign(driver);
//        design.nav_acc();
//        design.log();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
        design.log();

        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div/div/div[1]/ul/li/button/span/span")).click();
        Select select=new Select(driver.findElement(By.id("billing-address-select")));
        select.selectByIndex(1);

        driver.findElement(By.name("billing[firstname]")).clear();
        driver.findElement(By.name("billing[firstname]")).sendKeys("Mohamed");
        driver.findElement(By.name("billing[middlename]")).clear();
        driver.findElement(By.name("billing[middlename]")).sendKeys("yasser");
        driver.findElement(By.name("billing[lastname]")).clear();
        driver.findElement(By.name("billing[lastname]")).sendKeys("Mohamed");
        driver.findElement(By.id("billing:street1")).clear();
        driver.findElement(By.id("billing:street1")).sendKeys("ABC");
        driver.findElement(By.id("billing:city")).clear();
        driver.findElement(By.id("billing:city")).sendKeys("manhatn");


        driver.findElement(By.id("billing:postcode")).clear();
        driver.findElement(By.id("billing:postcode")).sendKeys("542896");
        Select country=new Select(driver.findElement(By.id("billing:country_id")));
        country.selectByValue("US");

        driver.findElement(By.id("billing:telephone")).clear();
        driver.findElement(By.id("billing:telephone")).sendKeys("12345678");

        driver.findElement(By.id("shipping:save_in_address_book")).isSelected();

        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button")).click();
        Select state=new Select(driver.findElement(By.id("billing:region_id")));
        state.selectByIndex(43);
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button")).click();

        //checkout

        String rate= driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/dl/dt")).getText();
        System.out.println(rate);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span")).click();

        //payment information
        driver.findElement(By.xpath("//*[@id=\"dt_method_checkmo\"]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button")).click();
        //place order
        driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button")).click();
    }

}
