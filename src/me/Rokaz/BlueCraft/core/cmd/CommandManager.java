package me.Rokaz.BlueCraft.core.cmd;

import me.Rokaz.BlueCraft.core.cmd.embeds.PopUpEmbed;
import me.Rokaz.BlueCraft.core.lib.command.ICommand;
import me.Rokaz.BlueCraft.core.lib.embed.premades.SimpleCustomEmbed;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandManager extends ListenerAdapter {
    public static final String PREFIX = "-";
    private static final SimpleCustomEmbed PERMISSION_EMBED = new PopUpEmbed("You don't have the permission to execute this command");
    private List<ICommand> commands;
    private JDA bot;
    public CommandManager(JDA bot) {
        this.bot = bot;
        commands = new ArrayList<>();
        bot.addEventListener(this);
    }
    public List<ICommand> getCommands() {
        return this.commands;
    }
    public void registerCommand(ICommand cmd) {
        commands.add(cmd);
    }
    public ICommand getCommand(String command) {
        return !commands.stream().filter(cmd -> cmd.getAliases().contains(command)).collect(Collectors.toList()).isEmpty()?commands.stream().filter(cmd -> cmd.getAliases().contains(command)).collect(Collectors.toList()).get(0):null;
    }
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (!e.getMessage().getContentRaw().startsWith(PREFIX) || e.getMessage().getAuthor().isBot()) return;
        String command = e.getMessage().getContentRaw();
        ICommand cmd = getCommand(command.contains(" ")?command.substring(1).split(" ")[0].toLowerCase():command.substring(1).toLowerCase());
        String[] args = command.contains(" ")? command.substring(command.indexOf(' ') + 1).split(" "):null;
        if (cmd != null) {
            if (cmd.getPermission().getRole() != null && !cmd.getPermission().hasRequiredPermission(e.getMember())) {
                PERMISSION_EMBED.send(e.getChannel());
                return;
            }
            cmd.run(e.getMessage(),command.substring(1),args);
            e.getMessage().delete().queue();
        }
    }
}
