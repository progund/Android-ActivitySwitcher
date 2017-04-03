package se.juneday.throwaway.activityswitcher;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hesa on 4/3/17.
 */

public class User implements Parcelable {

  private String name;

  public User(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  public String toString() {
    return name;
  }

  public static final Parcelable.Creator<User> CREATOR
      = new Parcelable.Creator<User>() {
    public User createFromParcel(Parcel in) {
      return new User(in);
    }

    public User[] newArray(int size) {
      return new User[size];
    }
  };


  private User(Parcel in) {
    name = in.readString();
  }
  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(name);
  }
}
