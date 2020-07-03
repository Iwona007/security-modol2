package pl.iwona.modol2security.service;


import java.security.Principal;
import org.springframework.stereotype.Service;


@Service
public class ServiceImpl implements ServiceAuth {

    private Counter authen;

    public ServiceImpl(Counter authen) {
        this.authen = authen;
    }

    @Override
    public String helloAdmin(Principal principal) {
        return String.format("Hello admin: %s you are authenticated for: %d time",
                principal.getName(), authen.getCounter(principal.getName()));
//                principal.getName(), authen.counterName(principal.getName()));
    }

    @Override
    public String helloUser(Principal principal) {
//        return String.format("Hello user: %s you are authenticated for: %d time",
//                principal.getName(), authen.search(principal.getName()));
        return "Hello user: " + principal.getName() + " zalogowałeś się razy " + authen.getCounter(principal.getName());
//        return "Hello user: " + principal.getName() + " zalogowałeś się razy " + authen.counterName(principal.getName());
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
