class SpaceMission {
    private String destination;
    private String spacecraft;
    private int crewSize;
    private boolean isRobotic;
    private String primaryObjective;
    private int missionDurationDays;

    private SpaceMission() {}

    public static class Builder {
        private String destination;
        private String spacecraft;
        private int crewSize;
        private boolean isRobotic;
        private String primaryObjective;
        private int missionDurationDays;

        public Builder(String destination) {
            this.destination = destination;
        }

        public Builder spacecraft(String spacecraft) {
            this.spacecraft = spacecraft;
            return this;
        }

        public Builder crewSize(int crewSize) {
            this.crewSize = crewSize;
            return this;
        }

        public Builder isRobotic(boolean isRobotic) {
            this.isRobotic = isRobotic;
            return this;
        }

        public Builder primaryObjective(String primaryObjective) {
            this.primaryObjective = primaryObjective;
            return this;
        }

        public Builder missionDurationDays(int missionDurationDays) {
            this.missionDurationDays = missionDurationDays;
            return this;
        }

        public SpaceMission build() {
            SpaceMission mission = new SpaceMission();
            mission.destination = this.destination;
            mission.spacecraft = this.spacecraft;
            mission.crewSize = this.crewSize;
            mission.isRobotic = this.isRobotic;
            mission.primaryObjective = this.primaryObjective;
            mission.missionDurationDays = this.missionDurationDays;
            return mission;
        }
    }

    @Override
    public String toString() {
        return "SpaceMission{" +
                "destination='" + destination + '\'' +
                ", spacecraft='" + spacecraft + '\'' +
                ", crewSize=" + crewSize +
                ", isRobotic=" + isRobotic +
                ", primaryObjective='" + primaryObjective + '\'' +
                ", missionDurationDays=" + missionDurationDays +
                '}';
    }
}

public class SpaceMissionPlanner {
    public static void main(String[] args) {
        SpaceMission marsMission = new SpaceMission.Builder("Mars")
                .spacecraft("Resilience")
                .crewSize(4)
                .isRobotic(false)
                .primaryObjective("Establish first human colony")
                .missionDurationDays(900)
                .build();

        SpaceMission jupiterMission = new SpaceMission.Builder("Jupiter")
                .spacecraft("Voyager III")
                .isRobotic(true)
                .primaryObjective("Study Jovian moons")
                .missionDurationDays(2555)
                .build();

        System.out.println(marsMission);
        System.out.println(jupiterMission);
    }
}