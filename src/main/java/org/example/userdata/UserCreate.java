package org.example.userdata;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UserCreate {

    private final String URL = "https://stellarburgers.nomoreparties.site/";

    private final String CREATE_API_ENDPOINT = "api/auth/register";

    private final String DELETE_API_ENDPOINT = "api/auth/user";
    private final String AUTHORIZATION_API_ENDPOINT = "api/auth/login";

    // Создаем пользователя
    public ValidatableResponse createUser (User user){
            return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .body(user)
                .when()
                .post(CREATE_API_ENDPOINT)
                .then().log().all();
    }

    public String successCreate(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(200)
                .extract().path("accessToken");
    }


    public ValidatableResponse successfulAuthorization(IncompleteUser incompleteUser) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .body(incompleteUser)
                .when()
                .post(AUTHORIZATION_API_ENDPOINT)
                .then().log().all();
    }

    public String successfulAuthorization(ValidatableResponse response){
       return response.assertThat()
                .statusCode(200)
                .extract().path("accessToken");
    }





    public void deleteUser(String accessToken){
         given().log().all()
                .contentType(ContentType.JSON)
                .headers("Authorization", accessToken)
                .baseUri(URL)
                .when()
                .delete(DELETE_API_ENDPOINT)
                .then().log().all();
    }
}
