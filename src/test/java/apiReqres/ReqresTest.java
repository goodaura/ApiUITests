package apiReqres;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    /**
     * 1. Get a list of users from the second page on the site https://reqres.in/
     * 2. Make sure that the user id is contained in their avatar;
     * 3. Make sure that users email end with "@reqres.in";
     */

    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarIdEmail(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        //Method 1: Compare values directly from class instances
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data",UserData.class);

        //Avatar name contains id
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        //Emails end with "@reqres.in"
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        //Method 2: comparison through getting lists
        //Avatar list
        List<String> realPeopleAvatars  = users.stream()
                .map(UserData::getAvatar)
                .collect(Collectors.toList());
        //Id list
        List<String> realPeopleIds = users.stream()
                .map(x->x.getId().toString())
                .collect(Collectors.toList());
        //Comparison
        for (int i = 0; i<realPeopleAvatars.size(); i++){
            Assertions.assertTrue(realPeopleAvatars.get(i).contains(realPeopleIds.get(i)));
        }
    }

    /**
     *
     * Successful registration in https://reqres.in/
     */
    @Test
    public void successRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessRegistration successRegistration = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegistration.class);
        //Check answer is not empty
        Assert.assertNotNull(successRegistration.getId());
        Assert.assertNotNull(successRegistration.getToken());
        //Compare
        Assert.assertEquals(id, successRegistration.getId());
        Assert.assertEquals(token, successRegistration.getToken());
    }

    /**
     * Unsuccessful registration - password not entered - in https://reqres.in/
     */
    @Test
    public void unSuccessRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseError400());
        Register user = new Register("sydney@fife", "");
        UnsuccessRegistration unsuccessRegistration = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessRegistration.class);
        Assert.assertEquals("Missing password", unsuccessRegistration.getError());
    }

}
