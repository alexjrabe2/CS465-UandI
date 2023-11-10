package com.illinois.cs465.doctorsorders;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class EventFormActivity extends AppCompatActivity {
    private EditText eventNameEditText;
    private EditText eventLocationEditText;
    private EditText eventDateEditText;
    private EditText eventTimeEditText;
    private EditText eventDescriptionEditText;
    private CheckBox tag1CheckBox;
    private CheckBox tag2CheckBox;
    private CheckBox tag3CheckBox;
    private Button saveButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_form);

        eventNameEditText = findViewById(R.id.eventNameEditText);
        eventLocationEditText = findViewById(R.id.eventLocationEditText);
        eventDateEditText = findViewById(R.id.eventDateEditText);
        eventTimeEditText = findViewById(R.id.eventTimeEditText);
        eventDescriptionEditText = findViewById(R.id.eventDescriptionEditText);
        tag1CheckBox = findViewById(R.id.tag1CheckBox);
        tag2CheckBox = findViewById(R.id.tag2CheckBox);
        tag3CheckBox = findViewById(R.id.tag3CheckBox);
        saveButton = findViewById(R.id.saveButton);
        deleteButton = findViewById(R.id.deleteButton);

        // Handle button click events
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEvent();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteEvent();
            }
        });

        // Set up the DatePickerDialog for the "Date" EditText
        eventDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDayOfMonth;
                eventDateEditText.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void saveEvent() {
        // Implement event saving logic here
        String selectedTags = getSelectedTags();
        Toast.makeText(this, "Event saved with tags: " + selectedTags, Toast.LENGTH_SHORT).show();
    }

    private void deleteEvent() {
        // Implement event deletion logic here
        Toast.makeText(this, "Event deleted!", Toast.LENGTH_SHORT).show();
    }

    private String getSelectedTags() {
        StringBuilder selectedTags = new StringBuilder();
        if (tag1CheckBox.isChecked()) {
            selectedTags.append("Tag 1, ");
        }
        if (tag2CheckBox.isChecked()) {
            selectedTags.append("Tag 2, ");
        }
        if (tag3CheckBox.isChecked()) {
            selectedTags.append("Tag 3, ");
        }
        // Add more CheckBoxes for additional tags here

        String tags = selectedTags.toString().trim();
        if (tags.endsWith(",")) {
            tags = tags.substring(0, tags.length() - 2);
        }
        return tags;
    }
}
