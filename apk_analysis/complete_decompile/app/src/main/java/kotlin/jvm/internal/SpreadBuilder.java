package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SpreadBuilder {

    /* renamed from: a */
    public final ArrayList f21188a;

    public SpreadBuilder(int i) {
        this.f21188a = new ArrayList(i);
    }

    public void add(Object obj) {
        this.f21188a.add(obj);
    }

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        boolean z = obj instanceof Object[];
        ArrayList arrayList = this.f21188a;
        if (z) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(arrayList, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            arrayList.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int size() {
        return this.f21188a.size();
    }

    public Object[] toArray(Object[] objArr) {
        return this.f21188a.toArray(objArr);
    }
}
