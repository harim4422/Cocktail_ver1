package and.harim.com.cocktail;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{


    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastlocation;
    private Marker currentLocationmMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 10000;
    double latitude,longitude;
    LatLng bus;
    String barname1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        String ad = (String)getIntent().getStringExtra("add");
        if(ad!=null){
            Geocoder mCoder = new Geocoder(this);
            try{
                List<Address> addr = mCoder.getFromLocationName(ad, 1);
                Double Lat =addr.get(0).getLatitude();
                Double Lon =addr.get(0).getLongitude();
                bus = new LatLng(Lat, Lon);
                barname1 = (String) getIntent().getStringExtra("barname");




            } catch (IOException e) {
                e.printStackTrace();
            }

        } else{
            bus = new LatLng(37.582037, 127.001892);
            barname1="헤화";
        }



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkLocationPermission();

        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            bulidGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied" , Toast.LENGTH_LONG).show();
                }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        mMap.addMarker(new MarkerOptions().position(bus).title(barname1)).showInfoWindow();

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(
                bus   // 위도, 경도
        ));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.animateCamera(zoom);








        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            bulidGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }


    protected synchronized void bulidGoogleApiClient() {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        client.connect();

    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        lastlocation = location;
        if(currentLocationmMarker != null)
        {
            currentLocationmMarker.remove();

        }
        Log.d("lat = ",""+latitude);
        LatLng latLng = new LatLng(location.getLatitude() , location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        currentLocationmMarker = mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(10));

        if(client != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(client,this);
        }
    }

    public void onClick(View v)
    {
        Object dataTransfer[] = new Object[2];
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();

        switch(v.getId())
        {
            /*case R.id.B_hopistals:
                mMap.clear();
                String hospital = "hospital";
                String url = getUrl(latitude, longitude, hospital);
                dataTransfer[0] = mMap;
                dataTransfer[1] = url;

                getNearbyPlacesData.execute(dataTransfer);
                Toast.makeText(MapsActivity.this, "Showing Nearby Hospitals", Toast.LENGTH_SHORT).show();
                break;*/

            case R.id.B_cocktail:
                mMap.clear();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(37.582037, 127.001892)));
                CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
                mMap.animateCamera(zoom);

                // Add a marker in Sydney and move the camera
                LatLng Germanyhouse = new LatLng(37.582915, 127.000523);
                mMap.addMarker(new MarkerOptions().position(Germanyhouse).title("독일주택"));


                LatLng sweetlife = new LatLng(37.584115,  126.997011);
                mMap.addMarker(new MarkerOptions().position(sweetlife).title("인생의단맛"));

                LatLng ournight = new LatLng(37.583052,  126.998188);
                mMap.addMarker(new MarkerOptions().position(ournight).title("우리의 밤"));

                LatLng beetles = new LatLng(37.581642,  127.003729);
                mMap.addMarker(new MarkerOptions().position(beetles).title("비틀즈"));

                LatLng sunshineboat = new LatLng(37.584724,  127.001035);
                mMap.addMarker(new MarkerOptions().position(sunshineboat).title("햇살돛단배"));

                LatLng doriangray = new LatLng(37.582021,  127.000086);
                mMap.addMarker(new MarkerOptions().position(doriangray).title("도리안그레이"));

                LatLng banju = new LatLng(37.583000,  127.002811);
                mMap.addMarker(new MarkerOptions().position(banju).title("반저"));

                LatLng mixnmolt = new LatLng(37.583084,  126.998127);
                mMap.addMarker(new MarkerOptions().position(mixnmolt).title("믹스앤몰트"));

                LatLng queen101 = new LatLng(37.583071,  126.998151);
                mMap.addMarker(new MarkerOptions().position(queen101).title("퀸101"));

                LatLng monk = new LatLng(37.581706,  127.004714);
                mMap.addMarker(new MarkerOptions().position(monk).title("수도원"));

                LatLng glenco = new LatLng(37.579499,  127.006393);
                mMap.addMarker(new MarkerOptions().position(glenco).title("더글랜코"));

                LatLng humber = new LatLng(37.582278,  126.999406);
                mMap.addMarker(new MarkerOptions().position(humber).title("Humber"));

                LatLng spaceplato = new LatLng(37.582676,  127.000621);
                mMap.addMarker(new MarkerOptions().position(spaceplato).title("스페이스플라토"));

                LatLng namu = new LatLng(37.581971,  126.999772);
                mMap.addMarker(new MarkerOptions().position(namu).title("나무요일"));

                LatLng chako = new LatLng(37.583964,  126.997471);
                mMap.addMarker(new MarkerOptions().position(chako).title("챠코"));

                LatLng comfortzone = new LatLng(37.583085,  126.998172);
                mMap.addMarker(new MarkerOptions().position(comfortzone).title("Comfort Zone"));

                LatLng eightstreet = new LatLng(37.582113,  127.002512);
                mMap.addMarker(new MarkerOptions().position(eightstreet).title("에잇스트리트"));

                LatLng witchkitchen = new LatLng(37.583463,  127.000482);
                mMap.addMarker(new MarkerOptions().position(witchkitchen).title("마녀주방"));

                LatLng aperfactday = new LatLng(37.583552,  126.998047);
                mMap.addMarker(new MarkerOptions().position(aperfactday).title("A perfect day 찡쪽바"));

                LatLng mugnglass = new LatLng(37.584389,  126.996440);
                mMap.addMarker(new MarkerOptions().position(mugnglass).title("머그앤글래스"));

                Toast.makeText(MapsActivity.this, "Cocktail & Wine Bar", Toast.LENGTH_SHORT).show();






                break;





        }
    }


    private String getUrl(double latitude , double longitude , String nearbyPlace)
    {

        StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlaceUrl.append("location="+latitude+","+longitude);
        googlePlaceUrl.append("&radius="+PROXIMITY_RADIUS);
        googlePlaceUrl.append("&type="+nearbyPlace);
        googlePlaceUrl.append("&sensor=true");
        googlePlaceUrl.append("&key="+"AIzaSyBLAPIdLinKChu4nuSeoCWcFvvsPPlJ_t4");

        Log.d("MapsActivity", "url = "+googlePlaceUrl.toString());

        return googlePlaceUrl.toString();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(100);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }
    }


    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            return false;

        }
        else
            return true;
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
    public void click_back(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 뒤로가기 버튼 (종료)

    public void click_home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }//하단 홈 버튼

    public void click_set(View view) {
        Intent set = new Intent(this,SettingsActivity.class);
        startActivity(set);
    }//세팅 연결
}