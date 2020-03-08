package me.Rokaz.BlueLight.core.lib.embed.custom;

import me.Rokaz.BlueLight.core.lib.embed.Embed;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface ICustomEmbed {
    Embed getEmbed();
    Message send(TextChannel c);
}
