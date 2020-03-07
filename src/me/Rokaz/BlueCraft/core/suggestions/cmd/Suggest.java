package me.Rokaz.BlueCraft.core.suggestions.cmd;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueCraft.core.lib.command.Command;
import me.Rokaz.BlueCraft.core.suggestions.SuggestionManager;
import me.Rokaz.BlueCraft.core.suggestions.embeds.BugEmbed;
import me.Rokaz.BlueCraft.core.suggestions.embeds.SuggestEmbed;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Suggest extends Command {
    public Suggest() {
        super(RequiredPermission.MEMBER, Arrays.asList("<Title> [Description]") ,"suggest");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (!m.getTextChannel().getId().equals(SuggestionManager.CREATOR_CHANNEL_ID)) {
            new PopUpEmbed("You must put the suggestion in the suggestion-bug creator channel").send(m.getTextChannel());
            return;
        }
        if (args == null || args.length == 0) {
            new WrongArgsEmbed(enteredCmd,getUsages()).send(m.getTextChannel());
            return;
        }
        new SuggestEmbed(m.getAuthor(),args[0], StringUtils.join(Arrays.asList(args).subList(1,args.length)," ")).send(m.getGuild().getTextChannelById(SuggestionManager.SUGGESTION_CHANNEL_ID));
    }
}
