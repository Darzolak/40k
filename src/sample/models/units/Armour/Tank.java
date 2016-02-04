package sample.models.units.Armour;

/**
 * Created by Darzolak on 04-Feb-16.
 */
public class Tank extends Vehicle {


    public Tank(int ballisticSkill, int frontArmour, int sideArmour, int rearArmour, int hullPoints) {
        this.ballisticSkill = ballisticSkill;
        this.frontArmour = frontArmour;
        this.sideArmour = sideArmour;
        this.rearArmour = rearArmour;
        this.hullPoints = hullPoints;
    }
}
