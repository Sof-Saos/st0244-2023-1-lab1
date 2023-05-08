
ER = -fPIC -Wall -Wextra -Werror -Wno-unused-parameter
JAVA_HOME = /usr/lib/jvm/java-19-openjdk-amd64
all : compile run

compile : Lab1.java Mean.cc 
	javac -h . -Xlint:all,-serial -Werror Lab1.java
	g++ $(ER) -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux" -shared -o liblab1.so Mean.cc

run : Lab1.class Lab1.java my-file.txt
	java -Djava.library.path=. Lab1 my-file.txt

clean : 
	rm -f *.class *.so *.h
