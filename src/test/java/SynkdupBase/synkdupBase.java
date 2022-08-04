package SynkdupBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class synkdupBase {
        public static WebDriver driver;
        public static FileInputStream file;
        public static ExtentReports report;
        public static ExtentTest test;
        public String screen;
        @BeforeSuite
        public void setUp()
        {
            if(driver==null) {
                Properties config = new Properties();
                FileInputStream file = null;
                try {
                    file = new FileInputStream("src/resourse/setup.properties");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    config.load(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (config.get("browser").equals("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                } else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();

                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }
            if(report==null)
            {
                report= new ExtentReports();
                ExtentSparkReporter spark= new ExtentSparkReporter("synkdup_reports.html");
                report.attachReporter(spark);
            }


        }

        public String screenCapture() throws IOException {
            Date d= new Date();
            String picname = d.toString().replace(":", "_").replace(" ", "_");
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = "src/test/resourses/screenshot/pic" + picname + ".jpg";
            FileUtils.copyFile(src,new File(dest));
            return dest;

        }
        @AfterSuite
        public void tearDown()
        {
            if(driver!=null)
            {
                report.flush();
                driver.close();
            }
        }
    }

