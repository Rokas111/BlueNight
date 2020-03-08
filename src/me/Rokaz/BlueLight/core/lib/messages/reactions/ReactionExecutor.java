package me.Rokaz.BlueLight.core.lib.messages.reactions;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;

public interface ReactionExecutor {
    void executeReaction(Message m, Member p);
}
