package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset;

/* renamed from: com.google.common.collect.y1 */
/* loaded from: classes.dex */
public abstract class AbstractC0955y1 implements Multiset.Entry {
    @Override // com.google.common.collect.Multiset.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Multiset.Entry)) {
            return false;
        }
        Multiset.Entry entry = (Multiset.Entry) obj;
        if (getCount() != entry.getCount() || !Objects.equal(getElement(), entry.getElement())) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int hashCode() {
        int hashCode;
        Object element = getElement();
        if (element == null) {
            hashCode = 0;
        } else {
            hashCode = element.hashCode();
        }
        return hashCode ^ getCount();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final String toString() {
        String valueOf = String.valueOf(getElement());
        int count = getCount();
        if (count != 1) {
            StringBuilder sb = new StringBuilder(valueOf.length() + 14);
            sb.append(valueOf);
            sb.append(" x ");
            sb.append(count);
            return sb.toString();
        }
        return valueOf;
    }
}
