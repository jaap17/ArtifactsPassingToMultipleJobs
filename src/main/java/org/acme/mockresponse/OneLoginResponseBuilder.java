package org.acme.mockresponse;

import javax.json.Json;
import javax.json.JsonArray;

/**
 * Builds response of the OneLogin events API.
 */
public class OneLoginResponseBuilder {

    /**
     * Returns a list of mock events.
     *
     * @return  JsonArray
     */
    public static JsonArray getMockResponse() {
        var jsonObjectOne = Json.createObjectBuilder()
                .add("user_id", 174676981)
                .add("user_attributes_account_id", 208137)
                .add("user_attributes_firstname", "TEST")
                .add("user_attributes_username", "TEST")
                .add("user_attributes_email", "anitized@sanitized.com")
                .add("user_attributes_lastname", "TEST")
                .add("user_attributes_title", "Title")
                .add("user_name", "User name")
                .add("account_id", 208137)
                .add("event_timestamp", "2022-06-23 12:47:05 UTC")
                .add("ipaddr", "55.55.55.55")
                .add("notes", "Authentication method: password (invalid password).")
                .build();

        var jsonObjectTwo = Json.createObjectBuilder()
                .add("user_id", 174676981)
                .add("user_name", "User name")
                .add("uuid", "ef43facd-59b9-4414-9f42-70954af99f53")
                .add("account_id", 208137)
                .add("event_timestamp", "2022-06-23 12:48:35 UTC")
                .add("ipaddr", "147.161.249.109")
                .add("event_type_id", 7)
                .build();

        var jsonObjectThree = Json.createObjectBuilder()
                .add("app_name", "Accellion")
                .add("app_id", 1729171)
                .add("role_name", "test")
                .add("role_id", 560805)
                .add("uuid", "debca8d3-2be4-461f-904d-b8e25693fd9c")
                .add("account_id", 208137)
                .add("event_timestamp", "2022-06-23 12:48:35 UTC")
                .add("actor_user_name", "Test User")
                .add("actor_user_id", 174676981)
                .build();

        var jsonObjectFour = Json.createObjectBuilder()
                .add("role_name", "test")
                .add("role_id", 560805)
                .add("user_id", 174676981)
                .add("user_name", "User name")
                .add("uuid", "debca8d3-2be4-461f-904d-b8e25693fd9c")
                .add("account_id", 208137)
                .add("event_timestamp", "2022-06-23 12:48:35 UTC")
                .add("event_type_id", 1801)
                .add("actor_user_id", 174676981)
                .build();

        return Json.createArrayBuilder()
                .add(jsonObjectOne)
                .add(jsonObjectTwo)
                .add(jsonObjectThree)
                .add(jsonObjectFour)
                .build();
    }
}
