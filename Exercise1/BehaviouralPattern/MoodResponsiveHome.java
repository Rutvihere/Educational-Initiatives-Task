interface MoodState {
    void adjustLighting();
    void playMusic();
    void setTemperature();
}

class HappyState implements MoodState {
    public void adjustLighting() {
        System.out.println("Bright, warm lighting activated");
    }
    public void playMusic() {
        System.out.println("Upbeat playlist started");
    }
    public void setTemperature() {
        System.out.println("Temperature set to comfortable 22°C");
    }
}

class RelaxedState implements MoodState {
    public void adjustLighting() {
        System.out.println("Soft, dim lighting activated");
    }
    public void playMusic() {
        System.out.println("Ambient playlist started");
    }
    public void setTemperature() {
        System.out.println("Temperature set to cozy 24°C");
    }
}

class FocusedState implements MoodState {
    public void adjustLighting() {
        System.out.println("Bright, cool lighting activated");
    }
    public void playMusic() {
        System.out.println("Instrumental focus playlist started");
    }
    public void setTemperature() {
        System.out.println("Temperature set to alert 20°C");
    }
}

class SmartHome {
    private MoodState currentState;

    public void setState(MoodState state) {
        this.currentState = state;
    }

    public void moodDetected() {
        currentState.adjustLighting();
        currentState.playMusic();
        currentState.setTemperature();
    }
}


public class MoodResponsiveHome {
    public static void main(String[] args) {
        SmartHome home = new SmartHome();

        home.setState(new HappyState());
        home.moodDetected();

        home.setState(new RelaxedState());
        home.moodDetected();

        home.setState(new FocusedState());
        home.moodDetected();
    }
}