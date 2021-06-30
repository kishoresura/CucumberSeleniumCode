package testrunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test {
    public static WebDriver driver;
    private String Stringactual;

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @And("^user enters username:\"([^\"]*)\" and Password:\"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("email")).sendKeys(arg0);
        driver.findElement(By.id("passwd")).sendKeys(arg1);
        driver.findElement(By.id("SubmitLogin")).click();
    }


    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Stringactual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, Stringactual);
        driver.quit();
    }


}