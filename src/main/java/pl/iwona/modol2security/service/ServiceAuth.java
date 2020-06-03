package pl.iwona.modol2security.service;

import java.security.Principal;

public interface ServiceAuth {

    String helloAdmin(Principal principal);

    String helloUser(Principal principal);

    String helloStranger(Principal principal);

    String byeBye();
}
