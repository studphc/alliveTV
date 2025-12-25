package p000;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class au0 implements zt0 {

    /* renamed from: a */
    public final String f7741a;

    /* renamed from: b */
    public final int f7742b;

    /* renamed from: c */
    public final int f7743c;

    /* renamed from: d */
    public final /* synthetic */ FragmentManager f7744d;

    public au0(FragmentManager fragmentManager, String str, int i, int i2) {
        this.f7744d = fragmentManager;
        this.f7741a = str;
        this.f7742b = i;
        this.f7743c = i2;
    }

    @Override // p000.zt0
    /* renamed from: a */
    public final boolean mo1218a(ArrayList arrayList, ArrayList arrayList2) {
        Fragment fragment = this.f7744d.f4496A;
        if (fragment != null && this.f7742b < 0 && this.f7741a == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return false;
        }
        return this.f7744d.m1164O(arrayList, arrayList2, this.f7741a, this.f7742b, this.f7743c);
    }
}
