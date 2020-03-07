package me.Rokaz.BlueCraft.core.suggestions;

import net.dv8tion.jda.api.JDA;

public class SuggestionManager {
    public static final String SUGGESTION_CHANNEL_ID = "685619504558112776";
    public static final String BUG_CHANNEL_ID = "685619702713548812";
    public static final String TO_DO_CHANNEL_ID = "685619872084000775";
    private JDA bot;
    public SuggestionManager(JDA bot) {
        this.bot = bot;
        registerCommands();
    }
    private void registerCommands() {

    }
}
