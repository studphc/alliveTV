package p000;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class v51 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ Iterator f27652a;

    /* renamed from: b */
    public final /* synthetic */ int f27653b;

    /* renamed from: c */
    public final /* synthetic */ boolean f27654c;

    public v51(Iterator it, int i, boolean z) {
        this.f27652a = it;
        this.f27653b = i;
        this.f27654c = z;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f27652a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it = this.f27652a;
        if (it.hasNext()) {
            int i = this.f27653b;
            Object[] objArr = new Object[i];
            int i2 = 0;
            while (i2 < i && it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
            for (int i3 = i2; i3 < i; i3++) {
                objArr[i3] = null;
            }
            List unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            if (!this.f27654c && i2 != i) {
                return unmodifiableList.subList(0, i2);
            }
            return unmodifiableList;
        }
        throw new NoSuchElementException();
    }
}
