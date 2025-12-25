package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import p000.ye0;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: a */
    public boolean f13337a;

    /* renamed from: b */
    public ArrayList f13338b;

    @KeepForSdk
    public EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.f13337a = false;
    }

    /* renamed from: a */
    public final int m3132a(int i) {
        if (i >= 0 && i < this.f13338b.size()) {
            return ((Integer) this.f13338b.get(i)).intValue();
        }
        throw new IllegalArgumentException(ye0.m8292l(i, "Position ", " is out of bounds for this buffer"));
    }

    /* renamed from: b */
    public final void m3133b() {
        synchronized (this) {
            try {
                if (!this.f13337a) {
                    int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                    ArrayList arrayList = new ArrayList();
                    this.f13338b = arrayList;
                    if (count > 0) {
                        arrayList.add(0);
                        String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                        String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                        for (int i = 1; i < count; i++) {
                            int windowIndex = this.mDataHolder.getWindowIndex(i);
                            String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i, windowIndex);
                            if (string2 != null) {
                                if (!string2.equals(string)) {
                                    this.f13338b.add(Integer.valueOf(i));
                                    string = string2;
                                }
                            } else {
                                throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i + ", for window: " + windowIndex);
                            }
                        }
                    }
                    this.f13337a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final T get(int i) {
        int intValue;
        int intValue2;
        m3133b();
        int m3132a = m3132a(i);
        int i2 = 0;
        if (i >= 0 && i != this.f13338b.size()) {
            if (i == this.f13338b.size() - 1) {
                intValue = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                intValue2 = ((Integer) this.f13338b.get(i)).intValue();
            } else {
                intValue = ((Integer) this.f13338b.get(i + 1)).intValue();
                intValue2 = ((Integer) this.f13338b.get(i)).intValue();
            }
            int i3 = intValue - intValue2;
            if (i3 == 1) {
                int m3132a2 = m3132a(i);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(m3132a2);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, m3132a2, windowIndex) != null) {
                    i2 = 1;
                }
            } else {
                i2 = i3;
            }
        }
        return getEntry(m3132a, i2);
    }

    @Nullable
    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        m3133b();
        return this.f13338b.size();
    }

    @NonNull
    @KeepForSdk
    public abstract T getEntry(int i, int i2);

    @NonNull
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();
}
