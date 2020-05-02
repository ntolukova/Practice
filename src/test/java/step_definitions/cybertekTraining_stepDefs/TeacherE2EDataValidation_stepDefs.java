package step_definitions.cybertekTraining_stepDefs;

import api_models.Teachers;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.Teacher_page;
import utilities.APIUtil;
import utilities.Config;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;


public class TeacherE2EDataValidation_stepDefs {
    Teacher_page teacher_page = new Teacher_page();

    @Given("user gets teacher at {string}")
    public void user_gets_teacher_at(String resource) {
        APIUtil.hitGET(resource);
    }

    @Given("user goes to cybertek training application")
    public void user_goes_to_cybertek_training_application() {
        Driver.getDriver().get(Config.getProperty("cybertekTrainingUrl"));
    }

    @Then("user opens teacher profile details page {string}")
    public void user_opens_teacher_profile_details_page(String idValue) throws InterruptedException {
        teacher_page.teacherTab.click();
        teacher_page.allTeachersLink.click();
        Thread.sleep(500);
        teacher_page.teacherIdField.sendKeys(idValue);
        teacher_page.searchButton.click();
        teacher_page.teacherProfile.click();
    }

    @Then("user cross validates teacher details on API and on UI")
    public void user_cross_validates_teacher_details_on_API_and_on_UI() {
        String apiFullName = APIUtil.getResponseBody().getTeachers().get(0).getFirstName() + " " + APIUtil.getResponseBody().getTeachers().get(0).getLastName();
        Assert.assertEquals("E2E full name verification failed", apiFullName, teacher_page.fullName.getText());
        Assert.assertEquals("E2E phone verification failed", APIUtil.getResponseBody().getTeachers().get(0).getPhone().trim(), teacher_page.phoneNumber.getText().trim());
        Assert.assertEquals("E2E batch verification failed", APIUtil.getResponseBody().getTeachers().get(0).getBatch() + "".trim(), teacher_page.batch.getText().trim());
        Assert.assertEquals("E2E email address verification failed", APIUtil.getResponseBody().getTeachers().get(0).getEmailAddress(), teacher_page.email.getText().trim());
        Assert.assertEquals("E2E birthday verification failed", APIUtil.getResponseBody().getTeachers().get(0).getBirthDate().trim(), teacher_page.birthday.getText().trim());
        Assert.assertEquals("E2E join date verification failed", APIUtil.getResponseBody().getTeachers().get(0).getJoinDate().trim(), teacher_page.joinDate.getText().trim());
        Assert.assertEquals("E2E address verification failed", APIUtil.getResponseBody().getTeachers().get(0).getPremanentAddress().trim(), teacher_page.address.getText().trim());
        Assert.assertEquals("E2E salary verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSalary() + "".trim(), teacher_page.salary.getText().trim());
        Assert.assertEquals("E2E gender verification failed", APIUtil.getResponseBody().getTeachers().get(0).getGender().trim(), teacher_page.gender.getText().trim());
        Assert.assertEquals("E2E section verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSection().trim(), teacher_page.section.getText().trim());
        Assert.assertEquals("E2E subject verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSubject().trim(),teacher_page.subject.getText().trim());
    }


    @Then("user searches the teacher with {string}")
    public void user_searches_the_teacher_with(String teacherName) throws InterruptedException {
        teacher_page.teacherTab.click();
        teacher_page.allTeachersLink.click();
        Thread.sleep(500);
        teacher_page.teacherNameField.sendKeys(teacherName);
        teacher_page.searchButton.click();
    }


    @Then("user cross validates {string} on API and UI")
    public void user_cross_validates_on_API_and_UI(String teacherName) {
        int UIresult = teacher_page.searchResultsName.size();
        int APIresult = APIUtil.getResponseBody().getTeachers().size();
        Assert.assertEquals("Number of results failed!", APIresult, UIresult);
        for (WebElement teacher : teacher_page.searchResultsName) {
            Assert.assertEquals("Teacher name on UI failed!", teacher.getText(), teacherName);
        }
        for(Teachers teacher: APIUtil.getResponseBody().getTeachers()){
            Assert.assertEquals("Teacher name on API failed!", teacher.getFirstName(), teacherName);
        }
    }
    @Given("user connects to Cybertek Training DB")
    public void user_connects_to_Cybertek_Training_DB(){
        DBUtility.createConnection();
    }

    @Then("user gets data from DB with {string}")
    public void user_gets_data_from_DB_with(String teacherID) throws SQLException {
        DBUtility.executeQuery("select first_name from teachers where teacher_id = " + teacherID);


    }

    @Then("user cross validates API with DB")
    public void user_cross_validates_API_with_DB() {

    }
}



