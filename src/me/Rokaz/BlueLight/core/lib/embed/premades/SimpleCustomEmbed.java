package me.Rokaz.BlueLight.core.lib.embed.premades;

import me.Rokaz.BlueLight.core.lib.embed.Embed;
import me.Rokaz.BlueLight.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;

public class SimpleCustomEmbed extends CustomEmbed {
    private String message;
    public SimpleCustomEmbed(String message,boolean deleteAfter) {
        super(deleteAfter);
        this.message = message;
    }
    public Embed getEmbed() {
        return new Embed(
                new EmbedAuthor(message),new EmbedHeader(null,null)
                ,null,null, new EmbedFooter(null));
    }
}
