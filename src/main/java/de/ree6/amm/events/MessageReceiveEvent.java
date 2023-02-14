package de.ree6.amm.events;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.NewsChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageReceiveEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if (event.getChannel().getType() == ChannelType.NEWS) {
            NewsChannel newsChannel = event.getChannel().asNewsChannel();
            newsChannel.crosspostMessageById(event.getMessageIdLong())
                    .queue(c -> event.getMessage().addReaction(Emoji.fromUnicode("✔")).queue());
        }
    }
}
