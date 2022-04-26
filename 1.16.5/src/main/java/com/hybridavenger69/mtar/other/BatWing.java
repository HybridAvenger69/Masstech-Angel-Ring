package com.hybridavenger69.mtar.other;

import com.hybridavenger69.lib.main.MtGroup;
import com.hybridavenger69.mtar.AngelRing;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AngelRing.MODID)
public class BatWing extends Item {
    public BatWing() {
        super((new Item.Properties()).stacksTo(64).tab(MtGroup.MT_GROUP));
    }
}
