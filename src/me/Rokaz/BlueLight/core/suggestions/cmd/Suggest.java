package me.Rokaz.BlueLight.core.suggestions.cmd;

import me.Rokaz.BlueLight.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueLight.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueLight.core.lib.command.Command;
import me.Rokaz.BlueLight.core.suggestions.SuggestionManager;
import me.Rokaz.BlueLight.core.suggestions.embeds.SuggestEmbed;
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
