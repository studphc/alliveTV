package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class og1 extends oh2 {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        mo3859d().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object m4052h = Maps.m4052h(mo3859d(), key);
        if (!Objects.equal(m4052h, entry.getValue())) {
            return false;
        }
        if (m4052h == null && !mo3859d().containsKey(key)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public abstract Map mo3859d();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return mo3859d().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        if (contains(obj) && (obj instanceof Map.Entry)) {
            return mo3859d().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // p000.oh2, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException unused) {
            return Sets.m4072d(this, collection.iterator());
        }
    }

    @Override // p000.oh2, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException unused) {
            HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    newHashSetWithExpectedSize.add(((Map.Entry) obj).getKey());
                }
            }
            return mo3859d().keySet().retainAll(newHashSetWithExpectedSize);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return mo3859d().size();
    }
}
