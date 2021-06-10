import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RestAssured {

    String Token=" Bearer BQCGexS5fBQcn1D71Ir_9s0HKg8imqvns6FOhj7GyxWatL-nm4-2l8MM8PVYZ7HkTbQ5DAQseUPrve091TRrMNyR2w2bOM3W-uX9mUu8EZpPDqYddP-TE8tP6fEkNtZCvvu579KN1xK0t9Ej1uOiWeDNS5wKSYBqdae3lERjyI2OJrvdVL9pBLjntdvIS7UESUvLBHZvy5EbpS62XpwXVrqAFiO_UH9rIoh016nEKtYG24t3zcpLC_7I6N4DtnABMfTtXpzJbmA7iH5kseIOKhaNX3Q0pSbPpTv4wLum";
    String key="Authorization";
    @Test
    public void Get(){

        String URL="https://api.spotify.com/v1/me/playlists/";
        given().header(key,Token)
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void Post(){
        String URL="https://api.spotify.com/v1/users/39wgj4bg8cnhyqvvjboxietta/playlists";

        JSONObject json=new JSONObject();

        json.put("name","New playlist2");
        json.put("description","demo playlist");
        json.put("public",false);


        given().header(key,Token)
                .header("Content-Type","application/json")
                .body(json.toString())
                .when()
                .post(URL)
                .then()
                .assertThat()
                .statusCode(201);
    }
    @Test
    public void AddItemsInPlaylist(){
        String URL="https://api.spotify.com/v1/playlists/5F7qTBYpaPGYJ0eXAhnwMY/tracks?uris=spotify%3Atrack%3A77y2yW2spk3HCkZXjlbhCD";
        String URI="spotify%3Atrack%3A3TaoFBplKZB4AclYV2cDwT";

        given().header(key,Token)
                .header("Content-Type","application/json")
                .when()
                .post(URL)
                .then()
                .assertThat();
                //.statusCode(201);
    }
    @Test
    public void DeleteTrack(){
        String URL="https://api.spotify.com/v1/playlists/5F7qTBYpaPGYJ0eXAhnwMY/tracks";

        JSONObject json =new JSONObject();
        json.put("tracks","[{\"uri\":\"spotify:track:7bWIRK3emiP8UwH6fpDfuu\",\"positions\":[0]}]");

        given().header(key,Token)
                .header("Content-Type","application/json")
                .body(json.toString())
                .when()
                .post(URL)
                .then()
                .assertThat();
                //.statusCode(200);



    }


}


