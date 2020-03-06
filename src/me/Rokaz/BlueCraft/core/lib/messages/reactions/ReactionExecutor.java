package me.Rokaz.BlueCraft.core.lib.messages.reactions;

import net.dv8tion.jda.api.entities.Message;

public interface ReactionExecutor {
    void executeReaction(Message m);
}
