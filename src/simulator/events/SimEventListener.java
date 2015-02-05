// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public interface SimEventListener {

    void notifyPathAdded(PathAddedSimEvent event);

    void notifyPathRemoved(PathRemovedSimEvent event);

    void notifyRobotAdded(RobotAddedSimEvent event);

    void notifyRobotRemoved(RobotRemovedSimEvent event);

    void notifyItemAdded(ItemAddedSimEvent event);

    void notifyItemRemoved(ItemRemovedSimEvent event);

    void notifyRobotMoved(RobotMovedSimEvent event);

    void notifyRobotWaited(RobotWaitedSimEvent event);

    void notifyRobotProgrammed(RobotProgrammedSimEvent event);

    void notifyGridSizeChanged(GridSizeChangedSimEvent event);

    void notifySimStateChanged(SimStateChangedSimEvent event);

    void notifyItemPickedFromPath(ItemPickedFromPathSimEvent event);

    void notifyItemDroppedOnPath(ItemDroppedOnPathSimEvent event);

    void notifyItemPickedFromContainer(ItemPickedFromContainerSimEvent event);

    void notifyItemDroppedInContainer(ItemDroppedInContainerSimEvent event);

    void notifyRobotTurned(RobotTurnedSimEvent event);

    void notifyRobotOutOfBounds(RobotOutOfBoundsSimEvent event);

    void notifyRobotCollision(RobotCollisionSimEvent event);

    void notifyApplesInBins(ApplesInBinsSimEvent event);

    void notifySimStepChanged(SimStepChangedSimEvent event);
    
    void notifySimReset();

}
