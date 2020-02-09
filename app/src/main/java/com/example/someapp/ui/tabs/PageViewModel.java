package com.example.someapp.ui.tabs;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class PageViewModel extends ViewModel {

    private Map<String, Double> mItems = new HashMap<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private static final String NUM_SPACES = "                       ";

    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
        if (input == 1) {
            // ingredients tab
            return ingredientsToString(mItems);
        } else if (input == 2) {
            // equipment tab
            return equipmentsToString(mItems);
        } else if (input == 3) {
            // other factors tab
            return factorsToString(mItems);
        }
        // should not reach here
        return "New feature to be added soon at Section: " + input + "!";
        }
    });

    public void addItem(String item) {
        mItems.put(item, (mItems.containsKey(item)) ? mItems.get(item) + 1 : 1);
        updateLiveText();
    }

    private void updateLiveText() {
        mText = Transformations.map(mIndex, new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
            if (input == 1) {
                // ingredients tab
                return ingredientsToString(mItems);
            } else if (input == 2) {
                // equipment tab
                return equipmentsToString(mItems);
            } else if (input == 3) {
                // other factors tab
                return factorsToString(mItems);
            }
            return "Section: " + input + " under progress";
            }
        });
        mIndex.setValue(mIndex.getValue());
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return this.mText;
    }

    public Map<String, Double> getItems() {
        return mItems;
    }

    public String ingredientsToString(Map<String, Double> items) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ingredient" + NUM_SPACES);
        sb.append("Quantity");

        sb.append('\n');
        sb.append('\n');
        for (String key : items.keySet()) {
            sb.append(key + NUM_SPACES);
            sb.append(items.get(key));
            sb.append('\n');
        }

        return sb.toString();
    }

    public String equipmentsToString(Map<String, Double> items) {
        items.put("pan", 1.0);
        items.put("pot", 1.0);
        items.put("oven", 1.0);

        StringBuilder sb = new StringBuilder();
        sb.append("Equipment" + NUM_SPACES);
        sb.append("Quantity");

        sb.append('\n');
        sb.append('\n');
        for (String key : items.keySet()) {
            sb.append('\n');
            sb.append(key + NUM_SPACES);
            sb.append(items.get(key));
        }

        return sb.toString();
    }

    public String factorsToString(Map<String, Double> items) {
        items.put("time", 60.0);
        items.put("laziness", 10000.0);

        StringBuilder sb = new StringBuilder();
        sb.append("Factor" + NUM_SPACES);
        sb.append("Given Value");

        sb.append('\n');
        sb.append('\n');
        for (String key : items.keySet()) {
            sb.append(key + NUM_SPACES);
            sb.append(items.get(key));
            sb.append('\n');
        }

        return sb.toString();
    }

}