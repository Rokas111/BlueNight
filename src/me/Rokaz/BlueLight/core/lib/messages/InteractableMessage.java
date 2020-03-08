package me.Rokaz.BlueLight.core.lib.messages;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.lib.embed.custom.CustomEmbed;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public abstract class InteractableMessage extends CustomEmbed implements IInteractableMessage {
    private Message m;
    public InteractableMessage(boolean deleteAfter) {
        super(deleteAfter);
        BlueLight.im.addInteractableMessage(this);
    }
    public InteractableMessage(boolean deleteAfter,int customTime) {
        super(customTime,deleteAfter);
        BlueLight.im.addInteractableMessage(this);
    }
    @Override
    public Message send(TextChannel t) {
        Message m = super.send(t);
        getReactions().keySet().forEach(unicode -> m.addReaction(unicode).complete());
        this.m = m;
        return m;
    }
    public Message getMessage() {
        return this.m;
    }
}
