package JavaCartPro.src.model;

import java.io.*;

/**
 * class to manage data
 */
public class DataManager {
    /**
     * function to save data
     * @param appData data to be saved
     */
    public static void saveData(AppData appData) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(data))){
            output.writeObject(appData);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * function to load data
     * @return data stored by the program
     */
    public static AppData loadData() {
        AppData appData = null;
        File file = new File(data);
        if (file.exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(data))) {
                appData = (AppData) input.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else{
                appData = new AppData();
            }
            return appData;
    }

    private static final String data = "JavaCartPro/src/data/appData.dat";
}
