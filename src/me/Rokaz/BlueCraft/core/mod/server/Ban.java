package me.Rokaz.BlueCraft.core.mod.server;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import me.Rokaz.BlueCraft.core.mod.ModManager;
import me.Rokaz.BlueCraft.core.mod.embeds.server.BanEmbed;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Ban extends Command {
    public Ban() {
        super(RequiredPermission.MANAGER,Arrays.asList("<Player> [Reason]"), "ban");
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
        new BanEmbed(m.getMentionedMembers().get(0).getUser(),m.getAuthor(), StringUtils.join(Arrays.asList(args).subList(1,args.length)," ")).send(m.getGuild().getTextChannelById(ModManager.PUNISHMENT_LOG));
        m.getGuild().ban(m.getMentionedMembers().get(0),7).queue();
    }
}
