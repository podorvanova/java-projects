import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if (tokens[0].equals("add")) {
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                                addCommand);
                    }
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    if (tokens.length != 1) {
                        throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                                "list");
                    }
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                                "remove Василий Петров");
                    }
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    if (tokens.length != 1) {
                        throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                                "count");
                    }
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    if (tokens.length != 1) {
                        throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                                "help");
                    }
                    System.out.println(helpText);
                } else {
                    throw new IllegalArgumentException(commandError);
                }
            }
            catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
