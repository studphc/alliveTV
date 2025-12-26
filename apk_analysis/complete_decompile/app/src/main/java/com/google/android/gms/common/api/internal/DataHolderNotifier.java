package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {

    /* renamed from: a */
    public final DataHolder f13102a;

    @KeepForSdk
    public DataHolderNotifier(@NonNull DataHolder dataHolder) {
        this.f13102a = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public final void notifyListener(@NonNull L l) {
        notifyListener(l, this.f13102a);
    }

    @KeepForSdk
    public abstract void notifyListener(@NonNull L l, @NonNull DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public void onNotifyListenerFailed() {
        DataHolder dataHolder = this.f13102a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
