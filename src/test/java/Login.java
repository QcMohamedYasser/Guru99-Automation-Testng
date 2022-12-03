import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;
    @DataProvider(name = "login")
    public static Object[][] logindata () {
        return new Object[][]
                {
                        {"hamo@yahoo.com", "hamoyasserhamo"},
                        {"a.sfjal","ajfnaf"},
                        {"hamoya40@yahoo.com", "Mohamed123"}


                };
    }
    @Test(dataProvider = "login",priority = 6)

    public void Testlog (String username, String pass)
    {
        soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
        if (driver.getCurrentUrl()=="http://live.techpanda.org/index.php/customer/account/login/")
        {
            String ExpRes="Invalid login or password.";
            String Actual=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")).getText();
            soft.assertTrue(Actual.contains(ExpRes));

        }
        else if (driver.getCurrentUrl()=="http://live.techpanda.org/index.php/wishlist/index/index/wishlist_id/24698/")
        {
            String welcome="Welcome, Mohamed yasser Mohamed! ";
            String messageAct=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[1]/div/p")).getText();
            soft.assertEquals(messageAct,welcome);
            driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();


        }



    }
}
