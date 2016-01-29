package sample.controller;

import sample.models.units.BaseProfile;

import java.util.ArrayList;

/**
 * Created by Darzolak on 29-Jan-16.
 */
public class Compare {

    public static ArrayList<Integer> comparebaseStats(BaseProfile unit1, BaseProfile unit2) {
        ArrayList<Integer> comparedList = new ArrayList<>();
        for (int i = 0; i < unit1.getBaseProfile().size(); i++)
        {
            comparedList.add(unit1.getBaseProfile().get(i) - unit2.getBaseProfile().get(i));
        }
        return comparedList;
    }
}
