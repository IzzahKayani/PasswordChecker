import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{
    public static void loadList(SeparateChaining[] scList, LinearProbing[] lpList) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("wordList.txt"));
        sc.useDelimiter("\n");
        String input;
        while (sc.hasNext()) {
            input = sc.next();
            for (SeparateChaining s : scList) {
                s.put(input);
            }

            for (LinearProbing l : lpList) {
                l.put(input);
            }
        }
    }

    public static String passwordCheckerSC(String password, SeparateChaining[] scList)
    {
        String result = "Strong Password";
        if(password.length() < 8)
            return "Weak Password, should be at least 8 letters";
        for(SeparateChaining s : scList)
        {
            if(s.contains(password))
                result = "Weak Password, should not be in the dictionary";
            if(password.matches("^[a-zA-Z]+\\d$") && s.contains(password.substring(0, password.length()-1)))
                result = "Weak Password, should not be a dictionary word with a single digit";
        }
        return result;
    }

    public static String passwordCheckerLP(String password, LinearProbing[] lpList)
    {
        String result = "Strong Password";
        if(password.length() < 8)
            return "Weak Password, should be at least 8 letters";
        for(LinearProbing l : lpList)
        {
            if(l.contains(password))
                result = "Weak Password, should not be in the dictionary";
            if(password.matches("^[a-zA-Z]+\\d$") && l.contains(password.substring(0, password.length()-1)))
                result = "Weak Password, should not be a dictionary word with a single digit";
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        SeparateChaining oldHashSC = new SeparateChaining(1000, HashTypes::oldHash);
        SeparateChaining newHashSC = new SeparateChaining(1000, HashTypes::newHash);
        LinearProbing oldHashLP = new LinearProbing(20000, HashTypes::oldHash);
        LinearProbing newHashLP = new LinearProbing(20000, HashTypes::newHash);

        SeparateChaining[] scList = {oldHashSC, newHashSC};
        LinearProbing[] lpList = {oldHashLP, newHashLP};

        loadList(scList, lpList);

        String[] passwords = {"account8", "accountability", "9a$D#qW7!uX&Lv3zT", "B@k45*W!c$Y7#zR9P", "X$8vQ!mW#3Dz&Yr4K5"};

        for(String password : passwords)
        {
            System.out.println("\nPassword: " + password);
            String resultSC = passwordCheckerSC(password, scList);
            String resultLP = passwordCheckerLP(password, lpList);
            System.out.println(resultSC);
            System.out.println("SC Old Hash Comparisons: " + scList[0].getComparisons());
            System.out.println("SC New Hash Comparisons: " + scList[1].getComparisons());
            System.out.println("LP Old Hash Comparisons: " + lpList[0].getComparisons());
            System.out.println("LP New Hash Comparisons: " + lpList[1].getComparisons());
        }


    }
}
