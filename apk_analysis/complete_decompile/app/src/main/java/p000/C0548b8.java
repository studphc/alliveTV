package p000;

import android.animation.TimeInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: b8 */
/* loaded from: classes.dex */
public final class C0548b8 implements TimeInterpolator {

    /* renamed from: a */
    public int[] f7916a;

    /* renamed from: b */
    public int f7917b;

    /* renamed from: c */
    public int f7918c;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2;
        int i = (int) ((f * this.f7918c) + 0.5f);
        int i2 = this.f7917b;
        int[] iArr = this.f7916a;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = iArr[i3];
            if (i < i4) {
                break;
            }
            i -= i4;
            i3++;
        }
        if (i3 < i2) {
            f2 = i / this.f7918c;
        } else {
            f2 = RecyclerView.f7068F0;
        }
        return (i3 / i2) + f2;
    }
}
