// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.path;

import java.util.HashMap;

import simulator.LocationState;
import simulator.SimCoordinator;
import simulator.events.SimEventDispatcher;

public class PathManager {

    private HashMap<String, Path> paths = new HashMap<String, Path>();

    public PathManager() {
        super();
    }

    public void addPath(int positionX, int positionY, int positionZ) {
        if (!pathExists(positionX, positionY, positionZ)) {
            boolean locationWithinGrid = SimCoordinator.getInstance()
                    .locationWithinGrid(positionX, positionY, positionZ);
            if (locationWithinGrid) {
                String pathID = createPathID(positionX, positionY, positionZ);
                Path path = new Path(pathID, positionX, positionY, positionZ);
                paths.put(pathID, path);
                SimEventDispatcher.getInstance().notifyPathAdded(path);
            }
        }
    }

    public void removePath(int positionX, int positionY, int positionZ) {
        if (pathExists(positionX, positionY, positionZ)) {
            String pathID = createPathID(positionX, positionY, positionZ);
            if (paths.get(pathID).isEmpty()) {
                Path path = paths.remove(pathID);
                SimEventDispatcher.getInstance().notifyPathRemoved(path);
            }
        }

    }

    public Path getPath(int positionX, int positionY, int positionZ) {
        String pathID = createPathID(positionX, positionY, positionZ);
        return paths.get(pathID);
    }

    public boolean pathExists(int positionX, int positionY, int positionZ) {
        String pathID = createPathID(positionX, positionY, positionZ);
        return paths.containsKey(pathID) ? true : false;
    }

    private String createPathID(int positionX, int positionY, int positionZ) {
        return "P-" + positionX + "-" + positionY + "-" + positionZ;
    }

    public void clear() {
        String copyOfPathIDs[] = new String[paths.size()];
        paths.keySet().toArray(copyOfPathIDs);
        for (String pathID : copyOfPathIDs) {
            Path pathToRemove = paths.get(pathID);
            this.removePath(pathToRemove.getPositionX(),
                    pathToRemove.getPositionY(), pathToRemove.getPositionZ());
        }
    }

    public LocationState queryLocationContents(int positionX, int positionY,
            int positionZ) {
        Path path = getPath(positionX, positionY, positionZ);
        return new LocationState(path);
    }

    public void resetPaths() {
        for (Path path : paths.values()) {
            path.reset();
        }
    }

}
