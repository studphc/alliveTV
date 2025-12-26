package p000;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class k82 implements DataFetcher {

    /* renamed from: k */
    public static final String[] f20779k = {"_data"};

    /* renamed from: a */
    public final Context f20780a;

    /* renamed from: b */
    public final ModelLoader f20781b;

    /* renamed from: c */
    public final ModelLoader f20782c;

    /* renamed from: d */
    public final Uri f20783d;

    /* renamed from: e */
    public final int f20784e;

    /* renamed from: f */
    public final int f20785f;

    /* renamed from: g */
    public final Options f20786g;

    /* renamed from: h */
    public final Class f20787h;

    /* renamed from: i */
    public volatile boolean f20788i;

    /* renamed from: j */
    public volatile DataFetcher f20789j;

    public k82(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Uri uri, int i, int i2, Options options, Class cls) {
        this.f20780a = context.getApplicationContext();
        this.f20781b = modelLoader;
        this.f20782c = modelLoader2;
        this.f20783d = uri;
        this.f20784e = i;
        this.f20785f = i2;
        this.f20786g = options;
        this.f20787h = cls;
    }

    /* renamed from: a */
    public final DataFetcher m5511a() {
        boolean isExternalStorageLegacy;
        ModelLoader.LoadData buildLoadData;
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Options options = this.f20786g;
        int i = this.f20785f;
        int i2 = this.f20784e;
        Context context = this.f20780a;
        if (isExternalStorageLegacy) {
            Uri uri = this.f20783d;
            try {
                Cursor query = context.getContentResolver().query(uri, f20779k, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndexOrThrow("_data"));
                            if (!TextUtils.isEmpty(string)) {
                                File file = new File(string);
                                query.close();
                                buildLoadData = this.f20781b.buildLoadData(file, i2, i, options);
                            } else {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            int checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            Uri uri2 = this.f20783d;
            if (checkSelfPermission == 0) {
                uri2 = MediaStore.setRequireOriginal(uri2);
            }
            buildLoadData = this.f20782c.buildLoadData(uri2, i2, i, options);
        }
        if (buildLoadData == null) {
            return null;
        }
        return buildLoadData.fetcher;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f20788i = true;
        DataFetcher dataFetcher = this.f20789j;
        if (dataFetcher != null) {
            dataFetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        DataFetcher dataFetcher = this.f20789j;
        if (dataFetcher != null) {
            dataFetcher.cleanup();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class getDataClass() {
        return this.f20787h;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            DataFetcher m5511a = m5511a();
            if (m5511a == null) {
                dataCallback.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.f20783d));
            } else {
                this.f20789j = m5511a;
                if (this.f20788i) {
                    cancel();
                } else {
                    m5511a.loadData(priority, dataCallback);
                }
            }
        } catch (FileNotFoundException e) {
            dataCallback.onLoadFailed(e);
        }
    }
}
