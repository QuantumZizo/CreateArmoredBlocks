package com.quantumzizo.createarmoredblocks;

import com.mojang.logging.LogUtils;
import com.quantumzizo.createarmoredblocks.datagen.CABDataGenerators;
import com.quantumzizo.createarmoredblocks.index.CABBlocks;
import com.quantumzizo.createarmoredblocks.index.CABCreativeTab;
import com.quantumzizo.createarmoredblocks.index.CABItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.quantumzizo.createarmoredblocks.index.CABBlocks.*;

@Mod(CreateArmoredBlocks.MOD_ID)
public class CreateArmoredBlocks {
    public static final String MOD_ID = "createarmoredblocks";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateArmoredBlocks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::debugLog);
        modEventBus.addListener(EventPriority.LOWEST, CABDataGenerators::gatherData);

        CABBlocks.register();
        CABItems.register();
        CABCreativeTab.register(modEventBus);

        REGISTRATE.registerEventListeners(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void debugLog(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}