package me.Rokaz.BlueLight.core.IMessages;

import me.Rokaz.BlueLight.core.lib.messages.IInteractableMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class InteractableManager extends ListenerAdapter {
    private List<IInteractableMessage> messages;
    private JDA bot;
    public InteractableManager(JDA bot) {
        messages = new ArrayList<>();
        this.bot = bot;
        bot.addEventListener(this);
    }
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (!e.getMember().getUser().isBot()&&!messages.isEmpty()&& messages.parallelStream().anyMatch(message -> message.getMessage().getId().equals(e.getMessageId()))) {
            IInteractableMessage imessage = messages.stream().filter(message -> message.getMessage().getId().equals(e.getMessageId())).findFirst().orElse(null);
            imessage.getReactions().get(e.getReactionEmote().getEmoji()).executeReaction(imessage.getMessage(),e.getMember());
        }
    }
    public void onGuildMessageDelete(GuildMessageDeleteEvent e) {
        if (!messages.isEmpty()&& messages.parallelStream().anyMatch(message -> message.getMessage().getId().equals(e.getMessageId()))) {
            messages.remove(messages.stream().filter(message -> message.getMessage().getId().equals(e.getMessageId())).findFirst().orElse(null));
        }
    }
    public void addInteractableMessage(IInteractableMessage im) {
        messages.add(im);
    }
}
