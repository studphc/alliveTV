package p000;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import java.io.File;

/* loaded from: classes.dex */
public abstract class j82 implements ModelLoaderFactory {

    /* renamed from: a */
    public final Context f20422a;

    /* renamed from: b */
    public final Class f20423b;

    public j82(Context context, Class cls) {
        this.f20422a = context;
        this.f20423b = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoaderFactory
    @NonNull
    public final ModelLoader<Uri, Object> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        Class cls = this.f20423b;
        return new QMediaStoreUriLoader(this.f20422a, multiModelLoaderFactory.build(File.class, cls), multiModelLoaderFactory.build(Uri.class, cls), cls);
    }

    @Override // com.bumptech.glide.load.model.ModelLoaderFactory
    public final void teardown() {
    }
}
