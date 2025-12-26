package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DefaultAllocator implements Allocator {

    /* renamed from: a */
    public final boolean f12432a;

    /* renamed from: b */
    public final int f12433b;

    /* renamed from: c */
    public final byte[] f12434c;

    /* renamed from: d */
    public int f12435d;

    /* renamed from: e */
    public int f12436e;

    /* renamed from: f */
    public int f12437f;

    /* renamed from: g */
    public Allocation[] f12438g;

    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        Allocation allocation;
        try {
            this.f12436e++;
            int i = this.f12437f;
            if (i > 0) {
                Allocation[] allocationArr = this.f12438g;
                int i2 = i - 1;
                this.f12437f = i2;
                allocation = (Allocation) Assertions.checkNotNull(allocationArr[i2]);
                this.f12438g[this.f12437f] = null;
            } else {
                allocation = new Allocation(new byte[this.f12433b], 0);
                int i3 = this.f12436e;
                Allocation[] allocationArr2 = this.f12438g;
                if (i3 > allocationArr2.length) {
                    this.f12438g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.f12433b;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.f12436e * this.f12433b;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        Allocation[] allocationArr = this.f12438g;
        int i = this.f12437f;
        this.f12437f = i + 1;
        allocationArr[i] = allocation;
        this.f12436e--;
        notifyAll();
    }

    public synchronized void reset() {
        if (this.f12432a) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z;
        if (i < this.f12435d) {
            z = true;
        } else {
            z = false;
        }
        this.f12435d = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        try {
            int i = 0;
            int max = Math.max(0, Util.ceilDivide(this.f12435d, this.f12433b) - this.f12436e);
            int i2 = this.f12437f;
            if (max >= i2) {
                return;
            }
            if (this.f12434c != null) {
                int i3 = i2 - 1;
                while (i <= i3) {
                    Allocation allocation = (Allocation) Assertions.checkNotNull(this.f12438g[i]);
                    if (allocation.data == this.f12434c) {
                        i++;
                    } else {
                        Allocation allocation2 = (Allocation) Assertions.checkNotNull(this.f12438g[i3]);
                        if (allocation2.data != this.f12434c) {
                            i3--;
                        } else {
                            Allocation[] allocationArr = this.f12438g;
                            allocationArr[i] = allocation2;
                            allocationArr[i3] = allocation;
                            i3--;
                            i++;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f12437f) {
                    return;
                }
            }
            Arrays.fill(this.f12438g, max, this.f12437f, (Object) null);
            this.f12437f = max;
        } catch (Throwable th) {
            throw th;
        }
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        Assertions.checkArgument(i > 0);
        Assertions.checkArgument(i2 >= 0);
        this.f12432a = z;
        this.f12433b = i;
        this.f12437f = i2;
        this.f12438g = new Allocation[i2 + 100];
        if (i2 > 0) {
            this.f12434c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f12438g[i3] = new Allocation(this.f12434c, i3 * i);
            }
            return;
        }
        this.f12434c = null;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(@Nullable Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            try {
                Allocation[] allocationArr = this.f12438g;
                int i = this.f12437f;
                this.f12437f = i + 1;
                allocationArr[i] = allocationNode.getAllocation();
                this.f12436e--;
                allocationNode = allocationNode.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }
}
