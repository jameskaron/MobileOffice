package pccw.mobleoffice;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MyFaxMainPage extends ActionBarActivity {

    private ImageButton efaxHeadInbox;
    private ImageButton efaxHeadOutBox;
    private ImageButton efaxHeadDeliver;
    private ImageButton efaxHeadDeleted;

    private List<Efax> efaxList = new ArrayList<Efax>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fax_main_page);

        //button1
        efaxHeadInbox = (ImageButton) findViewById(R.id.myfaxpgage_head_button1);
        efaxHeadInbox.setBackgroundResource(R.drawable.efax_tab_inbox); //set background image
        //button2
        efaxHeadOutBox = (ImageButton) findViewById(R.id.myfaxpgage_head_button2);
        efaxHeadOutBox.setBackgroundResource(R.drawable.efax_tab_outbox);
        //button3
        efaxHeadDeliver = (ImageButton) findViewById(R.id.myfaxpgage_head_button3);
        efaxHeadDeliver.setBackgroundResource(R.drawable.efax_tab_delieved);
        //button4
        efaxHeadDeleted = (ImageButton) findViewById(R.id.myfaxpgage_head_button4);
        efaxHeadDeleted.setBackgroundResource(R.drawable.efax_tab_deleted);

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

                initEfax();
                EfaxAdapter adapter = new EfaxAdapter(MyFaxMainPage.this, R.layout.efax_listview, efaxList);
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(adapter);
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

        //efaxHeadDeliver
        efaxHeadDeliver.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadDeliver.setBackgroundResource(R.drawable.efax_tab_delieved);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    efaxHeadDeliver.setBackgroundResource(R.drawable.efax_tab_delieved_p);
                    isIconChange = true;
                }
            }
        });

        //efaxHeadDeleted
        efaxHeadDeleted.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadDeleted.setBackgroundResource(R.drawable.efax_tab_deleted);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    efaxHeadDeleted.setBackgroundResource(R.drawable.efax_tab_deleted_p);
                    isIconChange = true;
                }
            }
        });
    }


    private void initEfax() {
        Efax efax1 = new Efax("Page 1", R.drawable.efax_tab_inbox);
        efaxList.add(efax1);
        Efax efax2 = new Efax("page 2", R.drawable.efax_tab_inbox_p);
        efaxList.add(efax2);
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
