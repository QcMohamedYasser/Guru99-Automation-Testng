import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CheckMyOrder extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 9)
    public void Test_my_order() throws IOException {
        soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav_acc();

        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();
        String pending="Pending";
        String Actual=driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[5]/em")).getText();
        System.out.println(Actual);
        soft.assertTrue(Actual.contains(pending),"true");
        driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/span/a[1]")).click();

        String itemorder="Items Ordered";
        String actual=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div/div[4]/h2")).getText();
        soft.assertTrue(actual.contains(itemorder),"yes contains");
        System.out.println(actual);

    }
}
