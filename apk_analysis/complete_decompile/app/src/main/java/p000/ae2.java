package p000;

import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class ae2 implements Allocator.AllocationNode {

    /* renamed from: a */
    public long f151a;

    /* renamed from: b */
    public long f152b;

    /* renamed from: c */
    public Allocation f153c;

    /* renamed from: d */
    public ae2 f154d;

    public ae2(long j, int i) {
        boolean z;
        if (this.f153c == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f151a = j;
        this.f152b = j + i;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator.AllocationNode
    public final Allocation getAllocation() {
        return (Allocation) Assertions.checkNotNull(this.f153c);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator.AllocationNode
    public final Allocator.AllocationNode next() {
        ae2 ae2Var = this.f154d;
        if (ae2Var != null && ae2Var.f153c != null) {
            return ae2Var;
        }
        return null;
    }
}
