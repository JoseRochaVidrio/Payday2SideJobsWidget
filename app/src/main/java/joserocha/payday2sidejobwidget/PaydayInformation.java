package joserocha.payday2sidejobwidget;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import joserocha.payday2sidejobwidget.Model.Achievements;


public class PaydayInformation extends ActionBarActivity {

    public static List<Achievements> _achivement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payday_information);

        final ImageView img1 = (ImageView) findViewById(R.id.iconinfor);
        final TextView txtName = (TextView) findViewById(R.id.txtName1);
        final TextView txtInformation = (TextView) findViewById(R.id.txtInfo1);

        final ImageView img2 = (ImageView) findViewById(R.id.iconinfor2);
        final TextView txtName2 = (TextView) findViewById(R.id.txtName2);
        final TextView txtInformation2 = (TextView) findViewById(R.id.txtInfo2);

        final ImageView img3 = (ImageView) findViewById(R.id.iconinfor3);
        final TextView txtName3 = (TextView) findViewById(R.id.txtName3);
        final TextView txtInformation3 = (TextView) findViewById(R.id.txtInfo3);

        setTitle("Achievements");
        img1.setImageResource(getResources().getIdentifier(_achivement.get(0).getIcon() != null && !_achivement.get(0).getIcon().isEmpty() ?   _achivement.get(0).getIcon() : "frog1","drawable", this.getPackageName()));
        txtName.setText( _achivement.get(0).getName() != null && !_achivement.get(0).getName().isEmpty() ? _achivement.get(0).getName() : "");
        txtInformation.setText( _achivement.get(0).getInformation() != null && !_achivement.get(0).getInformation().isEmpty() ? _achivement.get(0).getInformation() : "");


        img2.setImageResource(getResources().getIdentifier(_achivement.get(1).getIcon() != null && !_achivement.get(1).getIcon().isEmpty() ?   _achivement.get(1).getIcon() : "frog1","drawable", this.getPackageName()));
        txtName2.setText( _achivement.get(1).getName() != null && !_achivement.get(1).getName().isEmpty() ? _achivement.get(1).getName() : "");
        txtInformation2.setText(_achivement.get(1).getInformation() != null && !_achivement.get(1).getInformation().isEmpty() ? _achivement.get(1).getInformation() : "");

        img3.setImageResource(getResources().getIdentifier(_achivement.get(2).getIcon() != null && !_achivement.get(2).getIcon().isEmpty() ?   _achivement.get(2).getIcon() : "frog1","drawable", this.getPackageName()));
        txtName3.setText( _achivement.get(2).getName() != null && !_achivement.get(2).getName().isEmpty() ? _achivement.get(2).getName() : "");
        txtInformation3.setText(_achivement.get(2).getInformation() != null && !_achivement.get(2).getInformation().isEmpty() ? _achivement.get(2).getInformation() : "");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payday_information, menu);
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
}
