package me.Rokaz.BlueCraft.core.lib.embed.objects;

import net.dv8tion.jda.api.EmbedBuilder;

public class EmbedHeader {
    private String titletext;
    private String titleurl;
    private String description;
    public EmbedHeader(String titletext, String titleurl, String description) {
        this.titletext = titletext;
        this.titleurl = titleurl;
        this.description = description;
    }
    public EmbedHeader(String titletext, String description) {
        this.titletext = titletext;
        this.description = description;
    }
    public EmbedBuilder addToEmbed(EmbedBuilder eb) {
        if (titletext != null) {
            eb.setTitle(titletext);
            if (titleurl != null) {
                eb.setTitle(titletext,titleurl);
            }
        }
        if (description != null) {
            eb.setDescription(description);
        }
        return eb;
    }
}
