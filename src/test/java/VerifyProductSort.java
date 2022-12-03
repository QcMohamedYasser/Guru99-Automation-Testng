import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyProductSort extends OPenBrowser{
    SoftAssert soft;
    CodeDesign design;


    @Test(priority = 1)
    public void Test1_verify_mobile_list_page(){
        soft=new SoftAssert();
        design=new CodeDesign(driver);
        design.nav();
        String titleA=  driver.findElement(By.className("page-title")).getText();
        String titleE="This is demo site for &nbsp;&nbsp;";
        System.out.println(titleA);
        driver.findElement(By.className("level0")).click();
        Select category= new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
        category.selectByIndex(1);
        String nameActual=driver.findElement(By.cssSelector("select[title=\"Sort By\"]>option[selected=\"selected\"]")).getText();
        String name="Name";
        soft.assertTrue(nameActual.contains(name));
        soft.assertAll();
    }



}

