package Tom.commands;

public enum CommandType {
    TODO,DEADLINE,EVENT,LIST,MARK,UNMARK,DELETE,HELP,FIND,UNKNOWN,BYE;

    public static CommandType fromString(String command) {
        switch (command.toLowerCase()) {
            case "todo" : return TODO;
            case "deadline" : return DEADLINE;
            case "event" : return EVENT;
            case "list" : return LIST;
            case "mark" : return MARK;
            case "unmark" : return UNMARK;
            case "delete" : return DELETE;
            case "help" : return HELP;
            case "find" : return FIND;
            case "bye" : return BYE;
            default: return UNKNOWN;
        }
    }
}
