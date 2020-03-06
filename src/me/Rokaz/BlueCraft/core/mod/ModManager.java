package me.Rokaz.BlueCraft.core.mod;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.mod.chat.ClearChat;
import me.Rokaz.BlueCraft.core.mod.mute.Mute;
import me.Rokaz.BlueCraft.core.mod.server.Ban;
import me.Rokaz.BlueCraft.core.mod.server.Kick;
import me.Rokaz.BlueCraft.core.mod.server.Unban;
import net.dv8tion.jda.api.JDA;

public class ModManager {
    public static final String PUNISHMENT_LOG = "684122963393380413";
    private JDA bot;
    public ModManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueCraft.cm.registerCommand(new ClearChat());
        BlueCraft.cm.registerCommand(new Mute());
        BlueCraft.cm.registerCommand(new Ban());
        BlueCraft.cm.registerCommand(new Unban());
        BlueCraft.cm.registerCommand(new Kick());
    }
}
