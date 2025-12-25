package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;
import p000.h72;

/* loaded from: classes.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {

    /* renamed from: e */
    public static final Handler f9122e = new Handler(Looper.getMainLooper(), new h72(0));

    /* renamed from: d */
    public final RequestManager f9123d;

    public PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.f9123d = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget<>(requestManager, i, i2);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        f9122e.obtainMessage(1, this).sendToTarget();
    }
}
