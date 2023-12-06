package JavaCartPro.src.model;

import java.io.*;

public class DataManager {
    public static void saveData(AppData appData) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(data))){
            output.writeObject(appData);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

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
