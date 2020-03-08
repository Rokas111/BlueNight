package me.Rokaz.BlueLight.core.help.embeds;

import me.Rokaz.BlueLight.core.BlueLight;
import me.Rokaz.BlueLight.core.cmd.CommandManager;
import me.Rokaz.BlueLight.core.lib.embed.Embed;
import me.Rokaz.BlueLight.core.lib.embed.custom.CustomEmbed;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedAuthor;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedFooter;
import me.Rokaz.BlueLight.core.lib.embed.objects.EmbedHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelpEmbed extends CustomEmbed {
    private List<String> commands;
    private String title;
    public HelpEmbed(List<String> commands,String title) {
        super(15,true);
        this.commands = commands;
        this.title = title;
    }
    public Embed getEmbed() {
        List<String> commandlist = !commands.isEmpty()
                ?commands.stream().map(command -> String.join("\n\n", BlueLight.cm.getCommand(command).getUsages().stream().map(usage -> CommandManager.PREFIX+command + " " + usage).collect(Collectors.toList()))).collect(Collectors.toList())
                :new ArrayList<>();
        return new Embed(
                new EmbedAuthor(null),new EmbedHeader(title,"Here are the commands: \n\n" + String.join("\n\n",commandlist) + "\n")
                ,null,null, new EmbedFooter(BlueLight.AUTHOR_NAME, BlueLight.AUTHOR_AVATAR));
    }
}
