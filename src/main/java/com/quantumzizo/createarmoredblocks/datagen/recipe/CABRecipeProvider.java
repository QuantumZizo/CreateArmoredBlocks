package com.quantumzizo.createarmoredblocks.datagen.recipe;

import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;

import java.util.function.Consumer;

public class CABRecipeProvider extends RecipeProvider {
    public CABRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        infusedConcreteRecipe(CABBlocks.INFUSED_LIGHT_GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER).save(consumer);
    }

    private ShapelessRecipeBuilder infusedConcreteRecipe(BlockEntry<FallingBlock> infusedConcretePowder, ItemLike baseConcretePowder) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, infusedConcretePowder.get(), 2)
                .requires(AllItems.POWDERED_OBSIDIAN.get())
                .requires(baseConcretePowder)
                .unlockedBy(getHasName(infusedConcretePowder.get()), has(infusedConcretePowder.get()));
    }
}