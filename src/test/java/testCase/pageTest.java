package testCase;

import SynkdupBase.synkdupBase;
import homePage.synkdupHome;
import org.testng.annotations.Test;

import java.io.IOException;

public class pageTest extends synkdupBase {

    @Test
    public void login_with_id_and_password() throws IOException {
        synkdupHome home= new synkdupHome();
        home.home().login().login().home().findjobs().findjob();
    }


}
