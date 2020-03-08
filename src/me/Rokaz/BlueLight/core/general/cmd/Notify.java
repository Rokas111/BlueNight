package me.Rokaz.BlueLight.core.general.cmd;

import me.Rokaz.BlueLight.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueLight.core.lib.command.Command;
import me.Rokaz.BlueLight.core.lib.roles.Role;
import net.dv8tion.jda.api.entities.Message;

import java.util.Arrays;

public class Notify extends Command {

    public Notify() {
        super(RequiredPermission.MEMBER, Arrays.asList(""),"notify");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (m.getMember().getRoles().parallelStream().anyMatch(role -> role.getId().equals(Role.NOTIFY.getID()))) {
            m.getGuild().removeRoleFromMember(m.getMember(),m.getGuild().getRoleById(Role.NOTIFY.getID())).queue();
            new PopUpEmbed("You will no longer be notificated").send(m.getTextChannel());
            return;
        }
        m.getGuild().addRoleToMember(m.getMember(),m.getGuild().getRoleById(Role.NOTIFY.getID())).queue();
        new PopUpEmbed("You will now be notificated").send(m.getTextChannel());
    }
}
