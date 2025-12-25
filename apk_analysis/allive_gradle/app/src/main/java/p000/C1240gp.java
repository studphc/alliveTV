package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: gp */
/* loaded from: classes2.dex */
public final class C1240gp extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final char[] f17781a;

    /* renamed from: b */
    public final int f17782b;

    /* renamed from: c */
    public final int f17783c;

    public C1240gp(char[] cArr, int i, int i2) {
        this.f17781a = cArr;
        this.f17782b = i;
        this.f17783c = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Character) {
            if (Chars.m4242a(this.f17781a, ((Character) obj).charValue(), this.f17782b, this.f17783c) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1240gp) {
            C1240gp c1240gp = (C1240gp) obj;
            int size = size();
            if (c1240gp.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f17781a[this.f17782b + i] != c1240gp.f17781a[c1240gp.f17782b + i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        return Character.valueOf(this.f17781a[this.f17782b + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.f17782b; i2 < this.f17783c; i2++) {
            i = (i * 31) + Chars.hashCode(this.f17781a[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Character) {
            char charValue = ((Character) obj).charValue();
            char[] cArr = this.f17781a;
            int i = this.f17782b;
            int m4242a = Chars.m4242a(cArr, charValue, i, this.f17783c);
            if (m4242a >= 0) {
                return m4242a - i;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Character) {
            char charValue = ((Character) obj).charValue();
            int i2 = this.f17783c;
            while (true) {
                i2--;
                i = this.f17782b;
                if (i2 >= i) {
                    if (this.f17781a[i2] == charValue) {
                        break;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 >= 0) {
                return i2 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Preconditions.checkElementIndex(i, size());
        int i2 = this.f17782b + i;
        char[] cArr = this.f17781a;
        char c = cArr[i2];
        cArr[i2] = ((Character) Preconditions.checkNotNull((Character) obj)).charValue();
        return Character.valueOf(c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17783c - this.f17782b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.f17782b;
        return new C1240gp(this.f17781a, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 3);
        sb.append('[');
        char[] cArr = this.f17781a;
        int i = this.f17782b;
        sb.append(cArr[i]);
        while (true) {
            i++;
            if (i < this.f17783c) {
                sb.append(", ");
                sb.append(cArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
