package me.Rokaz.BlueCraft.core.lib.embed.objects;

import net.dv8tion.jda.api.EmbedBuilder;

public class EmbedAuthor {
    private String text;
    private String url;
    private String image;
    public EmbedAuthor(String text, String url, String image) {
        this.text = text;
        this.url = url;
        this.image = image;
    }
    public EmbedAuthor(String text, String url) {
        this.text = text;
        this.url = url;
    }
    public EmbedAuthor(String text) {
        this.text = text;
    }
    public EmbedBuilder addToEmbed(EmbedBuilder eb) {
        if (text != null) {
            eb.setAuthor(text);
            if (url != null) {
                eb.setAuthor(text,url);
                if (image != null) {
                    eb.setAuthor(text,url,image);
                }
            }
        }
        return eb;
    }

}
