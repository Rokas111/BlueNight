package me.Rokaz.BlueLight.core;

import me.Rokaz.BlueLight.core.IMessages.InteractableManager;
import me.Rokaz.BlueLight.core.cmd.CommandManager;
import me.Rokaz.BlueLight.core.general.GeneralManager;
import me.Rokaz.BlueLight.core.help.HelpManager;
import me.Rokaz.BlueLight.core.mod.ModManager;
import me.Rokaz.BlueLight.core.suggestions.SuggestionManager;
import me.Rokaz.BlueLight.core.welcome.WelcomeManager;
import me.Rokaz.BlueLight.core.status.StatusUpdater;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.util.Timer;

public class BlueLight {
    public static final String SERVER_NAME = "BlueLight";
    public static final String TOKEN = "NjgxNTcyMzkzODYwNDY0Nzg1.XmTsVQ.4zwtgw5eqpMvpjSAcEOHjkCG_oQ";
    public static final String AUTHOR_NAME = "Rokaz";
    public static final String AUTHOR_AVATAR = "https://cdn.discordapp.com/avatars/284360814163394564/ca64d69df984618931b4304c3d503a75.png?size=128";
    public static StatusUpdater sp;
    public static CommandManager cm;
    public static InteractableManager im;
    public static WelcomeManager wm;
    public static ModManager mm;
    public static HelpManager hm;
    public static GeneralManager gm;
    public static SuggestionManager sm;
    private static JDA bot;
    public static void main(String[] args) throws Exception {
        bot = new JDABuilder(AccountType.BOT).setToken(TOKEN).build();
        sp = new StatusUpdater(bot);
        cm = new CommandManager(bot);
        im = new InteractableManager(bot);
        wm = new WelcomeManager(bot);
        mm = new ModManager(bot);
        hm = new HelpManager(bot);
        gm = new GeneralManager(bot);
        sm = new SuggestionManager(bot);
        Timer timer = new Timer();
        timer.schedule(sp,1,2000);
    }
}
