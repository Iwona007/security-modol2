package pl.iwona.modol2security.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;

@Service
public class Counter {

    private Map<String, Integer> counterMap;

    public Counter() {
        this.counterMap = new HashMap<>();
        counterMap.put("user", 0);
        counterMap.put("admin", 0);
    }

    @EventListener
    public void authentication(AuthenticationSuccessEvent authenticationSuccessEvent) {
        countNameLog(authenticationSuccessEvent.getAuthentication().getName());
    }

    public void countNameLog(String name) {
        Integer counter = counterMap.get(name);
        countName(name, counter);
    }

    private void countName(String name, Integer counter) {
        if (counter != null) {
            counter++;
            counterMap.put(name, counter);
        } else {
            counterMap.put(name, 1);
        }
    }

    public Integer getCounter(String name) {
        return counterMap.get(name);
    }
}
