package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendUsAMessagePage {

    private static WebDriver driver;

    private static support.WebDriverHolder holder;

    @FindBy(name = "productType")
    private static WebElement productOrServiceDroplist;

    private WebElement html;

    @FindBy(xpath = "//*[@id=\'generalenquiry\']/fieldset[1]/div[1]/b/a")
    private WebElement logIntoInternetBankingButton;

    @FindBy(xpath = "//*[@id='header']/div/div/h1")
    private static WebElement pageHeading;

    @FindBy(name = "enquiryType")
    private WebElement productAlreadyWithUsRadioButton;


    public static SendUsAMessagePage navigateTo() {
        if(support.WebDriverHolder.isDriverSet() == true){
            driver = support.WebDriverHolder.get();
            System.out.println("Existing driver");
        }else{
            WebDriver webdriver = new ChromeDriver();
            support.WebDriverHolder.set(webdriver);
            driver = support.WebDriverHolder.get();
            System.out.println("New Driver");
        }
        driver.get("https://www.bnz.co.nz/contact/email");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='generalenquiry']/fieldset[1]/div[1]/b/a")));

        return landAt();
    }

    public static SendUsAMessagePage landAt() {
        SendUsAMessagePage result = new SendUsAMessagePage(support.WebDriverHolder.get());
        PageFactory.initElements(support.WebDriverHolder.get(), result);
        result.html = support.WebDriverHolder.get().findElement(By.tagName("html"));
        return result;
    }

    public SendUsAMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getPageName() {
        return pageHeading.getText();

    }

    public static String getPageTitle() {
      //  driver = support.WebDriverHolder.get();
        return driver.getTitle();

    }


    public static boolean checkDroplistContains(String droplistoption) {
        try {
            new Select(productOrServiceDroplist).selectByVisibleText(droplistoption);
            return true;

        }catch (NoSuchElementException e){
            return false;
        }

    }

    public void selectProductByName(String optionSelected){
        //TODO check something

        System.out.println("BLAH BLAH BLAH");
    }

    public void selectRadioButton(){
        productAlreadyWithUsRadioButton.click();
    }

    public boolean areEnquiryRadioButtonsChecked() {
        if(!productAlreadyWithUsRadioButton.isSelected()){
            return false;
        }

        // the other radio buttons
        return true;
    }

    public void closeTheBrowser(){
        support.WebDriverHolder.closeup();
        support.WebDriverHolder.clear();
    }
}
