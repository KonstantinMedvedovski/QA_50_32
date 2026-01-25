package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver,10),this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputUserEmail;
    @FindBy(id = "userNumber")
    WebElement inputMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement inputSubject;
    @FindBy(id = "currentAddress")
    WebElement inputAddress;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(id = "submit")
    WebElement btnSubmit;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;

    public void typePracticeForm(Student student){
        hideBanner();
        hideFooter();
        scroll();
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputUserEmail.sendKeys(student.getEmail());
        inputMobile.sendKeys(student.getMobile());
        inputAddress.sendKeys(student.getAddress());
        pause(3);
        typeGender(student.getGender());
        pause(3);
        typeDateOfBirth(student.getDateOfBirth());
        pause(3);
        typeSubjects(student.getSubjects());
        btnSubmit.click();
    }

    public boolean validateModalMessage(String text){
        return validateTextInElement(modalMessage,text);
    }

    private void typeGender(Gender gender){
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeDateOfBirth(String dateOfBirth){
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeSubjects(String subjects){
        inputSubject.click();
        String[] arr =subjects.split(",");
        for (String s : arr){
            inputSubject.sendKeys(s);
            inputSubject.sendKeys(Keys.ENTER);
        }
    }



}
