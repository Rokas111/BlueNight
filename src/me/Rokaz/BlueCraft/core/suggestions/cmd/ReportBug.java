package me.Rokaz.BlueCraft.core.suggestions.cmd;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import me.Rokaz.BlueCraft.core.suggestions.SuggestionManager;
import me.Rokaz.BlueCraft.core.suggestions.embeds.BugEmbed;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class ReportBug extends Command {
    public ReportBug() {
        super(RequiredPermission.MEMBER, Arrays.asList("[Description]") ,"reportbug");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (!m.getTextChannel().getId().equals(SuggestionManager.CREATOR_CHANNEL_ID)) {
            new PopUpEmbed("You must report the bug in the suggestion-bug creator channel").send(m.getTextChannel());
            return;
        }
        if (args == null || args.length == 0) {
            new WrongArgsEmbed(enteredCmd,getUsages()).send(m.getTextChannel());
            return;
        }
        new BugEmbed(m.getAuthor(), StringUtils.join(Arrays.asList(args)," ")).send(m.getGuild().getTextChannelById(SuggestionManager.BUG_CHANNEL_ID));
    }
}
