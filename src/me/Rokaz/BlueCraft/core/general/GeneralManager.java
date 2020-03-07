package me.Rokaz.BlueCraft.core.general;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.general.cmd.Notify;
import net.dv8tion.jda.api.JDA;

public class GeneralManager {
    private JDA bot;
    public GeneralManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueCraft.cm.registerCommand(new Notify());
    }
}
