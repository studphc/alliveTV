package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p000.AbstractC1726qj;
import p000.hu0;
import p000.zt0;

/* renamed from: androidx.fragment.app.q */
/* loaded from: classes.dex */
public final class C0262q implements zt0 {

    /* renamed from: a */
    public final /* synthetic */ FragmentManager f4687a;

    public C0262q(FragmentManager fragmentManager) {
        this.f4687a = fragmentManager;
    }

    @Override // p000.zt0
    /* renamed from: a */
    public final boolean mo1218a(ArrayList arrayList, ArrayList arrayList2) {
        boolean m1164O;
        FragmentManager fragmentManager = this.f4687a;
        fragmentManager.getClass();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "FragmentManager has the following pending actions inside of prepareBackStackState: " + fragmentManager.f4515a);
        }
        if (fragmentManager.f4518d.isEmpty()) {
            Log.i(FragmentManager.TAG, "Ignoring call to start back stack pop because the back stack is empty.");
            m1164O = false;
        } else {
            C0246a c0246a = (C0246a) AbstractC1726qj.m7053i(fragmentManager.f4518d, 1);
            fragmentManager.f4522h = c0246a;
            Iterator it = c0246a.f4596c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((hu0) it.next()).f18175b;
                if (fragment != null) {
                    fragment.f4460n = true;
                }
            }
            m1164O = fragmentManager.m1164O(arrayList, arrayList2, null, -1, 0);
        }
        if (!fragmentManager.f4529o.isEmpty() && arrayList.size() > 0) {
            boolean booleanValue = ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(FragmentManager.m1150D((C0246a) it2.next()));
            }
            Iterator it3 = fragmentManager.f4529o.iterator();
            while (it3.hasNext()) {
                FragmentManager.OnBackStackChangedListener onBackStackChangedListener = (FragmentManager.OnBackStackChangedListener) it3.next();
                Iterator it4 = linkedHashSet.iterator();
                while (it4.hasNext()) {
                    onBackStackChangedListener.onBackStackChangeStarted((Fragment) it4.next(), booleanValue);
                }
            }
        }
        return m1164O;
    }
}
