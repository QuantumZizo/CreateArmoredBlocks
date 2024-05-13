package com.quantumzizo.createarmoredblocks.datagen;

import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.foundation.data.TagGen.CreateTagsProvider;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.level.block.Block;

public class CABTags {
    public static void addGenerators() {
        CreateArmoredBlocks.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CABTags::genBlockTags);
    }
    private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
        CreateTagsProvider<Block> prov = new CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);
    }
}