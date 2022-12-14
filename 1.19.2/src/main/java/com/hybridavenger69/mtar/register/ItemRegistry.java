package com.hybridavenger69.mtar.register;

import com.hybridavenger69.mtar.AngelRing;
import com.hybridavenger69.mtar.other.BatWing;
import com.hybridavenger69.mtar.ring.ItemDiamondRing;
import com.hybridavenger69.mtar.ring.ItemRing;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry
{

    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AngelRing.MOD_ID);

    public static final RegistryObject<Item> ITEMDIAMONDRING = ITEMS.register("itemdiamondring", ItemDiamondRing::new);
    public static final RegistryObject<Item> ITEMRING = ITEMS.register("itemring", ItemRing::new);

    public static final RegistryObject<Item> BATWING = ITEMS.register("batwing", BatWing::new);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
