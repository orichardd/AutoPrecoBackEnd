package richard.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import richard.demo.models.EmailRequest;
import richard.demo.models.EmailService;

@CrossOrigin(origins = {"https://autopreco.netlify.app/" , "https://autopreco.me/"})
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviar(@RequestBody EmailRequest request) {
        emailService.MandarEmail(
                request.getMessage(),
                request.getName(),
                request.getEmail()
        );

        return "Email enviado!";
    }
}
