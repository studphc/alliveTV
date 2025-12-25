package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Map;
import p000.AbstractC1778ry;

/* loaded from: classes.dex */
public abstract class BaseDataSource implements DataSource {

    /* renamed from: a */
    public final boolean f12391a;

    /* renamed from: b */
    public final ArrayList f12392b = new ArrayList(1);

    /* renamed from: c */
    public int f12393c;

    /* renamed from: d */
    public DataSpec f12394d;

    public BaseDataSource(boolean z) {
        this.f12391a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        ArrayList arrayList = this.f12392b;
        if (!arrayList.contains(transferListener)) {
            arrayList.add(transferListener);
            this.f12393c++;
        }
    }

    public final void bytesTransferred(int i) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.f12394d);
        for (int i2 = 0; i2 < this.f12393c; i2++) {
            ((TransferListener) this.f12392b.get(i2)).onBytesTransferred(this, dataSpec, this.f12391a, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public /* synthetic */ Map getResponseHeaders() {
        return AbstractC1778ry.m7309a(this);
    }

    public final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.f12394d);
        for (int i = 0; i < this.f12393c; i++) {
            ((TransferListener) this.f12392b.get(i)).onTransferEnd(this, dataSpec, this.f12391a);
        }
        this.f12394d = null;
    }

    public final void transferInitializing(DataSpec dataSpec) {
        for (int i = 0; i < this.f12393c; i++) {
            ((TransferListener) this.f12392b.get(i)).onTransferInitializing(this, dataSpec, this.f12391a);
        }
    }

    public final void transferStarted(DataSpec dataSpec) {
        this.f12394d = dataSpec;
        for (int i = 0; i < this.f12393c; i++) {
            ((TransferListener) this.f12392b.get(i)).onTransferStart(this, dataSpec, this.f12391a);
        }
    }
}
