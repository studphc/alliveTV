package p000;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.TileList$Tile;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;

/* loaded from: classes.dex */
public final class un1 {

    /* renamed from: i */
    public static un1 f27381i;

    /* renamed from: j */
    public static final Object f27382j = new Object();

    /* renamed from: k */
    public static final float[] f27383k = {1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, -1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0, 1.0f, 1.0f};

    /* renamed from: l */
    public static final float[] f27384l = {1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, -0.5f, RecyclerView.f7068F0, RecyclerView.f7068F0, 0.5f, 1.0f};

    /* renamed from: m */
    public static final float[] f27385m = {0.5f, RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, -1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0, 1.0f, 1.0f};

    /* renamed from: a */
    public int f27386a;

    /* renamed from: b */
    public int f27387b;

    /* renamed from: c */
    public int f27388c;

    /* renamed from: d */
    public int f27389d;

    /* renamed from: e */
    public int f27390e;

    /* renamed from: f */
    public int f27391f;

    /* renamed from: g */
    public Object f27392g;

    /* renamed from: h */
    public Object f27393h;

    /* renamed from: a */
    public static boolean m7756a(a82 a82Var) {
        Projection$Mesh projection$Mesh = a82Var.f79a;
        if (projection$Mesh.getSubMeshCount() != 1 || projection$Mesh.getSubMesh(0).textureId != 0) {
            return false;
        }
        Projection$Mesh projection$Mesh2 = a82Var.f80b;
        if (projection$Mesh2.getSubMeshCount() != 1 || projection$Mesh2.getSubMesh(0).textureId != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static un1 m7757b(int i, int i2, int i3, int i4, int i5, int i6, TileList$Tile tileList$Tile) {
        un1 un1Var;
        synchronized (f27382j) {
            try {
                un1 un1Var2 = f27381i;
                if (un1Var2 == null) {
                    un1Var = new Object();
                } else {
                    f27381i = (un1) un1Var2.f27392g;
                    un1Var2.f27392g = null;
                    un1Var = un1Var2;
                }
                un1Var.f27386a = i;
                un1Var.f27387b = i2;
                un1Var.f27388c = i3;
                un1Var.f27389d = i4;
                un1Var.f27390e = i5;
                un1Var.f27391f = i6;
                un1Var.f27393h = tileList$Tile;
            } catch (Throwable th) {
                throw th;
            }
        }
        return un1Var;
    }

    /* renamed from: c */
    public void m7758c() {
        this.f27392g = null;
        this.f27391f = 0;
        this.f27390e = 0;
        this.f27389d = 0;
        this.f27388c = 0;
        this.f27387b = 0;
        this.f27386a = 0;
        this.f27393h = null;
        synchronized (f27382j) {
            try {
                un1 un1Var = f27381i;
                if (un1Var != null) {
                    this.f27392g = un1Var;
                }
                f27381i = this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
