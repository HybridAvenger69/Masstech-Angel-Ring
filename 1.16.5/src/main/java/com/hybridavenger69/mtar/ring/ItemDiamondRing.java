package com.hybridavenger69.mtar.ring;


import com.hybridavenger69.lib.main.MtGroup;
import com.hybridavenger69.mtar.AngelRing;
import net.minecraft.item.Item;

import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AngelRing.MODID)
public class ItemDiamondRing extends Item {
        public ItemDiamondRing() {
            super(new Properties().stacksTo(1).tab(MtGroup.MT_GROUP));
        }
}
