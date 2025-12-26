package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzjg extends Exception {
    public zzjg() {
    }

    public zzjg(String str) {
        super(str);
    }

    public zzjg(String str, Throwable th) {
        super("ContentProvider query failed", th);
    }
}
