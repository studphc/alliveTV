package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* loaded from: classes.dex */
public final class ja1 extends ImmutableList {

    /* renamed from: c */
    public final String f20438c;

    public ja1(String str) {
        this.f20438c = str;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        String str = this.f20438c;
        Preconditions.checkElementIndex(i, str.length());
        return Character.valueOf(str.charAt(i));
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Character) {
            return this.f20438c.indexOf(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Character) {
            return this.f20438c.lastIndexOf(((Character) obj).charValue());
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20438c.length();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public final ImmutableList subList(int i, int i2) {
        String str = this.f20438c;
        Preconditions.checkPositionIndexes(i, i2, str.length());
        return Lists.charactersOf(str.substring(i, i2));
    }
}
