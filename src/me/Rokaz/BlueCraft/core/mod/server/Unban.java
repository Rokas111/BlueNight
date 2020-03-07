package me.Rokaz.BlueCraft.core.mod.server;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import me.Rokaz.BlueCraft.core.lib.command.ICommand;
import me.Rokaz.BlueCraft.core.mod.ModManager;
import me.Rokaz.BlueCraft.core.mod.embeds.server.UnbanEmbed;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Unban extends Command {
    public Unban() {
        super(ICommand.RequiredPermission.MANAGER,Arrays.asList("<PlayerName>"), "unban");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (args == null || args.length < 1) {
            new WrongArgsEmbed(enteredCmd, getUsages()).send(m.getTextChannel());
            return;
        }
        m.getGuild().retrieveBanList().queue(bans -> {
            if (bans.isEmpty() || bans.stream().filter(ban -> ban.getUser().getName().toLowerCase().equals(args[0].toLowerCase())).collect(Collectors.toList()).isEmpty()) {
                new PopUpEmbed("The specified player is not banned").send(m.getTextChannel());
                return;
            }
            User unbannedUser = bans.stream().filter(ban -> ban.getUser().getName().toLowerCase().equals(args[0].toLowerCase())).map(Guild.Ban::getUser).collect(Collectors.toList()).get(0);
            new UnbanEmbed(unbannedUser,m.getAuthor()).send(m.getGuild().getTextChannelById(ModManager.PUNISHMENT_LOG));
            m.getGuild().unban(unbannedUser).queue();
        });
    }
}
