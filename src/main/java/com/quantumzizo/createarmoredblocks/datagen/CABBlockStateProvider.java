package com.quantumzizo.createarmoredblocks.datagen;

import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CABBlockStateProvider extends BlockStateProvider {
    public CABBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateArmoredBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CABBlocks.CAST_IRON_ARMOR_BLOCK);
    }
    private void blockWithItem(BlockEntry<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
