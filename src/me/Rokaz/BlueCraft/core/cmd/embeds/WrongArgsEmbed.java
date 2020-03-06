package me.Rokaz.BlueCraft.core.cmd.embeds;

import me.Rokaz.BlueCraft.core.BlueCraft;
import me.Rokaz.BlueCraft.core.cmd.CommandManager;
import me.Rokaz.BlueCraft.core.lib.embed.Embed;
import me.Rokaz.BlueCraft.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedField;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueCraft.core.lib.embed.objects.EmbedHeader;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class WrongArgsEmbed extends CustomEmbed {
    private String cmd;
    private List<String> usages;
    public WrongArgsEmbed(String cmd,List<String> usages) {
        super(true);
        this.cmd= cmd;
        this.usages = usages;
    }
    public Embed getEmbed() {
        usages.replaceAll(usage -> CommandManager.PREFIX+cmd+" "+ usage);
        return new Embed(
                new EmbedAuthor("Wrong command usage. Here are the usages of " + CommandManager.PREFIX + cmd),new EmbedHeader(null,null)
                ,null,null, new EmbedFooter(null), new EmbedField("Usages", StringUtils.join(usages,"\n\n"),false));
    }
}
