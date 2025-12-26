package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {

    /* renamed from: a */
    public final HashSet f13320a = new HashSet();

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void addObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.f13320a.add(dataBufferObserver);
    }

    public void clear() {
        this.f13320a.clear();
    }

    public boolean hasObservers() {
        if (!this.f13320a.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataChanged() {
        Iterator it = this.f13320a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeChanged(int i, int i2) {
        Iterator it = this.f13320a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i, i2);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeInserted(int i, int i2) {
        Iterator it = this.f13320a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i, i2);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeMoved(int i, int i2, int i3) {
        Iterator it = this.f13320a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeRemoved(int i, int i2) {
        Iterator it = this.f13320a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i, i2);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void removeObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.f13320a.remove(dataBufferObserver);
    }
}
