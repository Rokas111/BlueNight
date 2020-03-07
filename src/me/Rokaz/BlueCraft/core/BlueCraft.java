package me.Rokaz.BlueCraft.core;

import me.Rokaz.BlueCraft.core.IMessages.InteractableManager;
import me.Rokaz.BlueCraft.core.cmd.CommandManager;
import me.Rokaz.BlueCraft.core.general.GeneralManager;
import me.Rokaz.BlueCraft.core.help.HelpManager;
import me.Rokaz.BlueCraft.core.mod.ModManager;
import me.Rokaz.BlueCraft.core.mod.chat.ClearChat;
import me.Rokaz.BlueCraft.core.suggestions.SuggestionManager;
import me.Rokaz.BlueCraft.core.welcome.WelcomeManager;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import me.Rokaz.BlueCraft.core.status.StatusUpdater;

import java.util.Timer;

public class BlueCraft {
    public static final String SERVER_NAME = "BlueCraft";
    public static final String TOKEN = "NjgxNTcyMzkzODYwNDY0Nzg1.XlQulg.VISuY26QcEIVToO_5MtgdVoz8Zw";
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
