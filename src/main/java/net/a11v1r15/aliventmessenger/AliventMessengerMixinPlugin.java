package net.a11v1r15.aliventmessenger;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.minecraft.SharedConstants;

public class AliventMessengerMixinPlugin implements IMixinConfigPlugin {
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if(SharedConstants.getProtocolVersion() >= 1073742002){ //Snapshot 24w09a, that introduced Item Components
            if      (mixinClassName.contains("OneTwentyFive")) return true;
            else if (mixinClassName.contains("OneTwentyZero")) return false;
        }
        else {
            if      (mixinClassName.contains("OneTwentyFive")) return false;
            else if (mixinClassName.contains("OneTwentyZero")) return true;
        }
        return true;
    }

    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {return null;}

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {return null;}

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

}
