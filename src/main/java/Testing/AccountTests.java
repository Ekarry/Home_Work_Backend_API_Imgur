package Testing;


public class AccountTests {
    @Test
    void getAccountInfoTest() {
        given()
                .header("Authorization", token)
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200);
    }
    @Test
    void getAccountInfoWithLoggingTest() {
        given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c" )
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void getAccountInfoWithAssertionsInGivenTest() {
        given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c" )
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .body("data.url", equalTo(username))
                .body("success", equalTo(true))
                .body("status",equalTo(200))
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();
    }
    @Test
    void getAccountInfoWithAssertionsAfterTest() {
        Response response = given()
                .header("Authorization","Bearer ed7328187fb5c0a24092507ce0415ab1a5f8f55c" )
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();
        assertThat(response.jsonPath().get("data.url"), equalTo(username));
    }

}