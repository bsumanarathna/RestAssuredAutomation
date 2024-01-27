package api.endpoints;
import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.endpoints.routes.createUserURL;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


// This class is to create,read,update,delete methods
public class userendpoints {

    //These metheods are for user module
    //This method is to create user
    public static Response Createuser(user payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(createUserURL);
        return response;
    }

    //This method is to get user details
    public static Response ReadUser(String readUsername) {
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("username",readUsername)
                .when()
                .get(routes.readUserURL);
        return response;
    }

    //This method is to update the user
    public static Response Updateuser(String updateusername, user payload) {
        Response response = given()
                .pathParam("username", updateusername)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(routes.updateUserURL);
        return response;
    }

    //This method is to delete the user
    public static Response Deleteuser(String deleteusername) {
        Response response = given()
                .pathParam("username", deleteusername)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(routes.deleteUserURL);
        return response;

    }
}
