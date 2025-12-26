package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000.ye0;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    @NonNull
    protected final DataBuffer zaa;
    protected int zab = -1;

    public DataBufferIterator(@NonNull DataBuffer dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zab < this.zaa.getCount() - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    @NonNull
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zaa;
            int i = this.zab + 1;
            this.zab = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException(ye0.m8291k(this.zab, "Cannot advance the iterator beyond "));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
