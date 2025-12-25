package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import p000.aa3;

/* loaded from: classes.dex */
public class CancellationTokenSource {

    /* renamed from: a */
    public final aa3 f14450a = new aa3();

    public void cancel() {
        this.f14450a.f103a.m4716d(null);
    }

    @NonNull
    public CancellationToken getToken() {
        return this.f14450a;
    }
}
