package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    public final String f8634a;

    /* renamed from: b */
    public final AssetManager f8635b;

    /* renamed from: c */
    public Object f8636c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f8635b = assetManager;
        this.f8634a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        Object obj = this.f8636c;
        if (obj == null) {
            return;
        }
        try {
            close(obj);
        } catch (IOException unused) {
        }
    }

    public abstract void close(T t);

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.f8635b, this.f8634a);
            this.f8636c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(AssetManager assetManager, String str);
}
