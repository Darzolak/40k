package sample.models.unit;

import sample.Controller;
import sample.Main;
import sample.models.BaseItem;
import sample.models.unit.units.Armour.Vehicle;
import sample.models.unit.units.Model;
import sample.models.wargear.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Darzolak on 21-Mar-16.
 */
public class VehicleUnit extends Unit {
    int averageFrontArmour;
    int averageSideArmour;
    int averageRearArmour;

    public int getAverageFrontArmour() {
        return averageFrontArmour;
    }

    public int getAverageSideArmour() {
        return averageSideArmour;
    }

    public int getAverageRearArmour() {
        return averageRearArmour;
    }

    public VehicleUnit(String unitName) {
        super(unitName);
    }

    @Override
    public Unit casualties(int numberOfHits, Weapon weaponFiring) {
        //Roll to wound for the weapon
        //todo change this shit
        //todo pick model to destroy
        //todo refactor this shit out
        int rollNeededToPen = Main.controller.tables.toPenNeeded(weaponFiring.getStrength(), this.getAverageFrontArmour());

        int numberOfPens = 0;
        for (int i = 0; i < numberOfHits; i++) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(6) + 1; // 1-6.
            if (randomNumber >= rollNeededToPen) {
                numberOfPens += 1;
            }
        }

        while (this.getChildren().size() > 0 && numberOfPens > 0) {
            for (int i = 0; i < numberOfHits; i++) {
                Random rand = new Random();
                int randomNumber = rand.nextInt(6) + 1; // 0-9.
                if (randomNumber >= ((Vehicle) models.get(0)).getBestSave(weaponFiring.getAp(), false)) {
                    Vehicle targetVehicle = ((Vehicle) models.get(0));

                    targetVehicle.setHullPoints(targetVehicle.getHullPoints() - 1);

                    if (targetVehicle.getHullPoints() <= 0) {
                        models.remove(targetVehicle);
                    }
                }
            }
        }
        return this;
    }

    @Override
    public void addModels(Model model) {
        models.add(model);
        List<Integer> frontArmourValues = new ArrayList<>();
        List<Integer> sideArmourValues = new ArrayList<>();
        List<Integer> rearArmourValues = new ArrayList<>();
        for (BaseItem model1 : models)
        {
            frontArmourValues.add(((Vehicle) model1).getFrontArmour());
            sideArmourValues.add(((Vehicle) model1).getSideArmour());
            rearArmourValues.add(((Vehicle) model1).getRearArmour());
        }
        averageFrontArmour = majorityNumber(frontArmourValues);
        averageSideArmour = majorityNumber(sideArmourValues);
        averageRearArmour = majorityNumber(rearArmourValues);
    }
}
