package net.fabricmc.example;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class PumpkinCubeEntityRenderer extends MobEntityRenderer<PumpkinCubeEntity,PumpkinCubeEntityModel> {

    public PumpkinCubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PumpkinCubeEntityModel(context.getPart(ExampleModClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(PumpkinCubeEntity var1) {
        return new Identifier("vrdiyentity", "textures/entity/pumpkin_cube/pumpkin_cube.png");
    }

    @Override
    public void render(PumpkinCubeEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        Entity entity = ((PumpkinCubeEntity)mobEntity).getHoldingEntity();
        if (entity == null) {
            return;
        }
        
    }
}
