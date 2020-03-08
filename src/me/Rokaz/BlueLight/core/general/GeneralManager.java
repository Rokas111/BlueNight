package me.Rokaz.BlueLight.core.general;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.general.cmd.Notify;
import net.dv8tion.jda.api.JDA;

public class GeneralManager {
    private JDA bot;
    public GeneralManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueLight.cm.registerCommand(new Notify());
    }
}
