package com.example.credit_record.ui.information;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.credit_record.R;
import com.example.credit_record.databinding.FragmentInformationBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InformationFragment extends Fragment {

    private InformationViewModel informationViewModel;
    private FragmentInformationBinding binding;
    DatePickerDialog.OnDateSetListener datePicker;
    Calendar calendar = Calendar.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        informationViewModel =
                new ViewModelProvider(this).get(InformationViewModel.class);

        binding = FragmentInformationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView tName = root.findViewById(R.id.member_textname);
        TextView tEmail = root.findViewById(R.id.member_textemail);
        TextView tPhone = root.findViewById(R.id.member_textphone);

        Button member_btbirthday = root.findViewById(R.id.member_btbirthday);
        TextView member_textbirthday = root.findViewById(R.id.member_textbirthday);

        datePicker = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "yyyy年MM月dd日";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TAIWAN);
                member_textbirthday.setText(sdf.format(calendar.getTime()));
            }
        };
        member_btbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                        datePicker,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
        Button member_save = root.findViewById(R.id.member_save);
        member_save.setOnClickListener(new View.OnClickListener() {
            String name = tName.getText().toString();
            String phone = tPhone.getText().toString();
            String email = tEmail.getText().toString();

            @Override
            public void onClick(View v) {
                AlertDialog dialog = createBrightness();
                dialog.show();
                Toast.makeText(getActivity(),"已儲存",Toast.LENGTH_LONG).show();
            }
        });

        Button member_clear = (Button) root.findViewById(R.id.member_clear);
        member_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = root.findViewById(R.id.member_textname);
                et1.setText("");
                EditText et3 = root.findViewById(R.id.member_textemail);
                et3.setText("");
                EditText et4 = root.findViewById(R.id.member_textphone);
                et4.setText(null);
                Toast.makeText(getActivity(),"已清除",Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private AlertDialog createBrightness() {
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);


        // Add the buttons
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Toast.makeText(getActivity(),"已儲存！",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                Toast.makeText(getActivity(),"取消！",Toast.LENGTH_LONG).show();
            }
        });

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        return dialog;
    }


}