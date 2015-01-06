package pccw.mobleoffice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MyFaxMainPage extends ActionBarActivity {

    private ImageButton efaxHeadInbox;
    private ImageButton efaxHeadOutBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fax_main_page);

        efaxHeadInbox = (ImageButton) findViewById(R.id.myfaxpgage_head_button1);
        efaxHeadInbox.setBackgroundResource(R.drawable.efax_tab_inbox); //set background image

        efaxHeadOutBox = (ImageButton) findViewById(R.id.myfaxpgage_head_button2);
        efaxHeadOutBox.setBackgroundResource(R.drawable.efax_tab_outbox);

        //efaxHeadInbox
        efaxHeadInbox.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadInbox.setBackgroundResource(R.drawable.efax_tab_inbox);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    efaxHeadInbox.setBackgroundResource(R.drawable.efax_tab_inbox_p);
                    isIconChange = true;
                }
            }
        });

        //efaxHeadOutBox
        efaxHeadOutBox.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadOutBox.setBackgroundResource(R.drawable.efax_tab_outbox);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    efaxHeadOutBox.setBackgroundResource(R.drawable.efax_tab_outbox_p);
                    isIconChange = true;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_fax_main_page, menu);
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
