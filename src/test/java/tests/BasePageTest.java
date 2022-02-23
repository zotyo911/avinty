package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.BasePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasePageTest extends BaseTest {

    BasePage basePage;

    @Test
    @Order(1)
    @DisplayName("Testing test enviroment is ready. Navigate to BasePage")
    public void goToLandingPage() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'patients')]")).isDisplayed());
    }

    @Test
    @Order(2)
    @DisplayName("AVINTY-001 Clicking on a patient name")
    public void clickingOnPatientName() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.SMITH_JOHN);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'table-responsive')]")).isEnabled());
    }

    @Test
    @Order(3)
    @DisplayName("AVINTY-002 Delete patient who has no relative")
    @Disabled
    public void deletePatientNoRelatives() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Pence. Boris");
        basePage.deletePatientNoRelatives();

     //   Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'table-responsive')]")).isEnabled());
    }

    @Test
    @Order(4)
    @DisplayName("AVINTY-003 Delete patient who has no relatives but cancel the progress at the end")
    @Disabled
    public void deletePatientNoRelativesButCancelTheProcess() {
        //TODO
    }

    @Test
    @Order(5)
    @DisplayName("AVINTY-004 Delete patient who has relatives")
    @Disabled
    public void deletePatientWithRelatives() {
        //TODO
    }

    @Test
    @Order(6)
    @DisplayName("AVINTY-005 Delete a relative")
    @Disabled
    public void deleteARelative() {
        //TODO
    }

    @Test
    @Order(7)
    @DisplayName("AVINTY-006 Delete a relative, but cancel the process")
    @Disabled
    public void deleteARelativeButCancelTheProcess() {
        //TODO
    }

    @Test
    @Order(8)
    @DisplayName("AVINTY-007 Check that relatives list wiew table headlines")
    public void validateRelativesTableHeader() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName("Pence. Boris");

        String expected = "Id Name Birth date Relationship";
        String actual = basePage.validateTableColumsnames();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(9)
    @DisplayName("AVINTY-008 Check add on relative button")
    public void addOnRelativesButton() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME);

        Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'modal-body')]")).isDisplayed());
    }

    @Test
    @Order(10)
    @DisplayName("AVINTY-009 Add on relative (all datas are valid)")
    public void addOnRelativesAllDatasValid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Deyes Tom";
        String actual = driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(11)
    @DisplayName("AVINTY-010 Add on relative (all datas are valid and phone number too)")
    public void addOnRelativesAllDatasValidAndPhoneNumerToo() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER_2,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Deyes Tom";
        String actual = driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(12)
    @DisplayName("AVINTY-011 Add on relative (all datas are valid but phone number is invalid)")
    public void addOnRelativesPhoneNumerInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.INVALID_PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(13)
    @DisplayName("AVINTY-012 Add on relative (all datas are valid but birth date is invalid)")
    public void addOnRelativesBirthDateInvalid() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.INVALID_BIRTH_DATE_2, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(14)
    @DisplayName("AVINTY-013 Add on relative (all datas valid), but cancel the progress")
    public void addOnRelativesCancelTheProgress() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnCancelButton();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
    }

    @Test
    @Order(15)
    @DisplayName("AVINTY-014 Add on relative but leave \"First name\" field empty")
    public void addOnRelativesFirstNameFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME_EMPTY, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "This field is required.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'This field is required.')]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(16)
    @DisplayName("AVINTY-015 Add on relative but leave \"Last name\" field empty")
    public void addOnRelativesLastNameFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME_EMPTY, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "This field is required.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'This field is requird.')]")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(17)
    @DisplayName("AVINTY-016 Add on relative but leave \"Birth date\" field empty")
    public void addOnRelativesBirthDateFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE_EMPTY, Constraints.PHONE_NUMBER,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Wrong format";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'Wrong format')]")).getText();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(18)
    @DisplayName("AVINTY-017 Add on relatives but leave \"Phone number\" field empty")
    public void addOnRelativesPhoneNumberFieldEmpty() {
        basePage = new BasePage(driver);
        basePage.navigateToBasePage(Constraints.URL);
        basePage.clickingOnPatientName(Constraints.PATIENT_NAME_ADD_ON);
        basePage.clickingOnRelativesAddOnButton(Constraints.PATIENT_NAME_ADD_ON);
        basePage.newContactAddOn(Constraints.FIRST_NAME, Constraints.LAST_NAME, Constraints.BIRTH_DATE, Constraints.PHONE_NUMBER_EMPTY,
                Constraints.RELATIONSHIP);
        basePage.clickOnSubmitButton();

        String expected = "Wrong type.";
        String actual = driver.findElement(By.xpath("//*[contains(@class, 'invalid-feedback') and contains(text(), 'Wrong type.')]")).getText();

        Assertions.assertTrue(!driver.findElement(By.xpath("//*/table/tbody[2]/tr/td[2]")).isDisplayed());
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Order(19)
    @DisplayName("AVINTY-018 Edit relative datas (all datas are valid)")
    @Disabled
    public void editRelativeDatasValid() {
        //TODO
    }

    @Test
    @Order(20)
    @DisplayName("AVINTY-019 Edit relative datas, but cancel the progress")
    @Disabled
    public void editRelativeDatasCancelTheProcess() {
        //TODO
    }

    @Test
    @Order(21)
    @DisplayName("AVINTY-020 Edit relative datas (all datas and phone number valid)")
    @Disabled
    public void editRelativeDatasPhoneNumberValid() {
        //TODO
    }

    @Test
    @Order(22)
    @DisplayName("AVINTY-021 Edit relative datas (all datas valid but phone number invalid)")
    @Disabled
    public void editRelativeDatasPhoneNumberInvalid() {
        //TODO
    }

    @Test
    @Order(23)
    @DisplayName("AVINTY-022 Edit relative datas, modify the birt date to invalid date")
    @Disabled
    public void editRelativeDatasBirthDateInvalid() {
        //TODO
    }

    @Test
    @Order(24)
    @DisplayName("AVINTY-023 Edit relative datas, modify the Relationship dropdown")
    @Disabled
    public void editRelativeDatasModifyRelationshipDropdown() {
        //TODO
    }

    @Test
    @Order(25)
    @DisplayName("AVINTY-024 Relatives are sorted in ABC order by their names")
    @Disabled
    public void namesSortedABCOrder() {
        //TODO
    }


}
