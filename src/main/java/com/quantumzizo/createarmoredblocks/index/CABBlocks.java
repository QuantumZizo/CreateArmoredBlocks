package com.quantumzizo.createarmoredblocks.index;


import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

@SuppressWarnings({"all"})
public class CABBlocks {
    static {
        REGISTRATE.setCreativeTab(CABCreativeTab.BASE);
    }
    public static final BlockEntry<Block> CAST_IRON_ARMOR_BLOCK = REGISTRATE.block("cast_iron_armor_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.requiresCorrectToolForDrops())
            .properties(p -> p.strength(22.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .lang("Cast Iron Armor Block")
            .item()
            .build()
            .register();
    public static BlockEntry<FallingBlock> INFUSED_LIGHT_GRAY_CONCRETE_POWDER = REGISTRATE.block("infused_light_gray_concrete_powder", FallingBlock::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE_POWDER)
            .lang("Infused Light Gray Concrete Powder")
            .item()
            .build()
            .register();
    public static BlockEntry<Block> INFUSED_LIGHT_GRAY_CONCRETE = REGISTRATE.block("infused_light_gray_concrete", Block::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE)
            .properties(p -> p.strength(11.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .lang("Infused Light Gray Concrete")
            .item()
            .build()
            .register();
    public static void register() {};
}