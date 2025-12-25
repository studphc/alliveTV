package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class C$Gson$Preconditions {
    public static void checkArgument(boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }
}
