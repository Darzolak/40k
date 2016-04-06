package sample.controller;

/**
 * Created by Darzolak on 06-Apr-16.
 */
public class Statistics {
    int toHitNeeded = 0;
    int noHits = 0;
    int noHitsMade = 0;
    int toWound = 0;
    int noWounds = 0;
    int savesMade = 0;

    public Statistics() {

    }

    public int getNoHitsMade() {
        return noHitsMade;
    }

    public void setNoHitsMade(int noHitsMade) {
        this.noHitsMade = noHitsMade;
    }

    public int getToHitNeeded() {
        return toHitNeeded;
    }

    public void setToHitNeeded(int toHitNeeded) {
        this.toHitNeeded = toHitNeeded;
    }

    public int getNoHits() {
        return noHits;
    }

    public void setNoHits(int noHits) {
        this.noHits = noHits;
    }

    public int getToWound() {
        return toWound;
    }

    public void setToWound(int toWound) {
        this.toWound = toWound;
    }

    public int getNoWounds() {
        return noWounds;
    }

    public void setNoWounds(int noWounds) {
        this.noWounds = noWounds;
    }

    public int getSavesMade() {
        return savesMade;
    }

    public void setSavesMade(int savesMade) {
        this.savesMade = savesMade;
    }


}
