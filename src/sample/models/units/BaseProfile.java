package sample.models.units;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class BaseProfile extends Model {
    //region Variables
    protected int moveSpeed;
    protected int weaponSkill;
    protected int ballisticSkill;
    protected int strength;
    protected int toughness;
    protected int wounds;
    protected int initiative;
    protected int attacks;
    protected int leadership;
    protected int armourSave;

    //endregion

    //region Getters and Setters
    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(int weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public int getWounds() {
        return wounds;
    }

    public void setWounds(int wounds) {
        this.wounds = wounds;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getArmourSave() {
        return armourSave;
    }

    public void setArmourSave(int armourSave) {
        this.armourSave = armourSave;
    }


    //endregion

    public List<Integer> getBaseProfile() {
        List<Integer> returnedList =  Arrays.asList(weaponSkill, ballisticSkill, strength, toughness, wounds, initiative, attacks, leadership, armourSave, invulnerableSave, coverSave);
        return returnedList;
    }

    @Override
    public String toString() {
        return this.getBaseProfile().toString();
    }


}
