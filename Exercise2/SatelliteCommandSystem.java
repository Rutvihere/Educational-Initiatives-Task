import java.util.logging.Logger;
import java.util.logging.Level;

// Command interface
interface Command {
    void execute(Satellite satellite);
}

// Concrete command classes
class RotateCommand implements Command {
    private final String direction;

    public RotateCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Satellite satellite) {
        satellite.rotate(direction);
    }
}

class ActivatePanelsCommand implements Command {
    @Override
    public void execute(Satellite satellite) {
        satellite.activatePanels();
    }
}

class DeactivatePanelsCommand implements Command {
    @Override
    public void execute(Satellite satellite) {
        satellite.deactivatePanels();
    }
}

class CollectDataCommand implements Command {
    @Override
    public void execute(Satellite satellite) {
        satellite.collectData();
    }
}

// Satellite class
class Satellite {
    private static final Logger LOGGER = Logger.getLogger(Satellite.class.getName());
    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";
        this.solarPanelsActive = false;
        this.dataCollected = 0;
        LOGGER.info("Satellite initialized");
    }

    public void rotate(String direction) {
        try {
            if (!isValidDirection(direction)) {
                throw new IllegalArgumentException("Invalid direction");
            }
            this.orientation = direction;
            LOGGER.info("Satellite rotated to " + direction);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Rotation failed", e);
        }
    }

    private boolean isValidDirection(String direction) {
        return direction.equals("North") || direction.equals("South") || 
               direction.equals("East") || direction.equals("West");
    }

    public void activatePanels() {
        this.solarPanelsActive = true;
        LOGGER.info("Solar panels activated");
    }

    public void deactivatePanels() {
        this.solarPanelsActive = false;
        LOGGER.info("Solar panels deactivated");
    }

    public void collectData() {
        if (this.solarPanelsActive) {
            this.dataCollected += 10;
            LOGGER.info("Data collected. Total data: " + this.dataCollected);
        } else {
            LOGGER.warning("Cannot collect data. Solar panels are inactive.");
        }
    }

    public String getStatus() {
        return String.format("Orientation: %s, Solar Panels: %s, Data Collected: %d",
                             this.orientation, 
                             this.solarPanelsActive ? "Active" : "Inactive", 
                             this.dataCollected);
    }
}

// Command invoker
class SatelliteCommandInvoker {
    private static final Logger LOGGER = Logger.getLogger(SatelliteCommandInvoker.class.getName());

    public void executeCommand(Command command, Satellite satellite) {
        try {
            command.execute(satellite);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Command execution failed", e);
        }
    }
}

// Main class for demonstration
public class SatelliteCommandSystem {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        SatelliteCommandInvoker invoker = new SatelliteCommandInvoker();

        System.out.println("Initial State: " + satellite.getStatus());

        invoker.executeCommand(new RotateCommand("South"), satellite);
        invoker.executeCommand(new ActivatePanelsCommand(), satellite);
        invoker.executeCommand(new CollectDataCommand(), satellite);

        System.out.println("Final State: " + satellite.getStatus());
    }
}