package se.juneday.throwaway.activityswitcher;

/**
 * Created by hesa on 4/3/17.
 */

public class Session {

  private static Session session;

  public User currentUser;

  static {
    session = new Session();
  }

  public static Session getInstance() {
    return session;
  }

}
