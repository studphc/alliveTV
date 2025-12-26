package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource;

/* loaded from: classes.dex */
public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {

    /* renamed from: a */
    public final DataSource.Factory f11379a;

    public DefaultHlsDataSourceFactory(DataSource.Factory factory) {
        this.f11379a = factory;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public DataSource createDataSource(int i) {
        return this.f11379a.createDataSource();
    }
}
