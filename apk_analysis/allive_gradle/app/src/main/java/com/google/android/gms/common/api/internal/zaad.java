package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zaad {

    /* renamed from: a */
    public final Map f13188a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    public final Map f13189b = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: a */
    public final void m3097a(Status status, boolean z) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f13188a) {
            hashMap = new HashMap(this.f13188a);
        }
        synchronized (this.f13189b) {
            hashMap2 = new HashMap(this.f13189b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    public final void zaf() {
        m3097a(GoogleApiManager.zaa, false);
    }
}
