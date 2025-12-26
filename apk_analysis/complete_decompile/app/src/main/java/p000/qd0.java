package p000;

import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class qd0 extends ForwardingCollection {

    /* renamed from: a */
    public final /* synthetic */ int f25550a = 1;

    /* renamed from: b */
    public final Object f25551b;

    public qd0(rd0 rd0Var) {
        this.f25551b = rd0Var;
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f25550a) {
            case 0:
                return delegate();
            default:
                return (Collection) this.f25551b;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch (this.f25550a) {
            case 1:
                return new t51(((Collection) this.f25551b).iterator(), 2);
            default:
                return super.iterator();
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f25550a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    rd0 rd0Var = (rd0) this.f25551b;
                    if (rd0Var.f25933f.containsKey(entry.getKey()) && rd0Var.f25934g.apply(entry.getKey())) {
                        return rd0Var.f25933f.remove(entry.getKey(), entry.getValue());
                    }
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f25550a) {
            case 1:
                return standardToArray();
            default:
                return super.toArray();
        }
    }

    public qd0(Collection collection) {
        this.f25551b = collection;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f25550a) {
            case 1:
                return standardToArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        switch (this.f25550a) {
            case 0:
                rd0 rd0Var = (rd0) this.f25551b;
                return Collections2.filter(rd0Var.f25933f.entries(), rd0Var.mo6137c());
            default:
                return (Collection) this.f25551b;
        }
    }
}
