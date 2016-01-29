package sample.models.units;

import sample.models.BaseItem;
import sample.models.HierarchyData;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class Model extends BaseItem {

    //region Variables
    protected Integer invulnerableSave;
    protected Integer coverSave;
    //endregion

    //region Getters and Setters
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
    //endregion

}
