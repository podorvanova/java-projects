import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;
    private static final Pattern patternName = Pattern.compile("^[А-Я][а-я]* [А-Я][а-я]*$");
    private static final Pattern patternTelephone = Pattern.compile("^\\+7[0-9]{10}$");
    private static final Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z0-9-]+\\.[a-z]+$");

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws EmailException {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format. Correct format example: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        String name = components[0] + " " + components[1];
        Matcher matcherName = patternName.matcher(name);
        if (!matcherName.find()) {
            throw new IllegalArgumentException("Wrong name format. Name must be composed of given name and family name, separated by a space. Correct format example: Василий Петров");
        }

        Matcher matcherTelephone = patternTelephone.matcher(components[3]);
        if (!matcherTelephone.find()) {
            throw new TelephoneException("Wrong telephone format. Correct format example: +79215637722");
        }

        Matcher matcherEmail = patternEmail.matcher(components[2]);
        if (!matcherEmail.find()) {
            throw new EmailException("Wrong email format. Correct format example: vasily.petrov@gmail.com");
        }

        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Item you are trying to delete does not exist");
        }

        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}