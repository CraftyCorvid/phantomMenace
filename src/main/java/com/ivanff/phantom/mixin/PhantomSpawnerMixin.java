package com.ivanff.phantom.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.gen.PhantomSpawner;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.ivanff.phantom.PhantomSpawnerCallback;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {
	@Inject(at = @At("HEAD"), method = "spawn", cancellable = true)
	private void onPhantomSpawn(ServerWorld serverWorld, boolean spawnMonsters, boolean spawnAnimals, final CallbackInfoReturnable<Integer> info) {
		boolean result = PhantomSpawnerCallback.EVENT.invoker().blockSpawn();
        if (result) {
            info.setReturnValue(0);
        }
	}
}
