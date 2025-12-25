package com.google.firebase.installations.time;

/* loaded from: classes2.dex */
public class SystemClock implements Clock {

    /* renamed from: a */
    public static SystemClock f15640a;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.firebase.installations.time.SystemClock, java.lang.Object] */
    public static SystemClock getInstance() {
        if (f15640a == null) {
            f15640a = new Object();
        }
        return f15640a;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
