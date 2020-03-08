package me.Rokaz.BlueLight.core.welcome;

import me.Rokaz.BlueLight.core.lib.roles.Role;
import me.Rokaz.BlueLight.core.welcome.embeds.WelcomeEmbed;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public class WelcomeManager extends ListenerAdapter {
    public static final String WELCOME_CHANNEL = "683440681691250696";
    public static final List<Role> ON_JOIN_ROLES = Arrays.asList(Role.MEMBER,Role.NOTIFY);
    private JDA bot;
    public WelcomeManager(JDA bot) {
        this.bot = bot;
        bot.addEventListener(this);
    }
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        new WelcomeEmbed(e.getMember().getUser()).send(e.getGuild().getTextChannelById(WELCOME_CHANNEL));
        addRoles(e.getMember());
    }
    public void addRoles(Member m) {
        ON_JOIN_ROLES.forEach(role -> m.getGuild().addRoleToMember(m,m.getGuild().getRoleById(role.getID())).queue());
    }
}
