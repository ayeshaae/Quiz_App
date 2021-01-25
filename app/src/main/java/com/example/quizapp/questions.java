package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class questions extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Log.d("DebugeData", "inside oncreate");
        TextView tvName = (TextView) findViewById(R.id.tvName);
        String st = getIntent().getExtras().getString("Value");
        tvName.setText("Hello " + st + "\n good luck");
    }

    public int CalculateScore() {
        /* get referance */
        RadioGroup rdQ1 = (RadioGroup) findViewById(R.id.rdQuestion1);
        RadioGroup rdQ2 = (RadioGroup) findViewById(R.id.rdQuestion2);
        CheckBox cbQ3_a = (CheckBox) findViewById(R.id.q3a);
        CheckBox cbQ3_b = (CheckBox) findViewById(R.id.q3b);
        CheckBox cbQ3_c = (CheckBox) findViewById(R.id.q3c_Answer);
        CheckBox cbQ3_d = (CheckBox) findViewById(R.id.q3d_Answer);
        EditText etQ4 = (EditText) findViewById(R.id.q4_Answer);
        EditText etQ5 = (EditText) findViewById(R.id.q5_Answer);

        // get answer to question 1
        int q1_id = rdQ1.getCheckedRadioButtonId();
        if (q1_id == R.id.q1_Answer) {
            score = score + 1;
        }
        //get answer to question 2
        int q2_id = rdQ2.getCheckedRadioButtonId();
        if (q2_id == R.id.q2_Answer) {
            score = score + 1;
        }
        //get answer to question 3
        boolean checkedA = cbQ3_a.isChecked();
        boolean checkedB = cbQ3_b.isChecked();
        boolean checkedC = cbQ3_c.isChecked();
        boolean checkedD = cbQ3_d.isChecked();
        if (!checkedA && !checkedB && checkedC && checkedD) {
            score = score + 1;
        }
        //get answer to question 4
        String get_q4 = etQ4.getText().toString();
        if ("Red".equalsIgnoreCase(get_q4)) {
            score = score + 1;
        }
        //get answer to question 5
        String get_q5 = etQ5.getText().toString();
        if ("Chrome".equalsIgnoreCase(get_q5)) {
            score = score + 1;
        }
        return (score);
    }

    public void result(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to submit?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // show toast and  close the dialog
                Toast.makeText(getApplicationContext(), "Your Score is : " + CalculateScore() + "/ 5", Toast.LENGTH_SHORT).show();
                score = 0;
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    //reset
    public void reset(View v) {
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.mainScroll);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        RadioGroup rdQ1 = (RadioGroup) findViewById(R.id.rdQuestion1);
        RadioGroup rdQ2 = (RadioGroup) findViewById(R.id.rdQuestion2);
        CheckBox cbQ3_a = (CheckBox) findViewById(R.id.q3a);
        CheckBox cbQ3_b = (CheckBox) findViewById(R.id.q3b);
        CheckBox cbQ3_c = (CheckBox) findViewById(R.id.q3c_Answer);
        CheckBox cbQ3_d = (CheckBox) findViewById(R.id.q3d_Answer);
        EditText etQ4 = (EditText) findViewById(R.id.q4_Answer);
        EditText etQ5 = (EditText) findViewById(R.id.q5_Answer);

        rdQ1.clearCheck();
        rdQ2.clearCheck();
        cbQ3_a.setChecked(false);
        cbQ3_b.setChecked(false);
        cbQ3_c.setChecked(false);
        cbQ3_d.setChecked(false);
        etQ4.setText(" ");
        etQ5.setText(" ");
    }

    public void hint(View v) {
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.mainScroll);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        RadioGroup rdQ1 = (RadioGroup) findViewById(R.id.rdQuestion1);
        RadioGroup rdQ2 = (RadioGroup) findViewById(R.id.rdQuestion2);
        CheckBox cbQ3_c = (CheckBox) findViewById(R.id.q3c_Answer);
        CheckBox cbQ3_d = (CheckBox) findViewById(R.id.q3d_Answer);
        EditText etQ4 = (EditText) findViewById(R.id.q4_Answer);
        EditText etQ5 = (EditText) findViewById(R.id.q5_Answer);

        rdQ1.check(R.id.q1_Answer);
        rdQ2.check(R.id.q2_Answer);
        cbQ3_c.setChecked(true);
        cbQ3_d.setChecked(true);
        etQ4.setText("Red");
        etQ5.setText("Chrome");
    }
}
