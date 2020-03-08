package me.Rokaz.BlueLight.core.help;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.help.cmd.Help;
import net.dv8tion.jda.api.JDA;

public class HelpManager {
    private JDA bot;
    public HelpManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueLight.cm.registerCommand(new Help());
    }
}
