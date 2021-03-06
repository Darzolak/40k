package sample.view;

import javafx.scene.control.TreeItem;
import sample.Controller;
import sample.models.BaseItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jordane on 21/07/2015.
 */
public class HierarchyTracker {

    private static Boolean collapsedDefault = Boolean.FALSE;

    /**
     * A map to keep track of if items are expanded or not. True if expanded.
     */
    private static Map<BaseItem, Boolean> collapseMap = new HashMap<>();
    private static Map<TreeEntry, Boolean> collapseParentMap = new HashMap<>();


    static class TreeEntry {
        BaseItem item;
        BaseItem parent;

        TreeEntry(BaseItem item, BaseItem parent) {
            this.item = item;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final TreeEntry other = (TreeEntry) obj;
            if (this.item != other.item) {
                return false;
            }
            return this.parent == other.parent;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + (this.item != null ? this.item.hashCode() : 0);
            hash = 53 * hash + (this.parent != null ? this.parent.hashCode() : 0);
            return hash;
        }
    }


    /**
     * Analyses items in the workspace (usually after a deserialization,) and adds their expansion values to the
     * tracking map
     */
    public static void expandWorkspace() {
        //collapseMap.put(Global.currentWorkspace, true);
        collapseParentMap.put(new TreeEntry(Controller.army, null), true);
    }


    /**
     * Refreshes the mapping of the tree items and if they are expanded or not.
     *
     * @param tree The tree to map items for
     */
    public static void refreshMap(TreeViewWithItems<BaseItem> tree) {
        /*for (TreeItem<Model> item : tree.getTreeItems()) {
            //System.out.println(item + " " + item.isExpanded());
            collapseMap.put(item.getValue(), item.isExpanded());
        }*/

        for (TreeItem<BaseItem> item : tree.getTreeItems()) {

            TreeEntry entry;
            if (item.getParent() != null && item.getParent().getValue() != null) {
                entry = new TreeEntry(item.getValue(), item.getParent().getValue());
            }
            else {
                entry = new TreeEntry(item.getValue(), null);
            }

            collapseParentMap.put(entry, item.isExpanded());
        }
    }

    /**
     * Restores the mapping of the tree items from the internal dictionary of expanded items.
     *
     * @param tree The tree to restore the mapping of
     */
    public static void restoreMap(TreeViewWithItems<BaseItem> tree) {
        /*for (TreeItem<Model> item : tree.getTreeItems()) {
            item.setExpanded(isExpanded(item.getValue()));
        }*/

        for (TreeItem<BaseItem> item : tree.getTreeItems()) {
            TreeEntry entry;
            if (item.getParent() != null && item.getParent().getValue() != null) {
                entry = new TreeEntry(item.getValue(), item.getParent().getValue());
            }
            else {
                entry = new TreeEntry(item.getValue(), null);
            }
            item.setExpanded(isExpanded(entry));
        }
    }

    /**
     * Checks to see if an item in the tree is expanded or not. If the items
     * aren't in the dictionary, they are treated as expanded by default.
     *
     * @param item The item to check
     * @return If the item is expanded
     */
    public static Boolean isExpanded(TreeEntry item) {
        /*if (collapseMap.containsKey(item)) {
            return collapseMap.get(item);
        }
        else {
            return collapsedDefault;
        }*/

        if (collapseParentMap.containsKey(item)) {
            return collapseParentMap.get(item);
        }
        else {
            return collapsedDefault;
        }
    }

    /**
     * Expands all items in the tree by mapping all of the items inside of it to true, and then
     * restoring the map state from the dictionary
     *
     * @param tree The tree to expand all items of
     */
    public static void expandAll(TreeViewWithItems<BaseItem> tree) {
        /*for (TreeItem<Model> item : tree.getTreeItems()) {
            collapseMap.put(item.getValue(), Boolean.TRUE);
        }*/

        for (TreeItem<BaseItem> item : tree.getTreeItems()) {
            TreeEntry entry;
            if (item.getParent() != null && item.getParent().getValue() != null) {
                entry = new TreeEntry(item.getValue(), item.getParent().getValue());
            }
            else {
                entry = new TreeEntry(item.getValue(), null);
            }
            collapseParentMap.put(entry, Boolean.TRUE);
        }

        restoreMap(tree);
    }
}
