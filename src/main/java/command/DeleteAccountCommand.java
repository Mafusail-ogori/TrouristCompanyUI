package command;

import data.UserData;

import java.io.IOException;

public class DeleteAccountCommand implements Command {

    UserData database;

    public DeleteAccountCommand(UserData database) {
        this.database = database;
    }


    @Override
    public void execute() throws IOException {
        database.deleteAccount();
    }
}
