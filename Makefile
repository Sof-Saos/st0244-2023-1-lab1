
#This rule compile the program
JAVA_HOME = /usr/lib/jvm/java-19-openjdk-amd64
all : compile run

compile : Lab1.java Mean.cc 
        javac -h . Lab1.java
        g++ -fPIC -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux" -shared -o liblab1.so Mean.cc

#this rule runs the program
run : Lab1.java intgs.txt
    java -Djava.library.path=. Lab1 intgs.txt
