package pl.iwona.modol2security.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.iwona.modol2security.service.ServiceImpl;

@RestController
public class ApiUser {

    private ServiceImpl serviceImpl;

    public ApiUser(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping("/admin")
    public String helloAdmin(Principal principal) {
        return serviceImpl.helloAdmin(principal);
    }

    @GetMapping ("/user")
    public String helloUser(Principal principal) {
        return serviceImpl.helloUser(principal);
    }

    @GetMapping ("/stranger")
    public String helloStranger(Principal principal) {
        return serviceImpl.helloStranger(principal);
    }

    @GetMapping ("/bye")
    public String byeBye() {
        return serviceImpl.byeBye();
    }
}
