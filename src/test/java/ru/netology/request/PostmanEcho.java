package ru.netology.request;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEcho {
    @Test
    void shouldPostRequest() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("some data"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11)"));
    }
}