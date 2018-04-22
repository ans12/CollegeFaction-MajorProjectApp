package com.mp.collegefaction.collegefaction;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mp.collegefaction.collegefaction.fragments.HomeFragment;
import com.mp.collegefaction.collegefaction.fragments.MessagesFragment;
import com.mp.collegefaction.collegefaction.fragments.RequestsFragment;
import com.mp.collegefaction.collegefaction.fragments.UserProfileFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_requests);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_message);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_person);

        tabLayout.getTabAt(0).setText("").setTag("Home");
        tabLayout.getTabAt(1).setText("").setTag("Requests");
        tabLayout.getTabAt(2).setTag("Messages").setText("");
        tabLayout.getTabAt(3).setText("").setTag("Profile");

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    private void setUpViewPager(ViewPager mViewPager) {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(HomeFragment.newInstance(),"Home");
        sectionsPagerAdapter.addFragment(RequestsFragment.newInstance(),"Requests");
        sectionsPagerAdapter.addFragment(MessagesFragment.newInstance(),"Messages");
        sectionsPagerAdapter.addFragment(UserProfileFragment.newInstance(),"Profile");

        mViewPager.setAdapter(sectionsPagerAdapter);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "User logged out.", Toast.LENGTH_LONG).show();
                finish();
                return true;
            case R.id.action_feedback:
                Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                intent1.setData(Uri.parse("mailto:sharma.pranjul1998@gmail.com"));
                intent1.putExtra(Intent.EXTRA_SUBJECT, "feedback mail from 'username' for CollegeFaction Android App.");
                intent1.putExtra(Intent.EXTRA_TEXT, "Message for the feedback will go here.");
                startActivity(intent1);
                return true;
            case R.id.action_Help:
            case R.id.action_rate_us:
            case R.id.action_terms_n_conditions:
                Toast.makeText(getApplicationContext(), "Content and action related to " + item.getTitle() + " will be provided here.", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
