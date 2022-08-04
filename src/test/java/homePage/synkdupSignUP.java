package homePage;

import SynkdupBase.synkdupBase;
import org.openqa.selenium.By;

public class synkdupSignUP extends synkdupBase {

    public synkdupHome signup()
    {
        driver.findElement(By.xpath("//*[@id='fname']")).sendKeys("shivam");
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys(" singh");
        driver.findElement(By.xpath("//*[@id='email-address']")).sendKeys("atul45@gmail.com");
        driver.findElement(By.xpath("//*[@id='phoneno']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='confirm_password']")).sendKeys("123456");
        driver.findElement(By.id("gridCheck1")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        if(driver.findElement(By.id("dropdownMenuButton")).isDisplayed())
        {
            return new  synkdupHome();
        }
        return null;
    }
}
