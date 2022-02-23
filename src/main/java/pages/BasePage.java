package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    private final By DELETE_ICON = By.xpath("//*[contains(@class, 'btn btn-danger')]");
    private final By PATIENT_DETAILS_TABLE_GROUPS = By.xpath("//*[contains(@class, 'list-group-item')]");
    private final By PATIENTS_NEW_CONTACT_ADD_ON_BUTTON_GROUP = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg')]");

    //Patient's new contact add on buttons
    private final By SMITH_JOHN_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Smith')]");
    private final By BINDEN_GORDON_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Binden')]");
    private final By TRUMP_PETER_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Trump')]");
    private final By PENCE_BORIS_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Pence')]");
    private final By BLACK_CHARLES_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Black')]");
    private final By CLINTON_SUSAN_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Clinton')]");
    private final By FISCHER_ANNA_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Fischer')]");
    private final By ANGELA_MERKEL_NEW_CONTACT_ADD_ON_BUTTON = By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Merkel')]");

    private final By EDIT_BUTTON_GROUP = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'edit')]");
    private final By DELETE_BUTTON_GROUP = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'X')]");

    //new contact form and edit form WebElements
    private final By NEW_CONTACT_MODAL_BOX = By.xpath("//*[contains(@class, 'modal-body')]");
    private final By SUBMIT_BUTTON = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Submit')]");
    private final By CANCEL_BUTTON = By.xpath("//*[contains(@class, 'btn btn-primary') and contains(text(), 'Cancel')]");
    private final By FIRST_NAME = By.id("formGridEmail");
    private final By LAST_NAME = By.id("formGridPassword");
    private final By BIRTH_DATE = By.id("formGridAddress1");
    private final By PHONE_NUMBER = By.id("formGridAddress2");
    private final By RELATIONSHIP = By.id("formGridState");

    private final By PATIENT_NAMES_GROUP = By.xpath("//*[contains(@style, 'display: block;')]");
    private final By RELATIVES_TABLES_GROUP = By.xpath("//*[contains(@class, 'table-responsive')]/table/thead/tr");
    private final By RELATIVES_TABLES_GROUP_TBODY = By.xpath("//*[contains(@class, 'table-responsive')]/table/tbody/tr/td");

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
        if (name ==("Smith. John")) {
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
        } else if (name == "Merkel. Angela"){
            driver.findElement(ANGELA_MERKEL_NEW_CONTACT_ADD_ON_BUTTON).click();
        }
    }

    public void newContactAddOn(String first, String last, String birth, String phone, String relationship) {
        driver.findElement(FIRST_NAME).sendKeys(first);
        driver.findElement(LAST_NAME).sendKeys(last);
        driver.findElement(BIRTH_DATE).sendKeys(birth);
        driver.findElement(PHONE_NUMBER).sendKeys(phone);
        Select selectList = new Select(driver.findElement(RELATIONSHIP));
        selectList.selectByVisibleText(relationship);
    }

    public void clickOnSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void clickOnCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void patientRelativesTableContent() {
        //TODO
    }

    public void deletePatientNoRelatives() {
        List<WebElement> ListOfPatientNames = driver.findElements(RELATIVES_TABLES_GROUP_TBODY);
        for (WebElement names : ListOfPatientNames) {
        /*    names.click();
            List<WebElement> ListOfRelatives = driver.findElements(RELATIVES_TABLES_GROUP_TBODY);
            for (WebElement tags : ListOfRelatives) {*/
                String tag = names.getText();
                if (tag.equals("")) {
                    driver.findElement(DELETE_BUTTON_GROUP).click();
                }/* else {
                    break;
                }*/
            }
        }
    //}

    public String validateTableColumsnames() {
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


    public void deletePatient() {
        //TODO
    }

    public void cancelPatientDelete() {
        //TODO
    }

    public void editRelativesdata(){
        //TODO
    }


}
