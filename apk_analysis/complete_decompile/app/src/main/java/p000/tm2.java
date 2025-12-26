package p000;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class tm2 {

    /* renamed from: a */
    public int f26881a;

    /* renamed from: b */
    public int f26882b;

    /* renamed from: c */
    public boolean f26883c;

    /* renamed from: d */
    public boolean f26884d;

    /* renamed from: e */
    public boolean f26885e;

    /* renamed from: f */
    public int[] f26886f;

    /* renamed from: g */
    public final /* synthetic */ StaggeredGridLayoutManager f26887g;

    public tm2(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f26887g = staggeredGridLayoutManager;
        m7500a();
    }

    /* renamed from: a */
    public final void m7500a() {
        this.f26881a = -1;
        this.f26882b = Integer.MIN_VALUE;
        this.f26883c = false;
        this.f26884d = false;
        this.f26885e = false;
        int[] iArr = this.f26886f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
