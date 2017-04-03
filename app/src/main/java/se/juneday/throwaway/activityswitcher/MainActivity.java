package se.juneday.throwaway.activityswitcher;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  private static final String LOG_TAG = MainActivity.class.getSimpleName();
  public static final String USER_TAG = "user";
  public static final String TEMP_TAG = "temperature";
  private User user;
  static final int REQUEST_IMAGE_CAPTURE = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(LOG_TAG, "onCreate()");
    setContentView(R.layout.activity_main);
    user = new User("Bonnie Prince Billy");
    Session.getInstance().currentUser = new User("This is me!");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(LOG_TAG, "onStart()");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(LOG_TAG, "onPause()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(LOG_TAG, "onResume()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(LOG_TAG, "onStop()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "onDestroy()");
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(LOG_TAG, "---> onActivityResult");
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();
      Bitmap imageBitmap = (Bitmap) extras.get("data");
      ImageView imageView = (ImageView) findViewById(R.id.imageView);
      imageView.setImageBitmap(imageBitmap);
      Log.d(LOG_TAG, "onActivityResult");
    }
    Log.d(LOG_TAG, "<--- onActivityResult");
  }

  public void startCamera(View v) {

    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
  }

  public void startBlaBla(View v) {
    Log.d(LOG_TAG, "Starting Bla Bla");
    Intent intent = new Intent(this, BlaBlaActivity.class);
    intent.putExtra(USER_TAG, user);

    intent.putExtra(TEMP_TAG, 21);
    startActivity(intent);
  }

}
