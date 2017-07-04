package com.twburnsgmail.opiecalc;

import android.icu.text.DecimalFormat;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    public void calcSetAt(View view) {
        // calcs Set At Latitude using
        // captures values from 4 edtiTextFields

        // variables
        double distE_Value = 0;
        double latE_Value = 0;
        double distW_Value = 0;
        double latW_Value = 0;
        double distTotal = 0;
        double percWghtE = 0;
        double percWghtW = 0;
        double setAtResult = 0;

        // clear output view

        // decimal formst
        DecimalFormat df = new DecimalFormat("#.###");

        // create input textview variables
        TextView dist_WC = (TextView) findViewById(R.id.editText_dist_wc);
        TextView lat_WC = (TextView) findViewById(R.id.editText_lat_wc);
        TextView dist_EC = (TextView) findViewById(R.id.editText_dist_ec);
        TextView lat_EC = (TextView) findViewById(R.id.editText_lat_ec);

        // create output  textvew variable
        TextView setResult = (TextView) findViewById(R.id.textView_set_at_result);

       //try/catch for capturing values from textview variables
        try{
            distW_Value = Double.parseDouble(dist_WC.getText().toString());
            latW_Value = Double.parseDouble(lat_WC.getText().toString());
            distE_Value = Double.parseDouble(dist_EC.getText().toString());
            latE_Value = Double.parseDouble(lat_EC.getText().toString());

            //do calc if no errors
            distTotal = distE_Value + distW_Value;
            percWghtE = distE_Value / distTotal;
            percWghtW = distW_Value / distTotal;

            if(latW_Value > latE_Value)
            {
                setAtResult = ((latW_Value - latE_Value) * percWghtE) + latE_Value;
            }
            else
            {
                setAtResult = ((latE_Value - latW_Value) * percWghtW) + latW_Value;

            }
            // format result and pass to output textview varariable
            String formatedResult = df.format(setAtResult);
            setResult.setText(formatedResult);


        }catch (NumberFormatException e) {
            setResult.setText("-missing value-");
            //setResult.setText("error: " + e);
        }
    }

    public void convLinkFeet(View view){
        // converts links to feet

        // vars
        double inViewValue = 0;
        double outViewValue = 0;

        // format
        DecimalFormat df = new DecimalFormat("#.###");

        //input/out  edittext view vars
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);

        try{
            inViewValue = Double.parseDouble(inView.getText().toString());
            //conversion calc
            outViewValue = inViewValue * 0.66;
            // format and send result
            String formatedResult = df.format(outViewValue);
            outView.setText(inView.getText().toString() + " lks = " + formatedResult + " ft");
        }catch (NumberFormatException e) {
            outView.setText("-missing value-");
        }
    }

    public void convFeetLink(View view){
        // converts feet to links

        // vars
        double inViewValue = 0;
        double outViewValue = 0;

        // format
        DecimalFormat df = new DecimalFormat("#.###");

        //input/out  edittext view vars
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);

        try{
            inViewValue = Double.parseDouble(inView.getText().toString());
            //conversion calc
            outViewValue = inViewValue / 0.66;
            // format and send result
            String formatedResult = df.format(outViewValue);
            outView.setText(inView.getText().toString() + " ft = " + formatedResult + " lks");
        }catch (NumberFormatException e) {
            outView.setText("-missing value-");
        }
    }

    public void convFeetInch(View view){
        // converts feet to inches

        // vars
        double inViewValue = 0;
        double outViewValue = 0;

        // format
        DecimalFormat df = new DecimalFormat("#.###");

        //input/out  edittext view vars
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);

        try{
            inViewValue = Double.parseDouble(inView.getText().toString());
            //conversion calc
            outViewValue = inViewValue * 12;
            // format and send result
            String formatedResult = df.format(outViewValue);
            outView.setText(inView.getText().toString() + " ft = " + formatedResult + " in");
        }catch (NumberFormatException e) {
            outView.setText("-missing value-");
        }
    }

    public void convFeetChain(View view){
        // converts feet to chins

        // vars
        double inViewValue = 0;
        double outViewValue = 0;

        // format
        DecimalFormat df = new DecimalFormat("#.###");

        //input/out  view vars
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);

        try{
            inViewValue = Double.parseDouble(inView.getText().toString());
            //conversion calc
            outViewValue = inViewValue / 66;
            // format and send result
            String formatedResult = df.format(outViewValue);
            outView.setText(inView.getText().toString() + " ft = " + formatedResult + " ch");
        }catch (NumberFormatException e) {
            outView.setText("-missing value-");
        }
    }

    public void convChainFeet(View view){
        // converts chain to feet

        // vars
        double inViewValue = 0;
        double outViewValue = 0;

        // format
        DecimalFormat df = new DecimalFormat("#.###");

        //input/out  view vars
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);

        try{
            inViewValue = Double.parseDouble(inView.getText().toString());
            //conversion calc
            outViewValue = inViewValue * 66;
            // format and send result
            String formatedResult = df.format(outViewValue);
            outView.setText(inView.getText().toString() + " ch = " + formatedResult + " ft");
        }catch (NumberFormatException e) {
            outView.setText("-missing value-");
        }
    }

    public void calcOverall(View view) {
        // calculates overall distance from
        // tape distance to RTK and DORS add distance
        // returns overall distance to nearest 1/2 link

        //vars
        double distRTK_value;
        double distBT_value;
        double distSum;
        double sumLinks;
        double sumRound;
        double result;


        //format
        DecimalFormat df = new DecimalFormat("#.###");

        //create input/output view objects
        TextView dist_RTK = (TextView) findViewById(R.id.editText_dist_rtk);
        TextView dist_BT = (TextView) findViewById(R.id.editText_dist_bt);
        TextView rtkResult = (TextView) findViewById(R.id.textView_rtk_result);

        //try catch for for capturing values form textview variables.

        try{
            distRTK_value = Double.parseDouble(dist_RTK.getText().toString());
            distBT_value = Double.parseDouble(dist_BT.getText().toString());

            // sum distances
            distSum = distRTK_value + distBT_value;
            // conv to links
            sumLinks = (distSum/0.66);

            // round to nearest 0.5 = x2, round, /2
            sumRound = Math.round(sumLinks*2);
            result = sumRound/2;

            //format results
            String formatedResult = df.format(result);
            String formatedDistSum = df.format(distSum);
            rtkResult.setText(formatedDistSum + " ft" + " = " + formatedResult + " lks");

        }catch (NumberFormatException e) {
            rtkResult.setText("-missing value-");
        }

    }

    public void calcDiameter(View view) {
        //calculate diameter from given radius
        // return value in inches

        //vars
        double inViewValue = 0;
        double outViewValue = 0;
        double valueInches;
        double diamResult;

        //format
        DecimalFormat df = new DecimalFormat("#.##");

        //create input/output view objects
        TextView inView = (TextView) findViewById(R.id.editText_conv_input);
        TextView outView = (TextView) findViewById(R.id.textView_conv_result);


        // try catch for capturing value from textview objects

        try{
            //extract values from view objects
            inViewValue = Double.parseDouble(inView.getText().toString());

            //convert to inches
            valueInches = inViewValue*12;

            //calc radius
            diamResult = valueInches / Math.PI;

            //format result
            String formatedResult = df.format(diamResult);
            outView.setText(inView.getText().toString() + " ft circ = " + formatedResult + " in diam");


        }catch (NumberFormatException e) {
            outView.setText("-missing value-");

        }

    }

    public void calcAZ(View view) {
        // calc Azimuth from bearing and two cardinal inputs

        //vars
        double bearing = 0;
        double az = 0;
        String NS;
        String EW;

        //format
        DecimalFormat df = new DecimalFormat("#.##");

        // initiate  view objects
        ToggleButton toggleButtonNS = (ToggleButton) findViewById(R.id.toggleB_NS);
        ToggleButton toggleButtonEW = (ToggleButton) findViewById(R.id.toggleB_EW);
        EditText inView = (EditText) findViewById(R.id.editText_az_input);
        TextView outView = (TextView) findViewById(R.id.textView_az_result);

        //try catch for capturing values and calc az

        try{

            bearing = Double.parseDouble(inView.getText().toString());
            Boolean northSouthChecked = toggleButtonNS.isChecked();//true = south
            Boolean eastWestChecked = toggleButtonEW.isChecked();//true = West

            if (bearing > 90) {
                // out of bounds value
                outView.setText("-opie is jeanyes-");
            }  else {

                if (northSouthChecked) {
                    if (eastWestChecked) {
                        //South-West
                        az = 180 + bearing;
                        NS = "S";
                        EW = "W";
                    } else {
                        //south-east
                        az = 180 - bearing;
                        NS = "S";
                        EW = "E";
                    }

                } else {
                    if (eastWestChecked) {
                        //north-west
                        az = 360 - bearing;
                        NS = "N";
                        EW = "W";
                    } else {
                        //north-east
                        az = bearing;
                        NS = "N";
                        EW = "E";
                    }

                }



                String formatedAz = df.format(az);
                //String formatedBearing = String.format("%.2f", bearing);

                String formatedBearing = df.format(bearing);
                outView.setText(NS + " " + formatedBearing + " " + EW + " = " + formatedAz + " az" );
            }

        }catch (NumberFormatException e) {
            //outview error msg
            outView.setText("-missing value-");
        }

    }

    public void calcBearing(View view) {
        // calc bearing from given azimuth

        //vars
        double az = 0;
        double bearing = 0;
        String NS = "";
        String EW = "";
        String special = "";

        //format
        DecimalFormat df = new DecimalFormat("#.##");


        //initiate view objects
        EditText inView = (EditText) findViewById(R.id.editText_bearing_input);
        TextView outView = (TextView) findViewById(R.id.textView_bearing_result);

        //try catch calc block

        try{
            //do stuff
            az = Double.parseDouble(inView.getText().toString());
           // could make use 0to360() to normalize value

            if (az > 360) {
                do {
                    az = az - 360;
                } while (az > 360);
            }

            if (az > 270 && az < 360 ) {
                //NW
                NS = "N";
                EW = "W";
                bearing = 360 - az;

            } else if (az > 180 && az < 270) {
                //SW
                NS = "S";
                EW = "W";
                bearing = az - 180;

            } else if (az > 90 && az < 180) {
                //SE
                NS = "S";
                EW = "E";
                bearing = 180 - az;

            } else if (az > 0 && az < 90) {
                //NE
                NS = "N";
                EW = "E";
                bearing = az;

            } else if (az == 0 || az == 360) {
                //due north
                special = "Due North";
            } else if (az == 90) {
                // due East
                special = "Due East";
            } else if (az == 180) {
                // due south
                special = "Due South";
            } else if (az == 270) {
                // due west
                special = "Due West";

            } else {
                //out of bounds value
                special = "Out of Bounds";
            }

            String formatedBearing = df.format(bearing);
            outView.setText(az + " az = " + NS + " " + formatedBearing + " " + EW + special);


        }catch (NumberFormatException e) {
            //error msg
            outView.setText("-missing value-");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

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
    // deleted PlaceholderFragment class
    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    Tab1Angles tab1 = new Tab1Angles();
                    return tab1;
                case 1:
                    Tab2WCMC tab2 = new Tab2WCMC();
                    return tab2;
                case 2:
                    Tab3Distances tab3 = new Tab3Distances();
                    return tab3;
                case 3:
                    Tab4RTK tab4 = new Tab4RTK();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show # total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "AzB";
                case 1:
                    return "WCMC";
                case 2:
                    return "UNITS";
                case 3:
                    return "RTK";
            }
            return null;
        }
    }
}
