package net.fabricmc.example;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
//NETHERITE(MiningLevels.NETHERITE, 2031, 9.0f, 4.0f, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));
public class PumpkinTools implements ToolMaterial {

    public static final PumpkinTools INSTANCE = new PumpkinTools();
    @Override
    public int getDurability() {
        return 2031;
      }
      @Override
      public float getMiningSpeedMultiplier() {
        return 8.0F;
      }
      @Override
      public float getAttackDamage() {
        return 4.0F;
      }
      @Override
      public int getMiningLevel() {
        return MiningLevels.NETHERITE;
      }
      @Override
      public int getEnchantability() {
        return 15;
      }
      @Override
      public net.minecraft.recipe.Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.PUMPKIN);
      }
}
