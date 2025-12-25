package com.google.firebase.emulators;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class EmulatedServiceSettings {

    /* renamed from: a */
    public final String f15555a;

    /* renamed from: b */
    public final int f15556b;

    public EmulatedServiceSettings(@NonNull String str, int i) {
        this.f15555a = str;
        this.f15556b = i;
    }

    public String getHost() {
        return this.f15555a;
    }

    public int getPort() {
        return this.f15556b;
    }
}
