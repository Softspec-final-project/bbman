package game;

import model.Component;
import runHere.Main;

public class Fire implements Component {
    private int x;
    private int y;
    private Main display;
    private boolean isFiring;
    private int timeStamp;

    public Fire(Main display) {
        this.x = -64;
        this.y = -64;
        this.timeStamp = 0;
        this.isFiring = false;
        this.display = display;
    }

    public void start(int x, int y) {
        this.isFiring = true;
        this.x = x;
        this.y = y;
        this.timeStamp = display.millis();
    }

    public void stop() {
        this.isFiring = false;
        this.x = -64;
        this.y = -64;
    }


    public boolean isFiring() {
        return isFiring;
    }

    @Override
    public void render() {
        if(display.millis() - timeStamp < 500) {
            display.image(display.Flame.get(0), this.x, this.y);
        } else {
            stop();
            if (Coordinates.getInstance().getXs().size() > 0) {
                Coordinates.getInstance().removeHead();
            }
        }
    }

    public void reset() {
        this.x = -64;
        this.y = -64;
        this.timeStamp = 0;
        this.isFiring = false;
        render();
    }
}
