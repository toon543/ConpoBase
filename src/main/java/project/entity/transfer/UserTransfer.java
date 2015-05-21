package project.entity.transfer;

import java.util.Map;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
public class UserTransfer {
    private final String name;

    private final Map<String, Boolean> roles;

    public UserTransfer(String name, Map<String, Boolean> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public Map<String, Boolean> getRoles() {
        return roles;
    }
}