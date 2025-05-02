package com.pioneers.rest.controller;

import com.pioneers.rest.model.dto.StudentSignupDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    // Pass variable by Path Variable
    @GetMapping("{name}/{age}/{address}")
    public String welcomeStudentWithPathVariableApi(
            @PathVariable(value = "name") String theName,
            @PathVariable Integer age,
            @PathVariable String address
    ) {
        return "<h1>Welcome " + theName + " to Tech Pioneers Hub!\n Age = " + age + "\nAddress = " + address + "</h1>";
    }

    // Pass variable by Request Param
    // Adding password her is a bad practice because it's a public in the URL.
    @GetMapping("studentWithRequestParam")
    public String welcomeStudentWithRequestParamApi(
            @RequestParam String name,
            @RequestParam Integer age,
            @RequestParam String address,
            @RequestParam String password
    ) {
        return "<h1>Welcome " + name + " to Tech Pioneers Hub!, Age = " + age + ", Address = "
                + address + ", Password = " + password + "</h1>";
    }

    // Pass variable by Request Body
    @GetMapping("studentWithRequestBody")
    public String welcomeStudentWithRequestBodyApi(@RequestBody StudentSignupDto studentSignupDto) {
        return "<h1>Welcome " + studentSignupDto.getName() + " to Tech Pioneers Hub!, Age = " +
                studentSignupDto.getAge() + ", Address = " + studentSignupDto.getAddress() + ", Password = " +
                studentSignupDto.getPassword() + "</h1>";
    }
}
