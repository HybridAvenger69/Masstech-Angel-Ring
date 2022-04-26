package com.hybridavenger69.mtar.other;

import com.hybridavenger69.lib.main.MtGroup;
import com.hybridavenger69.mtar.AngelRing;


import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ObjectHolder;

import java.lang.management.MemoryType;

@ObjectHolder(AngelRing.MODID)
public class BatWing extends Item {
    public BatWing() {
        super((new Item.Properties()).stacksTo(64).tab(MtGroup.MT_TAB));
    }
}
