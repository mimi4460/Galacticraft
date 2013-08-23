package micdoodle8.mods.galacticraft.jupiter.client;

import java.util.EnumSet;

import micdoodle8.mods.galacticraft.API.IGalacticraftSubModClient;
import micdoodle8.mods.galacticraft.API.IMapPlanet;
import micdoodle8.mods.galacticraft.API.IPlanetSlotRenderer;
import micdoodle8.mods.galacticraft.callisto.client.GCCallistoMapPlanet;
import micdoodle8.mods.galacticraft.core.GCCoreLocalization;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.europa.client.ClientProxyEuropa;
import micdoodle8.mods.galacticraft.europa.client.GCEuropaMapPlanet;
import micdoodle8.mods.galacticraft.io.client.ClientProxyIo;
import micdoodle8.mods.galacticraft.io.client.GCIoMapPlanet;
import micdoodle8.mods.galacticraft.jupiter.CommonProxyJupiter;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Copyright 2012-2013, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class ClientProxyJupiter extends CommonProxyJupiter implements IGalacticraftSubModClient
{
	public static GCCoreLocalization lang;
	
	public static ClientProxyIo moonClientIo = new ClientProxyIo();
	public static ClientProxyEuropa moonClientEuropa = new ClientProxyEuropa();
	public static ClientProxyCallisto moonClientCallisto = new ClientProxyCallisto();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		moonClientIo.preInit(event);
		moonClientEuropa.preInit(event);
		moonClientCallisto.preInit(event);
		ClientProxyJupiter.lang = new GCCoreLocalization("micdoodle8/mods/galacticraft/jupiter/client");
	}

	@Override
	public void init(FMLInitializationEvent event) 
	{
		moonClientIo.init(event);
		moonClientEuropa.init(event);
		moonClientCallisto.init(event);
		GalacticraftCore.registerClientSubMod(this);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		moonClientIo.postInit(event);
		moonClientEuropa.postInit(event);
	        moonClientCallisto.postInit(event);
	}
	
	@Override
	public void registerRenderInformation() 
	{
	}

	@Override
    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean b)
    {
    }
	
    public class ClientPacketHandler implements IPacketHandler
    {
		@Override
		public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
		{
			
		}
    }
    
    public static class TickHandlerClient implements ITickHandler
    {
    	@Override
    	public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
    		
        }

    	@Override
    	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
    	{
    	}
    	
        @Override
		public String getLabel()
        {
            return "Galacticraft Jupiter Client";
        }

    	@Override
    	public EnumSet<TickType> ticks() 
    	{
    		return EnumSet.of(TickType.CLIENT);
    	}
    }

	@Override
	public String getDimensionName() 
	{
		return "Jupiter";
	}

	@Override
	public GCCoreLocalization getLanguageFile() 
	{
		return ClientProxyJupiter.lang;
	}

	@Override
	public String getPlanetSpriteDirectory() 
	{
		return "/micdoodle8/mods/galacticraft/jupiter/client/planets/";
	}

	@Override
	public IPlanetSlotRenderer getSlotRenderer() 
	{
		return new GCJupiterSlotRenderer();
	}
	
	private IMapPlanet jupiter = new GCJupiterMapPlanet();

	@Override
	public IMapPlanet getPlanetForMap() 
	{
		return jupiter;
	}

	@Override
	public IMapPlanet[] getChildMapPlanets() 
	{
		IMapPlanet[] moonMapPlanet = {new GCCallistoMapPlanet(), new GCEuropaMapPlanet(), new GCIoMapPlanet()};
		
		return moonMapPlanet;
	}

	@Override
	public String getPathToMusicFile() 
	{
		return null;
	}
}
