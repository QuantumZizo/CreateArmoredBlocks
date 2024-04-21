package com.quantumzizo.createarmoredblocks.datagen.loot;

import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

import static com.quantumzizo.createarmoredblocks.CreateArmoredBlocks.REGISTRATE;

public class CABBlockLootTables extends BlockLootSubProvider {
    public CABBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(CABBlocks.CAST_IRON_ARMOR_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return REGISTRATE.getAll(Registries.BLOCK).stream().map(RegistryEntry::get)::iterator;
    }
}
