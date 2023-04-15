import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class Lab1{
    static {
        System.loadLibrary("lab1"); //Load the native library
    }

    private native double nativeRead(int[] array); //define the function that will be called

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(); //define an empty array of lists to store the txt data
      
        try { //We use try to handle exceptions that may occur when reading the .txt file.
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) { //we read the file line by line
                String[] partes = line.split(" "); //Separate each line into parts using the space as delimiter.
                for (String parte : partes) {  //Recorrecting each part of the line
                    int ent = Integer.parseInt(parte); //We convert the part into an integer
                    data.add(ent); //add the integer into the arraylist
                }
            }
            br.close(); //Close both objects to free resources
            fr.close();

        } catch (IOException e) { //catches any errors that may occur and outputs a print if it does not give
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        //We convert the arraylist into an array
        int[] array = new int[data.size()];  //define an empty array with the same size of the arrayList
        for (int i = 0; i < data.size(); i++) { //copy the elements of the arrayList to the array
            array[i] = data.get(i);
        }
      
         new Lab1().nativeRead(array); //we create an instance and call the method with the argument
       
    }
}
