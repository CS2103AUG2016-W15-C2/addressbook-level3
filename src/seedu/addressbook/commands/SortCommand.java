package seedu.addressbook.commands;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Sort list in lexicographical order.\n\t"
            + "Example: " + COMMAND_WORD; 
    public static final String MESSAGE_SORT_SUCCESS = "Address Book has been sorted.";
    
    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(MESSAGE_SORT_SUCCESS);
    }
}
