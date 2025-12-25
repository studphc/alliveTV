package p000;

import androidx.core.graphics.PathParser;

/* loaded from: classes.dex */
public abstract class k13 extends j13 {

    /* renamed from: a */
    public PathParser.PathDataNode[] f20718a;

    /* renamed from: b */
    public String f20719b;

    /* renamed from: c */
    public int f20720c;

    public k13() {
        this.f20718a = null;
        this.f20720c = 0;
    }

    public PathParser.PathDataNode[] getPathData() {
        return this.f20718a;
    }

    public String getPathName() {
        return this.f20719b;
    }

    public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
        if (!PathParser.canMorph(this.f20718a, pathDataNodeArr)) {
            this.f20718a = PathParser.deepCopyNodes(pathDataNodeArr);
        } else {
            PathParser.updateNodes(this.f20718a, pathDataNodeArr);
        }
    }

    public k13(k13 k13Var) {
        this.f20718a = null;
        this.f20720c = 0;
        this.f20719b = k13Var.f20719b;
        this.f20718a = PathParser.deepCopyNodes(k13Var.f20718a);
    }
}
