package me.Rokaz.BlueCraft.core.mod.embeds.server;

import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.lib.time.TimeUtils;
import net.dv8tion.jda.api.entities.User;

public class UnbanEmbed extends CustomEmbed {
    private User u;
    private User admin;
    public UnbanEmbed(User u,User admin) {
        super(false);
        this.u = u;
        this.admin = admin;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(u.getName() + " has been unbanned from the server!"),new EmbedHeader(null,null)
                ,null,admin.getAvatarUrl(), new EmbedFooter("Unbanned person", u.getAvatarUrl()),
                new EmbedField("Member","<@"+u.getId() + ">",false),
                new EmbedField("Unbanned by","<@"+admin.getId() + ">",false),
                new EmbedField("Unbanned on", TimeUtils.getCurrentTime(),false));
    }
}
