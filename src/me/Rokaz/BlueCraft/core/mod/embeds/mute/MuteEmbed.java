package me.Rokaz.BlueCraft.core.mod.embeds.mute;

import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueCraft.core.lib.time.TimeUtils;
import net.dv8tion.jda.api.entities.User;

public class MuteEmbed extends CustomEmbed {
    private User u;
    private User admin;
    private Integer hours;
    private String reason;
    public MuteEmbed(User u,User admin, String reason,Integer hours) {
        super(false);
        this.u = u;
        this.admin = admin;
        this.reason = reason;
        this.hours = hours;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(u.getName() + " has been muted"),new EmbedHeader(null,null)
                ,null,admin.getAvatarUrl(), new EmbedFooter("Muted person", u.getAvatarUrl()),
                new EmbedField("Member","<@"+u.getId() + ">",false),
                new EmbedField("Muted by","<@"+admin.getId() + ">",false),
                new EmbedField("Muted on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Muted until",TimeUtils.addHoursToTime(hours),false),
                new EmbedField("Reason",reason,false));
    }
}
