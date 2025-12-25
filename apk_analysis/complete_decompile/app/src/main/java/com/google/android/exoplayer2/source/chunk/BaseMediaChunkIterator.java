package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* renamed from: a */
    public final long f11135a;

    /* renamed from: b */
    public final long f11136b;

    /* renamed from: c */
    public long f11137c;

    public BaseMediaChunkIterator(long j, long j2) {
        this.f11135a = j;
        this.f11136b = j2;
        reset();
    }

    public final void checkInBounds() {
        long j = this.f11137c;
        if (j >= this.f11135a && j <= this.f11136b) {
        } else {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.f11137c;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        if (this.f11137c > this.f11136b) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        this.f11137c++;
        return !isEnded();
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public void reset() {
        this.f11137c = this.f11135a - 1;
    }
}
