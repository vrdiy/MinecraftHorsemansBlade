package net.fabricmc.example;

import java.rmi.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PumpkinCubeBlockEntity extends BlockEntity {
    public PumpkinCubeBlockEntity(BlockPos pos, BlockState state){
        super(PUMPKIN_CUBE_BLOCK_ENTITY,pos,state);
    }
    
    public static final BlockEntityType<PumpkinCubeBlockEntity> PUMPKIN_CUBE_BLOCK_ENTITY = Registry.register(
        Registry.BLOCK_ENTITY_TYPE,
        new Identifier("tutorial", "demo_block_entity"),
        FabricBlockEntityTypeBuilder.create(PumpkinCubeBlockEntity::new, PUMPKIN_CUBE_BLOCK).build()
    );
    
}
