package mrtjp.projectred.expansion;

import static mrtjp.projectred.ProjectRedExpansion.blockMachines;
import static mrtjp.projectred.ProjectRedExpansion.itemVAWT;
import mrtjp.projectred.core.Configurator;
import mrtjp.projectred.core.IProxy;
import mrtjp.projectred.expansion.BlockMachines.EnumMachine;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExpansionProxy implements IProxy {

    public static final int alloySmelterWatcherUpdate = 1;

    @Override
    public void preinit() {

    }

    @Override
    public void init() {
        blockMachines = new BlockMachines(Configurator.block_machinesID.getInt());
        GameRegistry.registerBlock(blockMachines, ItemBlockMachines.class, "projectred.expansion.machines");
        for (EnumMachine m : EnumMachine.VALID_MACHINES) {
            GameRegistry.registerTileEntity(m.clazz, "tile.projectred.machines." + m.unlocalname);
        }

        itemVAWT = new ItemVAWT(Configurator.item_vawtID.getInt());
    }

    @Override
    public void postinit() {
        ExpansionRecipes.initRecipes();
    }

}
