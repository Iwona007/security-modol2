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

    private Map<String, Integer> counterMap;

    public AuthenticationSuccess() {
        this.counterMap = new HashMap<>();
    }

    @EventListener(AuthenticationSuccessEvent.class)
    public void processAuthenticationSuccessEvent(AbstractAuthenticationEvent event) {
        User name = ((User) event.getAuthentication().getPrincipal());
        Integer counter = 1;
        counterMap.put(name.getUsername(), counter);
        for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    public int counterName(Principal principal) {
//        String username = principal.getName();
//        Integer counter = (Integer) counterMap.get(username);
//        if (counter == null) {
//            counter = 0;
//        }
//        counter++;
////        counterMap.put(username, counter);
//        return counter;

        return   counterMap.entrySet().stream()
                .filter(userMap -> userMap.getKey().equals(principal.getName()))
                .mapToInt(Map.Entry::getValue).findFirst().orElse(0);

    }
}
