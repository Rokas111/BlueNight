package me.Rokaz.BlueCraft.core.lib.command;

import me.Rokaz.BlueCraft.core.lib.roles.Role;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

import java.util.List;

public interface ICommand {
    List<String> getAliases();
    List<String> getUsages();
    RequiredPermission getPermission();
    void run(Message m, String enteredCmd, String[] args);
    enum RequiredPermission {
        MEMBER(1, Role.MEMBER),
        FREELANCER(2,Role.FREELANCER),
        MANAGER(3,Role.MANAGER),
        FOUNDER(4,Role.FOUNDER);
        private Role role;
        private Integer id;
        private RequiredPermission(Integer id, Role role) {
            this.role = role;
            this.id = id;
        }
        public Role getRole() {
            return this.role;
        }
        public Integer getID() {
            return this.id;
        }
        public boolean hasRequiredPermission(Member m) {
            RequiredPermission pr = null;
            for (RequiredPermission r : RequiredPermission.class.getEnumConstants()) {
                if (Role.getRoles(m).contains(r.getRole()) &&(pr == null || pr.getID() <= r.getID())) {
                    pr = r;
                }
            }
            return getID() <= pr.getID();
        }
    }
}
