package se.juneday.throwaway.activityswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BlaBlaActivity extends AppCompatActivity {

  private static final String LOG_TAG = BlaBlaActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bla_bla);

    Bundle extras = getIntent().getExtras();
    if (extras == null) {
      return;
    }

    int temp = extras.getInt(MainActivity.TEMP_TAG);
    Log.d(LOG_TAG, "You passed temp: " + temp);

    User user = getIntent().getParcelableExtra(MainActivity.USER_TAG);
    if (user != null) {
      Log.d(LOG_TAG, "You passed user: " + user);
    }

    Log.d(LOG_TAG, "current user: " +     Session.getInstance().currentUser);

  }
}
