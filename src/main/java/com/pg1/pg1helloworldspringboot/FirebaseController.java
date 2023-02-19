package com.pg1.pg1helloworldspringboot;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirebaseController {
    @GetMapping("/welcome")
    public String welcome()
    {

        return "hello to Spring boot world!";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        return resetPasswordDTO.getEmail();
    }
}
