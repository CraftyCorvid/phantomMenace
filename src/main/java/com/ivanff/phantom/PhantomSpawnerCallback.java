package com.ivanff.phantom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface PhantomSpawnerCallback {
    Event<PhantomSpawnerCallback> EVENT = EventFactory.createArrayBacked(PhantomSpawnerCallback.class,
        (listeners) -> () -> {
            for (PhantomSpawnerCallback listener : listeners) {
                boolean result = listener.blockSpawn();
                if (result) {
                    return result;
                }
            }
        return false;
    });
 
    Boolean blockSpawn();
}