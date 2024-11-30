package com.meow.meowautoresourcepack;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.c2s.play.ResourcePackStatusC2SPacket;
import net.minecraft.text.Text;

public class MeowAutoResourcePack implements ModInitializer {

    @Override
    public void onInitialize() {
        // 初始化mod
    }

    public static void sendResourcePackRequest() {
        // 发送资源包请求
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        if (networkHandler != null) {
            // ACCEPTED 一把梭
            networkHandler.sendPacket(new ResourcePackStatusC2SPacket(ResourcePackStatusC2SPacket.Action.ACCEPTED));
        }
    }
}
