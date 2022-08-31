package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final PumpkinSword PUMPKIN_SWORD = new PumpkinSword(PumpkinTools.INSTANCE, 4,5.0F,new FabricItemSettings().group(ExampleMod.OTHER_GROUP));
	public static final ItemStack PUMPKIN_SWORD_ITEM_STACK = new ItemStack(PUMPKIN_SWORD);
	
	public static final EntityType<PumpkinCubeEntity> PUMPKIN_CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("vrdiyentity", "pumpkincube"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, PumpkinCubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("vrdiy", "pumpkin_sword"),PUMPKIN_SWORD);
		FabricDefaultAttributeRegistry.register(PUMPKIN_CUBE, PumpkinCubeEntity.createMobAttributes());
		LOGGER.info("Hello Fabric world!");
		//Registry.BLOCK.get(minecraft.CARVED_PUMPKIN)
	}

	//public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
    //    new Identifier("vrdiy", "general"),
    //    () -> new ItemStack(Blocks.COBBLESTONE));

 
    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
        new Identifier("vrdiy", "other"))
        .icon(() -> PUMPKIN_SWORD_ITEM_STACK)
        .appendItems(stacks -> {
            stacks.add(PUMPKIN_SWORD_ITEM_STACK);
            //stacks.add(new ItemStack(Items.APPLE));
            //stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
            //stacks.add(ItemStack.EMPTY);
            //stacks.add(new ItemStack(Items.IRON_SHOVEL));
        })
        .build();


	
}
