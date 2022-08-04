import SynkdupBase.synkdupBase;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import java.io.IOException;

public class Listeners extends synkdupBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = report.createTest(result.getMethod().getMethodName());
        System.out.println("test run");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"test pass"+result.getMethod().getMethodName());
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"test fail "+ result.getMethod().getMethodName());
        ITestListener.super.onTestFailure(result);
    }


}
