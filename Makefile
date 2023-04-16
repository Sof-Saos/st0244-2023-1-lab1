
#This rule compile the program
compile : Lab1.java Mean.cc
  javac -h . Lab1.java
  g++ -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o liblab1.so Mean.cc

#this rule runs the program
run : 
  java -Djava.library.path=. Lab1 intgs.txt
