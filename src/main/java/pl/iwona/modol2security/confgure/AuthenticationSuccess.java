package pl.iwona.modol2security.confgure;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccess {

    private Map<String, Integer> counterMap = new HashMap<>();

    @EventListener(AuthenticationSuccessEvent.class)
    public void processAuthenticationSuccessEvent(AbstractAuthenticationEvent event) {
        User name = ((User) event.getAuthentication().getPrincipal());
    }

    public int counterName(Principal principal) {
        String username = principal.getName();
        Integer licznik = (Integer) counterMap.get(username);
        if (licznik == null) {
            licznik = 0;
        }
        licznik++;
        counterMap.put(username, licznik);
        return licznik;
    }
}
