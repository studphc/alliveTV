package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class hh1 extends AbstractCollection {

    /* renamed from: a */
    public final Map f18058a;

    public hh1(Map map) {
        this.f18058a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f18058a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return this.f18058a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f18058a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return new fg1(this.f18058a.entrySet().iterator(), 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@CheckForNull Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            Map map = this.f18058a;
            for (Map.Entry entry : map.entrySet()) {
                if (Objects.equal(obj, entry.getValue())) {
                    map.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException unused) {
            HashSet newHashSet = Sets.newHashSet();
            Map map = this.f18058a;
            for (Map.Entry entry : map.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    newHashSet.add(entry.getKey());
                }
            }
            return map.keySet().removeAll(newHashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException unused) {
            HashSet newHashSet = Sets.newHashSet();
            Map map = this.f18058a;
            for (Map.Entry entry : map.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    newHashSet.add(entry.getKey());
                }
            }
            return map.keySet().retainAll(newHashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f18058a.size();
    }
}
