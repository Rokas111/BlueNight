package me.Rokaz.BlueLight.core.help.embeds;

import com.google.common.collect.ImmutableMap;
import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.lib.embed.Embed;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueLight.core.lib.messages.InteractableMessage;
import me.Rokaz.BlueLight.core.lib.messages.reactions.ReactionExecutor;

import java.util.Arrays;
import java.util.HashMap;

public class SelectorHelpEmbed extends InteractableMessage {
    private final HashMap<String, ReactionExecutor> REACTIONS = new HashMap<>(ImmutableMap.<String,ReactionExecutor>builder()
            .put("\uD83D\uDD27",(m,p)-> {
                new HelpEmbed(Arrays.asList("clearchat","mute","ban","kick","unban"),"Management commands").send(m.getTextChannel());
                getMessage().delete().queue();
            })
            .put("\uD83C\uDF9F", (m,p)-> {
                new HelpEmbed(Arrays.asList(""),"Ticket commands").send(m.getTextChannel());
                getMessage().delete().queue();
            })
            .put("\uD83C\uDFE1", (m,p) -> {
                new HelpEmbed(Arrays.asList("notify","suggest","reportbug"),"General commands").send(m.getTextChannel());
                getMessage().delete().queue();
            }).build());
    public SelectorHelpEmbed() {
        super(true,10);
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(null),new EmbedHeader("Help","Select one of the following emojis to continue\n\n\uD83D\uDD27- Ticket help\n\uD83C\uDF9F - General command help\n\uD83C\uDFE1 - Management command help\n")
                ,null,null, new EmbedFooter(BlueLight.AUTHOR_NAME, BlueLight.AUTHOR_AVATAR));
    }
    public HashMap<String, ReactionExecutor> getReactions() {
        return REACTIONS;
    }
}
