package com.saikrishna.picnews;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.StackTransformer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    MyApplication myapp;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myapp = MyApplication.getInstance();

        this.myDb = new DatabaseHelper(MainActivity.this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // FOR NAVIGATION VIEW ITEM TEXT COLOR
        int[][] state = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] color = new int[] {
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };

        ColorStateList csl = new ColorStateList(state, color);


// FOR NAVIGATION VIEW ITEM ICON COLOR
        int[][] states = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] colors = new int[] {
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };

        ColorStateList csl2 = new ColorStateList(states, colors);



        navigationView.setItemTextColor(csl);
        navigationView.setItemIconTintList(csl2);

        viewPagerall = (VerticalViewPager) findViewById(R.id.vertical_viewpager_all);
        viewPagerentertainment = (VerticalViewPager) findViewById(R.id.vertical_viewpager_entertainment);
        viewPagersports = (VerticalViewPager) findViewById(R.id.vertical_viewpager_sports);
        viewPagermoney = (VerticalViewPager) findViewById(R.id.vertical_viewpager_money);
        viewPagerlifestyle = (VerticalViewPager) findViewById(R.id.vertical_viewpager_lifestyle);
        viewPagerhealth = (VerticalViewPager) findViewById(R.id.vertical_viewpager_health);
        viewPagertravel = (VerticalViewPager) findViewById(R.id.vertical_viewpager_travel);
        viewPagerfood = (VerticalViewPager) findViewById(R.id.vertical_viewpager_food);
        viewPagerautos = (VerticalViewPager) findViewById(R.id.vertical_viewpager_autos);
        viewPagervideos = (VerticalViewPager) findViewById(R.id.vertical_viewpager_videos);
        viewPagersaved = (VerticalViewPager) findViewById(R.id.vertical_viewpager_saved);

        setTitle("ALL NEWS");
        initViewPager();
    }

    VerticalViewPager viewPagerall;
    VerticalViewPager viewPagerentertainment;
    VerticalViewPager viewPagersports;
    VerticalViewPager viewPagermoney;
    VerticalViewPager viewPagerlifestyle;
    VerticalViewPager viewPagerhealth;
    VerticalViewPager viewPagertravel;
    VerticalViewPager viewPagerfood;
    VerticalViewPager viewPagerautos;
    VerticalViewPager viewPagervideos;
    VerticalViewPager viewPagersaved;

    List<String> arr;
    List<Fragment> fragments;

    private void initViewPager() {

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(1);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        contentFragmentAdapterall = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerall.setAdapter(contentFragmentAdapterall);
        viewPagerall.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerall.setPageTransformer(true, new StackTransformer());



        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(2);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdapterentertainment = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerentertainment.setAdapter(contentFragmentAdapterentertainment);
        viewPagerentertainment.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerentertainment.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(3);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdaptersports = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagersports.setAdapter(contentFragmentAdaptersports);
        viewPagersports.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagersports.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(4);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdaptermoney = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagermoney.setAdapter(contentFragmentAdaptermoney);
        viewPagermoney.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagermoney.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(5);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdapterlifestyle = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerlifestyle.setAdapter(contentFragmentAdapterlifestyle);
        viewPagerlifestyle.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerlifestyle.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(6);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdapterhealth = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerhealth.setAdapter(contentFragmentAdapterhealth);
        viewPagerhealth.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerhealth.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(7);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdaptertravel = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagertravel.setAdapter(contentFragmentAdaptertravel);
        viewPagertravel.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagertravel.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(8);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdapterfood = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerfood.setAdapter(contentFragmentAdapterfood);
        viewPagerfood.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerfood.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(9);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdapterautos = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerautos.setAdapter(contentFragmentAdapterautos);
        viewPagerautos.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagerautos.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = myapp.getArray(10);
        for (Integer k=1;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdaptervideos = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagervideos.setAdapter(contentFragmentAdaptervideos);
        viewPagervideos.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagervideos.setPageTransformer(true, new StackTransformer());

        arr = new ArrayList<String>();
        fragments = new ArrayList<>();
        arr = viewAll();
        for (Integer k=0;k<arr.size();k++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("scanContent", arr.get(k));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ContentFragmentAdapter contentFragmentAdaptersaved = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagersaved.setAdapter(contentFragmentAdaptersaved);
        viewPagersaved.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPagersaved.setPageTransformer(true, new StackTransformer());


        viewPagerall.setVisibility(View.VISIBLE);
        viewPagerentertainment.setVisibility(View.GONE);
        viewPagersports.setVisibility(View.GONE);
        viewPagermoney.setVisibility(View.GONE);
        viewPagerlifestyle.setVisibility(View.GONE);
        viewPagerhealth.setVisibility(View.GONE);
        viewPagertravel.setVisibility(View.GONE);
        viewPagerfood.setVisibility(View.GONE);
        viewPagerautos.setVisibility(View.GONE);
        viewPagervideos.setVisibility(View.GONE);
        viewPagersaved.setVisibility(View.GONE);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    ContentFragmentAdapter contentFragmentAdapterall;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all) {
            viewPagerall.setVisibility(View.VISIBLE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("ALL NEWS");
        } else if (id == R.id.nav_entertainment) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.VISIBLE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("ENTERTAINMENT");
        } else if (id == R.id.nav_sports) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.VISIBLE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("SPORTS");
        } else if (id == R.id.nav_money) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.VISIBLE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("MONEY");
        } else if (id == R.id.nav_lifestyle) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.VISIBLE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("LIFESTYLE");
        } else if (id == R.id.nav_health) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.VISIBLE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("HEALTH");
        } else if (id == R.id.nav_travel) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.VISIBLE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("TRAVEL");
        } else if (id == R.id.nav_food) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.VISIBLE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("FOOD");
        } else if (id == R.id.nav_autos) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.VISIBLE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.VISIBLE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("AUTOS");
        } else if (id == R.id.nav_videos) {
            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.VISIBLE);
            viewPagersaved.setVisibility(View.GONE);
            setTitle("VIDEOS");
        } else if (id == R.id.nav_saved) {

            arr = new ArrayList<String>();
            fragments = new ArrayList<>();
            arr = viewAll();
            for (Integer k=0;k<arr.size();k++) {
                ContentFragment fragment = new ContentFragment();
                Bundle bundle = new Bundle();
                bundle.putString("scanContent", arr.get(k));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
            ContentFragmentAdapter contentFragmentAdaptersaved = new ContentFragmentAdapter(getSupportFragmentManager(), fragments);
            viewPagersaved.setAdapter(contentFragmentAdaptersaved);
            viewPagersaved.setOverScrollMode(View.OVER_SCROLL_NEVER);
            viewPagersaved.setPageTransformer(true, new StackTransformer());

            viewPagerall.setVisibility(View.GONE);
            viewPagerentertainment.setVisibility(View.GONE);
            viewPagersports.setVisibility(View.GONE);
            viewPagermoney.setVisibility(View.GONE);
            viewPagerlifestyle.setVisibility(View.GONE);
            viewPagerhealth.setVisibility(View.GONE);
            viewPagertravel.setVisibility(View.GONE);
            viewPagerfood.setVisibility(View.GONE);
            viewPagerautos.setVisibility(View.GONE);
            viewPagervideos.setVisibility(View.GONE);
            viewPagersaved.setVisibility(View.VISIBLE);
            setTitle("SAVED");
        } else if (id == R.id.nav_invite) {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out PICnews on Play Store\n\nhttps://play.google.com/store/apps/details?id=com.saikrishna.picnews&hl=en");
            startActivity(emailIntent);
        } else if (id == R.id.nav_rate) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.saikrishna.picnews&hl=en");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.saikrishna.picnews&hl=en")));
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public List<String> viewAll() {
        Cursor res = myDb.getAllData();
        List<String> insideArray = new ArrayList<String>();
        if(res.getCount() == 0) {
        } else {
            while (res.moveToNext()) {
                Log.d("sairahul", res.getString(0));
                insideArray.add(res.getString(0));
            }
        }
        return insideArray;
    }
}
