package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import p000.C1540m9;

/* loaded from: classes.dex */
public final class zag extends zac {

    /* renamed from: a */
    public final TaskApiCall f13296a;

    /* renamed from: b */
    public final TaskCompletionSource f13297b;

    /* renamed from: c */
    public final StatusExceptionMapper f13298c;

    public zag(int i, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.f13297b = taskCompletionSource;
        this.f13296a = taskApiCall;
        this.f13298c = statusExceptionMapper;
        if (i == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.f13296a.shouldAutoResolveMissingFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    @Nullable
    public final Feature[] zab(zabq zabqVar) {
        return this.f13296a.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(@NonNull Status status) {
        this.f13297b.trySetException(this.f13298c.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(@NonNull Exception exc) {
        this.f13297b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) {
        TaskCompletionSource taskCompletionSource = this.f13297b;
        try {
            this.f13296a.doExecute(zabqVar.zaf(), taskCompletionSource);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zai.m3127a(e2));
        } catch (RuntimeException e3) {
            taskCompletionSource.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(@NonNull zaad zaadVar, boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        Map map = zaadVar.f13189b;
        TaskCompletionSource taskCompletionSource = this.f13297b;
        map.put(taskCompletionSource, valueOf);
        taskCompletionSource.getTask().addOnCompleteListener(new C1540m9(27, zaadVar, taskCompletionSource, false));
    }
}
