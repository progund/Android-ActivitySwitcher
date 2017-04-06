package se.juneday.throwaway.activityswitcher;


public class Session {

  private static Session session;

  public User currentUser;

  private Session() {}

  static {
    session = new Session();
  }

  public static Session getInstance() {
    return session;
  }

}
