package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import p000.kt2;
import p000.lt2;
import p000.mt2;

/* loaded from: classes.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    public final Uri f8660a;

    /* renamed from: b */
    public final mt2 f8661b;

    /* renamed from: c */
    public InputStream f8662c;

    public ThumbFetcher(Uri uri, mt2 mt2Var) {
        this.f8660a = uri;
        this.f8661b = mt2Var;
    }

    /* renamed from: a */
    public static ThumbFetcher m2311a(Context context, Uri uri, lt2 lt2Var) {
        return new ThumbFetcher(uri, new mt2(Glide.get(context).getRegistry().getImageHeaderParsers(), lt2Var, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return m2311a(context, uri, new kt2(context.getContentResolver(), 0));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return m2311a(context, uri, new kt2(context.getContentResolver(), 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004e, code lost:
    
        if (r6 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if (r6 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        r6.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0024: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:37), block:B:80:0x0024 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x003f A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #4 {all -> 0x0023, blocks: (B:59:0x0014, B:61:0x001a, B:65:0x0039, B:67:0x003f), top: B:2:0x000a }] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Throwable, java.lang.NullPointerException] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InputStream m2312b() {
        ?? r6;
        SecurityException e;
        Cursor cursor;
        InputStream openInputStream;
        int i;
        Uri uri = this.f8660a;
        mt2 mt2Var = this.f8661b;
        ?? r5 = 0;
        InputStream inputStream = null;
        try {
            try {
                try {
                    try {
                        cursor = ((lt2) mt2Var.f23107b).mo5789a(uri);
                    } catch (SecurityException e2) {
                        e = e2;
                        cursor = null;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (SecurityException e3) {
                e = e3;
            }
            if (cursor != null) {
                try {
                } catch (SecurityException e4) {
                    e = e4;
                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    }
                }
                if (cursor.moveToFirst()) {
                    String str = cursor.getString(0);
                    cursor.close();
                    boolean isEmpty = TextUtils.isEmpty(str);
                    ContentResolver contentResolver = (ContentResolver) mt2Var.f23109d;
                    if (!isEmpty) {
                        File file = new File(str);
                        if (file.exists() && 0 < file.length()) {
                            Uri fromFile = Uri.fromFile(file);
                            try {
                                openInputStream = contentResolver.openInputStream(fromFile);
                                if (openInputStream != null) {
                                    try {
                                        try {
                                            inputStream = contentResolver.openInputStream(uri);
                                            i = ImageHeaderParserUtils.getOrientation((List<ImageHeaderParser>) mt2Var.f23110e, inputStream, (ArrayPool) mt2Var.f23108c);
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused) {
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            if (0 != 0) {
                                                try {
                                                    r5.close();
                                                } catch (IOException unused2) {
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (IOException | NullPointerException e5) {
                                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                                            Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e5);
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused3) {
                                            }
                                        }
                                    }
                                    if (i != -1) {
                                        return new ExifOrientationStream(openInputStream, i);
                                    }
                                    return openInputStream;
                                }
                                i = -1;
                                if (i != -1) {
                                }
                            } catch (NullPointerException e6) {
                                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e6));
                            }
                        }
                    }
                    openInputStream = null;
                    if (openInputStream != null) {
                    }
                    i = -1;
                    if (i != -1) {
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            r5 = r6;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.f8662c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream m2312b = m2312b();
            this.f8662c = m2312b;
            dataCallback.onDataReady(m2312b);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }
}
