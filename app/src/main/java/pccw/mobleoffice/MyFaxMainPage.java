package pccw.mobleoffice;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

//import com.actionbarsherlock.app.ActionBar;
//import com.actionbarsherlock.app.SherlockActivity;

import java.util.ArrayList;
import java.util.List;


public class MyFaxMainPage extends ActionBarActivity {

    private ImageButton efaxHeadInbox;
    private ImageButton efaxHeadOutBox;
    private ImageButton efaxHeadDeliver;
    private ImageButton efaxHeadDeleted;

    private EfaxAdapter adapter;
    private List<Efax> efaxInboxList = new ArrayList<Efax>();
    private List<Efax> efaxOutboxList = new ArrayList<Efax>();
    private ListView listView;

    //popwindow part
    private ImageButton popButton;
    private PopupWindow popUp;
    private View layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fax_main_page);

        //保证只刷新一次
        adapter = new EfaxAdapter(MyFaxMainPage.this, R.layout.efax_listview, efaxInboxList);
        listView = (ListView) findViewById(R.id.list_view);
        //初始化ListView数据
        initEfaxInbox();
        initEfaxOutbox();
        //button1
        efaxHeadInbox = (ImageButton) findViewById(R.id.myfaxpgage_head_button1);
        efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox); //set background image
        //button2
        efaxHeadOutBox = (ImageButton) findViewById(R.id.myfaxpgage_head_button2);
        efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox);
        //button3
        efaxHeadDeliver = (ImageButton) findViewById(R.id.myfaxpgage_head_button3);
        efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved);
        //button4
        efaxHeadDeleted = (ImageButton) findViewById(R.id.myfaxpgage_head_button4);
        efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted);

        popButton = (ImageButton) findViewById(R.id.pop_button);



        //efaxHeadInbox
        efaxHeadInbox.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;


            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox);
                    isIconChange = false;
                    listView.setVisibility(View.INVISIBLE);  //消失
                } else {   //when isIconChange is false,clicked image
                    iniButton(1);

                    efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox_p);
                    isIconChange = true;
                    listView.setVisibility(View.VISIBLE);  //出现
                    listView.setAdapter(adapter);
                }



            }
        });

        //efaxHeadOutBox
        efaxHeadOutBox.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox);
                    isIconChange = false;
                    listView.setVisibility(View.INVISIBLE);  //消失
                } else {   //when isIconChange is false,clicked image
                    iniButton(2);
                    efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox_p);
                    isIconChange = true;
                    listView.setVisibility(View.VISIBLE);  //出现
                    listView.setAdapter(adapter);
                }
            }
        });

        //efaxHeadDeliver
        efaxHeadDeliver.setOnClickListener(new View.OnClickListener() {
            boolean isIconChange = false;

            @Override
            public void onClick(View v) {
                if (isIconChange) {     //when isIconChange is true,default image
                    efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    iniButton(3);
                    efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved_p);
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
                    efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted);
                    isIconChange = false;
                } else {   //when isIconChange is false,clicked image
                    iniButton(4);
                    efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted_p);
                    isIconChange = true;
                }
            }
        });

        //popwindow
        //后两个参数是width和height
        final  View poplayout = this.getLayoutInflater().inflate(R.layout.popwindow, null);
        popUp = new PopupWindow(poplayout,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout = getLayoutInflater().inflate(R.layout.activity_my_fax_main_page,null);  //获得layout
        popUp.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popUp.setOutsideTouchable(true);
        popUp.setFocusable(true);

        popButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp.showAtLocation(layout, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                popUp.showAsDropDown(layout); //设置弹出效果
                popUp.showAsDropDown(null, 0, layout.getHeight());

             // Toast.makeText(MyFaxMainPage.this,"clicked",Toast.LENGTH_SHORT).show();


                //popwindow clicked-button
                poplayout.findViewById(R.id.footer_button1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyFaxMainPage.this, "clicked", Toast.LENGTH_SHORT).show();
                        popUp.dismiss();
                    }
                });

                poplayout.findViewById(R.id.footer_button2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyFaxMainPage.this, "clicked", Toast.LENGTH_SHORT).show();
                        popUp.dismiss();
                    }
                });
            }
        });



    }


//同一时间只有一个按钮被点亮
    private void iniButton(int buttonStatus) {
        switch (buttonStatus) {
            case 1:  //点击按钮1时，其他按钮被初始化
                //button2
                efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox);
                //button3
                efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved);
                //button4
                efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted);
                break;
            case 2:
                efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox); //set background image
                //button3
                efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved);
                //button4
                efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted);
                break;
            case 3:
                //button1
                efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox); //set background image
                //button2
                efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox);
                //button4
                efaxHeadDeleted.setImageResource(R.drawable.efax_tab_deleted);
                break;
            case 4:
                //button1
                efaxHeadInbox.setImageResource(R.drawable.efax_tab_inbox); //set background image
                //button2
                efaxHeadOutBox.setImageResource(R.drawable.efax_tab_outbox);
                //button3
                efaxHeadDeliver.setImageResource(R.drawable.efax_tab_delieved);
                break;
            }
    }



    private void initEfaxInbox() {
        Efax efax1 = new Efax("Page 1", R.drawable.efax_tab_inbox);
        efaxInboxList.add(efax1);
        Efax efax2 = new Efax("page 2", R.drawable.efax_tab_inbox_p);
        efaxInboxList.add(efax2);
    }

    private void initEfaxOutbox() {
        Efax efax1 = new Efax("Page 1", R.drawable.efax_tab_outbox);
        efaxOutboxList.add(efax1);
        Efax efax2 = new Efax("page 2", R.drawable.efax_tab_outbox_p);
        efaxOutboxList.add(efax2);
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
