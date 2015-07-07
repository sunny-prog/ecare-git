package command;


import entity.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides business logic for adding and updating business cases.
 * It validates user's input and distinguishes between Add and Update
 * business cases. In case of Add command it adds new user to the DB.
 * In case of update it updates user in the DB.
 * Finally at the end of the processing it loads list of all saved in DB users to the client.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserAddUpdateCommand extends UserCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        User user = new User();
        user.setName(getRequest().getParameter("name"));
        user.setSurname(getRequest().getParameter("surname"));

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(getRequest().getParameter("birthDay"));
            user.setBirthDay(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        user.setPassport(getRequest().getParameter("passport"));
        user.setAddress(getRequest().getParameter("address"));
        user.setEmail(getRequest().getParameter("email"));
        user.setAddress(getRequest().getParameter("address"));
        user.setPassword(getRequest().getParameter("password"));

        //Role is hardcoded, as on this application stage (version 1.0) only salesman can create new users with role "client"
        //In future when adminka will be implemented, it will be possible to create
        //users with both roles "salesman" and "client" by admin user, which is the only one per whole application.
        user.setRole("client");

        if (getRequest().getParameter("id").isEmpty()) {
            getUserService().add(user);
        } else {
            Long userId = Long.valueOf(getRequest().getParameter("id"));
            user.setId(userId);
            getUserService().update(user);
        }

        loadUsersList();
    }
}
