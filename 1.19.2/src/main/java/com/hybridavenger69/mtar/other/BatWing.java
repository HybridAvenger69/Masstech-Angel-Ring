package com.hybridavenger69.mtar.other;


import com.hybridavenger69.hybridlib.main.MtGroup;


import net.minecraft.world.item.Item;


public class BatWing extends Item {
    public BatWing() {
        super((new Item.Properties()).stacksTo(64).tab(MtGroup.MT_GROUP));
    }
}