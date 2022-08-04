package homePage;

import SynkdupBase.synkdupBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class synkdupFindjobs extends synkdupBase {
    public void findjob() throws IOException {
        driver.findElement(By.id("companyVal")).sendKeys("amazon");
        test.log(Status.INFO,"enter company details");
        test.addScreenCaptureFromPath(screenCapture(),"enter company details");
        test.addScreenCaptureFromPath(screenCapture());
        driver.findElement(By.id("stateVal")).sendKeys("new");
        test.log(Status.INFO,"enter location details");
        test.addScreenCaptureFromPath(screenCapture());
        List<WebElement> suggestionlist = driver.findElements(By.xpath("//*[@id='stateField']/li"));
        test.addScreenCaptureFromPath(screenCapture());
        for ( WebElement statelist:suggestionlist) {
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            //System.out.println(statelist.getText());
            if(statelist.getText().equalsIgnoreCase("New Baden, IL"))
            {
                statelist.click();
                test.log(Status.INFO,"click on suggested location ");
            }
        }
        driver.findElement(By.xpath("//*[@value='Find Jobs']")).click();
        test.log(Status.INFO,"click on login button for login ");
    }
}
