package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;

/* renamed from: z7 */
/* loaded from: classes.dex */
public final class C2047z7 extends rn2 {

    /* renamed from: J */
    public LongSparseArray f29262J;

    /* renamed from: K */
    public SparseArrayCompat f29263K;

    public C2047z7(C2047z7 c2047z7, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
        super(c2047z7, animatedStateListDrawableCompat, resources);
        if (c2047z7 != null) {
            this.f29262J = c2047z7.f29262J;
            this.f29263K = c2047z7.f29263K;
        } else {
            this.f29262J = new LongSparseArray();
            this.f29263K = new SparseArrayCompat();
        }
    }

    @Override // p000.rn2
    /* renamed from: f */
    public final void mo7293f() {
        this.f29262J = this.f29262J.m8471clone();
        this.f29263K = this.f29263K.m8472clone();
    }

    /* renamed from: g */
    public final int m8393g(int i, int i2, Drawable drawable, boolean z) {
        long j;
        int m7288a = m7288a(drawable);
        long j2 = i;
        long j3 = i2;
        long j4 = (j2 << 32) | j3;
        if (z) {
            j = 8589934592L;
        } else {
            j = 0;
        }
        long j5 = m7288a;
        this.f29262J.append(j4, Long.valueOf(j5 | j));
        if (z) {
            this.f29262J.append(j2 | (j3 << 32), Long.valueOf(4294967296L | j5 | j));
        }
        return m7288a;
    }

    @Override // p000.rn2, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new AnimatedStateListDrawableCompat(this, null);
    }

    @Override // p000.rn2, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new AnimatedStateListDrawableCompat(this, resources);
    }
}
