package androidx.core.os;

import androidx.annotation.NonNull;
import java.io.File;
import p000.u90;

/* loaded from: classes.dex */
public final class EnvironmentCompat {

    @Deprecated
    public static final String MEDIA_UNKNOWN = "unknown";

    @NonNull
    public static String getStorageState(@NonNull File file) {
        return u90.m7682a(file);
    }
}
