package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import p000.d83;

/* loaded from: classes.dex */
public abstract class zag {

    /* renamed from: a */
    public final d83 f13366a;
    protected int zab;

    public zag(Uri uri, int i) {
        this.f13366a = new d83(uri);
        this.zab = i;
    }

    /* renamed from: a */
    public final void m3135a(Context context, boolean z) {
        Drawable drawable;
        int i = this.zab;
        if (i != 0) {
            drawable = context.getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        zaa(drawable, z, false, false);
    }

    public abstract void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3);
}
