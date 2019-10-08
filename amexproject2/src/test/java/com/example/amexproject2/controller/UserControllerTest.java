package com.example.amexproject2.controller;

import com.example.amexproject2.config.JwtUtil;
import com.example.amexproject2.model.User;
import com.example.amexproject2.service.UserProfileService;
import com.example.amexproject2.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

// tells jUnit to run using Spring's testing support
@RunWith(SpringRunner.class)

// used for auto-configuring Spring MVC and Jackson converters.
// it loads relevant components such as @Controller, @RestController, etc. and configures MockMvc.
@WebMvcTest(UserController.class)
public class UserControllerTest {

    /**Main entry point for server-side Spring MVC test support.**/
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

//    @MockBean
//    private UserProfileService userProfileService;
//
//    @Autowired
//    UserProfileService userProfileService;

    // this JSON security mock bean is here because we are testing how it handles our requests
    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private User user;

    // ================== LOGIN TEST ===============================

    @Test
    public void login_Success() throws Exception{

        // mimics our post request
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("Dwight","schrute"));

        // if success return scranton
        when(userService.login(any())).thenReturn("scranton");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                // we know we are successful if returns NYC
                .andExpect(content().json("{\"token\":\"scranton\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    // ================== TEST SIGN UP ===============================
    @Test
    public void signUp_Success() throws Exception{

        // mimics our post request
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                //.content(createUserInJson("joe","abc"));
                .content(createUserSignUpInJson("Michael","scott", "mscott@dm.com"));


        // if success return paper
        when(userService.createUser(any())).thenReturn("paper");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                // we know we are successful if returns paper
                .andExpect(content().json("{\"token\":\"paper\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

//    // ================== TEST CREATE PROFILE ===============================
//    @Test
//    public void createProfile_Success() throws Exception {
//        user.setUsername("pam");
//        user.setPassword("ilovejim");
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/user/profile/pam")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content((createProfileInJson("570-343-3400", "Scranton, PA", "pamh@df.com")));
//
//        when(userProfileService.createUserProfile(user.getUsername(), createProfileInJson()))
//
//
//
//    }
    // ================== MOCK METHODS ===============================

    private static String createUserInJson (String username, String password) {
        return "{ \"username\": \"" + username + "\", " +
                "\"password\":\"" + password + "\"}";
    }

    private static String createUserSignUpInJson(String username, String password, String email) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("username",  username );
        obj.put("password", password);
        obj.put("email", email);

        return obj.toString();
    }

    private static String createProfileInJson(String mobile, String address, String altEmail) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("mobile", mobile);
        obj.put("address", address);
        obj.put("altEmail", altEmail);

        return obj.toString();

    }


}