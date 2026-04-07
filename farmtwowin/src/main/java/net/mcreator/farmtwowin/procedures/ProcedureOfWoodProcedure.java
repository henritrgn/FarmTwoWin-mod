package net.mcreator.farmtwowin.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.farmtwowin.network.FarmtwowinModVariables;
import net.mcreator.farmtwowin.FarmtwowinMod;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class ProcedureOfWoodProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		if (!world.isClientSide() && event instanceof net.minecraftforge.event.level.BlockEvent.BreakEvent e
				&& e.getState().is(net.minecraft.tags.BlockTags.LOGS)) {
			{
				entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.Count_log_mined = entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).orElseGet(FarmtwowinModVariables.PlayerVariables::new).Count_log_mined + 1;
					capability.markSyncDirty();
				});
			}
			FarmtwowinMod.LOGGER.info(entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).orElseGet(FarmtwowinModVariables.PlayerVariables::new).Count_log_mined);
			if (entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).orElseGet(FarmtwowinModVariables.PlayerVariables::new).Count_log_mined == 20) {
				FarmtwowinMod.LOGGER.info(entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).orElseGet(FarmtwowinModVariables.PlayerVariables::new).Count_log_mined);
				{
					entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
						capability.Count_log_mined = 0;
						capability.markSyncDirty();
					});
				}
				FarmtwowinMod.LOGGER.info(entity.getCapability(FarmtwowinModVariables.PLAYER_VARIABLES).orElseGet(FarmtwowinModVariables.PlayerVariables::new).Count_log_mined);
				Random = new Random().nextGaussian();
				FarmtwowinMod.LOGGER.info(Random);
				if (Random < -2) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.STICK).copy();
						_setstack.setCount(10);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					FarmtwowinMod.LOGGER.info("Classic drop ...");
				} else if (-2 <= Random && Random < -1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Blocks.JUNGLE_LOG).copy();
						_setstack.setCount(3);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Blocks.OAK_LOG).copy();
						_setstack.setCount(5);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					
					FarmtwowinMod.LOGGER.info("\"Why not ?\" drop ...");
				} else if (-1 <= Random && Random < 1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Blocks.JUNGLE_LOG).copy();
						_setstack.setCount(5);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Blocks.OAK_LOG).copy();
						_setstack.setCount(10);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.APPLE).copy();
						_setstack.setCount(3);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					FarmtwowinMod.LOGGER.info("Regular drop.");
				} else if (1 <= Random && Random < 2) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.APPLE).copy();
						_setstack.setCount(5);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.GOLDEN_APPLE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					FarmtwowinMod.LOGGER.info("Rare drop !");
				} else if (2 <= Random && Random < 2.4) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.GOLDEN_APPLE).copy();
						_setstack.setCount(3);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					
					FarmtwowinMod.LOGGER.info("Double-rare drop !");
				} else if (2.4 <= Random) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE).copy();
						_setstack.setCount(2);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.GOLDEN_APPLE).copy();
						_setstack.setCount(5);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					FarmtwowinMod.LOGGER.info("Ultra-rare drop !!");
				}
			}
		}
	}
}