package com.quantumzizo.createarmoredblocks.index;


import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

@SuppressWarnings({"all"})
public class CABBlocks {
    static {
        REGISTRATE.setCreativeTab(CABCreativeTab.BASE);
    }

    public static final BlockEntry<Block> WORKABLE_IRON_BLOCK = REGISTRATE.block("workable_iron_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .lang("Block of Workable Iron")
            .simpleItem()
            .register();
    public static BlockEntry<FallingBlock> INFUSED_LIGHT_GRAY_CONCRETE_POWDER = REGISTRATE.block("infused_light_gray_concrete_powder", FallingBlock::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE_POWDER)
            .simpleItem()
            .register();
    public static BlockEntry<Block> INFUSED_LIGHT_GRAY_CONCRETE = REGISTRATE.block("infused_light_gray_concrete", Block::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE)
            .properties(p -> p.strength(11.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .simpleItem()
            .register();
    public static void register() {};
}