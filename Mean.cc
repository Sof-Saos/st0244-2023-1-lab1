#include <jni.h>
#include <iostream>
#include "Lab1.h"

  JNIEXPORT jdouble JNICALLJava_Prueba_nativeRead(JNIEnv *env, jobject obj, jintArray array) {
    jint *arr = env->GetIntArrayElements(array, NULL);
    jsize len = env->GetArrayLength(array);

    std::cout << "Elements of the array: ";
    for (int i = 0; i < len; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
    env->ReleaseIntArrayElements(array, arr, 0);
}
