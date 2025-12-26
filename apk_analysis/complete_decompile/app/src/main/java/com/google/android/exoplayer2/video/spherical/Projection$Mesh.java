package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes.dex */
public final class Projection$Mesh {

    /* renamed from: a */
    public final Projection$SubMesh[] f12896a;

    public Projection$Mesh(Projection$SubMesh... projection$SubMeshArr) {
        this.f12896a = projection$SubMeshArr;
    }

    public Projection$SubMesh getSubMesh(int i) {
        return this.f12896a[i];
    }

    public int getSubMeshCount() {
        return this.f12896a.length;
    }
}
