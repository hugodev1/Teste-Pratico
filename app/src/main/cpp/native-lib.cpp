#include <jni.h>
#include <string>


extern "C" JNIEXPORT jstring JNICALL
Java_com_hugo_testesoma_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
   return env->NewStringUTF(hello.c_str());
}


extern "C" JNIEXPORT jint JNICALL

Java_com_hugo_testesoma_MainActivity_somaFromJNI(
        JNIEnv* env,
        jobject /* this */,
        jint numA,
        jint numB
        ) {

        return numA + numB;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_hugo_testesoma_Calculadora_soma(
        JNIEnv* env,
        jobject,
        jint num
        ) {
    return num + 5;
}
