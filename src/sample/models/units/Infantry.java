package sample.models.units;

import javafx.collections.ObservableList;
import sample.models.BaseItem;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Infantry extends BaseProfile {

    public Infantry(int weaponSkill, int ballisticSkill, int strength, int toughness, int wounds, int initiative,
                    int attacks, int leadership, int armourSave) {
        this.weaponSkill = weaponSkill;
        this.ballisticSkill = ballisticSkill;
        this.strength = strength;
        this.toughness = toughness;
        this.wounds = wounds;
        this.initiative = initiative;
        this.attacks = attacks;
        this.leadership = leadership;
        this.armourSave = armourSave;
    }

    public Infantry(int weaponSkill, int ballisticSkill, int strength, int toughness, int wounds, int initiative,
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
    }

    @Override
    public ObservableList<BaseItem> getChildren() {
        return null;
    }
}
