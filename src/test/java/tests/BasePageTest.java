package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasePageTest extends BaseTest {

    BasePage basePage;

    @Test
    @Order(1)
    @DisplayName("AVINTY-001 Clicking on a patient name")
    public void clickingOnPatientName() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Smith. John");

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'table-responsive')]")).isEnabled());
    }

    @Test
    @Order(2)
    @DisplayName("AVINTY-002 Delete patient who has no relative")
    public void deletePatientNoRelatives() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.BindenGordonDeleteIcon();
        driver.switchTo().activeElement();
        basePage.okButtonClickOnDeletePopUp();

        List<String> result = basePage.getAllNames();
        List<String> expected = new ArrayList<>();
        expected.add("Smith. John");
        expected.add("Trump. Peter");
        expected.add("Pence. Boris");
        expected.add("Black. Charles");
        expected.add("Clinton. Susan");
        expected.add("Fischer. Anna");
        expected.add("Merkel. Angela");

        Assertions.assertEquals(expected, result);
    }

    @Test
    @Order(3)
    @DisplayName("AVINTY-003 Delete patient who has no relatives but cancel the progress at the end")
    public void deletePatientNoRelativesButCancelTheProcess() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.BindenGordonDeleteIcon();
        driver.switchTo().activeElement();
        basePage.cancelButtonClickOnDeletePopUp();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@style, 'display: block;') and contains(text(), 'Binden. Gordon')]")).isEnabled());
    }

    @Test
    @Order(4)
    @DisplayName("AVINTY-004 Delete patient who has relatives")
    public void deletePatientWithRelatives() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);

        Assertions.assertFalse(driver.findElement(By.xpath("//*/p/div/div[1]/div/div[1]/div[2]/button")).isEnabled());
    }

    @Test
    @Order(5)
    @DisplayName("AVINTY-005 Delete a relative")
    public void deleteARelative() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Fischer. Anna");
        basePage.tuskPeterDeleteIcon();
        driver.switchTo().activeElement();
        basePage.okButtonClickOnDeletePopUp();

        String expected = "Clinton Hillary";
        String actual = driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[1]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Order(6)
    @DisplayName("AVINTY-006 Delete a relative, but cancel the process")
    public void deleteARelativeButCancelTheProcess() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Fischer. Anna");
        basePage.tuskPeterDeleteIcon();
        driver.switchTo().activeElement();
        basePage.cancelButtonClickOnDeletePopUp();

        String expected = "Tusk Peter";
        String actual = driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[1]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(7)
    @DisplayName("AVINTY-007 Check that relatives list wiew table headlines")
    public void validateRelativesTableHeader() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Pence. Boris");

        String expected = "Id Name Birth date Relationship";
        String actual = basePage.validateTableColumsNames();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(8)
    @DisplayName("AVINTY-008 Check add on relative button")
    public void addOnRelativesButton() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Merkel. Angela");
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'modal-body')]")).isDisplayed());
    }

    @Test
    @Order(9)
    @DisplayName("AVINTY-009 Add on relative (all datas are valid)")
    public void addOnRelativesAllDatasValid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Deyes Tom";
        String actual = driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(10)
    @DisplayName("AVINTY-010 Add on relative (all datas are valid and phone number too)")
    public void addOnRelativesAllDatasValidAndPhoneNumerToo() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER_2,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = Constraints.FIRST_NAME + " " + Constraints.LAST_NAME;
        String actual = driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(11)
    @DisplayName("AVINTY-011 Add on relative (all datas are valid but phone number is invalid)")
    public void addOnRelativesPhoneNumerInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.INVALID_PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(12)
    @DisplayName("AVINTY-012 Add on relative (all datas are valid but birth date is invalid)")
    public void addOnRelativesBirthDateInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.INVALID_BIRTH_DATE_2, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(13)
    @DisplayName("AVINTY-013 Add on relative (all datas valid), but cancel the progress")
    public void addOnRelativesCancelTheProgress() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnCancelButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(14)
    @DisplayName("AVINTY-014 Add on relative but leave \"First name\" field empty")
    public void addOnRelativesFirstNameFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME_EMPTY, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "This field is required.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'This field is required.')]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(15)
    @DisplayName("AVINTY-015 Add on relative but leave \"Last name\" field empty")
    public void addOnRelativesLastNameFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME_EMPTY, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "This field is required.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'This field is requird.')]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(16)
    @DisplayName("AVINTY-016 Add on relative but leave \"Birth date\" field empty")
    public void addOnRelativesBirthDateFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE_EMPTY, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Wrong format";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'Wrong format')]")).getText();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(17)
    @DisplayName("AVINTY-017 Add on relatives but leave \"Phone number\" field empty")
    public void addOnRelativesPhoneNumberFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.fillContactForm(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER_EMPTY,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Wrong type.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'Wrong type.')]")).getText();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Order(18)
    @DisplayName("AVINTY-018 Edit relative datas (all datas are valid)")
    public void editRelativeDatasValid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_BIRTH_DATE,
                Constraints.TEST1_PHONE_NUMBER, Constraints.TEST1_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'btn btn-secondary btn-block btn-lg') and contains(@title, 'Trump')]")).isEnabled());
    //    basePage.clickOnKamalaHarrisEditButton();

    //    String expected_phone_number = Constraints.TEST1_PHONE_NUMBER;
    //    driver.findElement(By.id("formGridAddress2")).click();
    //    String actual_phone_number = driver.findElement(By.id("formGridAddress2")).getText();

    //    Assertions.assertEquals(expected_phone_number, actual_phone_number);
    }

    @Test
    @Order(19)
    @DisplayName("AVINTY-019 Edit relative datas, but cancel the progress")
    public void editRelativeDatasCancelTheProcess() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_MODIFIED_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_BIRTH_DATE,
                Constraints.TEST1_PHONE_NUMBER, Constraints.TEST1_RELATIONSHIP);
        basePage.clickOnCancelButton();

        String expected = Constraints.TEST1_FIRST_NAME + " " + Constraints.TEST1_LAST_NAME;

        String actual = driver.findElement(By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(20)
    @DisplayName("AVINTY-020 Edit relative datas (all datas and phone number valid)")
    public void editRelativeDatasPhoneNumberValid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_BIRTH_DATE,
                Constraints.TEST1_MODIFIED_VALID_PHONE_NUMBER, Constraints.TEST1_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = Constraints.TEST1_FIRST_NAME + " " + Constraints.TEST1_LAST_NAME;
        String actual = driver.findElement(By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(21)
    @DisplayName("AVINTY-021 Edit relative datas (all datas valid but phone number invalid)")
    public void editRelativeDatasPhoneNumberInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_BIRTH_DATE,
                Constraints.TEST1_INVALID_PHONE_NUMBER, Constraints.TEST1_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(22)
    @DisplayName("AVINTY-022 Edit relative datas, modify the birt date to invalid date")
    public void editRelativeDatasBirthDateInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_INVALID_BIRTH_DATE,
                Constraints.TEST1_PHONE_NUMBER, Constraints.TEST1_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(23)
    @DisplayName("AVINTY-023 Edit relative datas, modify the Relationship dropdown")
    public void editRelativeDatasModifyRelationshipDropdown() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickOnKamalaHarrisEditButton();
        basePage.fillContactForm(Constraints.TEST1_FIRST_NAME, Constraints.TEST1_LAST_NAME, Constraints.TEST1_BIRTH_DATE,
                Constraints.TEST1_PHONE_NUMBER, Constraints.TEST1_MODIFIED_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = Constraints.TEST1_MODIFIED_RELATIONSHIP;
        String actual = driver.findElement(By.xpath("//*/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr/td[4]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(24)
    @DisplayName("AVINTY-024 Relatives are sorted in ABC order by their names")
    public void namesSortedABCOrder() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Fischer. Anna");
        basePage.clickingOnRelativesAddOnButton("Fischer. Anna");
        basePage.fillContactForm(Constraints.FISCHER_RELATIVE_FIRST_NAME, Constraints.FISCHER_RELATIVE_LAST_NAME,
                Constraints.FISCHER_RELATIVE_BIRTH_DATE, Constraints.FISCHER_RELATIVE_PHONE_NUMBER, Constraints.FISCHER_RELATIVE_RELATIONSHIP);
        basePage.clickOnSubmitButton();

        List<String> result = new ArrayList<>();
        result.add(driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[1]/tr/td[2]")).getText());
        result.add(driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[2]/tr/td[2]")).getText());
        result.add(driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[3]/tr/td[2]")).getText());
        result.add(driver.findElement(By.xpath("//*/div[7]/div/div[2]/div/div[2]/div/table/tbody[4]/tr/td[2]")).getText());

        List<String> expected = new ArrayList<>();
        expected.add("Alber Atlas");
        expected.add("Carter Donald");
        expected.add("Clinton Hillary");
        expected.add("Tusk Peter");

        Assertions.assertEquals(expected, result);
    }
}
