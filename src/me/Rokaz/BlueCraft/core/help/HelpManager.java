package me.Rokaz.BlueCraft.core.help;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.help.cmd.Help;
import net.dv8tion.jda.api.JDA;

public class HelpManager {
    private JDA bot;
    public HelpManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueCraft.cm.registerCommand(new Help());
    }
}
