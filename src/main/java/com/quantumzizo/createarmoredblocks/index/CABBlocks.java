package com.quantumzizo.createarmoredblocks.index;


import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

@SuppressWarnings({"all"})
public class CABBlocks {
    static {
        REGISTRATE.setCreativeTab(CABCreativeTab.BASE);
    }
    public static final BlockEntry<Block> CAST_IRON_ARMOR_BLOCK = REGISTRATE.block("cast_iron_armor_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.requiresCorrectToolForDrops())
            .properties(p -> p.strength(20.0F, 250.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .lang("Cast Iron Armor Block")
            .item()
            .build()
            .register();
}
