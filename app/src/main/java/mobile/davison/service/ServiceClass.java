package mobile.davison.service;

/**
 * Created by kevin on 10/27/2015.
 * This is
 */
public class ServiceClass {

    public ServiceClass(){}

    public  void loginPost(String password, String username)
    {
        LoginPostAsync post = new LoginPostAsync();
        post.execute(password, username);
    }

    public  void loginGet(String password, String username)
    {
        LoginGetAsync get = new LoginGetAsync();
        get.execute(password, username);
    }

    public void registrationPost()
    {
        RegistrationPostAsync post = new RegistrationPostAsync();
        post.execute();
    }

    public void registrationGet()
    {
        RegistrationGetAsync get = new RegistrationGetAsync();
        get.execute();
    }
    public void formPost()
    {
        FormPostAsync post = new FormPostAsync();
        post.execute();
    }
    public void formGet()
    {
        FormGetAsync get = new FormGetAsync();
        get.execute();
    }

}
