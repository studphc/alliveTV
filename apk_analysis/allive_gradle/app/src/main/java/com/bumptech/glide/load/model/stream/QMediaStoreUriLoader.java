package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import p000.j82;
import p000.k82;

@RequiresApi(29)
/* loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a */
    public final Context f8843a;

    /* renamed from: b */
    public final ModelLoader f8844b;

    /* renamed from: c */
    public final ModelLoader f8845c;

    /* renamed from: d */
    public final Class f8846d;

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class FileDescriptorFactory extends j82 {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class InputStreamFactory extends j82 {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    public QMediaStoreUriLoader(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Class cls) {
        this.f8843a = context.getApplicationContext();
        this.f8844b = modelLoader;
        this.f8845c = modelLoader2;
        this.f8846d = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<DataT> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new k82(this.f8843a, this.f8844b, this.f8845c, uri, i, i2, options, this.f8846d));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.isMediaStoreUri(uri);
    }
}
