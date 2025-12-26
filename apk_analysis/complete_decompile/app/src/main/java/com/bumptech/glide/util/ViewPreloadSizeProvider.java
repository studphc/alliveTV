package com.bumptech.glide.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.SizeReadyCallback;
import java.util.Arrays;
import p000.nb2;

/* loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a */
    public int[] f9183a;

    /* renamed from: b */
    public nb2 f9184b;

    public ViewPreloadSizeProvider() {
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T t, int i, int i2) {
        int[] iArr = this.f9183a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        this.f9183a = new int[]{i, i2};
        this.f9184b = null;
    }

    public void setView(@NonNull View view) {
        if (this.f9183a == null && this.f9184b == null) {
            nb2 nb2Var = new nb2(view, 1);
            this.f9184b = nb2Var;
            nb2Var.getSize(this);
        }
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        nb2 nb2Var = new nb2(view, 1);
        this.f9184b = nb2Var;
        nb2Var.getSize(this);
    }
}
