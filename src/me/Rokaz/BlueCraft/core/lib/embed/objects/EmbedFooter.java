package me.Rokaz.BlueCraft.core.lib.embed.objects;

import net.dv8tion.jda.api.EmbedBuilder;

public class EmbedFooter {
    private String text;
    private String image;
    public EmbedFooter(String text, String image) {
        this.text = text;
        this.image = image;
    }
    public EmbedFooter(String text) {
        this.text = text;
    }
    public EmbedBuilder addToEmbed(EmbedBuilder eb) {
        if (text != null) {
            eb.setFooter(text);
            if (image != null) {
                eb.setFooter(text,image);
            }
        }
        return eb;
    }
}
