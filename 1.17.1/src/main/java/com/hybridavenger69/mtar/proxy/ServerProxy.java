package com.hybridavenger69.mtar.proxy;


import net.minecraft.world.level.Level;

public class ServerProxy implements IProxy {
    @Override
    public Level getClientLevel() {
        throw new IllegalStateException("Only run this on the client!");
    }

    @Override
    public Level getClientlevel() {
        return null;
    }
}
