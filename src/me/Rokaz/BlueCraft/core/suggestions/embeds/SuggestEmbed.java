package me.Rokaz.BlueCraft.core.suggestions.embeds;

import com.google.common.collect.ImmutableMap;
import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.lib.messages.InteractableMessage;
import me.Rokaz.BlueCraft.core.lib.messages.reactions.ReactionExecutor;
import me.Rokaz.BlueCraft.core.lib.time.TimeUtils;
import net.dv8tion.jda.api.entities.User;

import java.util.Arrays;
import java.util.HashMap;

public class SuggestEmbed extends InteractableMessage {
    enum SuggestType {
        SUGGESTION,
        BUG;
    }
    private final HashMap<String, ReactionExecutor> REACTIONS = new HashMap<>(ImmutableMap.<String,ReactionExecutor>builder()
            .put("✔",m-> {})
            .put("❌", m-> {}).build());
    private User u;
    private String title;
    private String description;
    private SuggestType type;
    public SuggestEmbed(User u,String title,String description,SuggestType type) {
        super(false);
        this.u = u;
        this.title = title;
        this.description = description;
        this.type = type;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(null),new EmbedHeader(title,null)
                ,null,u.getAvatarUrl(), new EmbedFooter(BlueCraft.AUTHOR_NAME,BlueCraft.AUTHOR_AVATAR),
                new EmbedField(type == SuggestType.SUGGESTION?"Suggested by":"Reported by",u.getName(),false),
                new EmbedField(type == SuggestType.SUGGESTION?"Suggested on":"Reported on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Description",description,false));
    }
    public HashMap<String, ReactionExecutor> getReactions() {
        return REACTIONS;
    }
}
