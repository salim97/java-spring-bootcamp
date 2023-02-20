package com.pg1.pg1helloworldspringboot;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FirebaseController {
    @GetMapping("/welcome")
    public String welcome()
    {

        return "hello to Spring boot world!";
    }


    @PostMapping("/resetPassword")
    public Map<String, Object> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) throws FirebaseAuthException {

        // 1) prepare template for request language
        // 2) generate link
        // 3) send link using SMTP ( request email )

        /* // translate template according to request language
        I18n i18n = I18n.builder()
                .locale(resetPasswordDTO.getLanguageCode())
                .addDefaultResourceBundle("i18n/password-reset")
                .build();
        */

        ActionCodeSettings actionCodeSettings = ActionCodeSettings.builder()
                .setUrl("https://spinarena.net/reset-password" )
                .setHandleCodeInApp(true)
                .build();

        String link = FirebaseAuth.getInstance().generatePasswordResetLink(resetPasswordDTO.getEmail(), actionCodeSettings);

//        sendEmail(email, message, link); // Implement this method to send the email.


        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return response;

    }

    @ExceptionHandler(FirebaseAuthException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleFirebaseAuthException(FirebaseAuthException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("errorCode", e.getErrorCode());
        response.put("errorMessage", e.getMessage());
        return response;
    }
}
