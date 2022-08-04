package homePage;

import SynkdupBase.synkdupBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

import java.io.IOException;

public class synkdupHome extends synkdupBase {
    public synkdupHome home() throws IOException {
        driver.get("https://beta.synkdup.com/");
        test.log(Status.INFO,"click on home page");
        test.addScreenCaptureFromPath(screenCapture());
        return new synkdupHome();
    }
    public synkdupLogin login() throws IOException {
        driver.findElement(By.xpath("(//*[text()='Login'])[1]")).click();
        test.log(Status.INFO,"click on login button");
        test.addScreenCaptureFromPath(screenCapture());
        return  new synkdupLogin();

    }
    public synkdupHome signup() throws IOException {
        driver.findElement(By.xpath("/*[text()='Signup']")).click();
        return new synkdupHome();
    }
    public void affiliate()
    {
        driver.findElement(By.xpath("//*[@class='px-4 py-2 btn-second d-inline-block rounded-3 semi-bold hover-state']")).click();

    }
    public synkdupSignUP joinUs()
    {
        driver.findElement(By.xpath("(//*[@class='px-5 py-2 btn-second rounded-3 semi-bold hover-state'])[1]")).click();
        return  new synkdupSignUP();
    }
    public synkdupFindjobs findjobs() throws IOException {
        driver.findElement(By.xpath("(//*[text()='Find Jobs'])[1]")).click();
        test.log(Status.INFO,"click on find job on home page");
        test.addScreenCaptureFromPath(screenCapture());
        return  new synkdupFindjobs();
    }

    public synkdupFindjobs homeSearchjob()
    {
        driver.findElement(By.xpath("(//*[@class='px-5 py-2 btn-second rounded-3 semi-bold hover-state'])[2]")).click();
        return new synkdupFindjobs();
    }

}
