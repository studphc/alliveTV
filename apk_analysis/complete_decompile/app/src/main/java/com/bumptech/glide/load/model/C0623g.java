package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.FileLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.model.g */
/* loaded from: classes.dex */
public final class C0623g implements DataFetcher {

    /* renamed from: a */
    public final File f8830a;

    /* renamed from: b */
    public final FileLoader.FileOpener f8831b;

    /* renamed from: c */
    public Object f8832c;

    public C0623g(File file, FileLoader.FileOpener fileOpener) {
        this.f8830a = file;
        this.f8831b = fileOpener;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        Object obj = this.f8832c;
        if (obj != null) {
            try {
                this.f8831b.close(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return this.f8831b.getDataClass();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object open = this.f8831b.open(this.f8830a);
            this.f8832c = open;
            dataCallback.onDataReady(open);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("FileLoader", 3)) {
                Log.d("FileLoader", "Failed to open file", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }
}
