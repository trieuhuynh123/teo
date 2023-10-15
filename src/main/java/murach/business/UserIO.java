package murach.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserIO {

    public static void add(User user, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra.");
        }
    }

    public static User getUser(String emailAddress, String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length >= 3 && parts[0].equals(emailAddress)) {
                    User user = new User();
                    user.setEmail(parts[0]);
                    user.setFirstName(parts[1]);
                    user.setLastName(parts[2]);

                    reader.close();
                    return user;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra.");
        }

        return null;
    }

}
