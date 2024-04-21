package com.quantumzizo.createarmoredblocks.datagen;

import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CABBlockTagGenerator extends BlockTagsProvider {
    public CABBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateArmoredBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CABBlocks.CAST_IRON_ARMOR_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CABBlocks.CAST_IRON_ARMOR_BLOCK.get());
    }
}
