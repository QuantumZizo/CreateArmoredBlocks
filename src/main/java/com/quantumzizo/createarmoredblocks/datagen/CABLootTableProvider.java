package com.quantumzizo.createarmoredblocks.datagen;

import com.quantumzizo.createarmoredblocks.datagen.loot.CABBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CABLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(CABBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
