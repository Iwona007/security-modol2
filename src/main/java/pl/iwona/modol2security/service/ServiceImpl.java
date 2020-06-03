package pl.iwona.modol2security.service;


import java.security.Principal;
import org.springframework.stereotype.Service;
import pl.iwona.modol2security.confgure.AuthenticationSuccess;


@Service
public class ServiceImpl implements ServiceAuth {

    private AuthenticationSuccess authen;

    public ServiceImpl(AuthenticationSuccess authen) {
        this.authen = authen;
    }

    @Override
    public String helloAdmin(Principal principal) {
        return String.format("Hello admin: %s you are authenticated for: %d time",
                principal.getName(), authen.counterName(principal));
    }

    @Override
    public String helloUser(Principal principal) {
        return String.format("Hello user: %s you are authenticated for: %d time",
                principal.getName(), authen.counterName(principal));
    }

    @Override
    public String helloStranger(Principal principal) {
        if (principal != null) {
            return "Hello " + principal.getName();
        } else {
            return "Hello Stranger";
        }
    }
    @Override
    public String byeBye() {
        return "Bye bye";
    }
}
