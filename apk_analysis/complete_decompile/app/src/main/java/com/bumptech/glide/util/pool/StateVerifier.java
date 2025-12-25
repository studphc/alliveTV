package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class StateVerifier {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bumptech.glide.util.pool.StateVerifier, java.lang.Object] */
    @NonNull
    public static StateVerifier newInstance() {
        return new Object();
    }

    /* renamed from: a */
    public abstract void mo2400a(boolean z);

    public abstract void throwIfRecycled();
}
