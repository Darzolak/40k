package sample.view.scenes.unitScenes;

import sample.models.BaseItem;
import sample.models.Unit;
import sample.view.scenes.BaseScene;
import sample.view.scenes.ISceneSwitcher;

/**
 * Created by Darzolak on 30-Jan-16.
 */
public class UnitScene extends BaseScene implements ISceneSwitcher {

    public UnitScene() {

    }

    @Override
    public void buildScene(BaseItem item) {
        Unit unit = (Unit) item;
    }
}
