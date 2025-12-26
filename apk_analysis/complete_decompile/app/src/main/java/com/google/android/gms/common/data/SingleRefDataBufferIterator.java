package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;
import p000.ye0;

@KeepForSdk
/* loaded from: classes.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {

    /* renamed from: a */
    public Object f13339a;

    public SingleRefDataBufferIterator(@NonNull DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    @NonNull
    public final Object next() {
        if (hasNext()) {
            int i = this.zab + 1;
            this.zab = i;
            if (i == 0) {
                Object checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
                this.f13339a = checkNotNull;
                if (!(checkNotNull instanceof DataBufferRef)) {
                    throw new IllegalStateException(ye0.m8296p("DataBuffer reference of type ", String.valueOf(checkNotNull.getClass()), " is not movable"));
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.f13339a)).zaa(this.zab);
            }
            return this.f13339a;
        }
        throw new NoSuchElementException(ye0.m8291k(this.zab, "Cannot advance the iterator beyond "));
    }
}
