import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class Register extends OPenBrowser{
    @Test(priority = 5)
            public void register() throws IOException, CsvValidationException {
  driver.navigate().to("http://live.techpanda.org/index.php/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.linkText("Register")).click();
    CSVReader reader=new CSVReader(new FileReader("C:\\Users\\HAMO\\IdeaProjects\\Guru99_ITI\\csv\\datadriven.csv"));
    String []data_driven ;

        while ((data_driven=reader.readNext()) !=null){
        String fname=data_driven[0];
        String mname=data_driven[1];
        String lname=data_driven[2];
        String email=data_driven[3];
        String confirm=data_driven[4];
        String rconfirm=data_driven[5];
        System.out.println(fname);
        driver.findElement(By.id("firstname")).sendKeys(fname);
        driver.findElement(By.id("middlename")).sendKeys(mname);
        driver.findElement(By.id("lastname")).sendKeys(lname);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(confirm);
        driver.findElement(By.id("confirmation")).sendKeys(rconfirm);
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if (driver.getCurrentUrl().equals("http://live.techpanda.org/index.php/customer/account/create/"))
        {

//            String text=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li/span")).getText();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            System.out.println(text);

            if((fname==" ")||(mname==" ")||(lname==" ")||(email==" ")||(confirm==" ")||(rconfirm==" "))
            {
                System.out.println("This is a required field.");
            }
           if (!email.contains("@")|| !email.endsWith(".com"))
            {
                System.out.println("wrong email data check missing ( @ ) Or (.com)");
            }
           if (confirm.length()<6 ||    rconfirm.length()<6 )
           {

               System.out.println("Please enter 6 or more characters without leading or trailing spaces");
           }


        }
        else if (driver.getCurrentUrl().equals("http://live.techpanda.org/index.php/customer/account/index/"))
        {
            System.out.println("Thank you for registering with Main Website Store.");

        }
        else {
            System.out.println(" can not find element");
        }

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[5]/a")).click();


    }

}}
