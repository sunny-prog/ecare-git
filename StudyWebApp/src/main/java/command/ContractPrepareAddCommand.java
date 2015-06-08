package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 08.06.2015.
 */
public class ContractPrepareAddCommand extends ContractCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("/views/contract.jsp");
    }
}