package com.soldemom.part6_17;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TwoFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("DialogFragment")
                .setMessage("DialogFragment임니다")
                .setPositiveButton("OK",null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
