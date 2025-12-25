package com.facebook.crypto.util;

import java.io.IOException;

/* loaded from: classes.dex */
public class Assertions {
    public static void checkArgumentForIO(boolean z, String str) {
        if (z) {
        } else {
            throw new IOException(str);
        }
    }

    public static void checkState(boolean z, String str) {
        if (z) {
        } else {
            throw new IllegalStateException(str);
        }
    }
}
