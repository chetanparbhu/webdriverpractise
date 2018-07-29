package test.java;


import main.java.pages.SendUsAMessagePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;


public class SendUsAMessageTest {

    @AfterClass
    public void tearDown(){
                System.out.println("CLOSE ALREADY");
//        support.WebDriverHolder webDriverHolder = new support.WebDriverHolder();
//        webDriverHolder.closeup();
//                driver.quit();
    }

    @Test
    public void verifyPageHeadingIsCorrect() {


        out.println("GIVEN I want to need to contact the bank");

        out.println("WHEN I navigate to the Email Us page");
            SendUsAMessagePage.navigateTo();

            out.println("THEN I can see the name of the page is correct");
        Assert.assertEquals("Send us a message", SendUsAMessagePage.getPageName());
    }

    @Test
    public void verifyPageTitleIsCorrect(){
        out.println("GIVEN I need to contact the bank");

        out.println("WHEN I navigate to the Email Us page");
        SendUsAMessagePage.navigateTo();

        out.println("THEN I can see the page title is correct");
        Assert.assertEquals("Email us - BNZ", SendUsAMessagePage.getPageTitle());

    }

    @Test
    public void checkRadioButtonDefaultsAreUnchecked(){
        SendUsAMessagePage sendUsAMessagePage = SendUsAMessagePage.navigateTo();
        Assert.assertEquals(false, sendUsAMessagePage.areEnquiryRadioButtonsChecked());
        sendUsAMessagePage.closeTheBrowser();
    }

    // Test I can select a particular option on the droplist


    @Test
    public void checkListOptions(){
        out.println("Given I have general enquiry");

        out.println("when I go bnz's enquiry page");
        SendUsAMessagePage.navigateTo();
        out.println("I should be able to choose the option from droplist");
        Assert.assertEquals(true, SendUsAMessagePage.checkDroplistContains("Business banking"));
    }

    // Test there are a certain amount of items in the droplist
    
    // Test I can complete the whole form, names etc and all that stuff

    // Order the tests then close the browser

}
