package me.Rokaz.BlueCraft.core.mod.embeds.server;

import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.lib.time.TimeUtils;
import net.dv8tion.jda.api.entities.User;

public class BanEmbed extends CustomEmbed {
    private User u;
    private User admin;
    private String reason;
    public BanEmbed(User u,User admin, String reason) {
        super(false);
        this.u = u;
        this.admin = admin;
        this.reason = reason;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(u.getName() + " has been banned from the server!"),new EmbedHeader(null,null)
                ,null,admin.getAvatarUrl(), new EmbedFooter("Banned person", u.getAvatarUrl()),
                new EmbedField("Member","<@"+u.getId() + ">",false),
                new EmbedField("Banned by","<@"+admin.getId() + ">",false),
                new EmbedField("Banned on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Reason",reason,false));
    }
}
