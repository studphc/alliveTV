package p000;

import com.google.common.collect.AbstractC0856d;
import com.google.common.collect.Multisets;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class kq1 extends AbstractC0856d {
    @Override // com.google.common.collect.AbstractC0856d
    /* renamed from: b */
    public int mo3838b() {
        return elementSet().size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        elementSet().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator iterator() {
        return Multisets.m4062c(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Multisets.m4063d(this);
    }
}
