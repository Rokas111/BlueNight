package me.Rokaz.BlueLight.core.lib.embed;

import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Embed {
    public static final Color COLOR = new Color(121,137,255);
    private EmbedAuthor author;
    private EmbedHeader header;
    private EmbedFooter footer;
    private String image;
    private String thumbnail;
    private List<EmbedField> fields;
    public Embed(EmbedAuthor author,EmbedHeader header,String image,String thumbnail,EmbedFooter footer, EmbedField... fields) {
        this.author = author;
        this.header = header;
        this.image = image;
        this.thumbnail = thumbnail;
        this.footer = footer;
        this.fields = Arrays.asList(fields);
    }
    public MessageEmbed build() {
        EmbedBuilder b = new EmbedBuilder();
        b.setColor(COLOR);
        author.addToEmbed(b);
        header.addToEmbed(b);
        fields.forEach(field -> field.addToEmbed(b));
        if (image != null) b.setImage(image);
        if (thumbnail != null) b.setThumbnail(thumbnail);
        footer.addToEmbed(b);
        return b.build();
    }
}
