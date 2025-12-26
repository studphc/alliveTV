package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zaf extends zag {

    /* renamed from: b */
    public final WeakReference f13365b;

    public zaf(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(onImageLoadedListener);
        this.f13365b = new WeakReference(onImageLoadedListener);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zaf)) {
            return false;
        }
        zaf zafVar = (zaf) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f13365b.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zafVar.f13365b.get();
        if (onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.equal(onImageLoadedListener2, onImageLoadedListener) && Objects.equal(zafVar.f13366a, this.f13366a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f13366a);
    }

    @Override // com.google.android.gms.common.images.zag
    public final void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f13365b.get()) != null) {
            onImageLoadedListener.onImageLoaded(this.f13366a.f16292a, drawable, z3);
        }
    }
}
