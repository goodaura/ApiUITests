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
        //Method 1: Compare values directly from class instances
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"api/users?page=2")
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
}
