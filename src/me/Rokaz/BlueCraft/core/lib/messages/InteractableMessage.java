package me.Rokaz.BlueCraft.core.lib.messages;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public abstract class InteractableMessage extends CustomEmbed implements IInteractableMessage {
    private Message m;
    public InteractableMessage(boolean deleteAfter,int customTime) {
        super(customTime,deleteAfter);
        BlueCraft.im.addInteractableMessage(this);
    }
    @Override
    public Message send(TextChannel t) {
        Message m = super.send(t);
        getReactions().keySet().forEach(unicode -> m.addReaction(unicode).queue());
        this.m = m;
        return m;
    }
    public Message getMessage() {
        return this.m;
    }
}
