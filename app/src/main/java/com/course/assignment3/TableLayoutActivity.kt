package com.course.assignment3

import android.app.ActionBar
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setMargins
import kotlinx.android.synthetic.main.activity_main.*


class TableLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAddRow.setOnClickListener {
            if (validateFields()) {
                addNewRow(edAndroidVersion.text.toString(), edAndroidCodeName.text.toString());
            }
        }

    }

    private fun validateFields(): Boolean {

        if (edAndroidVersion.text.isEmpty()) {
            Toast.makeText(this, "Enter android code version please", Toast.LENGTH_SHORT).show()
            return false;
        }

        if (edAndroidCodeName.text.isEmpty()) {
            Toast.makeText(this, "Enter android code name please", Toast.LENGTH_SHORT).show()
            return false;
        }

        return true;
    }

    private fun addNewRow(version: String, codeName: String) {

        // Create a new table row.
        val tableRow = TableRow(applicationContext)

        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams

        // add values into row by calling addView()
        val tvVersion = TextView(this,null,0,R.style.tableCell)
        val tvCode = TextView(this,null,0,R.style.tableCell)

        tableRow.addView(tvVersion, 0);
        tableRow.addView(tvCode, 1);

       //set margin
        val lp = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
        lp.setMargins(5,5,5,5)
        tvVersion.layoutParams = lp
        tvCode.layoutParams = lp

      tvVersion.text = version
        tvCode.text = codeName




        // Finally add the created row row into layout
        tblAndroidData.addView(tableRow) // id from Layout_file

    }
}