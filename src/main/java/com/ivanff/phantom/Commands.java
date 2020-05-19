package com.ivanff.phantom;

import com.mojang.brigadier.CommandDispatcher;

import static com.mojang.brigadier.arguments.BoolArgumentType.*;

import static net.minecraft.server.command.CommandManager.*;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static com.ivanff.phantom.PhantomMenaceMod.LOGGER;
import static com.ivanff.phantom.ModState.setEnabled;
import static com.ivanff.phantom.ModState.getEnabled;

public class Commands {
    static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(literal("phantommenace")
            .requires(source -> source.hasPermissionLevel(2))
            .then(argument("enabled", bool())
                .executes(ctx -> {
                    boolean enabled = getBool(ctx, "enabled");
                    String feedback = "PhantomMenace has been " + (enabled ? "enabled" : "disabled");
                    ctx.getSource().sendFeedback(new LiteralText(feedback), true);
                    setEnabled(enabled);
                    LOGGER.info(feedback);
                    return 1;
                }))
            .executes(ctx -> {
                ctx.getSource().sendFeedback(new LiteralText("PhantomMenace is " + (getEnabled() ? "enabled" : "disabled")), false);
                return 1;
            }));
    }
}