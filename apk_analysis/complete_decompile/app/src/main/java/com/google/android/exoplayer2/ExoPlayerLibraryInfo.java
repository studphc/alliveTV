package com.google.android.exoplayer2;

import java.util.HashSet;

/* loaded from: classes.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String TAG = "ExoPlayerLib";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.18.1";
    public static final int VERSION_INT = 2018001;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.18.1";

    /* renamed from: a */
    public static final HashSet f9350a = new HashSet();

    /* renamed from: b */
    public static String f9351b = "goog.exo.core";

    public static synchronized void registerModule(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (f9350a.add(str)) {
                f9351b += ", " + str;
            }
        }
    }

    public static synchronized String registeredModules() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = f9351b;
        }
        return str;
    }
}
