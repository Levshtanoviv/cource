import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private WebDriver driver;
    private WebElement tableElement;

    public Table(WebElement tableElement, WebDriver driver){
        this.tableElement = tableElement;
        this.driver = driver;
    }

    public List<WebElement> getRows(){ // метод для находения строк
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));//все строки
        rows.remove(0);//даление строки с заголовками
        return  rows;
    }

    public List<WebElement> getHeadings(){ //метод для нахождения заголовков
        WebElement headingRow = tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingColumns = headingRow.findElements(By.xpath(".//th"));
        return headingColumns;
    }

    public List<List<WebElement>> getRowsWithColumns(){//разбитие строк на столбцы
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row : rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));//разсбиение строк на столбцы
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();

        for(List<WebElement> row : rowsWithColumns){
            rowByHeadings = new HashMap<String, WebElement>();
            for(int i = 0; i < headingColumns.size(); i++){
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    public String getValueFromCell(int rowNumber, int columnNumber){//поиск и получение значения ячейки
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();//получение текста в ячейке cell
    }

    public String getValueFromCell(int rowNumber, String columnNumber){//поиск и получение значения ячейки
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnNumber).getText();
    }
}
