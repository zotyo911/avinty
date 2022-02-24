package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Patient's new contact add on buttons WebElements
    private final By SMITH_JOHN_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Smith')]");
    private final By BINDEN_GORDON_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Binden')]");
    private final By TRUMP_PETER_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Trump')]");
    private final By PENCE_BORIS_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Pence')]");
    private final By BLACK_CHARLES_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Black')]");
    private final By CLINTON_SUSAN_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Clinton')]");
    private final By FISCHER_ANNA_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Fischer')]");
    private final By ANGELA_MERKEL_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Merkel')]");

    //WebElements of buttons and icons
    private final By OK_BUTTON_ON_DELETE_CONFIRMATION_POP_UP = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Ok')]");
    private final By CANCEL_BUTTON_ON_DELETE_CONFIRMATION_POP_UP = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Cancel')]");
    private final By KAMALA_HARRIS_EDIT_BUTTON = By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[5]/button[1]");
    private final By BINDEN_DELETE_ICON = By.xpath("//*/div[2]/div/div[1]/div[2]/button");
    private final By TUSK_PETER_DELETE_ICON = By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[1]/tr/td[5]/button[2]");

    //new contact form and edit form WebElements
    private final By SUBMIT_BUTTON = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Submit')]");
    private final By CANCEL_BUTTON = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Cancel')]");
    private final By FIRST_NAME = By.id("formGridEmail");
    private final By LAST_NAME = By.id("formGridPassword");
    private final By BIRTH_DATE = By.id("formGridAddress1");
    private final By PHONE_NUMBER = By.id("formGridAddress2");
    private final By RELATIONSHIP = By.id("formGridState");

    private final By PATIENT_NAMES_GROUP = By.xpath("//*[contains(@style, 'display: block;')]");
    private final By RELATIVES_TABLES_GROUP = By.xpath("//*[contains(@class, 'table-responsive')]/table/thead/tr");

    //this method navigates to base test page
    public void navigateToBasePage(String url) {
        driver.get(url);
    }

    //find the patient we would like to find, and click on his/her name
    public void clickingOnPatientName(String name) {
        List<WebElement> ListOfPatientNames = driver.findElements(PATIENT_NAMES_GROUP);
            for (WebElement names : ListOfPatientNames) {
                String patientName = names.getText();
                if (patientName.equals(name)) {
                    names.click();
                }
            }
    }

    //clicking on relative's add on button
    public void clickingOnRelativesAddOnButton(String name) {
        if (name.equals("Smith. John")) {
            driver.findElement(SMITH_JOHN_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Binden. Gordon")) {
            driver.findElement(BINDEN_GORDON_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Trump. Peter")) {
            driver.findElement(TRUMP_PETER_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Pence. Boris")) {
            driver.findElement(PENCE_BORIS_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Black. Charles")) {
            driver.findElement(BLACK_CHARLES_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Clinton. Susan")) {
            driver.findElement(CLINTON_SUSAN_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Fischer. Anna")) {
            driver.findElement(FISCHER_ANNA_NEW_CONTACT_ADD_ON_BUTTON).click();
        } else if (name.equals("Merkel. Angela")){
            driver.findElement(ANGELA_MERKEL_NEW_CONTACT_ADD_ON_BUTTON).click();
        }
    }

    //this method fill in and/or modifies relative's personal datas
    public void fillContactForm(String first, String last, String birth, String phone, String relationship) {
        driver.findElement(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys(first);
        driver.findElement(LAST_NAME).clear();
        driver.findElement(LAST_NAME).sendKeys(last);
        driver.findElement(BIRTH_DATE).clear();
        driver.findElement(BIRTH_DATE).sendKeys(birth);
        driver.findElement(PHONE_NUMBER).clear();
        driver.findElement(PHONE_NUMBER).sendKeys(phone);
        Select selectList = new Select(driver.findElement(RELATIONSHIP));
        selectList.selectByVisibleText(relationship);
    }

    //button click methods
    public void clickOnSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void clickOnCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickOnKamalaHarrisEditButton() {
        driver.findElement(KAMALA_HARRIS_EDIT_BUTTON).click();
    }

    public void BindenGordonDeleteIcon() {
        driver.findElement(BINDEN_DELETE_ICON).click();
    }

    public void tuskPeterDeleteIcon() {
        driver.findElement(TUSK_PETER_DELETE_ICON).click();
    }

    public void cancelButtonClickOnDeletePopUp() {
        driver.findElement(CANCEL_BUTTON_ON_DELETE_CONFIRMATION_POP_UP).click();
    }

    public void okButtonClickOnDeletePopUp() {
        driver.findElement(OK_BUTTON_ON_DELETE_CONFIRMATION_POP_UP).click();
    }

    //this function validates the headers of patient's relatives table
    public String validateTableColumsNames() {
        List<WebElement> relativesTableHeader = driver.findElements(RELATIVES_TABLES_GROUP);
        String text = "";
        if (relativesTableHeader.size() > 0) {
            for (WebElement header : relativesTableHeader) {
                String content = header.getText();
                if (!content.equals("")) {
                    text = content;
                }
            }
        }
        return text;
    }

    //this function store the patients name's into an ArrayList
    public List<String> getAllNames() {
        List<String> allNames = new ArrayList<>();
        List<WebElement> patients = driver.findElements(PATIENT_NAMES_GROUP);
        for (WebElement name : patients) {
            String patient = name.getText();
            allNames.add(patient);
        }
        return allNames;
    }
}


