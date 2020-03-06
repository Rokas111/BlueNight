package me.Rokaz.BlueCraft.core.help.cmd;

import me.Rokaz.BlueCraft.core.help.embeds.SelectorHelpEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import net.dv8tion.jda.api.entities.Message;

import java.util.Arrays;

public class Help extends Command {
    public Help() {
        super(RequiredPermission.MEMBER, Arrays.asList(""),"help");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        new SelectorHelpEmbed().send(m.getTextChannel());
    }
}
