#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_boozehound_boozehound_SplashPage_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
