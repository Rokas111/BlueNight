package me.Rokaz.BlueCraft.core.suggestions;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.suggestions.cmd.ReportBug;
import me.Rokaz.BlueCraft.core.suggestions.cmd.Suggest;
import net.dv8tion.jda.api.JDA;

public class SuggestionManager {
    public static final String CREATOR_CHANNEL_ID = "685619934516084757";
    public static final String SUGGESTION_CHANNEL_ID = "685619504558112776";
    public static final String BUG_CHANNEL_ID = "685619702713548812";
    public static final String TO_DO_SUGGESTION_CHANNEL_ID = "685619872084000775";
    public static final String TO_DO_BUG_CHANNEL_ID = "685842464052871170";
    private JDA bot;
    public SuggestionManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {
        BlueCraft.cm.registerCommand(new ReportBug());
        BlueCraft.cm.registerCommand(new Suggest());
    }
}
