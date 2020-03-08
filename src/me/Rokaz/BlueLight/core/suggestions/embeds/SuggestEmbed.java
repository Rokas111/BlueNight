package me.Rokaz.BlueLight.core.suggestions.embeds;

import com.google.common.collect.ImmutableMap;
import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.lib.command.ICommand;
import me.Rokaz.BlueLight.core.lib.embed.Embed;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueLight.core.lib.messages.InteractableMessage;
import me.Rokaz.BlueLight.core.lib.messages.reactions.ReactionExecutor;
import me.Rokaz.BlueLight.core.lib.time.TimeUtils;
import me.Rokaz.BlueLight.core.suggestions.SuggestionManager;
import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;

public class SuggestEmbed extends InteractableMessage {
    private final HashMap<String, ReactionExecutor> REACTIONS = new HashMap<>(ImmutableMap.<String,ReactionExecutor>builder()
            .put("✅",(m,p)-> {})
            .put("\uD83D\uDD34", (m,p)-> {})
            .put("➡️",(m,p)-> {
                if (ICommand.RequiredPermission.MANAGER.hasRequiredPermission(p)) {
                    m.getGuild().getTextChannelById(SuggestionManager.TO_DO_SUGGESTION_CHANNEL_ID).sendMessage(getEmbed().build()).queue();
                    m.delete().queue();
                }
            }).build());
    private User u;
    private String title;
    private String description;
    public SuggestEmbed(User u,String title,String description) {
        super(false);
        this.u = u;
        this.title = title;
        this.description = description;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(null),new EmbedHeader(!title.isEmpty()?title:"Suggestion",null)
                ,null,u.getAvatarUrl(), new EmbedFooter(BlueLight.AUTHOR_NAME, BlueLight.AUTHOR_AVATAR),
                new EmbedField("Suggested by",u.getName(),false),
                new EmbedField("Suggested on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Description",description,false));
    }
    public HashMap<String, ReactionExecutor> getReactions() {
        return REACTIONS;
    }
}
