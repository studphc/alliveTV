package p000;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class vm1 implements DataFetcher {

    /* renamed from: c */
    public static final String[] f27871c = {"_data"};

    /* renamed from: a */
    public final Context f27872a;

    /* renamed from: b */
    public final Uri f27873b;

    public vm1(Context context, Uri uri) {
        this.f27872a = context;
        this.f27873b = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return File.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        Cursor query = this.f27872a.getContentResolver().query(this.f27873b, f27871c, null, null, null);
        String str = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(query.getColumnIndexOrThrow("_data"));
                }
            } finally {
                query.close();
            }
        }
        if (TextUtils.isEmpty(str)) {
            dataCallback.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.f27873b));
            return;
        }
        dataCallback.onDataReady(new File(str));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
    }
}
