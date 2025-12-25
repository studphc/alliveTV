package p000;

import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.NodeList;

/* loaded from: classes2.dex */
public final class p80 implements Incomplete {

    /* renamed from: a */
    public final boolean f25060a;

    public p80(boolean z) {
        this.f25060a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.f25060a;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.f25060a) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
