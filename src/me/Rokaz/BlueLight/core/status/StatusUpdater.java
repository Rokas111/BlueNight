package me.Rokaz.BlueLight.core.status;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

public class StatusUpdater extends TimerTask {
    private static final List<String> frames = Arrays.asList("Managing BlueLight!","Managing BlueLight!.","Managing BlueLight!..","Managing BlueLight!...");
    private int current_index;
    private JDA bot;
    public StatusUpdater(JDA bot) {
        this.bot = bot;
        this.current_index = 0;
    }
    public void run() {
        try {
            bot.getPresence().setActivity(Activity.of(Activity.ActivityType.DEFAULT, frames.get(current_index)));
            if (current_index >= frames.size() - 1) {
                current_index = 0;
                bot.getPresence().setActivity(Activity.of(Activity.ActivityType.DEFAULT, frames.get(current_index)));
            } else current_index++;
        } catch (Exception e) {
            bot.getPresence().setActivity(Activity.of(Activity.ActivityType.DEFAULT, "asd"));
        }
    }
}
