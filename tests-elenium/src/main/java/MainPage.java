import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //пишем локаторы
    //используется PageFactory
//    @FindBy(xpath = "//a[@href='/login']..")
//    private WebElement signInButton;   // почему то не работает
    private By signInButton = By.xpath("//a[@href='/login']");
    @FindBy(xpath = "//a[@href='/login']/parent::div/following-sibling::a")
    private WebElement signUpButton;
    //private By userNameField = By.xpath("");
    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailField;
    //private By passwordFeild = By.xpath("");
    @FindBy(xpath = "//button[contains(@class, 'btn-mktg')]")
    private WebElement signUpFormButton;

    public LoginPage clickSignInButton(){
        //signInButton.click();
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        //signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        //signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email){//тоже самое для имени и пароля, если бы они были
        //emailField.sendKeys(email);
        return this;
    }

    public SignUpPage register(String email){//регистрация
        this.typeEmail(email);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}