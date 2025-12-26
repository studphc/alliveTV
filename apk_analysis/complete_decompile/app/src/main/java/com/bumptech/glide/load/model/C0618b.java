package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ByteArrayLoader;

/* renamed from: com.bumptech.glide.load.model.b */
/* loaded from: classes.dex */
public final class C0618b implements DataFetcher {

    /* renamed from: a */
    public final byte[] f8825a;

    /* renamed from: b */
    public final ByteArrayLoader.Converter f8826b;

    public C0618b(byte[] bArr, ByteArrayLoader.Converter converter) {
        this.f8825a = bArr;
        this.f8826b = converter;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return this.f8826b.getDataClass();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        dataCallback.onDataReady(this.f8826b.convert(this.f8825a));
    }
}
