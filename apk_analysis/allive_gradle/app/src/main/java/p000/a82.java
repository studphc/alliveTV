package p000;

import com.google.android.exoplayer2.video.spherical.Projection$Mesh;

/* loaded from: classes.dex */
public final class a82 {

    /* renamed from: a */
    public final Projection$Mesh f79a;

    /* renamed from: b */
    public final Projection$Mesh f80b;

    /* renamed from: c */
    public final int f81c;

    /* renamed from: d */
    public final boolean f82d;

    public a82(Projection$Mesh projection$Mesh, Projection$Mesh projection$Mesh2, int i) {
        boolean z;
        this.f79a = projection$Mesh;
        this.f80b = projection$Mesh2;
        this.f81c = i;
        if (projection$Mesh == projection$Mesh2) {
            z = true;
        } else {
            z = false;
        }
        this.f82d = z;
    }
}
