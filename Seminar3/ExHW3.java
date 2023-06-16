package Seminar3;

import Seminar3.WrongAmountOfDataException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ExHW3 {

    final static DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
    static Scanner userInput = new Scanner(System.in);

    static int GROUPSQUANTITY = 6;

    static String[] clearData = new String[GROUPSQUANTITY];
    static Boolean wasDataClearExceptinon = false;

    public static void main(String[] args) {
        getUserInput();
    }

    public static void getUserInput() {
        /*
         * Getting data from the user
         */
        printHelperText();

        System.out.print("Please enter your data: ");

        String inputString = userInput.nextLine();
        try {
            verifyData(inputString.trim());
        } catch (WrongAmountOfDataException e) {
            System.out.println("You entered less or more data than required!");
        }
    }

    public static void printHelperText() {
        String textForUser = "\nEnter the following data separated by a space: ";
        textForUser += "\nsurname, name, patronymic, birthday, phone number, gender.";

        String dataFormatsInfo = "Data formats:";
        dataFormatsInfo += "\n* surname, name, patronymic - strings";
        dataFormatsInfo += "\n* date of birth - format string dd.mm.yyyy";
        dataFormatsInfo += "\n* phone number - unsigned integer without formatting";
        dataFormatsInfo += "\n* gender - Latin character f or m.";

        String dataExample = "Example data: Ivanov Ivan Ivanovich 06.08.1988 79881234567 m";
        System.out.println(textForUser);
        System.out.println(dataFormatsInfo);
        System.out.println(dataExample);

    }

    private static void verifyData(String userData) throws WrongAmountOfDataException {

        Date birthDate = new Date();
        Long phoneNum = 0L;

        String SPACEREGEX = "\\s";

        // Splitting a string on a space
        Pattern spacePattern = Pattern.compile(SPACEREGEX);
        String[] rawData = spacePattern.split(userData);

        // Checking the amount of data
        try {
            if (rawData.length != GROUPSQUANTITY) {
                throw new WrongAmountOfDataException();
            }
            checkDataFormat(rawData);

            if (!wasDataClearExceptinon) {
                // Convert birthday date and phone number

                // dateFormat: "dd.mm.yyyy"
                dateFormat.setLenient(false);
                birthDate = dateFormat.parse(clearData[3]);

                try {
                    phoneNum = Long.parseLong(clearData[4]);

                } catch (IllegalArgumentException | IllegalStateException e) {
                    throw new IllegalArgumentException("Phone format illegal: " + rawData[4]);
                }

                String template = "%s %s %s %s %s %s";
                String resultStr = String.format(
                        template,
                        clearData[0],
                        clearData[1],
                        clearData[2],
                        dateFormat.format(birthDate),
                        phoneNum.toString(),
                        clearData[5]);

                // If, after checking all groups, the data is correct, we write to the file
                try {
                    saveToFile(resultStr, clearData[0] + ".txt");
                } catch (IOException e) {
                    System.out.println("File read/write problems");
                    e.printStackTrace();
                }
            }

        } catch (ParseException e) {
            System.out.println("Birthday format illegal: " + clearData[3]);
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void checkDataFormat(String[] data) {
        /* Parsing data */
        String fioRegex = "[a-zA-Z]+";
        String birthdayRegex = "\\d{2}\\.\\d{2}.\\d{4}";
        String phoneRegex = "[7|8]\\d{10}";
        String genderRegex = "[f|m]";

        String msgException = "";
        String regex = "";

        for (int i = 0; i < data.length; i++) {
            switch (i) {
                case (0):
                    regex = fioRegex;
                    msgException = "Surname format illegal: ";
                    break;
                case (1):
                    regex = fioRegex;
                    msgException = "Name format illegal: ";
                    break;
                case (2):
                    regex = fioRegex;
                    msgException = "Patronymic format illegal: ";
                    break;
                case (3):
                    regex = birthdayRegex;
                    msgException = "Birthday format illegal: ";
                    break;
                case (4):
                    regex = phoneRegex;
                    msgException = "Phone number format illegal: ";
                    break;
                case (5):
                    regex = genderRegex;
                    msgException = "Gender format illegal: ";
                    break;

            }
            try {
                if (!data[i].matches(regex)) {
                    wasDataClearExceptinon = true;
                    throw new IllegalArgumentException();
                } else {
                    clearData[i] = data[i];
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(msgException + data[i]);
            }
        }
    }

    private static void saveToFile(String data, String path) throws IOException {
        /* Writing to a data file */

        // If a file with such a surname already exists, then we add the data there
        try (FileWriter fileWriter = new FileWriter(new File(path))) {
            // Adds data to a file
            fileWriter.append(data.toString() + "\n");
            fileWriter.flush();
            System.out.println("Your data written to file");
        } catch (IOException e) {
            throw new IOException("File read/write problems");
        }
    }
}
