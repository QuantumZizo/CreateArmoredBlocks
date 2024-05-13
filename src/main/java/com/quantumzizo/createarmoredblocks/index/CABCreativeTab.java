package com.quantumzizo.createarmoredblocks.index;

import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedList;
import java.util.List;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

public class CABCreativeTab {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateArmoredBlocks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BASE = TAB_REGISTER.register("base", () -> CreativeModeTab.builder()
            .icon(CABBlocks.WORKABLE_IRON_BLOCK::asStack)
            .title(Component.translatable("creativetab.base"))
            .displayItems(new RegistrateDisplayItemsGenerator())
            .build());

    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
        private List<Item> collectBlocks(RegistryObject<CreativeModeTab> tab) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Block> entry : REGISTRATE.getAll(Registries.BLOCK)) {
                if (!REGISTRATE.isInCreativeTab(entry, tab)) continue;

                Item item = entry.get().asItem();
                if (item != Items.AIR) items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }
        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Item> entry : REGISTRATE.getAll(Registries.ITEM)) {
                if (!REGISTRATE.isInCreativeTab(entry, tab)) continue;

                Item item = entry.get();
                if (!(item instanceof BlockItem)) items.add(item);
            }
            return items;
        }
        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(BASE));
            items.addAll(collectItems(BASE));

            items.forEach(output::accept);
        }
    }
}
