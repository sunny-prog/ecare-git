package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.User;
import service.UserService;

public class UserDeleteCommand extends UserCommand {
	
	@Override
	public void execute() throws ServletException, IOException {

		UserService userService = new UserService(getContext());

		Long id = Long.valueOf(getRequest().getParameter("id"));
		userService.deleteUserById(id);
        List<User> list = userService.getAll();
		loadUsersList(list);
	}
}
