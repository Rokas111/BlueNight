package me.Rokaz.BlueLight.core.lib.messages;

import me.Rokaz.BlueLight.core.lib.messages.reactions.ReactionExecutor;
import net.dv8tion.jda.api.entities.Message;

import java.util.HashMap;

public interface IInteractableMessage {
    HashMap<String, ReactionExecutor> getReactions();
    Message getMessage();
}
