package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class LibraryLoader {

    /* renamed from: a */
    public String[] f12712a;

    /* renamed from: b */
    public boolean f12713b;

    /* renamed from: c */
    public boolean f12714c;

    public LibraryLoader(String... strArr) {
        this.f12712a = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.f12713b) {
            return this.f12714c;
        }
        this.f12713b = true;
        try {
            for (String str : this.f12712a) {
                loadLibrary(str);
            }
            this.f12714c = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.m3027w("LibraryLoader", "Failed to load " + Arrays.toString(this.f12712a));
        }
        return this.f12714c;
    }

    public abstract void loadLibrary(String str);

    public synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.f12713b, "Cannot set libraries after loading");
        this.f12712a = strArr;
    }
}
