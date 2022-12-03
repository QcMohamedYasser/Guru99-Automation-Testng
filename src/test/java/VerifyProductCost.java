import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyProductCost extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 2)
    public void TEST2_verify_product_cost()
    {soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav();
        design.mob().click();
        String expected=driver.findElement(By.id("product-price-1")).getText();
        System.out.println(expected);
        driver.findElement(By.xpath("//ul/li[2]/div/h2")).click();
        String actual=driver.findElement(By.xpath("//div[@class=\"price-box\"]")).getText();
        soft.assertEquals(actual,expected,"true price");
    }

}
