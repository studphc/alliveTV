package p000;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public class zg1 extends oh2 {

    /* renamed from: a */
    public final Map f29371a;

    public zg1(Map map) {
        this.f29371a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        mo2097d().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return mo2097d().containsKey(obj);
    }

    /* renamed from: d */
    public Map mo2097d() {
        return this.f29371a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return mo2097d().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Object> iterator() {
        return new fg1(mo2097d().entrySet().iterator(), 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        if (contains(obj)) {
            mo2097d().remove(obj);
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return mo2097d().size();
    }
}
