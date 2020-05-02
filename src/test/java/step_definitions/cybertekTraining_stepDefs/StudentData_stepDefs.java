package step_definitions.cybertekTraining_stepDefs;

import api_models.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.Student_page;
import utilities.APIUtil;

import java.util.Map;

public class StudentData_stepDefs {
    Student_page student_page = new Student_page();

    @Given("user gets student at {string}")
    public void user_gets_student_at(String resource) {
        APIUtil.hitGET(resource);
    }

    @Then("user should be able to see all the student list by {string}")
    public void user_should_be_able_to_see_all_the_student_list_by(String batchNumber) {
        for (Students students : APIUtil.getResponseBody().getStudents())
            Assert.assertEquals("The list batch number matching failed!", students.getBatch() + "", batchNumber);
    }

    @Given("user deletes student with {string}")
    public void user_deletes_student_with(String resource) {
        APIUtil.hitDELETE(resource);
    }

    @Given("user searches the student by {string}")
    public void user_searches_the_student_by(String studentID) {
        student_page.studentButton.click();
        student_page.allStudentsTag.click();
        student_page.searchStudentById.sendKeys(studentID);
        student_page.searchButton.click();
    }

    @Then("user shouldn't be able to find the student on UI")
    public void user_shouldn_t_be_able_to_find_the_student_on_UI() {
        Assert.assertEquals("Deleting student failed", 0, student_page.searchResultsName.size());
    }

    @Given("user posts student with following data {string}")
    public void user_posts_student_with_following_data(String resource, DataTable dataTable) {
        Map<String, String> studentData = dataTable.asMap(String.class, String.class);
        RequestBody requestBody = new RequestBody();
        requestBody.setFirstName(studentData.get("firstName"));
        requestBody.setLastName(studentData.get("lastName"));
        requestBody.setMajor(studentData.get("major"));
        requestBody.setSubject(studentData.get("subject"));
        requestBody.setAdmissionNo(studentData.get("admissionNo"));
        requestBody.setBatch(Integer.parseInt(studentData.get("batch")));
        requestBody.setGender(studentData.get("gender"));
        requestBody.setBirthDate(studentData.get("birthDate"));
        requestBody.setJoinDate(studentData.get("joinDate"));
        requestBody.setPassword(studentData.get("password"));
        requestBody.setSection(studentData.get("section"));
        Contact contact = new Contact();
        contact.setPhone(studentData.get("phone"));
        contact.setEmailAddress(studentData.get("emailAddress"));
        contact.setPremanentAddress(studentData.get("premanentAddress"));

        Company company = new Company();
        company.setCompanyName(studentData.get("companyName"));
        company.setStartDate(studentData.get("startDate"));
        company.setTitle(studentData.get("title"));

        Address address = new Address();
        address.setStreet(studentData.get("street"));
        address.setCity(studentData.get("city"));
        address.setState(studentData.get("state"));
        address.setZipCode(Integer.parseInt(studentData.get("zipCode")));

        company.setAddress(address);

        requestBody.setContact(contact);
        requestBody.setCompany(company);

        APIUtil.hitPOST(resource, requestBody);

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @Given("user searches for student with newly created studentID")
    public void user_searches_for_student_with_newly_created_studentID() {
        student_page.studentButton.click();
        student_page.allStudentsTag.click();
        student_page.searchStudentById.sendKeys(APIUtil.getResponseBody().getStudentId()+"");
        student_page.searchButton.click();
    }

    @Then("user verifies that student is created")
    public void user_verifies_that_student_is_created() {
      Assert.assertEquals("Student creation failed!",1,student_page.searchResultsName.size());
    }


}
