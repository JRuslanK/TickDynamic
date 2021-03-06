package com.wildex999.tickdynamic;

import java.util.Map;

import net.minecraft.launchwrapper.Launch;

import com.wildex999.patcher.EntityInjector;
import com.wildex999.patcher.TransformerPatcher;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.DependsOn;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@SortingIndex(1009) //Run after deobfuscation, and try to run after most other coremods
@MCVersion("1.7.10")
@DependsOn("forge")
@TransformerExclusions({ "com.wildex999", })
public class LoadingPlugin implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		boolean developmentEnvironment = (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
		
		//Only return the patcher if running in live environment, to allow for testing when running from eclipse
		if(!developmentEnvironment)
			return new String[] { TransformerPatcher.class.getName(), EntityInjector.class.getName() };
		else
			return new String[] { EntityInjector.class.getName() };
	}

	@Override
	public String getModContainerClass() {
		return TickDynamicMod.class.getName();
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

}
