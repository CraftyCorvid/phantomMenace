package com.ivanff.phantom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static com.ivanff.phantom.ModState.getEnabled;

public class PhantomMenaceMod implements ModInitializer {
    public static final String MOD_ID = "phantom_menace";
    public static final String MOD_NAME = "Phantom Menace";

    public static Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Phantom Menace Initializing");
        
        CommandRegistrationCallback.EVENT.register(Commands::register);

        PhantomSpawnerCallback.EVENT.register(() -> getEnabled());
    }
}