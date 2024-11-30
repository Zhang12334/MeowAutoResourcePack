package com.meow;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.ClientResourcePackProfile;
import net.minecraft.client.resource.ResourcePackManager;
import net.minecraft.client.resource.ResourcePackSource;

public class MeowAutoResourcePackClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // 自动接受资源包请求的逻辑
        MinecraftClient.getInstance().getResourcePackManager().registerListener((profile, action) -> {
            if (action == ResourcePackManager.ProfileAction.ADD) {
                profile.getResourcePack().add(ResourcePackSource.PACK_SOURCE_SERVER);
                System.out.println("自动接受资源包: " + profile.getName());
            }
        });
    }
}
