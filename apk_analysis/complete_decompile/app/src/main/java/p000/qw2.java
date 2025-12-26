package p000;

import com.google.common.base.Function;
import com.google.common.collect.TreeTraverser;

/* loaded from: classes.dex */
public final class qw2 extends TreeTraverser {

    /* renamed from: a */
    public final /* synthetic */ Function f25785a;

    public qw2(Function function) {
        this.f25785a = function;
    }

    @Override // com.google.common.collect.TreeTraverser
    public final Iterable children(Object obj) {
        return (Iterable) this.f25785a.apply(obj);
    }
}
