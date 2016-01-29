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
    protected Integer moveSpeed;
    protected Integer weaponSkill;
    protected Integer ballisticSkill;
    protected Integer strength;
    protected Integer toughness;
    protected Integer wounds;
    protected Integer initiative;
    protected Integer attacks;
    protected Integer leadership;
    protected Integer armourSave;

    //endregion

    //region Getters and Setters
    public Integer getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Integer moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Integer getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(Integer weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public Integer getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(Integer ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    public Integer getWounds() {
        return wounds;
    }

    public void setWounds(Integer wounds) {
        this.wounds = wounds;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getAttacks() {
        return attacks;
    }

    public void setAttacks(Integer attacks) {
        this.attacks = attacks;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getArmourSave() {
        return armourSave;
    }

    public void setArmourSave(Integer armourSave) {
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
