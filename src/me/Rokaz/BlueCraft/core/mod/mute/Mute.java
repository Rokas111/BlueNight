package me.Rokaz.BlueCraft.core.mod.mute;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import me.Rokaz.BlueCraft.core.mod.ModManager;
import me.Rokaz.BlueCraft.core.mod.embeds.mute.MuteEmbed;
import me.Rokaz.BlueCraft.core.lib.roles.Role;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Mute extends Command {
    public Mute() {
        super(RequiredPermission.MANAGER, Arrays.asList("<Player> <Hours> [Reason]"), "mute");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (args == null || args.length < 3) {
            new WrongArgsEmbed(enteredCmd, getUsages()).send(m.getTextChannel());
            return;
        }
        if (m.getMentionedMembers().isEmpty()) {
            new PopUpEmbed("You must mention a member").send(m.getTextChannel());
            return;
        }

        new MuteEmbed(m.getMentionedMembers().get(0).getUser(),m.getAuthor(), StringUtils.join(Arrays.asList(args).subList(2,args.length)," "),Integer.parseInt(args[1])).send(m.getGuild().getTextChannelById(ModManager.PUNISHMENT_LOG));
        m.getGuild().addRoleToMember(m.getMember(),m.getGuild().getRoleById(Role.MUTED.getID())).queue();
        m.getGuild().removeRoleFromMember(m.getMember(),m.getGuild().getRoleById(Role.MUTED.getID())).queueAfter(Integer.parseInt(args[1]), TimeUnit.HOURS);
    }
}
