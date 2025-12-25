package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.C0643C;

/* loaded from: classes.dex */
public abstract class Buffer {

    /* renamed from: a */
    public int f9917a;

    public final void addFlag(int i) {
        this.f9917a = i | this.f9917a;
    }

    public void clear() {
        this.f9917a = 0;
    }

    public final void clearFlag(int i) {
        this.f9917a = (~i) & this.f9917a;
    }

    public final boolean getFlag(int i) {
        if ((this.f9917a & i) == i) {
            return true;
        }
        return false;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isFirstSample() {
        return getFlag(C0643C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i) {
        this.f9917a = i;
    }
}
