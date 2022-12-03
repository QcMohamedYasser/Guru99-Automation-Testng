import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class CompareTwoProducts extends OPenBrowser {
    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 4)
    public void TEST4_compare_2_products() throws InterruptedException {
        soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav();
        driver.findElement(By.className("level0")).click();
        driver.findElement(By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]//li[3]//li[2]")).click();
        driver.findElement(By.xpath("//ul[@class=\"products-grid products-grid--max-4-col first last odd\"]//li[2]//li[2]")).click();
        String parent =driver.getWindowHandle();
        String parentTitle=driver.getTitle();
        driver.findElement(By.xpath("//div[@class=\"block-content\"]//button[@class=\"button\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Set<String> all_windows=driver.getWindowHandles();
        for (String window:all_windows)
        {
            if (!window.equalsIgnoreCase(parent))
            {
                driver.switchTo().window(window);
            }
        }
        driver.manage().window().maximize();
        String msg= driver.findElement(By.xpath("//div[@class=\"page-title title-buttons\"] ")).getText();
        System.out.println(msg);
        String childTitle=driver.getTitle();

        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div[2]/button/span/span")).click();
        driver.switchTo().window(parent);
        soft.assertNotEquals(parentTitle,childTitle);

    }
}
