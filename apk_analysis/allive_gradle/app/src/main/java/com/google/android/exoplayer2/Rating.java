package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Bundleable;
import p000.t82;

/* loaded from: classes.dex */
public abstract class Rating implements Bundleable {
    public static final Bundleable.Creator<Rating> CREATOR = new t82(0);

    public abstract boolean isRated();
}
