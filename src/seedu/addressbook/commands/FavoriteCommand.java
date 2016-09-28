package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
 * Favorites a particular person in the address book specified by the index
 */
public class FavoriteCommand extends Command {

    public static final String COMMAND_WORD = "favorite";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Favorites the person identified by the index number used in the last person listing.\n\t"
            + "Parameters: INDEX\n\t"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_FAVORITE_PERSON_SUCCESS = "Favorited Person: %1$s";


    public FavoriteCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
    }


    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();

            // Delete existing person, then creates a new one that is favorited
            addressbook.removePerson(target);
            Person replacementPerson = new Person(target);
            replacementPerson.setFavorite(true);
            addressbook.addPerson(replacementPerson)
            return new CommandResult(String.format(MESSAGE_FAVORITE_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (DuplicatePersonException dupe) {
            return new CommandResult(Messages.MESSAGE_PERSON_ALREADY_EXISTS);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}
