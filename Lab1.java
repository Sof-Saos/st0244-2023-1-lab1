import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class Lab1{
    static {
        System.loadLibrary("lab1");
    }

    private native double nativeRead(int[] array);

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
      
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(" "); //lista de strings
                for (String parte : partes) {
                    int ent = Integer.parseInt(parte);
                    data.add(ent);
                }
            }
            br.close(); //Cerramos ambos objectos para liberar recursos
            fr.close();

        } catch (IOException e) { //Este catch atrapa los errores que puedan haber y saca un print en caso de no dar
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        int[] array = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            array[i] = data.get(i);
        }
        IntBuffer intBuffer = ByteBuffer.allocateDirect(array.length * 4).asIntBuffer();
        //System.out.println("El arreglo en formato arraylist es " + data);
        intBuffer.put(array);
        System.out.println("El arreglo es " + intBuffer);
        //nativeRead();
        new lab1().readArray(array)
       
    }
}
