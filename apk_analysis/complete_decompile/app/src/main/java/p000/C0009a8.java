package p000;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* renamed from: a8 */
/* loaded from: classes.dex */
public final class C0009a8 extends yy2 {

    /* renamed from: p */
    public final ObjectAnimator f73p;

    /* renamed from: q */
    public final boolean f74q;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.animation.TimeInterpolator, b8, java.lang.Object] */
    public C0009a8(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        int i;
        int i2;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i3 = z ? numberOfFrames - 1 : 0;
        if (z) {
            i = 0;
        } else {
            i = numberOfFrames - 1;
        }
        ?? obj = new Object();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        obj.f7917b = numberOfFrames2;
        int[] iArr = obj.f7916a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            obj.f7916a = new int[numberOfFrames2];
        }
        int[] iArr2 = obj.f7916a;
        int i4 = 0;
        for (int i5 = 0; i5 < numberOfFrames2; i5++) {
            if (z) {
                i2 = (numberOfFrames2 - i5) - 1;
            } else {
                i2 = i5;
            }
            int duration = animationDrawable.getDuration(i2);
            iArr2[i5] = duration;
            i4 += duration;
        }
        obj.f7918c = i4;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i3, i);
        ofInt.setAutoCancel(true);
        ofInt.setDuration(obj.f7918c);
        ofInt.setInterpolator(obj);
        this.f74q = z2;
        this.f73p = ofInt;
    }

    @Override // p000.yy2
    /* renamed from: M */
    public final void mo34M() {
        this.f73p.reverse();
    }

    @Override // p000.yy2
    /* renamed from: N */
    public final void mo35N() {
        this.f73p.start();
    }

    @Override // p000.yy2
    /* renamed from: O */
    public final void mo36O() {
        this.f73p.cancel();
    }

    @Override // p000.yy2
    /* renamed from: g */
    public final boolean mo37g() {
        return this.f74q;
    }
}
