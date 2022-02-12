import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//h1[text() = 'Sign in to GitHub']");
    private By error = By.xpath("//div[@id='js-flash-container']//div[@class='px-2']");
    private By createAccLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){//метод для невалидного логина или пароля
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){//получение текста заголовка
        return  driver.findElement(heading).getText();
    }

    public String getErrorText(){//получение ошибки при невалидном логине или пароле
        return  driver.findElement(heading).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }
}
