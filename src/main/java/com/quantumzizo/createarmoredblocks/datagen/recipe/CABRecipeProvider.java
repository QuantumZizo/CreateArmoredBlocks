package com.quantumzizo.createarmoredblocks.datagen.recipe;

import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class CABRecipeProvider extends RecipeProvider {
    public CABRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CABBlocks.CAST_IRON_ARMOR_BLOCK.get())
                .define('I', Items.IRON_BLOCK)
                .define('D', Items.DEEPSLATE)
                .pattern("III")
                .pattern("IDI")
                .pattern("III")
                .unlockedBy(getHasName(CABBlocks.CAST_IRON_ARMOR_BLOCK.get()), has(CABBlocks.CAST_IRON_ARMOR_BLOCK.get()))
                .save(consumer);
    }
}