package com.hybridavenger69.mtar;


import com.hybridavenger69.mtar.compat.ExternalMods;
import com.hybridavenger69.mtar.other.BatWing;
import com.hybridavenger69.mtar.proxy.ClientProxy;
import com.hybridavenger69.mtar.proxy.IProxy;
import com.hybridavenger69.mtar.proxy.ServerProxy;
import com.hybridavenger69.mtar.register.ItemRegistry;
import com.hybridavenger69.mtar.ring.ItemDiamondRing;
import com.hybridavenger69.mtar.ring.ItemRing;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mtar")
public class AngelRing {
    public static final String MODID = "mtar";
    private static final Logger LOGGER = LogManager.getLogger();

    public AngelRing() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Angel Ring's setup initialized.");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void RegisterItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll
                    (
                            ItemRegistry.ItemRing = new ItemRing().setRegistryName(location("itemring")),
                            ItemRegistry.ItemDiamondRing = new ItemDiamondRing().setRegistryName(location("itemdiamondring")),
                            ItemRegistry.BatWing = new BatWing().setRegistryName(location("batwing"))
                    );
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(MODID, name);
        }
    }
}