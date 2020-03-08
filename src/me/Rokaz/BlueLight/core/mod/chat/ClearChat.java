package me.Rokaz.BlueLight.core.mod.chat;

import me.Rokaz.BlueLight.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueLight.core.cmd.embeds.WrongArgsEmbed;
import me.Rokaz.BlueLight.core.lib.command.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Arrays;
import java.util.List;

public class ClearChat extends Command {
    public ClearChat() {
        super(RequiredPermission.MANAGER,Arrays.asList("<Number Of Messages>"), "clearchat");
    }
    public void run(Message m, String enteredCmd, String[] args) {
        if (args == null || args.length == 0) {
            new WrongArgsEmbed(enteredCmd, getUsages()).send(m.getTextChannel());
            return;
        }
        if (!NumberUtils.isParsable(args[0])) {
            new PopUpEmbed("You must specify a number").send(m.getTextChannel());
            return;
        }
        MessageHistory h = new MessageHistory(m.getTextChannel());
        List<Message> messages = h.retrievePast(Integer.parseInt(args[0])).complete();
        messages.remove(m);
        m.getTextChannel().deleteMessages(messages).queue();
    }
}
