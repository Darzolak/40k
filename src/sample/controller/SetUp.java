package sample.controller;

import sample.models.Army;
import sample.models.unit.InfantryUnit;
import sample.models.unit.units.Infantry.Infantry;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;
import sample.models.wargear.WeaponType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darzolak on 22-Mar-16.
 */
public class SetUp {

    public static Army setUpArmy() {
        Army chaosSpaceMarines = new Army();
        InfantryUnit chaosMarines = new InfantryUnit("Chaos Space Marines");
        Infantry chaosSpaceMarine1 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine2 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine3 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine4 = new Infantry("Chaos Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarineCaptain = new Infantry("Aspiring Champion", 4,4,4,4,1,4,2,9,3);

        Weapon bolter = new Weapon(24, 4, 5, WeaponType.Rapid_Fire, 1);
        Weapon missileLauncher = new Weapon(48, 8, 3, WeaponType.Heavy, 1);
        Weapon boltPistol = new Weapon(12, 4, 5, WeaponType.Pistol, 1);
        Weapon chainSword = new Weapon(12, 4, 0, WeaponType.Melee);

        chaosSpaceMarine1.addRangedWeapon(bolter);
        chaosSpaceMarine2.addRangedWeapon(bolter);
        chaosSpaceMarine3.addRangedWeapon(bolter);
        chaosSpaceMarine4.addRangedWeapon(bolter);
        chaosSpaceMarine4.addRangedWeapon(missileLauncher);
        chaosSpaceMarineCaptain.addRangedWeapon(boltPistol);
        chaosSpaceMarineCaptain.addAssaultWeapon(chainSword);

        chaosMarines.addModels(chaosSpaceMarine1);
        chaosMarines.addModels(chaosSpaceMarine2);
        chaosMarines.addModels(chaosSpaceMarine3);
        chaosMarines.addModels(chaosSpaceMarine4);
        chaosMarines.addModels(chaosSpaceMarineCaptain);

        InfantryUnit chaosMarines1 = new InfantryUnit("Space Marines");
        Infantry chaosSpaceMarine11 = new Infantry("Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine12 = new Infantry("Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine13 = new Infantry("Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarine14 = new Infantry("Space Marine", 4,4,4,4,1,4,1,8,3);
        Infantry chaosSpaceMarineCaptain1 = new Infantry("Space Marine Sergeant", 4,4,4,4,1,4,2,9,3);

        chaosSpaceMarine11.addRangedWeapon(bolter);
        chaosSpaceMarine12.addRangedWeapon(bolter);
        chaosSpaceMarine13.addRangedWeapon(bolter);
        chaosSpaceMarine14.addRangedWeapon(bolter);
        chaosSpaceMarine14.addRangedWeapon(missileLauncher);
        chaosSpaceMarineCaptain.addRangedWeapon(boltPistol);
        chaosSpaceMarineCaptain.addAssaultWeapon(chainSword);

        chaosMarines1.addModels(chaosSpaceMarine11);
        chaosMarines1.addModels(chaosSpaceMarine12);
        chaosMarines1.addModels(chaosSpaceMarine13);
        chaosMarines1.addModels(chaosSpaceMarine14);
        chaosMarines1.addModels(chaosSpaceMarineCaptain1);

        Map<Weapon, ArrayList<Model>> map = new HashMap<Weapon, ArrayList<Model>>() {
        };
        ArrayList<Model> models = new ArrayList<>();

        models.add(chaosSpaceMarine1);
        models.add(chaosSpaceMarine2);
        models.add(chaosSpaceMarine3);
        models.add(chaosSpaceMarine4);
        models.add(chaosSpaceMarineCaptain);

        map.put(bolter, models);

        chaosSpaceMarines.addUnits(chaosMarines);
        chaosSpaceMarines.addUnits(chaosMarines1);





        return chaosSpaceMarines;
    }
}
