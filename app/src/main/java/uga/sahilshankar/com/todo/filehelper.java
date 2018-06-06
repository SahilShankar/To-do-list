package uga.sahilshankar.com.todo;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class filehelper {

    public static final String FILENAME = "listinfo.dat";

    public static void writedata(ArrayList<String> items, Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<String> readdata(Context context){
        ArrayList<String> itemslist = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemslist = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {

            itemslist = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemslist;
    }
}
