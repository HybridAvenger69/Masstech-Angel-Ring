package com.hybridavenger69.mtar.ring;

import com.hybridavenger69.hybridlib.main.MtGroup;
import com.hybridavenger69.mtar.AngelRing;
import com.hybridavenger69.mtar.compat.CuriosCompat;
import com.hybridavenger69.mtar.compat.ExternalMods;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = AngelRing.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRing extends Item {

    public ItemRing() {
        super(new Item.Properties().stacksTo(1).tab(MtGroup.MT_GROUP));
    }

    @SubscribeEvent
    public static void sendImc(InterModEnqueueEvent event) {
        if (ExternalMods.CURIOS.isLoaded())
            CuriosCompat.sendImc();


    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (ExternalMods.CURIOS.isLoaded()) {
            return CuriosCompat.initCapabilities();
        }
        return super.initCapabilities(stack, nbt);
    }
}