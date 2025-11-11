package MVCShapes;

import java.io.*;
import java.util.ArrayList;

public class IOProcessor {

    public static Shape[] importShapes(String path){
        ArrayList<Shape> importedShapes = new ArrayList<>();
        try(ObjectInputStream reader =  new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){

            Shape importedShape = (Shape)reader.readObject();

            while(true){
                importedShapes.add(importedShape);
                importedShape = (Shape)reader.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            // кінець файла
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return importedShapes.toArray(Shape[]::new);
    }

    public static void exportShapes(String path, Shape[] shapes){
        try(ObjectOutputStream writer =  new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
            
            for (Shape shape : shapes) {
               writer.writeObject(shape);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
