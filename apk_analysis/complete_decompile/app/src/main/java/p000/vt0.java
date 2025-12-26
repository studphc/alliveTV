package p000;

import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class vt0 implements zt0 {

    /* renamed from: a */
    public final /* synthetic */ int f27951a;

    /* renamed from: b */
    public final String f27952b;

    /* renamed from: c */
    public final /* synthetic */ FragmentManager f27953c;

    public /* synthetic */ vt0(FragmentManager fragmentManager, String str, int i) {
        this.f27951a = i;
        this.f27953c = fragmentManager;
        this.f27952b = str;
    }

    @Override // p000.zt0
    /* renamed from: a */
    public final boolean mo1218a(ArrayList arrayList, ArrayList arrayList2) {
        switch (this.f27951a) {
            case 0:
                FragmentManager fragmentManager = this.f27953c;
                String str = this.f27952b;
                if (!fragmentManager.m1167R(arrayList, arrayList2, str)) {
                    return false;
                }
                return fragmentManager.m1164O(arrayList, arrayList2, str, -1, 1);
            default:
                return this.f27953c.m1167R(arrayList, arrayList2, this.f27952b);
        }
    }
}
