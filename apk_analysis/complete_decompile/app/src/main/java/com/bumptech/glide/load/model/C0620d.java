package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.DataUrlLoader;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.model.d */
/* loaded from: classes.dex */
public final class C0620d implements DataFetcher {

    /* renamed from: a */
    public final String f8827a;

    /* renamed from: b */
    public final DataUrlLoader.DataDecoder f8828b;

    /* renamed from: c */
    public Object f8829c;

    public C0620d(String str, DataUrlLoader.DataDecoder dataDecoder) {
        this.f8827a = str;
        this.f8828b = dataDecoder;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        try {
            this.f8828b.close(this.f8829c);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return this.f8828b.getDataClass();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object decode = this.f8828b.decode(this.f8827a);
            this.f8829c = decode;
            dataCallback.onDataReady(decode);
        } catch (IllegalArgumentException e) {
            dataCallback.onLoadFailed(e);
        }
    }
}
