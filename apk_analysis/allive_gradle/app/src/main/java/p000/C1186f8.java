package p000;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;

/* renamed from: f8 */
/* loaded from: classes.dex */
public final class C1186f8 implements TypeEvaluator {

    /* renamed from: a */
    public PathParser.PathDataNode[] f17164a;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        PathParser.PathDataNode[] pathDataNodeArr = (PathParser.PathDataNode[]) obj;
        PathParser.PathDataNode[] pathDataNodeArr2 = (PathParser.PathDataNode[]) obj2;
        if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
            if (!PathParser.canMorph(this.f17164a, pathDataNodeArr)) {
                this.f17164a = PathParser.deepCopyNodes(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.f17164a[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.f17164a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
