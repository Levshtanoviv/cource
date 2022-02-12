import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");// ссылка на драйвер
        driver = new ChromeDriver();//инициализация драйвера

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//задержка драйвера на 10 сек

        driver.manage().window().maximize();//браузер на весь экран
        //driver.manage().window().setSize(new Dimension(900,500));//размер окна
        driver.get("https://github.com/");

        //Обычный PageObject
        //MainPage mainPage = new MainPage(driver);
        //mainPage.register("sdvsvsvv@fb.com");

        //PageFactory
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignInButton();
        //mainPage.register("sdvsvsvv@fb.com");
        //driver.quit();//закрытие браузера
    }
}

//         driver.navigate().to("http://seleniumhq.org"); //одно и тоже - это запуск браузера
//         driver.navigate().back();//возврат на предыдущую страницу
//         driver.navigate().forward();// на страницу вперед
//         driver.navigate().refresh();//перезагрузка страницы
//
//         System.out.println(driver.getTitle()); //заголовок вкладки
//         System.out.println(driver.getCurrentUrl());// получить URL страницы