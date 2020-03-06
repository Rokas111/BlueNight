package me.Rokaz.BlueCraft.core.mod.embeds.server;

import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.utils.TimeUtils;
import net.dv8tion.jda.api.entities.User;

public class KickEmbed extends CustomEmbed {
    private User u;
    private User admin;
    private String reason;
    public KickEmbed(User u,User admin, String reason) {
        super(false);
        this.u = u;
        this.admin = admin;
        this.reason = reason;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(u.getName() + " has been kicked from the server!"),new EmbedHeader(null,null)
                ,null,admin.getAvatarUrl(), new EmbedFooter("Kicked person", u.getAvatarUrl()),
                new EmbedField("Member","<@"+u.getId() + ">",false),
                new EmbedField("Kicked by","<@"+admin.getId() + ">",false),
                new EmbedField("Kicked on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Reason",reason,false));
    }
}
