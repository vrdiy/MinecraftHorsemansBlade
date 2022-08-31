package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ExampleModClient implements ClientModInitializer{
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("vrdiyentity", "pumpkincube"), "main");
    @Override
    public void onInitializeClient() {
        /*
         * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
         *
         * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
         */
        
        // In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
        EntityRendererRegistry.register(ExampleMod.PUMPKIN_CUBE, (context) -> {
            return new PumpkinCubeEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, PumpkinCubeEntityModel::getTexturedModelData);
    }

}
