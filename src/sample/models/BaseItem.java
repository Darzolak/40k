package sample.models;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public abstract class BaseItem implements HierarchyData<BaseItem> {
    protected String itemType;
    protected String name;

    public String getItemType () {
        return itemType;
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }



}
