package pl.iwona.modol2security.service;


import java.security.Principal;
import org.springframework.stereotype.Service;
import pl.iwona.modol2security.confgure.AuthenticationSuccess;


@Service
public class ServiceImpl {

  private AuthenticationSuccess authen;

    public ServiceImpl(AuthenticationSuccess authen) {
        this.authen = authen;
    }

    public String helloAdmin(Principal principal) {
        return String.format("Hello admin: %s zalogowaleś się po raz: %s", principal.getName(), authen.counterName(principal));
    }

    public String helloUser(Principal principal) {
        return String.format("Hello user: %s zalogowaleś się po raz: %s", principal.getName(), authen.counterName(principal));
    }

    public String helloStranger(Principal principal) {
        if (principal != null) {
            return "Hello " + principal.getName();
        } else {
            return "Hello Stranger";
        }
    }

    public String byeBye() {
        return "Bye bye";
    }
}
