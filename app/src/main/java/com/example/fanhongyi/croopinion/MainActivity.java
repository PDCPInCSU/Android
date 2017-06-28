package com.example.fanhongyi.croopinion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment f1,f2,f3,f4,f5,f6,f7;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private TextView mUserText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String userValue=intent.getStringExtra("u");

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        //head = (ImageView) headerLayout.findViewById(R.id.Iamge_mine_head);
        mUserText = (TextView)headerLayout.findViewById(R.id.userTextView);
        mUserText.setText(userValue);

        f1 = new NewFragment();
        f2 = new ReportFragment();
        f3 = new TopicFragment();
        f4 = new GroupFragment();
        f5 = new KeywordFragment();
        f6 = new UserFragment();
        f7 = new AboutFragment();

//        mUserFragmentText=(TextView)findViewById(R.id.userTextView);
//        mUserFragmentText.setText(userValue);
//        ((TextView)f6.getView().findViewById(R.id.userTextView)).setText("hahaha");
        transaction.replace(R.id.fl_content, f6);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_new) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f1);
            transaction.commit();
        } else if (id == R.id.nav_report) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f2);
            transaction.commit();
        } else if (id == R.id.nav_topic) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f3);
            transaction.commit();
        } else if (id == R.id.nav_group) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f4);
            transaction.commit();
        } else if (id == R.id.nav_keyword) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f5);
            transaction.commit();
        } else if (id == R.id.nav_user) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f6);
            transaction.commit();
        } else if (id == R.id.nav_about) {
            hideFragment(transaction);
            transaction.replace(R.id.fl_content, f7);
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    * 去除（隐藏）所有的Fragment
    * */
    private void hideFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
            //transaction.remove(f1);
        }
    }


}
