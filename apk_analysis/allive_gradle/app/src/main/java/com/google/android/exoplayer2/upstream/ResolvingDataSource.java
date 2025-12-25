package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ResolvingDataSource implements DataSource {

    /* renamed from: a */
    public final DataSource f12535a;

    /* renamed from: b */
    public final Resolver f12536b;

    /* renamed from: c */
    public boolean f12537c;

    /* loaded from: classes.dex */
    public static final class Factory implements DataSource.Factory {

        /* renamed from: a */
        public final DataSource.Factory f12538a;

        /* renamed from: b */
        public final Resolver f12539b;

        public Factory(DataSource.Factory factory, Resolver resolver) {
            this.f12538a = factory;
            this.f12539b = resolver;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public ResolvingDataSource createDataSource() {
            return new ResolvingDataSource(this.f12538a.createDataSource(), this.f12539b);
        }
    }

    /* loaded from: classes.dex */
    public interface Resolver {
        DataSpec resolveDataSpec(DataSpec dataSpec);

        Uri resolveReportedUri(Uri uri);
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver) {
        this.f12535a = dataSource;
        this.f12536b = resolver;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12535a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f12537c) {
            this.f12537c = false;
            this.f12535a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f12535a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        Uri uri = this.f12535a.getUri();
        if (uri == null) {
            return null;
        }
        return this.f12536b.resolveReportedUri(uri);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        DataSpec resolveDataSpec = this.f12536b.resolveDataSpec(dataSpec);
        this.f12537c = true;
        return this.f12535a.open(resolveDataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return this.f12535a.read(bArr, i, i2);
    }
}
