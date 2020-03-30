
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.Body;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




/* Мне интересно познакомиться с обеими библиотеками, поэтому я сделаю 2 теста. Яндекс Translate через Unirest
и домашнее задание через Rest-assured. В качестве теста домашнего задания сделаю просто также создание
нового пользователя. А проверкой будет то, что в консоли выведется такое же сообщение, как в Postman. Т.е. сообщение
о том, что данный Email уже был создан.
 */

public class Test_API {

    @Test
    public void yandex() {

        try {

            HttpResponse<JsonNode> a = Unirest.get("https://translate.yandex.net/api/v1.5/tr.json/translate")
                    .queryString("key",
                            "trnsl.1.1.20200330T173123Z.52e65c991966452a.1ef17109bbc9594f7af84a7737c76573d3d49a7b")
                    .queryString("text", "Hände hoch!")
                    .queryString("lang", "de-ru").asJson();
            //Assertions.assertEquals(201,a.getStatus());
            System.out.println(a.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void gorest() {
        Response b=
                (Response) RestAssured.given().baseUri("https://gorest.co.in")
                        .basePath("public-api")
                        .header("Authorization","Bearer LS-SDXguT8eSKP58TZ6yMT6wZpit93MDZcpp")
                        .param("email","rzn.popov@gmail.com")
                .param("first_name", "Ivan")
                         .param("last_name","Popov")
                         .param("gender","male")
                         .param("status", "active")
                .post("/users");
        b.getBody().prettyPrint();
    }
// После выполнения этого задания, я теперь лично понял, что мне тоже больше по душе RestAssured
}
