package com.rutaji.exaqua.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.rutaji.exaqua.ExAqua;
import com.rutaji.exaqua.block.SqueezerBlock;
import com.rutaji.exaqua.container.SqueezerContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Screen for {@link SqueezerBlock squeezer} UI.
 * This class handles graphic on clinets side. Logic is handled by {@link SqueezerContainer SieveContainer}.
 */
public class SqueezerScreen extends ContainerScreen<SqueezerContainer> {
    private final ResourceLocation GUI = new ResourceLocation(ExAqua.MOD_ID,"gui/squeezer.png");
    //region Constructor
    public SqueezerScreen(SqueezerContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
    }
    //endregion

    @Override
    protected void drawGuiContainerBackgroundLayer(@NotNull MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
        DrawLiquid(i,j,matrixStack);

    }
    private void DrawLiquid(int i,int j,MatrixStack matrixStack){
        String liguid = container.GetLiquid();
        Minecraft.getInstance().fontRenderer.drawString(matrixStack,liguid , i +87 - font.getStringWidth(liguid)/2 , j+10, 0x111111);
        String toDraw = container.GetLiquidAmount() +" mB";
        if(!liguid.equals("Empty")) {Minecraft.getInstance().fontRenderer.drawString(matrixStack,toDraw, i +87 - font.getStringWidth(toDraw)/2 , j+20, 0x111111);}

    }
    @Override
    public void render(@NotNull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

    }
}
