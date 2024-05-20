package com.quantumzizo.createarmoredblocks.index;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

@SuppressWarnings({"unused"})
public class CABItems {
    static {
        REGISTRATE.setCreativeTab(CABCreativeTab.BASE);
    }

    public static final ItemEntry<SequencedAssemblyItem>
        HOT_METAL = sequencedIngredient("hot_metal");

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }

    public static void register() {}
}