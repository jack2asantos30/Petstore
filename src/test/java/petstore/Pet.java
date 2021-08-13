// 1 - Pacote
package petstore;

// 2 - Bibliotecas



import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// 3 - classe

public class Pet {
    // 3.1 - Atributos
    String uri = "https://petstore.swagger.io/v2/pet" ; // endereço da entidade Pet

    // 3.2 - Metodos e Funções
public String lerJson(String caminhoJson) throws IOException {
    return new String(Files.readAllBytes(Paths.get(caminhoJson)));
}

// Incluir - Create - Post
    @Test // Identifica o metodo ou função como um teste para o TestNG

public void incluirPet() throws IOException {
    String JsonBody = lerJson("db/pet1.json");


    // Sintaxe Gherkin
    // Dado - Quando - Então
    // Given -When - Then

        given()// Dado
                .contentType("application/json") // comum em API RESET - "antigos era txt/xml"
                .log().all()
                .body(JsonBody)
                .when() // Quando
                .post(uri)
                .then() // Então
                .log().all()
                .statusCode(200)
                .body("name", is ("Nina"))

                .body("status", is("available"))
        ;



 }

}

