package p000;

import androidx.core.widget.AutoScrollHelper;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: sd */
/* loaded from: classes.dex */
public final class C1794sd {

    /* renamed from: a */
    public int f26380a;

    /* renamed from: b */
    public int f26381b;

    /* renamed from: c */
    public float f26382c;

    /* renamed from: d */
    public float f26383d;

    /* renamed from: e */
    public long f26384e;

    /* renamed from: f */
    public long f26385f;

    /* renamed from: g */
    public long f26386g;

    /* renamed from: h */
    public float f26387h;

    /* renamed from: i */
    public int f26388i;

    /* renamed from: a */
    public final float m7359a(long j) {
        long j2 = this.f26384e;
        if (j < j2) {
            return RecyclerView.f7068F0;
        }
        long j3 = this.f26386g;
        if (j3 >= 0 && j >= j3) {
            float f = this.f26387h;
            return (AutoScrollHelper.m1012b(((float) (j - j3)) / this.f26388i, RecyclerView.f7068F0, 1.0f) * f) + (1.0f - f);
        }
        return AutoScrollHelper.m1012b(((float) (j - j2)) / this.f26380a, RecyclerView.f7068F0, 1.0f) * 0.5f;
    }
}
