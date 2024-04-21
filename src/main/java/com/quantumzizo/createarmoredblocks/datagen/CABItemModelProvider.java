package com.quantumzizo.createarmoredblocks.datagen;

import com.quantumzizo.createarmoredblocks.CreateArmoredBlocks;
import com.simibubi.create.Create;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CABItemModelProvider extends ItemModelProvider {
    public CABItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateArmoredBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateArmoredBlocks.MOD_ID, "item/"+item.getId().getPath()));
    }
}
