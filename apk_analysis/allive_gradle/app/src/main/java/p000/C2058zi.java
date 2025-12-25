package p000;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: zi */
/* loaded from: classes.dex */
public final class C2058zi implements DataFetcher {

    /* renamed from: a */
    public final File f29384a;

    public C2058zi(File file) {
        this.f29384a = file;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            dataCallback.onDataReady(ByteBufferUtil.fromFile(this.f29384a));
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
    }
}
