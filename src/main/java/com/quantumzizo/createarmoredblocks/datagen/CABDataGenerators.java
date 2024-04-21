package com.quantumzizo.createarmoredblocks.datagen;

import com.google.common.eventbus.Subscribe;
import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
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
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new CABRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), CABLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new CABBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new CABItemModelProvider(packOutput, existingFileHelper));

        CABBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new CABBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new CABItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
