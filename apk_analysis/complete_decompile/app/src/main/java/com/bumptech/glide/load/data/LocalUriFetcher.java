package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a */
    public final Uri f8654a;

    /* renamed from: b */
    public final ContentResolver f8655b;

    /* renamed from: c */
    public Object f8656c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f8655b = contentResolver;
        this.f8654a = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        Object obj = this.f8656c;
        if (obj != null) {
            try {
                close(obj);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void close(T t);

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.f8654a, this.f8655b);
            this.f8656c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver);
}
