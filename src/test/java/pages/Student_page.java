package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Student_page {
   public Student_page(){
       PageFactory.initElements(Driver.getDriver(), this);
   }
    @FindBy(xpath = "(//li[@class='submenu'])[2]")
    public WebElement studentButton;

    @FindBy(linkText = "All Students")
    public WebElement allStudentsTag;

    @FindBy (xpath = "(//div[@class='form-group custom-mt-form-group']//input)[1]")
    public WebElement searchStudentById;

    @FindBy (xpath = "//a[@class='btn btn-success btn-block mt-4 mb-2']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='row staff-grid-row']//h4/a")
    public List<WebElement> searchResultsName;

}
