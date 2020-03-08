package me.Rokaz.BlueLight.core.welcome.embeds;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.lib.embed.Embed;
import me.Rokaz.BlueLight.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;
import me.Rokaz.BlueLight.core.lib.time.TimeUtils;
import net.dv8tion.jda.api.entities.User;

public class WelcomeEmbed extends CustomEmbed {
    private User u;
    public WelcomeEmbed(User u) {
        super(false);
        this.u = u;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor("Welcome to " + BlueLight.SERVER_NAME + "! " + u.getName()),new EmbedHeader(null,null)
                ,null,u.getAvatarUrl(), new EmbedFooter(null),
                new EmbedField("Joined on", TimeUtils.getCurrentTime(),false),
                new EmbedField("Member","<@"+u.getId() + ">",false),
                new EmbedField("Help","Please read <#683745516994953256> for more information",false));
    }
}
