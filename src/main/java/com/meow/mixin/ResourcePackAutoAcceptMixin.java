package com.meow.mixin.client;

import net.minecraft.client.resource.ClientResourcePackProfile;
import net.minecraft.client.resource.ResourcePackManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ResourcePackManager.class)
public abstract class ResourcePackAutoAcceptMixin {
    @Shadow
    public abstract void add(ClientResourcePackProfile profile);

    public void autoAcceptResourcePack(ClientResourcePackProfile profile) {
        // 自动添加资源包
        add(profile);
        System.out.println("Auto-accepted resource pack: " + profile.getName());
    }
}
