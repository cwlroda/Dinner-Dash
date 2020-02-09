package com.example.someapp.ui.tabs;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class PageViewModel extends ViewModel {

    private Map<String, Integer> mItems = new HashMap<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

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
        if (mItems.containsKey(item)) {
            mItems.put(item, mItems.get(item));
        } else {
            mItems.put(item, 1);
        }
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
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return this.mText;
    }

    public Map<String, Integer> getItems() {
        return mItems;
    }

    private String ingredientsToString(Map<String, Integer> items) {
        StringBuilder sb = new StringBuilder();
        String spaces = "               ";
        sb.append("Ingredient" + spaces);
        sb.append("Quantity");

        for (String key : items.keySet()) {
            sb.append(key + spaces);
            sb.append(items.get(key));
        }

        return sb.toString();
    }

    private String equipmentsToString(Map<String, Integer> items) {
        StringBuilder sb = new StringBuilder();
        String spaces = "               ";
        sb.append("Equipment" + spaces);
        sb.append("Quantity");

        for (String key : items.keySet()) {
            sb.append(key + spaces);
            sb.append(items.get(key));
        }

        return sb.toString();
    }

    private String factorsToString(Map<String, Integer> items) {
        StringBuilder sb = new StringBuilder();
        String spaces = "               ";
        sb.append("Factor" + spaces);
        sb.append("Given Value");

        for (String key : items.keySet()) {
            sb.append(key + spaces);
            sb.append(items.get(key));
        }

        return sb.toString();
    }

}