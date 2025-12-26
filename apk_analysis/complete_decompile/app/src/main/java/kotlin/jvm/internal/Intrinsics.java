package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes2.dex */
public class Intrinsics {

    @SinceKotlin(version = "1.4")
    /* loaded from: classes2.dex */
    public static class Kotlin {
    }

    /* renamed from: a */
    public static String m5623a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m5624b(String str, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(AbstractC1726qj.m7057m(str, " must not be null"));
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Field specified as non-null is null: " + str + "." + str2);
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void checkHasClass(String str) {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(ye0.m8296p("Class ", replace, " is not found. Please update the Kotlin runtime to the latest version"), e);
            m5624b(Intrinsics.class.getName(), classNotFoundException);
            throw classNotFoundException;
        }
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(AbstractC1726qj.m7057m(str, " must not be null"));
        m5624b(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(m5623a(str));
        m5624b(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(m5623a(str));
        m5624b(Intrinsics.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2);
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    public static void throwAssert() {
        AssertionError assertionError = new AssertionError();
        m5624b(Intrinsics.class.getName(), assertionError);
        throw assertionError;
    }

    public static void throwIllegalArgument() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        m5624b(Intrinsics.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void throwIllegalState() {
        IllegalStateException illegalStateException = new IllegalStateException();
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        m5624b(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        m5624b(Intrinsics.class.getName(), kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        m5624b(Intrinsics.class.getName(), uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double d, Double d2) {
        if (d == null) {
            if (d2 != null) {
                return false;
            }
        } else if (d2 == null || d.doubleValue() != d2.doubleValue()) {
            return false;
        }
        return true;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str);
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str);
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void throwAssert(String str) {
        AssertionError assertionError = new AssertionError(str);
        m5624b(Intrinsics.class.getName(), assertionError);
        throw assertionError;
    }

    public static void throwIllegalArgument(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        m5624b(Intrinsics.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void throwIllegalState(String str) {
        IllegalStateException illegalStateException = new IllegalStateException(str);
        m5624b(Intrinsics.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe(String str) {
        NullPointerException nullPointerException = new NullPointerException(str);
        m5624b(Intrinsics.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void throwNpe(String str) {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(str);
        m5624b(Intrinsics.class.getName(), kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float f, Float f2) {
        if (f == null) {
            if (f2 != null) {
                return false;
            }
        } else if (f2 == null || f.floatValue() != f2.floatValue()) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static void checkHasClass(String str, String str2) {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e);
            m5624b(Intrinsics.class.getName(), classNotFoundException);
            throw classNotFoundException;
        }
    }
}
