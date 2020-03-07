package me.Rokaz.BlueCraft.core.lib.roles;

import net.dv8tion.jda.api.entities.Member;

import java.util.ArrayList;
import java.util.List;

public enum Role {
    NOTIFY("685832068940562526"),
    MUTED("684149406072569868"),
    MEMBER("683406698571890736"),
    FREELANCER("684088592670261250"),
    MANAGER("683439586046902355"),
    FOUNDER("684088666783744059");
    private String id;
    private Role(String id) {
        this.id = id;
    }
    public String getID() {
        return this.id;
    }
    public static List<Role> getRoles(Member m) {
        List<Role> roles = new ArrayList<>();
        for (Role r :Role.class.getEnumConstants()) {
            if (m.getRoles().parallelStream().anyMatch(role -> role.getId().equals(r.getID()))) {
                roles.add(r);
            }
        }
        return roles;
    }
}
