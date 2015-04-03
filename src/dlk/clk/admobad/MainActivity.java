package dlk.clk.admobad;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
 
import android.os.Bundle;
import android.app.Activity;
 
public class MainActivity extends Activity {
	private InterstitialAd interstitial;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.activity_main);
 
		// Prepare the Interstitial Ad
		interstitial = new InterstitialAd(MainActivity.this);
		// Insert the Ad Unit ID
		interstitial.setAdUnitId("ca-app-pub-123456789/123456789");
 
		//Locate the Banner Ad in activity_main.xml
		AdView adView = (AdView) this.findViewById(R.id.adView);
 
		// Request for Ads
		AdRequest adRequest = new AdRequest.Builder()
 
		// Add a test device to show Test Ads
		 .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
		 .addTestDevice("CC5F2C72DF2B356BBF0DA198")
				.build();
 
		// Load ads into Banner Ads
		adView.loadAd(adRequest);
 
		// Load ads into Interstitial Ads
		interstitial.loadAd(adRequest);
 
		// Prepare an Interstitial Ad Listener
		interstitial.setAdListener(new AdListener() {
			public void onAdLoaded() {
				// Call displayInterstitial() function
				displayInterstitial();
			}
		});
	}
	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}
}
