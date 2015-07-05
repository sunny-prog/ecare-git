package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * This class provides business logic for "ContractLoadList" command.
 * It deletes command by it's id.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractLoadListCommand extends ContractCommand {
    @Override
    public void execute() throws ServletException, IOException {
        loadContractsList();
    }
}
