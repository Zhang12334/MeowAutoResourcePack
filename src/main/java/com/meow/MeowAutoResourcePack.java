package com.meow;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.resource.ClientResourcePackProfile;
import net.minecraft.client.resource.ResourcePackManager;
import net.minecraft.client.resource.ResourcePackSource;
import net.minecraft.resource.ResourcePack;
import net.minecraft.util.Identifier;

public class MeowAutoResourcePackClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // 监听资源包请求
        MinecraftClient.getInstance().getResourcePackManager().registerListener((profile, action) -> {
            if (action == ResourcePackManager.ProfileAction.ADD) {
                // 自动接受所有资源包
                System.out.println("Automatically accepting resource pack: " + profile.getName());
                profile.getResourcePack().add(ResourcePackSource.PACK_SOURCE_SERVER);
            }
        });
    }
}
