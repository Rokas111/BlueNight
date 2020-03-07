package me.Rokaz.BlueCraft.core.suggestions.embeds;

import com.google.common.collect.ImmutableMap;
import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.lib.command.ICommand;
import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.lib.messages.InteractableMessage;
import me.Rokaz.BlueCraft.core.lib.messages.reactions.ReactionExecutor;
import me.Rokaz.BlueCraft.core.lib.roles.Role;
import me.Rokaz.BlueCraft.core.lib.time.TimeUtils;
import me.Rokaz.BlueCraft.core.suggestions.SuggestionManager;
import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;

public class BugEmbed extends InteractableMessage {
    private User u;
    private String description;
    private final HashMap<String, ReactionExecutor> REACTIONS = new HashMap<>(ImmutableMap.<String,ReactionExecutor>builder()
            .put("➡️",(m,p)-> {
                if (ICommand.RequiredPermission.MANAGER.hasRequiredPermission(p)) {
                    m.getGuild().getTextChannelById(SuggestionManager.TO_DO_BUG_CHANNEL_ID).sendMessage(getEmbed().build()).queue();
                    m.delete().queue();
                }
            })
            .put("\uD83D\uDD34", (m,p)-> {
                if (ICommand.RequiredPermission.MANAGER.hasRequiredPermission(p)) {
                    m.delete().queue();
                }
            }).build());
    public BugEmbed(User u,String description) {
        super(false);
        this.u = u;
        this.description = description;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(null),new EmbedHeader("Bug Report",null)
                ,null,u.getAvatarUrl(), new EmbedFooter(BlueCraft.AUTHOR_NAME,BlueCraft.AUTHOR_AVATAR),
                new EmbedField("Reported by",u.getName(),false),
                new EmbedField("Reported on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Description",description,false));
    }
    public HashMap<String, ReactionExecutor> getReactions() {
        return REACTIONS;
    }
}
