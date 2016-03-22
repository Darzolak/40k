package sample.controller;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Darzolak on 06-Feb-16.
 */
public class Tables {
    public ArrayList<ArrayList<Integer>> toWoundChart;
    public ArrayList<Integer> shootingToHitTable;

    public ArrayList<Integer> getShootingToHitTable() {
        return shootingToHitTable;
    }

    public ArrayList<ArrayList<Integer>> toWoundChart () {
        return toWoundChart;
    }

    public int toWoundRollNeeded(int strength, int toughness) {
        ArrayList<Integer> strength0 = new ArrayList<>(Arrays.asList(4, 5, 6, 6, 7, 7, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength1 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 6, 7, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 6, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength3 = new ArrayList<>(Arrays.asList(5, 2, 3, 4, 5, 6, 6, 7, 7, 7, 7));
        ArrayList<Integer> strength4 = new ArrayList<>(Arrays.asList(2, 2, 2, 3, 4, 5, 6, 6, 7, 7, 7));
        ArrayList<Integer> strength5 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 3, 4, 5, 6, 6, 7, 7));
        ArrayList<Integer> strength6 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 7));
        ArrayList<Integer> strength7 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6));
        ArrayList<Integer> strength8 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6));
        ArrayList<Integer> strength9 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5));
        ArrayList<Integer> strength10 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4));
        ArrayList<ArrayList<Integer>> toWoundChart = new ArrayList<>();
        toWoundChart.add(strength0);
        toWoundChart.add(strength1);
        toWoundChart.add(strength2);
        toWoundChart.add(strength3);
        toWoundChart.add(strength4);
        toWoundChart.add(strength5);
        toWoundChart.add(strength6);
        toWoundChart.add(strength7);
        toWoundChart.add(strength8);
        toWoundChart.add(strength9);
        toWoundChart.add(strength10);
        return toWoundChart.get(strength).get(toughness);
    }

    public int toHitRollNeeded(int ballisticSkill) {
        shootingToHitTable = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 2));
        return shootingToHitTable.get(ballisticSkill);
    }

    public int toPenNeeded(int strength, int armourValue) { return armourValue - strength + 1; }

    public Tables() {
        shootingToHitTable = new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 2));
        ArrayList<Integer> strength0 = new ArrayList<>(Arrays.asList(4, 5, 6, 6, 7, 7, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength1 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 6, 7, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 6, 7, 7, 7, 7, 7));
        ArrayList<Integer> strength3 = new ArrayList<>(Arrays.asList(5, 2, 3, 4, 5, 6, 6, 7, 7, 7, 7));
        ArrayList<Integer> strength4 = new ArrayList<>(Arrays.asList(2, 2, 2, 3, 4, 5, 6, 6, 7, 7, 7));
        ArrayList<Integer> strength5 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 3, 4, 5, 6, 6, 7, 7));
        ArrayList<Integer> strength6 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 7));
        ArrayList<Integer> strength7 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6));
        ArrayList<Integer> strength8 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6));
        ArrayList<Integer> strength9 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5));
        ArrayList<Integer> strength10 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4));
        ArrayList<ArrayList<Integer>> toWoundChart = new ArrayList<>();
        toWoundChart.add(strength0);
        toWoundChart.add(strength1);
        toWoundChart.add(strength2);
        toWoundChart.add(strength3);
        toWoundChart.add(strength4);
        toWoundChart.add(strength5);
        toWoundChart.add(strength6);
        toWoundChart.add(strength7);
        toWoundChart.add(strength8);
        toWoundChart.add(strength9);
        toWoundChart.add(strength10);

    }
}
