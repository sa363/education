package ru.itfb.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class ProductsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    @Sql("/sql/t_product.sql")
    void findProduct_ProductExists_ReturnsProductsList() throws Exception{
        //given
        var requestBuilder = MockMvcRequestBuilders.get("/api/products/cb4418cd-bf1b-45c8-8033-b317bf996623");
        //when
        this.mockMvc.perform(requestBuilder)
                //then
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""
                                {
                                  "id": "cb4418cd-bf1b-45c8-8033-b317bf996623",
                                  "depricated": false,
                                  "title": "Первый продукт",
                                  "details": "Описание первого продукта"
                                }
                                """)
                );
    }

    @Test
    void findProduct_ProductDoesNotExist_ReturnsNotFound() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.get("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d1");
        // when
        this.mockMvc.perform(requestBuilder)
        // then
                .andDo(print())
                .andExpectAll(
                        status().isNotFound()
                );
    }

    @Test
    @Sql("/sql/t_product.sql")
    void updateProduct_RequestIsValid_ReturnsNoContent() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.patch("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d0")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "Новое название",
                            "details": "Новое описание"
                        }""");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isNoContent()
                );
    }

    @Test
    @Sql("/sql/t_product.sql")
    void updateProduct_RequestIsInvalid_ReturnsBadRequest() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.patch("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d0")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "   ",
                            "details": null
                        }""");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_PROBLEM_JSON),
                        content().json("""
                                {
                                    "errors": [
                                    {
                                    "defaultMessage": "must not be blank"
                                    }
                                    ]
                                }""")
                );
    }

    @Test
    void updateProduct_ProductDoesNotExist_ReturnsNotFound() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.patch("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "Новое название",
                            "details": "Новое описание"
                        }""");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isNotFound()
                );
    }

    @Test
    @Sql("/sql/t_product.sql")
    void deleteProduct_ProductExists_ReturnsNoContent() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.delete("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d0");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isNoContent()
                );
    }
    @Test
    void deleteProduct_ProductDoesNotExist_ReturnsNotFound() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.delete("/api/products/e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d1");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isNotFound()
                );
    }

    @Test
    void createProduct_RequestIsValid_ReturnsNewProduct() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"title": "Ещё один новый товар", "details": "Какое-то описание нового товара"}""");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isCreated(),
//                        header().string(HttpHeaders.LOCATION, "http://localhost/api/products/1"),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        content().json("""
                                {
                                    "title": "Ещё один новый товар",
                                    "details": "Какое-то описание нового товара"
                                }
                                """));
    }
    @Test
    void createProduct_RequestIsInvalid_ReturnsBadRequest() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"title": "    ", "details": "Какое-то описание нового товара"}""");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_PROBLEM_JSON),
                        content().json("""
                                {
                                    "errors": [
                                    {
                                    "defaultMessage": "must not be blank"
                                    }
                                    ]
                                }"""));
    }

    @Test
    @Sql("/sql/t_product.sql")
    void findProducts_ReturnsProductsList() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.get("/api/products")
                .param("filter", "продукт");

        // when
        this.mockMvc.perform(requestBuilder)
                // then
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        content().json("""
                                [
                                    {
                                       "id": "cb4418cd-bf1b-45c8-8033-b317bf996623",
                                       "depricated": false,
                                       "title": "Первый продукт",
                                       "details": "Описание первого продукта"
                                    },
                                    {
                                        "id": "26c728f8-7189-4bd2-a13e-49de68d20d6c",
                                        "depricated": false,
                                        "title": "Второй продукт",
                                        "details": "Описание второго продукта"
                                    },
                                    {
                                        "id": "b701aaf7-09f4-4d4e-8181-b3cf23a8a017",
                                        "depricated": false,
                                        "title": "Третий продукт",
                                        "details": "Описание третьего продукта"
                                    },
                                    {
                                        "id": "e7c20fd3-b2f8-400e-b77f-fb7fdc6b39d0",
                                        "depricated": false,
                                        "title": "Четвертый продукт",
                                        "details": "Описание четвертого продукта"
                                    }
                                ]""")
                );
    }




}