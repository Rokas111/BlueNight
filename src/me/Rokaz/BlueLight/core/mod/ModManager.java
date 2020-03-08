package me.Rokaz.BlueLight.core.mod;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.mod.chat.ClearChat;
import me.Rokaz.BlueLight.core.mod.mute.Mute;
import me.Rokaz.BlueLight.core.mod.server.Ban;
import me.Rokaz.BlueLight.core.mod.server.Kick;
import me.Rokaz.BlueLight.core.mod.server.Unban;
import net.dv8tion.jda.api.JDA;

public class ModManager {
    public static final String PUNISHMENT_LOG = "684122963393380413";
    private JDA bot;
    public ModManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueLight.cm.registerCommand(new ClearChat());
        BlueLight.cm.registerCommand(new Mute());
        BlueLight.cm.registerCommand(new Ban());
        BlueLight.cm.registerCommand(new Unban());
        BlueLight.cm.registerCommand(new Kick());
    }
}
