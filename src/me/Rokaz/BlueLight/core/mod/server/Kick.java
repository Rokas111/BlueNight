package me.Rokaz.BlueLight.core.mod.server;

import me.Rokaz.BlueLight.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueLight.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueLight.core.lib.command.Command;
import me.Rokaz.BlueLight.core.mod.ModManager;
import me.Rokaz.BlueLight.core.mod.embeds.server.KickEmbed;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Kick extends Command {
    public Kick() {
        super(RequiredPermission.MANAGER, Arrays.asList("<Player> [Reason]"),"kick");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (args == null || args.length < 2) {
            new WrongArgsEmbed(enteredCmd, getUsages()).send(m.getTextChannel());
            return;
        }
        if (m.getMentionedMembers().isEmpty()) {
            new PopUpEmbed("You must mention a member").send(m.getTextChannel());
            return;
        }
        new KickEmbed(m.getMentionedMembers().get(0).getUser(),m.getAuthor(), StringUtils.join(Arrays.asList(args).subList(1,args.length)," ")).send(m.getGuild().getTextChannelById(ModManager.PUNISHMENT_LOG));
        m.getGuild().kick(m.getMentionedMembers().get(0)).queue();
    }
}
