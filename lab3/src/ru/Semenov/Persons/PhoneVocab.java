package ru.Semenov.Persons;

import java.util.*;


public class PhoneVocab {
    private Map<String, String> vocab = new HashMap<String, String>();


    public PhoneVocab() {
        this.vocab.put("111-222", "Ivan");
        this.vocab.put("323-232", "Volodimir");
        this.vocab.put("014-1480", "Ben");
    }

    public void Add(String Phone, String Name) {
        if (!IsNameExists(Name)) {
            vocab.put(Phone,Name);
        } else {
            String numbr = GetNumberByName(Name);
            System.out.println("Old phone: " + numbr);
            if (numbr != "-1") {
                vocab.remove(numbr);
                vocab.put(Phone, Name);
            }
        }
    }

    public void Remove(String Name) {
        String number = GetNumberByName(Name);
        if (number != "-1") {
            vocab.remove(number);
        }
    }

    public int GetSize() {
        return vocab.size();
    }

    public boolean IsInVocab(String Something) {
        Set<String > Kset = vocab.keySet();
        Collection<String> vals = vocab.values();

        return Kset.contains(Something) || vals.contains(Something);
    }

    public String GetNumber(String Name) {
        String number = GetNumberByName(Name);
        return number != "-1" ? number : "There`s no information about " + Name;
    }

    private String GetNumberByName(String Name) {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            if (vocab.get(key) == Name ) {
                return key;
            }
        }

        return "-1";
    }

    public ArrayList<String> GetAllPairs() {
        Set<String> set = vocab.keySet();

        ArrayList<String> result = new ArrayList<String>();

        for (String key : set) {
            result.add(key + " " +  vocab.get(key));
        }

        return result;
    }


    public ArrayList<String> GetNamesBySubstring(String sub) {
        Collection<String> vals = vocab.values();

        ArrayList<String> result = new ArrayList<String>();

        for (String val : vals) {
            if (val.contains(sub)) result.add(val);
        }

        return result;
    }

    public ArrayList<String> GetAllNumbers() {
        ArrayList<String> numbers = new ArrayList<String>();

        Collection<String> keys = vocab.keySet();

        for (String key : keys) {
            numbers.add(key);
        }

        return numbers;
    }

    public ArrayList<String> GetAllNames() {
        ArrayList<String> names = new ArrayList<String>();

        Collection<String> vals = vocab.values();

        for (String val : vals) {
            names.add(val);
        }

        return names;
    }

    private boolean IsNameExists(String Name) {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            if (vocab.get(key) == Name) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            System.out.println(key + " " +  vocab.get(key));
        }

        return "Its all phone numbers";
    }

}
