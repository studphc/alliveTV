package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class oh2 extends AbstractSet {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return Sets.m4071c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) Preconditions.checkNotNull(collection));
    }
}
