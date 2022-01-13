package com.example.credit_record.ui.calculate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CalculateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calculate fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}