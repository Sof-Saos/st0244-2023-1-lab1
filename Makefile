
#Esta regla compila el programa
compile : Lab1.java Mean.cc
  javac -h . Lab1.java
  g++ -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o liblab1.so Mean.cc

#esta regla corre el programa
run : 
  java -Djava.library.path=. Lab1 intgs.txt
