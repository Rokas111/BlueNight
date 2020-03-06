package me.Rokaz.BlueCraft.core.lib.embed.objects;

import net.dv8tion.jda.api.EmbedBuilder;
import org.jetbrains.annotations.NotNull;

public class EmbedField {
    private String text;
    private String value;
    private boolean inline;
    public EmbedField(@NotNull String text, @NotNull String value, @NotNull boolean inline) {
        this.text = text;
        this.value = value;
        this.inline = inline;
    }
    public EmbedBuilder addToEmbed(EmbedBuilder eb) {
        eb.addField(text,value,inline);
        return eb;
    }

}
