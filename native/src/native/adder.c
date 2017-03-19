#include "org_github_jw3_Adder.h"

JNIEXPORT jint JNICALL Java_org_github_jw3_Adder_plus
  (JNIEnv* env, jobject instance, jint term)
{
	jclass clazz = (*env)->GetObjectClass(env, instance);
	jfieldID field = (*env)->GetFieldID(env, clazz, "base", "I");
	jint base = (*env)->GetIntField(env, instance, field);
	return base + term;
}
