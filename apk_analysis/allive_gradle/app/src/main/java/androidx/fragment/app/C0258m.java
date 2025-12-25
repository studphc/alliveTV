package androidx.fragment.app;

import android.util.Log;
import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p000.RunnableC0006a5;
import p000.hu0;

/* renamed from: androidx.fragment.app.m */
/* loaded from: classes.dex */
public final class C0258m extends OnBackPressedCallback {

    /* renamed from: d */
    public final /* synthetic */ FragmentManager f4684d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0258m(FragmentManager fragmentManager) {
        super(false);
        this.f4684d = fragmentManager;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackCancelled() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        FragmentManager fragmentManager = this.f4684d;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "handleOnBackCancelled. PREDICTIVE_BACK = " + FragmentManager.f4495U + " fragment manager " + fragmentManager);
        }
        if (FragmentManager.f4495U) {
            fragmentManager.getClass();
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "cancelBackStackTransition for transition " + fragmentManager.f4522h);
            }
            C0246a c0246a = fragmentManager.f4522h;
            if (c0246a != null) {
                c0246a.f4646u = false;
                c0246a.m1220f();
                C0246a c0246a2 = fragmentManager.f4522h;
                RunnableC0006a5 runnableC0006a5 = new RunnableC0006a5(19, fragmentManager);
                if (c0246a2.f4612s == null) {
                    c0246a2.f4612s = new ArrayList();
                }
                c0246a2.f4612s.add(runnableC0006a5);
                fragmentManager.f4522h.commit();
                fragmentManager.f4523i = true;
                fragmentManager.executePendingTransactions();
                fragmentManager.f4523i = false;
                fragmentManager.f4522h = null;
            }
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        FragmentManager fragmentManager = this.f4684d;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "handleOnBackPressed. PREDICTIVE_BACK = " + FragmentManager.f4495U + " fragment manager " + fragmentManager);
        }
        fragmentManager.f4523i = true;
        fragmentManager.m1201y(true);
        fragmentManager.f4523i = false;
        boolean z = FragmentManager.f4495U;
        C0258m c0258m = fragmentManager.f4524j;
        if (z && fragmentManager.f4522h != null) {
            ArrayList arrayList = fragmentManager.f4529o;
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(FragmentManager.m1150D(fragmentManager.f4522h));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    FragmentManager.OnBackStackChangedListener onBackStackChangedListener = (FragmentManager.OnBackStackChangedListener) it.next();
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        onBackStackChangedListener.onBackStackChangeCommitted((Fragment) it2.next(), true);
                    }
                }
            }
            Iterator it3 = fragmentManager.f4522h.f4596c.iterator();
            while (it3.hasNext()) {
                Fragment fragment = ((hu0) it3.next()).f18175b;
                if (fragment != null) {
                    fragment.f4460n = false;
                }
            }
            Iterator it4 = fragmentManager.m1182f(new ArrayList(Collections.singletonList(fragmentManager.f4522h)), 0, 1).iterator();
            while (it4.hasNext()) {
                ((SpecialEffectsController) it4.next()).completeBack();
            }
            Iterator it5 = fragmentManager.f4522h.f4596c.iterator();
            while (it5.hasNext()) {
                Fragment fragment2 = ((hu0) it5.next()).f18175b;
                if (fragment2 != null && fragment2.f4427J == null) {
                    fragmentManager.m1183g(fragment2).m1240k();
                }
            }
            fragmentManager.f4522h = null;
            fragmentManager.m1178b0();
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "Op is being set to null");
                Log.d(FragmentManager.TAG, "OnBackPressedCallback enabled=" + c0258m.getIsEnabled() + " for  FragmentManager " + fragmentManager);
                return;
            }
            return;
        }
        if (c0258m.getIsEnabled()) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "Calling popBackStackImmediate via onBackPressed callback");
            }
            fragmentManager.popBackStackImmediate();
        } else {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "Calling onBackPressed via onBackPressed callback");
            }
            fragmentManager.f4521g.onBackPressed();
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackProgressed(BackEventCompat backEventCompat) {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
        FragmentManager fragmentManager = this.f4684d;
        if (isLoggingEnabled) {
            Log.v(FragmentManager.TAG, "handleOnBackProgressed. PREDICTIVE_BACK = " + FragmentManager.f4495U + " fragment manager " + fragmentManager);
        }
        if (fragmentManager.f4522h != null) {
            Iterator it = fragmentManager.m1182f(new ArrayList(Collections.singletonList(fragmentManager.f4522h)), 0, 1).iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).processProgress(backEventCompat);
            }
            Iterator it2 = fragmentManager.f4529o.iterator();
            while (it2.hasNext()) {
                ((FragmentManager.OnBackStackChangedListener) it2.next()).onBackStackChangeProgressed(backEventCompat);
            }
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackStarted(BackEventCompat backEventCompat) {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        FragmentManager fragmentManager = this.f4684d;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "handleOnBackStarted. PREDICTIVE_BACK = " + FragmentManager.f4495U + " fragment manager " + fragmentManager);
        }
        if (FragmentManager.f4495U) {
            fragmentManager.m1198v();
            fragmentManager.m1199w(new C0262q(fragmentManager), false);
        }
    }
}
