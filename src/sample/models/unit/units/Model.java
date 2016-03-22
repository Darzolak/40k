package sample.models.unit.units;

import javafx.collections.ObservableList;
import sample.models.BaseItem;
import sample.models.wargear.Weapon;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class Model extends BaseItem {


    //region Variables
    protected int ballisticSkill;
    protected Integer invulnerableSave;
    protected Integer coverSave;
    protected ObservableList<Weapon> assaultWeapons = observableArrayList();
    protected ObservableList<Weapon> rangedWeapons = observableArrayList();
    //endregion

    //region Getters and Setters
    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public Integer getInvulnerableSave() {
        return invulnerableSave;
    }

    public void setInvulnerableSave(Integer invulnerableSave) {
        this.invulnerableSave = invulnerableSave;
    }

    public Integer getCoverSave() {
        return coverSave;
    }

    public void setCoverSave(Integer coverSave) {
        this.coverSave = coverSave;
    }

    public ObservableList<Weapon> getRangedWeapons() {
        return rangedWeapons;
    }

    public void setRangedWeapons(ObservableList<Weapon> rangedWeapons) {
        this.rangedWeapons = rangedWeapons;
    }

    public ObservableList<Weapon> getAssaultWeapons() {
        return assaultWeapons;
    }

    public void setAssaultWeapons(ObservableList<Weapon> assaultWeapons) {
        this.assaultWeapons = assaultWeapons;
    }
    //endregion

    public abstract int getBestSave(int ap, boolean ignoresCover);

    public void addAssaultWeapon(Weapon weaponToAdd) {
        assaultWeapons.add(weaponToAdd);
    }

    public void addRangedWeapon(Weapon weaponToAdd) {
        rangedWeapons.add(weaponToAdd);
    }

    public Weapon getRangedAntiTankWeapon() {
        Weapon returnedWeapon = null;
        for (Weapon weapon : rangedWeapons) {
            if (returnedWeapon != null) {
                if (weapon.antiTankComparison(returnedWeapon) > 0) {
                    returnedWeapon = weapon;
                }
            }
            else {
                returnedWeapon = weapon;
            }
        }
        return returnedWeapon;
    }
}
