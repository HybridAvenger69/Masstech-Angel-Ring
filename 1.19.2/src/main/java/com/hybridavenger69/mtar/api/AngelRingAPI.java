package com.hybridavenger69.mtar.api;

import com.hybridavenger69.mtar.register.ItemRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public class AngelRingAPI
{
    public static boolean IsRingInCuriosSlot(LivingEntity player)
    {
        ItemStack angelRing = ItemRegistry.ITEMRING.get().getDefaultInstance();
        return CuriosApi.getCuriosHelper().findEquippedCurio(angelRing.getItem(), player).isPresent();
    }
}
