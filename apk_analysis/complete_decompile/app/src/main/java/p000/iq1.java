package p000;

import com.google.common.collect.Multiset;
import java.util.Collection;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class iq1 extends oh2 {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        mo3860d().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return mo3860d().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return mo3860d().containsAll(collection);
    }

    /* renamed from: d */
    public abstract Multiset mo3860d();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return mo3860d().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        if (mo3860d().remove(obj, Integer.MAX_VALUE) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return mo3860d().entrySet().size();
    }
}
