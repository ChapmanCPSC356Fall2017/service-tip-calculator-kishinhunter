package cpsc.newapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void TipCalculator(View view)
    {
        //Get the total from the box as a String to check for the Case of entering no number
        EditText bill = (EditText) findViewById(R.id.text_box);
        String bill_input = bill.getText().toString();
        if (bill_input.matches(""))
        {
            Toast.makeText(this, "No Bill Total Given, Try Again", Toast.LENGTH_SHORT).show();
            //Show the user an "error" blurb
            return;
        }
        //Now we can return to calculating with a float value
        float bill_float = Float.valueOf(bill_input);
        EditText rating = (EditText) findViewById(R.id.rating);
        String rating_error = rating.getText().toString();
        if (rating_error.matches(""))
        {
            Toast.makeText(this, "No Rating Given, Try Again", Toast.LENGTH_SHORT).show();
            //Show the user an "error" blurb
            return;
        }
        //Return this text box to a float value after error checking
        float rating_float = Float.valueOf(rating_error);
        if (rating_float >10)
        {
            Toast.makeText(this, "Invalid Rating, Try Again", Toast.LENGTH_SHORT).show();
            //Show the user an "error" blurb
            return;
        }
        //Initialize tip float variable
        double tip = 0;
        if (rating_float>=1 && rating_float<=3)
        {
            tip = bill_float *(.1);
        }
        else if (rating_float>=4 && rating_float<=5)
        {
            tip = bill_float *(.13);
        }
        else if (rating_float>=6 && rating_float<=7)
        {
            tip = bill_float *(.15);
        }
        else if (rating_float>=8 && rating_float<=9)
        {
            tip = bill_float *(.2);
        }
        else if (rating_float==10)
        {
            tip = bill_float *(.25);
        }
        //Output tip to the Textbox
        TextView tipamount = (TextView) findViewById(R.id.tipamount);
        //Reset value if any
        tipamount.setText("");
        tipamount.setText(String.format("Your tip should be $%.2f", tip));
    }
}
