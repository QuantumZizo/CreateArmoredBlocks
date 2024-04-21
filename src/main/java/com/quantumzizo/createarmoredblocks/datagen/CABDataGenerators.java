package com.quantumzizo.createarmoredblocks.datagen;

import com.google.common.eventbus.Subscribe;
import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.quantumzizo.createarmoredblocks.datagen.recipe.CABRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CreateArmoredBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CABDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(true, new CABRecipeProvider(output));
        }
    }
}
