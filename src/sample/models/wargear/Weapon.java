package sample.models.wargear;

/**
 * Created by Darzolak on 04-Feb-16.
 */
public class Weapon {

    //region variables
    private int range;
    private int strength;
    private int ap;
    private WeaponType weaponType;



    private int numberOfShots;
    //endregion

    public Weapon(int range, int strength, int ap, WeaponType weaponType) {
        this.range = range;
        this.strength = strength;
        this.ap = ap;
        this.weaponType = weaponType;
    }

    public Weapon(int range, int strength, int ap, WeaponType weaponType, int numberOfShots) {
        this.range = range;
        this.strength = strength;
        this.ap = ap;
        this.weaponType = weaponType;
        this.numberOfShots = numberOfShots;
    }

    //region getters and setters
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public int getNumberOfShots(int range) {
        return  this.range - range >= 0 ? (weaponType == WeaponType.Rapid_Fire && this.range - range <= range ? numberOfShots * 2: numberOfShots) : 0;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }
    //endregion

    public int antiTankComparison(Weapon weapon) {
        int rangeScore = (this.range > weapon.range ? this.range / weapon.range : weapon.range / this.range);
        int strengthScore = this.strength - weapon.strength;
        int apScore = (this.ap == 1 ? 3 : (this.ap == 2 ? 2 : 0)) - (weapon.ap == 1 ? 3 : (weapon.ap == 2 ? 2 : 0));
        int score = rangeScore + strengthScore + apScore;
        return score;
    }

    public int antiInfantryComparison(Weapon weapon) {
        return (this.range ^ weapon.range) + this.strength - weapon.strength + (this.ap < 4 ? 3 : (this.ap == 5 ? 1 : 0)) - (weapon.ap < 4 ? 3 : (weapon.ap == 5 ? 1 : 0));
    }
}
