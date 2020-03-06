package me.Rokaz.BlueCraft.core.lib.embed.custom;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public abstract class CustomEmbed implements ICustomEmbed {
    private static final int REMAIN_TIME_SECONDS = 4;
    private boolean deleteAfter;
    private int time;
    public CustomEmbed(boolean deleteAfter) {
        this.deleteAfter = deleteAfter;
        this.time = REMAIN_TIME_SECONDS;
    }
    public CustomEmbed(int customTime,boolean deleteAfter) {
        this.deleteAfter = deleteAfter;
        this.time = customTime;
    }
    public Message send(TextChannel t) {
        if (deleteAfter) {
            Message m = t.sendMessage(getEmbed().build()).complete();
            m.delete().submitAfter(time, TimeUnit.SECONDS);
            return m;
        }
        return t.sendMessage(getEmbed().build()).complete();
    }
}
