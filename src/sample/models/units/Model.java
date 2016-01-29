package sample.models.units;

import sample.models.BaseItem;
import sample.models.HierarchyData;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class Model extends BaseItem {

    //region Variables
    protected int invulnerableSave;
    protected int coverSave;
    //endregion

    //region Getters and Setters
    public int getInvulnerableSave() {
        return invulnerableSave;
    }

    public void setInvulnerableSave(int invulnerableSave) {
        this.invulnerableSave = invulnerableSave;
    }

    public int getCoverSave() {
        return coverSave;
    }

    public void setCoverSave(int coverSave) {
        this.coverSave = coverSave;
    }
    //endregion

}
