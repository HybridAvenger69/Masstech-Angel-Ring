package com.hybridavenger69.mtar.compat;

import com.hybridavenger69.mtar.AngelRing;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CuriosCompat{

    public static void sendImc() {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () -> new SlotTypeMessage.Builder("angelring").icon(new ResourceLocation("curios:slot/empty_ring_slot")).build());
    }
    public static ICapabilityProvider initCapabilities() {
        ICurio curio = new ICurio() {
            @Override
            public ItemStack getStack() {
                return AngelRing.ITEMRING.get().getDefaultInstance();
            }


            @Override
            public boolean canEquipFromUse(SlotContext slotContext) {
                return true;
            }

            @Override
            public void onEquip(SlotContext slotContext, ItemStack prevStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity instanceof Player player) {
                    startFlying(player);
                }
            }



            @Override
            public void onUnequip(SlotContext slotContext, ItemStack newStack) {
                LivingEntity livingEntity = slotContext.entity();
                if (livingEntity instanceof Player player) {
                    stopFlying(player);
                }
            }

            private void startFlying(Player player) {
                if (!player.isCreative() && !player.isSpectator()) {
                    player.getAbilities().mayfly = true;
                    player.onUpdateAbilities();
                }
            }

            private void stopFlying(Player player) {
                if (!player.isCreative() && !player.isSpectator()) {
                    player.getAbilities().flying = false;
                    player.getAbilities().mayfly = false;
                    player.onUpdateAbilities();
                }
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                LivingEntity entity = slotContext.entity();
                if (entity instanceof Player player) {
                    if (!player.getAbilities().mayfly) {
                        startFlying(player);
                    }
                }
            }

            public static boolean isRingInCuriosSlot(ItemStack ITEMRING, LivingEntity player) {
                return CuriosApi.getCuriosHelper().findEquippedCurio(ITEMRING.getItem(), player).isPresent();
            }

            @Override
            public void playRightClickEquipSound(LivingEntity livingEntity) {
                livingEntity.playSound(SoundEvents.ARMOR_EQUIP_ELYTRA,
                        1.0F, 1.0F);
            }
        };

        return new ICapabilityProvider() {
            private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
                                                     @Nullable Direction side) {

                return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
            }
        };
    }
}
