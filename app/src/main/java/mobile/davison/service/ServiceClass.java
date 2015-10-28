package mobile.davison.service;

/**
 * Created by kevin on 10/27/2015.
 * This is
 */
public class ServiceClass {

    public ServiceClass(String tag, String...args)
    {

    }

    private  void loginPost(String password, String username)
    {
        LoginPostAsync post = new LoginPostAsync();
        post.execute(password, username);
    }

    private  void loginGet(String password, String username)
    {
        LoginGetAsync get = new LoginGetAsync();
        get.execute(password, username);
    }

    private void registrationPost()
    {
        RegistrationPostAsync post = new RegistrationPostAsync();
        post.execute();
    }

    private void registrationGet()
    {
        RegistrationGetAsync get = new RegistrationGetAsync();
        get.execute();
    }
    private void formPost()
    {
        FormPostAsync post = new FormPostAsync();
        post.execute();
    }
    private void formGet()
    {
        FormGetAsync get = new FormGetAsync();
        get.execute();
    }

}
