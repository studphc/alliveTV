package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: a */
    public final int f9101a;

    /* renamed from: b */
    public final int f9102b;

    /* renamed from: c */
    public Request f9103c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        return this.f9103c;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f9101a, this.f9102b);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        this.f9103c = request;
    }

    public CustomTarget(int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            this.f9101a = i;
            this.f9102b = i2;
            return;
        }
        throw new IllegalArgumentException(ye0.m8293m(i, "Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ", " and height: ", i2));
    }
}
