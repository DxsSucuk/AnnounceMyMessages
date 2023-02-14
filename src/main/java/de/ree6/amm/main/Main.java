package de.ree6.amm.main;

import de.presti.ree6.bot.BotWorker;
import de.presti.ree6.bot.version.BotVersion;
import de.ree6.amm.events.MessageReceiveEvent;

public class Main {

    public static void main(String[] args) {
        BotWorker.createBot(BotVersion.DEVELOPMENT_BUILD);
        BotWorker.addEvent(new MessageReceiveEvent());
    }

}