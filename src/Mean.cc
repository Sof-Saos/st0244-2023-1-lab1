#include <jni.h>
#include "Lab1.h"

  JNIEXPORT jdouble JNICALL Java_Lab1_nativeRead(JNIEnv *env, jobject obj, jintArray array) { //we define the function that calls the function previously defined in the java program
    
    jint *arr = env->GetIntArrayElements(array, NULL); //we get a pointer to the elements of the jintArray object
    jsize len = env->GetArrayLength(array); //we get the size of the array

    jint counter = 0; //We use a counter that will be used to calculate the sum of the array elements
    for (int i = 0; i < len; i++) { // for loop that will iterate over each element of the integer array
        counter += arr[i]; //adds the value of the current array element to the counter variable.
    }
    jdouble mean = counter/len; //calculate the mean dividing the sum (counter) by the length of the array
    env->ReleaseIntArrayElements(array, arr, 0); //we release the reference to the jintArray object
    
    return mean; //returns the average 
}
