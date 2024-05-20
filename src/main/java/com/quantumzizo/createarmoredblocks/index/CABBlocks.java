package com.quantumzizo.createarmoredblocks.index;


import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.*;
import uwu.lopyluna.create_dd.item.DDItems;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.*;

@SuppressWarnings({"unused"})
public class CABBlocks {
    static {
        REGISTRATE.setCreativeTab(CABCreativeTab.BASE);
    }

    public static final BlockEntry<Block> WORKABLE_STEEL_BLOCK = REGISTRATE.block("workable_steel_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .lang("Block of Workable Steel")
            .recipe((c, p) ->
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get())
                        .pattern("SS")
                        .pattern("SS")
                        .define('S', DDItems.steel_ingot.get())
                        .unlockedBy("has_steel_ingot", has(DDItems.steel_ingot.get()))
                        .save(p, CreateArmoredBlocks.asResource("crafting/armor_blocks/" + c.getName()))
            )
            .simpleItem()
            .register();
    public static final BlockEntry<StairBlock> WORKABLE_STEEL_STAIRS = workableStairs("workable_steel_stairs", WORKABLE_STEEL_BLOCK)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .register();
    public static final BlockEntry<SlabBlock> WORKABLE_STEEL_SLAB = workableSlab("workable_steel_slab", WORKABLE_STEEL_BLOCK)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .register();
    public static final BlockEntry<Block> QUENCHED_STEEL_BLOCK = REGISTRATE.block("quenched_steel_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.strength(20.0F, 3.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(AllTags.AllBlockTags.COPYCAT_DENY.tag)
            .simpleItem()
            .register();
    public static final BlockEntry<StairBlock> QUENCHED_STEEL_STAIRS = stairs("quenched_steel_stairs", QUENCHED_STEEL_BLOCK)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .register();
    public static final BlockEntry<SlabBlock> QUENCHED_STEEL_SLAB = slab("quenched_steel_slab", QUENCHED_STEEL_BLOCK)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .register();
    public static final BlockEntry<FallingBlock> INFUSED_LIGHT_GRAY_CONCRETE_POWDER = REGISTRATE.block("infused_light_gray_concrete_powder", FallingBlock::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE_POWDER)
            .recipe((c, p) ->
                ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 2)
                        .requires(AllItems.POWDERED_OBSIDIAN.get())
                        .requires(Blocks.LIGHT_GRAY_CONCRETE_POWDER)
                        .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CONCRETE_POWDER), has(Blocks.LIGHT_GRAY_CONCRETE_POWDER))
                        .unlockedBy(getHasName(AllItems.POWDERED_OBSIDIAN), has(AllItems.POWDERED_OBSIDIAN))
                        .save(p, CreateArmoredBlocks.asResource("crafting/infused_concrete/" + c.getName()))
            )
            .simpleItem()
            .register();
    public static final BlockEntry<Block> INFUSED_LIGHT_GRAY_CONCRETE = REGISTRATE.block("infused_light_gray_concrete", Block::new)
            .initialProperties(() -> Blocks.LIGHT_GRAY_CONCRETE)
            .properties(p -> p.strength(11.0F))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .simpleItem()
            .register();
    public static void register() {}

    private static BlockBuilder<StairBlock, CreateRegistrate> workableStairs(String name, BlockEntry<? extends Block> baseBlock) {
        return stairs(name, baseBlock)
                .recipe((c, p) ->
                    ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 6)
                            .pattern("S  ")
                            .pattern("SS ")
                            .pattern("SSS")
                            .define('S', baseBlock)
                            .unlockedBy(getHasName(baseBlock), has(baseBlock))
                            .save(p, CreateArmoredBlocks.asResource("crafting/armor_blocks/" + c.getName()))
                );
    }
    private static BlockBuilder<StairBlock, CreateRegistrate> stairs(String name, BlockEntry<? extends Block> baseBlock) {
        return REGISTRATE.block(name, p -> new StairBlock(baseBlock::getDefaultState, p))
                .initialProperties(baseBlock)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(BlockTags.STAIRS)
                .blockstate((c, p) -> p.stairsBlock(c.get(), p.blockTexture(baseBlock.get())))
                .item()
                .tag(ItemTags.STAIRS)
                .build();
    }
    private static BlockBuilder<SlabBlock, CreateRegistrate> workableSlab(String name, BlockEntry<? extends Block> baseBlock) {
        return slab(name, baseBlock)
                .recipe((c, p) ->
                        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 6)
                                .pattern("SSS")
                                .define('S', baseBlock)
                                .unlockedBy(getHasName(baseBlock), has(baseBlock))
                                .save(p, CreateArmoredBlocks.asResource("crafting/armor_blocks/" + c.getName()))
                );
    }
    private static BlockBuilder<SlabBlock, CreateRegistrate> slab(String name, BlockEntry<? extends Block> baseBlock) {
        return REGISTRATE.block(name, SlabBlock::new)
                .initialProperties(baseBlock)
                .loot((loot, slab) -> loot.add(slab, loot.createSlabItemTable(slab)))
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(BlockTags.SLABS)
                .blockstate((c, p) -> p.slabBlock(c.get(), baseBlock.getId(), p.blockTexture(baseBlock.get())))
                .item()
                .tag(ItemTags.SLABS)
                .build();
    }
}