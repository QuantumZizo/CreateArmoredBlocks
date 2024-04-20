package com.quantumzizo.createarmoredblocks;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateArmoredBlocks.MOD_ID)
public class CreateArmoredBlocks {
    public static final String MOD_ID = "createarmoredblocks";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateArmoredBlocks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
