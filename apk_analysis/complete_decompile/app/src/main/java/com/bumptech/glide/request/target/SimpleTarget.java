package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;

@Deprecated
/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: b */
    public final int f9124b;

    /* renamed from: c */
    public final int f9125c;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        int i = this.f9124b;
        int i2 = this.f9125c;
        if (Util.isValidDimensions(i, i2)) {
            sizeReadyCallback.onSizeReady(i, i2);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2 + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i, int i2) {
        this.f9124b = i;
        this.f9125c = i2;
    }
}
