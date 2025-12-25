package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class PriorityDataSource implements DataSource {

    /* renamed from: a */
    public final DataSource f12519a;

    /* renamed from: b */
    public final PriorityTaskManager f12520b;

    /* renamed from: c */
    public final int f12521c;

    /* loaded from: classes.dex */
    public static final class Factory implements DataSource.Factory {

        /* renamed from: a */
        public final DataSource.Factory f12522a;

        /* renamed from: b */
        public final PriorityTaskManager f12523b;

        /* renamed from: c */
        public final int f12524c;

        public Factory(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i) {
            this.f12522a = factory;
            this.f12523b = priorityTaskManager;
            this.f12524c = i;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public PriorityDataSource createDataSource() {
            return new PriorityDataSource(this.f12522a.createDataSource(), this.f12523b, this.f12524c);
        }
    }

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i) {
        this.f12519a = (DataSource) Assertions.checkNotNull(dataSource);
        this.f12520b = (PriorityTaskManager) Assertions.checkNotNull(priorityTaskManager);
        this.f12521c = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12519a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12519a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f12519a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12519a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        this.f12520b.proceedOrThrow(this.f12521c);
        return this.f12519a.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        this.f12520b.proceedOrThrow(this.f12521c);
        return this.f12519a.read(bArr, i, i2);
    }
}
