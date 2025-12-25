package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class zal {

    /* renamed from: d */
    public int f13303d;

    /* renamed from: b */
    public final ArrayMap f13301b = new ArrayMap();

    /* renamed from: c */
    public final TaskCompletionSource f13302c = new TaskCompletionSource();

    /* renamed from: e */
    public boolean f13304e = false;

    /* renamed from: a */
    public final ArrayMap f13300a = new ArrayMap();

    public zal(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f13300a.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.f13303d = this.f13300a.keySet().size();
    }

    public final Task zaa() {
        return this.f13302c.getTask();
    }

    public final Set zab() {
        return this.f13300a.keySet();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, @Nullable String str) {
        ArrayMap arrayMap = this.f13300a;
        arrayMap.put(apiKey, connectionResult);
        ArrayMap arrayMap2 = this.f13301b;
        arrayMap2.put(apiKey, str);
        this.f13303d--;
        if (!connectionResult.isSuccess()) {
            this.f13304e = true;
        }
        if (this.f13303d == 0) {
            boolean z = this.f13304e;
            TaskCompletionSource taskCompletionSource = this.f13302c;
            if (z) {
                taskCompletionSource.setException(new AvailabilityException(arrayMap));
            } else {
                taskCompletionSource.setResult(arrayMap2);
            }
        }
    }
}
