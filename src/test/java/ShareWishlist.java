import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShareWishlist extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;
    @Test(priority = 7)
    public void shareWishlist()
    {soft=new SoftAssert();
        design=new CodeDesign(driver);


        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
        design.log();
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]/span/span")).click();
        driver.findElement(By.id("email_address")).sendKeys("hamoya40@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
        String txt=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
        String wish="Your Wishlist has been shared.";
        soft.assertTrue(txt.contains(wish),"true");
        System.out.println(txt);


    }
}
