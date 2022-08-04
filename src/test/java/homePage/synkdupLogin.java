package homePage;

import SynkdupBase.synkdupBase;
import org.openqa.selenium.By;

public class synkdupLogin extends synkdupBase {

    public synkdupHome login()
    {
        driver.findElement(By.xpath("//*[@id='exampleInputEmail1']")).sendKeys("shivam19930509@gmail.com");
        driver.findElement(By.xpath("//*[@id='exampleInputPassword1']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        if(driver.findElement(By.id("dropdownMenuButton")).isDisplayed())
        {
             return new synkdupHome();
        }
        return null;

    }


}
