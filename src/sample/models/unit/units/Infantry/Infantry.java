package sample.models.unit.units.Infantry;

import javafx.collections.ObservableList;
import sample.models.BaseItem;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Infantry extends BaseProfile {

    public Infantry(String name, int weaponSkill, int ballisticSkill, int strength, int toughness, int wounds, int initiative,
                    int attacks, int leadership, int armourSave) {
        this.name = name;
        this.weaponSkill = weaponSkill;
        this.ballisticSkill = ballisticSkill;
        this.strength = strength;
        this.toughness = toughness;
        this.wounds = wounds;
        this.initiative = initiative;
        this.attacks = attacks;
        this.leadership = leadership;
        this.armourSave = armourSave;
        this.itemType = "Infantry";
        this.invulnerableSave = 7;
        this.coverSave = 7;
    }

    public Infantry(String name, int weaponSkill, int ballisticSkill, int strength, int toughness, int wounds, int initiative,
                    int attacks, int leadership, int armourSave, int invulnerableSave, int coverSave) {
        this.weaponSkill = weaponSkill;
        this.ballisticSkill = ballisticSkill;
        this.strength = strength;
        this.toughness = toughness;
        this.wounds = wounds;
        this.initiative = initiative;
        this.attacks = attacks;
        this.leadership = leadership;
        this.armourSave = armourSave;
        this.invulnerableSave = invulnerableSave;
        this.coverSave = coverSave;
        this.itemType = "Infantry";
    }

    @Override
    public ObservableList<BaseItem> getChildren() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
