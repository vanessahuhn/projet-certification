/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vanessa
 */
public class FixtureControllerTest {

    @BeforeClass

    public static void init() {

        RestAssured.baseURI = "http://localhost";

        RestAssured.port = 8080;

    }

    @Test

    public void testFixtureFetchesSuccess() {

        /*get("/api/fixtures/1")
                .then()
                .body("id", equalTo(12))
                .body("firstName", equalTo("Vinod"))
                .body("lastName", equalTo("Kashyap"))
                .body("designation", equalTo("CEO"));*/

    }

}
