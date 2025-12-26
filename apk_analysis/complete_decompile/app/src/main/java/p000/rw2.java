package p000;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class rw2 extends FluentIterable {

    /* renamed from: b */
    public final /* synthetic */ int f26171b;

    /* renamed from: c */
    public final /* synthetic */ Object f26172c;

    /* renamed from: d */
    public final /* synthetic */ TreeTraverser f26173d;

    public /* synthetic */ rw2(TreeTraverser treeTraverser, Object obj, int i) {
        this.f26171b = i;
        this.f26173d = treeTraverser;
        this.f26172c = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f26171b) {
            case 0:
                TreeTraverser treeTraverser = this.f26173d;
                treeTraverser.getClass();
                return new h31(treeTraverser, this.f26172c);
            case 1:
                TreeTraverser treeTraverser2 = this.f26173d;
                treeTraverser2.getClass();
                return new C0566bq(treeTraverser2, this.f26172c);
            default:
                return new sw2(this.f26173d, this.f26172c);
        }
    }
}
