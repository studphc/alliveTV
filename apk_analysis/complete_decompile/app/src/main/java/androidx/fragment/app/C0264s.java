package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.ViewOnAttachStateChangeListenerC1162el;
import p000.bu0;
import p000.du0;
import p000.eu0;
import p000.jt0;
import p000.kt0;
import p000.mt2;
import p000.pu0;
import p000.ye0;

/* renamed from: androidx.fragment.app.s */
/* loaded from: classes.dex */
public final class C0264s {

    /* renamed from: a */
    public final FragmentLifecycleCallbacksDispatcher f4690a;

    /* renamed from: b */
    public final mt2 f4691b;

    /* renamed from: c */
    public final Fragment f4692c;

    /* renamed from: d */
    public boolean f4693d = false;

    /* renamed from: e */
    public int f4694e = -1;

    public C0264s(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, mt2 mt2Var, Fragment fragment) {
        this.f4690a = fragmentLifecycleCallbacksDispatcher;
        this.f4691b = mt2Var;
        this.f4692c = fragment;
    }

    /* renamed from: a */
    public final void m1230a() {
        Bundle bundle;
        Bundle bundle2;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "moveto ACTIVITY_CREATED: " + fragment);
        }
        Bundle bundle3 = fragment.f4446b;
        if (bundle3 != null) {
            bundle = bundle3.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        fragment.f4470x.m1161L();
        fragment.f4444a = 3;
        fragment.f4426I = false;
        fragment.onActivityCreated(bundle);
        if (fragment.f4426I) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "moveto RESTORE_VIEW_STATE: " + fragment);
            }
            if (fragment.f4428K != null) {
                Bundle bundle4 = fragment.f4446b;
                if (bundle4 != null) {
                    bundle2 = bundle4.getBundle("savedInstanceState");
                } else {
                    bundle2 = null;
                }
                SparseArray<Parcelable> sparseArray = fragment.f4448c;
                if (sparseArray != null) {
                    fragment.f4428K.restoreHierarchyState(sparseArray);
                    fragment.f4448c = null;
                }
                fragment.f4426I = false;
                fragment.onViewStateRestored(bundle2);
                if (fragment.f4426I) {
                    if (fragment.f4428K != null) {
                        fragment.f4439V.m6923a(Lifecycle.Event.ON_CREATE);
                    }
                } else {
                    throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onViewStateRestored()"));
                }
            }
            fragment.f4446b = null;
            bu0 bu0Var = fragment.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(4);
            this.f4690a.dispatchOnFragmentActivityCreated(fragment, bundle, false);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onActivityCreated()"));
    }

    /* renamed from: b */
    public final void m1231b() {
        View view;
        View view2;
        Fragment fragment = this.f4692c;
        Fragment m1149C = FragmentManager.m1149C(fragment.f4427J);
        Fragment parentFragment = fragment.getParentFragment();
        if (m1149C != null && !m1149C.equals(parentFragment)) {
            FragmentStrictMode.onWrongNestedHierarchy(fragment, m1149C, fragment.f4418A);
        }
        mt2 mt2Var = this.f4691b;
        mt2Var.getClass();
        ViewGroup viewGroup = fragment.f4427J;
        int i = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) mt2Var.f23107b;
            int indexOf = arrayList.indexOf(fragment);
            int i2 = indexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(indexOf);
                        if (fragment2.f4427J == viewGroup && (view = fragment2.f4428K) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i2);
                    if (fragment3.f4427J == viewGroup && (view2 = fragment3.f4428K) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        fragment.f4427J.addView(fragment.f4428K, i);
    }

    /* renamed from: c */
    public final void m1232c() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.f4454h;
        C0264s c0264s = null;
        mt2 mt2Var = this.f4691b;
        if (fragment2 != null) {
            C0264s c0264s2 = (C0264s) ((HashMap) mt2Var.f23108c).get(fragment2.f4452f);
            if (c0264s2 != null) {
                fragment.f4455i = fragment.f4454h.f4452f;
                fragment.f4454h = null;
                c0264s = c0264s2;
            } else {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.f4454h + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.f4455i;
            if (str != null && (c0264s = (C0264s) ((HashMap) mt2Var.f23108c).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(AbstractC1726qj.m7061q(sb, fragment.f4455i, " that does not belong to this FragmentManager!"));
            }
        }
        if (c0264s != null) {
            c0264s.m1240k();
        }
        fragment.f4469w = fragment.f4468v.getHost();
        fragment.f4471y = fragment.f4468v.f4540z;
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f4690a;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(fragment, false);
        ArrayList arrayList = fragment.f4447b0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((kt0) it.next()).mo4992a();
        }
        arrayList.clear();
        fragment.f4470x.m1177b(fragment.f4469w, fragment.mo1133b(), fragment);
        fragment.f4444a = 0;
        fragment.f4426I = false;
        fragment.onAttach(fragment.f4469w.getContext());
        if (fragment.f4426I) {
            FragmentManager fragmentManager = fragment.f4468v;
            Iterator it2 = fragmentManager.f4531q.iterator();
            while (it2.hasNext()) {
                ((FragmentOnAttachListener) it2.next()).onAttachFragment(fragmentManager, fragment);
            }
            bu0 bu0Var = fragment.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(0);
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(fragment, false);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onAttach()"));
    }

    /* renamed from: d */
    public final int m1233d() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment = this.f4692c;
        if (fragment.f4468v == null) {
            return fragment.f4444a;
        }
        int i = this.f4694e;
        int i2 = eu0.f16981a[fragment.f4437T.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        i = Math.min(i, -1);
                    } else {
                        i = Math.min(i, 0);
                    }
                } else {
                    i = Math.min(i, 1);
                }
            } else {
                i = Math.min(i, 5);
            }
        }
        if (fragment.f4462p) {
            if (fragment.f4463q) {
                i = Math.max(this.f4694e, 2);
                View view = fragment.f4428K;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.f4694e < 4 ? Math.min(i, fragment.f4444a) : Math.min(i, 1);
            }
        }
        if (fragment.f4464r && fragment.f4427J == null) {
            i = Math.min(i, 4);
        }
        if (!fragment.f4458l) {
            i = Math.min(i, 1);
        }
        ViewGroup viewGroup = fragment.f4427J;
        if (viewGroup != null) {
            lifecycleImpact = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        } else {
            lifecycleImpact = null;
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i = Math.min(i, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i = Math.max(i, 3);
        } else if (fragment.f4459m) {
            if (fragment.m1142h()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (fragment.f4429L && fragment.f4444a < 5) {
            i = Math.min(i, 4);
        }
        if (fragment.f4460n) {
            i = Math.max(i, 3);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "computeExpectedState() of " + i + " for " + fragment);
        }
        return i;
    }

    /* renamed from: e */
    public final void m1234e() {
        Bundle bundle;
        Bundle bundle2;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        final Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "moveto CREATED: " + fragment);
        }
        Bundle bundle3 = fragment.f4446b;
        if (bundle3 != null) {
            bundle = bundle3.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        if (!fragment.f4436S) {
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f4690a;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(fragment, bundle, false);
            fragment.f4470x.m1161L();
            fragment.f4444a = 1;
            fragment.f4426I = false;
            fragment.f4438U.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.6
                public C02446() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP && (view = Fragment.this.f4428K) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
            fragment.onCreate(bundle);
            fragment.f4436S = true;
            if (fragment.f4426I) {
                fragment.f4438U.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment, bundle, false);
                return;
            }
            throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onCreate()"));
        }
        fragment.f4444a = 1;
        Bundle bundle4 = fragment.f4446b;
        if (bundle4 != null && (bundle2 = bundle4.getBundle("childFragmentManager")) != null) {
            fragment.f4470x.m1168S(bundle2);
            bu0 bu0Var = fragment.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(1);
        }
    }

    /* renamed from: f */
    public final void m1235f() {
        Bundle bundle;
        String str;
        Fragment fragment = this.f4692c;
        if (fragment.f4462p) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "moveto CREATE_VIEW: " + fragment);
        }
        Bundle bundle2 = fragment.f4446b;
        Bundle bundle3 = null;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        LayoutInflater onGetLayoutInflater = fragment.onGetLayoutInflater(bundle);
        fragment.f4435R = onGetLayoutInflater;
        ViewGroup viewGroup = fragment.f4427J;
        if (viewGroup == null) {
            int i = fragment.f4418A;
            if (i != 0) {
                if (i != -1) {
                    viewGroup = (ViewGroup) fragment.f4468v.f4539y.onFindViewById(i);
                    if (viewGroup == null) {
                        if (!fragment.f4465s && !fragment.f4464r) {
                            try {
                                str = fragment.getResources().getResourceName(fragment.f4418A);
                            } catch (Resources.NotFoundException unused) {
                                str = EnvironmentCompat.MEDIA_UNKNOWN;
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.f4418A) + " (" + str + ") for fragment " + fragment);
                        }
                    } else if (!(viewGroup instanceof FragmentContainerView)) {
                        FragmentStrictMode.onWrongFragmentContainer(fragment, viewGroup);
                    }
                } else {
                    throw new IllegalArgumentException(ye0.m8295o("Cannot create fragment ", fragment, " for a container view with no id"));
                }
            } else {
                viewGroup = null;
            }
        }
        fragment.f4427J = viewGroup;
        fragment.mo1134i(onGetLayoutInflater, viewGroup, bundle);
        if (fragment.f4428K != null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "moveto VIEW_CREATED: " + fragment);
            }
            fragment.f4428K.setSaveFromParentEnabled(false);
            fragment.f4428K.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                m1231b();
            }
            if (fragment.f4420C) {
                fragment.f4428K.setVisibility(8);
            }
            if (fragment.f4428K.isAttachedToWindow()) {
                ViewCompat.requestApplyInsets(fragment.f4428K);
            } else {
                View view = fragment.f4428K;
                view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC1162el(2, view));
            }
            Bundle bundle4 = fragment.f4446b;
            if (bundle4 != null) {
                bundle3 = bundle4.getBundle("savedInstanceState");
            }
            fragment.onViewCreated(fragment.f4428K, bundle3);
            fragment.f4470x.m1197u(2);
            this.f4690a.dispatchOnFragmentViewCreated(fragment, fragment.f4428K, bundle, false);
            int visibility = fragment.f4428K.getVisibility();
            fragment.m1137c().f20621s = fragment.f4428K.getAlpha();
            if (fragment.f4427J != null && visibility == 0) {
                View findFocus = fragment.f4428K.findFocus();
                if (findFocus != null) {
                    fragment.m1137c().f20622t = findFocus;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                fragment.f4428K.setAlpha(RecyclerView.f7068F0);
            }
        }
        fragment.f4444a = 2;
    }

    /* renamed from: g */
    public final void m1236g() {
        boolean z;
        boolean z2;
        Fragment m6250b;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "movefrom CREATED: " + fragment);
        }
        boolean z3 = true;
        if (fragment.f4459m && !fragment.m1142h()) {
            z = true;
        } else {
            z = false;
        }
        mt2 mt2Var = this.f4691b;
        if (z && !fragment.f4461o) {
            mt2Var.m6257i(fragment.f4452f, null);
        }
        if (!z) {
            du0 du0Var = (du0) mt2Var.f23110e;
            if (!du0Var.f16542d.containsKey(fragment.f4452f)) {
                z2 = true;
            } else if (du0Var.f16545g) {
                z2 = du0Var.f16546h;
            } else {
                z2 = !du0Var.f16547i;
            }
            if (!z2) {
                String str = fragment.f4455i;
                if (str != null && (m6250b = mt2Var.m6250b(str)) != null && m6250b.f4422E) {
                    fragment.f4454h = m6250b;
                }
                fragment.f4444a = 0;
                return;
            }
        }
        FragmentHostCallback fragmentHostCallback = fragment.f4469w;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z3 = ((du0) mt2Var.f23110e).f16546h;
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z3 = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
        }
        if ((z && !fragment.f4461o) || z3) {
            ((du0) mt2Var.f23110e).m4614d(fragment, false);
        }
        fragment.f4470x.m1188l();
        fragment.f4438U.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        fragment.f4444a = 0;
        fragment.f4426I = false;
        fragment.f4436S = false;
        fragment.onDestroy();
        if (fragment.f4426I) {
            this.f4690a.dispatchOnFragmentDestroyed(fragment, false);
            Iterator it = mt2Var.m6252d().iterator();
            while (it.hasNext()) {
                C0264s c0264s = (C0264s) it.next();
                if (c0264s != null) {
                    String str2 = fragment.f4452f;
                    Fragment fragment2 = c0264s.f4692c;
                    if (str2.equals(fragment2.f4455i)) {
                        fragment2.f4454h = fragment;
                        fragment2.f4455i = null;
                    }
                }
            }
            String str3 = fragment.f4455i;
            if (str3 != null) {
                fragment.f4454h = mt2Var.m6250b(str3);
            }
            mt2Var.m6256h(this);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onDestroy()"));
    }

    /* renamed from: h */
    public final void m1237h() {
        View view;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.f4427J;
        if (viewGroup != null && (view = fragment.f4428K) != null) {
            viewGroup.removeView(view);
        }
        fragment.f4470x.m1197u(1);
        if (fragment.f4428K != null) {
            pu0 pu0Var = fragment.f4439V;
            pu0Var.m6924b();
            if (pu0Var.f25303e.getF6494d().isAtLeast(Lifecycle.State.CREATED)) {
                fragment.f4439V.m6923a(Lifecycle.Event.ON_DESTROY);
            }
        }
        fragment.f4444a = 1;
        fragment.f4426I = false;
        fragment.onDestroyView();
        if (fragment.f4426I) {
            LoaderManager.getInstance(fragment).markForRedelivery();
            fragment.f4466t = false;
            this.f4690a.dispatchOnFragmentViewDestroyed(fragment, false);
            fragment.f4427J = null;
            fragment.f4428K = null;
            fragment.f4439V = null;
            fragment.f4440W.setValue(null);
            fragment.f4463q = false;
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onDestroyView()"));
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.fragment.app.FragmentManager, bu0] */
    /* renamed from: i */
    public final void m1238i() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "movefrom ATTACHED: " + fragment);
        }
        fragment.f4444a = -1;
        fragment.f4426I = false;
        fragment.onDetach();
        fragment.f4435R = null;
        if (fragment.f4426I) {
            if (!fragment.f4470x.isDestroyed()) {
                fragment.f4470x.m1188l();
                fragment.f4470x = new FragmentManager();
            }
            this.f4690a.dispatchOnFragmentDetached(fragment, false);
            fragment.f4444a = -1;
            fragment.f4469w = null;
            fragment.f4471y = null;
            fragment.f4468v = null;
            if (!fragment.f4459m || fragment.m1142h()) {
                du0 du0Var = (du0) this.f4691b.f23110e;
                boolean z = true;
                if (du0Var.f16542d.containsKey(fragment.f4452f)) {
                    if (du0Var.f16545g) {
                        z = du0Var.f16546h;
                    } else {
                        z = true ^ du0Var.f16547i;
                    }
                }
                if (!z) {
                    return;
                }
            }
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "initState called for fragment: " + fragment);
            }
            fragment.m1141g();
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onDetach()"));
    }

    /* renamed from: j */
    public final void m1239j() {
        Bundle bundle;
        Fragment fragment = this.f4692c;
        if (fragment.f4462p && fragment.f4463q && !fragment.f4466t) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "moveto CREATE_VIEW: " + fragment);
            }
            Bundle bundle2 = fragment.f4446b;
            Bundle bundle3 = null;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            LayoutInflater onGetLayoutInflater = fragment.onGetLayoutInflater(bundle);
            fragment.f4435R = onGetLayoutInflater;
            fragment.mo1134i(onGetLayoutInflater, null, bundle);
            View view = fragment.f4428K;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.f4428K.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.f4420C) {
                    fragment.f4428K.setVisibility(8);
                }
                Bundle bundle4 = fragment.f4446b;
                if (bundle4 != null) {
                    bundle3 = bundle4.getBundle("savedInstanceState");
                }
                fragment.onViewCreated(fragment.f4428K, bundle3);
                fragment.f4470x.m1197u(2);
                this.f4690a.dispatchOnFragmentViewCreated(fragment, fragment.f4428K, bundle, false);
                fragment.f4444a = 2;
            }
        }
    }

    /* renamed from: k */
    public final void m1240k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.f4693d;
        Fragment fragment = this.f4692c;
        if (z) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f4693d = true;
            boolean z2 = false;
            while (true) {
                int m1233d = m1233d();
                int i = fragment.f4444a;
                mt2 mt2Var = this.f4691b;
                if (m1233d != i) {
                    if (m1233d > i) {
                        switch (i + 1) {
                            case 0:
                                m1232c();
                                break;
                            case 1:
                                m1234e();
                                break;
                            case 2:
                                m1239j();
                                m1235f();
                                break;
                            case 3:
                                m1230a();
                                break;
                            case 4:
                                if (fragment.f4428K != null && (viewGroup3 = fragment.f4427J) != null) {
                                    SpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(fragment.f4428K.getVisibility()), this);
                                }
                                fragment.f4444a = 4;
                                break;
                            case 5:
                                m1246q();
                                break;
                            case 6:
                                fragment.f4444a = 6;
                                break;
                            case 7:
                                m1243n();
                                break;
                        }
                    } else {
                        switch (i - 1) {
                            case -1:
                                m1238i();
                                break;
                            case 0:
                                if (fragment.f4461o) {
                                    if (((Bundle) ((HashMap) mt2Var.f23109d).get(fragment.f4452f)) == null) {
                                        mt2Var.m6257i(fragment.f4452f, m1244o());
                                    }
                                }
                                m1236g();
                                break;
                            case 1:
                                m1237h();
                                fragment.f4444a = 1;
                                break;
                            case 2:
                                fragment.f4463q = false;
                                fragment.f4444a = 2;
                                break;
                            case 3:
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    Log.d(FragmentManager.TAG, "movefrom ACTIVITY_CREATED: " + fragment);
                                }
                                if (fragment.f4461o) {
                                    mt2Var.m6257i(fragment.f4452f, m1244o());
                                } else if (fragment.f4428K != null && fragment.f4448c == null) {
                                    m1245p();
                                }
                                if (fragment.f4428K != null && (viewGroup2 = fragment.f4427J) != null) {
                                    SpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager()).enqueueRemove(this);
                                }
                                fragment.f4444a = 3;
                                break;
                            case 4:
                                m1247r();
                                break;
                            case 5:
                                fragment.f4444a = 5;
                                break;
                            case 6:
                                m1241l();
                                break;
                        }
                    }
                    z2 = true;
                } else {
                    if (!z2 && i == -1 && fragment.f4459m && !fragment.m1142h() && !fragment.f4461o) {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            Log.d(FragmentManager.TAG, "Cleaning up state of never attached fragment: " + fragment);
                        }
                        ((du0) mt2Var.f23110e).m4614d(fragment, true);
                        mt2Var.m6256h(this);
                        if (FragmentManager.isLoggingEnabled(3)) {
                            Log.d(FragmentManager.TAG, "initState called for fragment: " + fragment);
                        }
                        fragment.m1141g();
                    }
                    if (fragment.f4434Q) {
                        if (fragment.f4428K != null && (viewGroup = fragment.f4427J) != null) {
                            SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.f4420C) {
                                orCreateController.enqueueHide(this);
                            } else {
                                orCreateController.enqueueShow(this);
                            }
                        }
                        FragmentManager fragmentManager = fragment.f4468v;
                        if (fragmentManager != null && fragment.f4458l && FragmentManager.m1151H(fragment)) {
                            fragmentManager.f4504I = true;
                        }
                        fragment.f4434Q = false;
                        fragment.onHiddenChanged(fragment.f4420C);
                        fragment.f4470x.m1191o();
                    }
                    this.f4693d = false;
                    return;
                }
            }
        } catch (Throwable th) {
            this.f4693d = false;
            throw th;
        }
    }

    /* renamed from: l */
    public final void m1241l() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "movefrom RESUMED: " + fragment);
        }
        fragment.f4470x.m1197u(5);
        if (fragment.f4428K != null) {
            fragment.f4439V.m6923a(Lifecycle.Event.ON_PAUSE);
        }
        fragment.f4438U.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        fragment.f4444a = 6;
        fragment.f4426I = false;
        fragment.onPause();
        if (fragment.f4426I) {
            this.f4690a.dispatchOnFragmentPaused(fragment, false);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onPause()"));
    }

    /* renamed from: m */
    public final void m1242m(ClassLoader classLoader) {
        Fragment fragment = this.f4692c;
        Bundle bundle = fragment.f4446b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (fragment.f4446b.getBundle("savedInstanceState") == null) {
            fragment.f4446b.putBundle("savedInstanceState", new Bundle());
        }
        try {
            fragment.f4448c = fragment.f4446b.getSparseParcelableArray("viewState");
            fragment.f4450d = fragment.f4446b.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) fragment.f4446b.getParcelable("state");
            if (fragmentState != null) {
                fragment.f4455i = fragmentState.f4575m;
                fragment.f4456j = fragmentState.f4576n;
                Boolean bool = fragment.f4451e;
                if (bool != null) {
                    fragment.f4430M = bool.booleanValue();
                    fragment.f4451e = null;
                } else {
                    fragment.f4430M = fragmentState.f4577o;
                }
            }
            if (!fragment.f4430M) {
                fragment.f4429L = true;
            }
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + fragment, e);
        }
    }

    /* renamed from: n */
    public final void m1243n() {
        View view;
        String str;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "moveto RESUMED: " + fragment);
        }
        jt0 jt0Var = fragment.f4431N;
        if (jt0Var == null) {
            view = null;
        } else {
            view = jt0Var.f20622t;
        }
        if (view != null) {
            if (view != fragment.f4428K) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != fragment.f4428K) {
                    }
                }
            }
            boolean requestFocus = view.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(view);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(fragment);
                sb.append(" resulting in focused view ");
                sb.append(fragment.f4428K.findFocus());
                Log.v(FragmentManager.TAG, sb.toString());
            }
        }
        fragment.m1137c().f20622t = null;
        fragment.f4470x.m1161L();
        fragment.f4470x.m1201y(true);
        fragment.f4444a = 7;
        fragment.f4426I = false;
        fragment.onResume();
        if (fragment.f4426I) {
            LifecycleRegistry lifecycleRegistry = fragment.f4438U;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (fragment.f4428K != null) {
                fragment.f4439V.m6923a(event);
            }
            bu0 bu0Var = fragment.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(7);
            this.f4690a.dispatchOnFragmentResumed(fragment, false);
            this.f4691b.m6257i(fragment.f4452f, null);
            fragment.f4446b = null;
            fragment.f4448c = null;
            fragment.f4450d = null;
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onResume()"));
    }

    /* renamed from: o */
    public final Bundle m1244o() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f4692c;
        if (fragment.f4444a == -1 && (bundle = fragment.f4446b) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(fragment));
        if (fragment.f4444a > -1) {
            Bundle bundle3 = new Bundle();
            fragment.onSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f4690a.dispatchOnFragmentSaveInstanceState(fragment, bundle3, false);
            Bundle bundle4 = new Bundle();
            fragment.f4442Y.performSave(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle m1169T = fragment.f4470x.m1169T();
            if (!m1169T.isEmpty()) {
                bundle2.putBundle("childFragmentManager", m1169T);
            }
            if (fragment.f4428K != null) {
                m1245p();
            }
            SparseArray<? extends Parcelable> sparseArray = fragment.f4448c;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = fragment.f4450d;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = fragment.f4453g;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    /* renamed from: p */
    public final void m1245p() {
        Fragment fragment = this.f4692c;
        if (fragment.f4428K == null) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Saving view state for fragment " + fragment + " with view " + fragment.f4428K);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.f4428K.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.f4448c = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.f4439V.f25304f.performSave(bundle);
        if (!bundle.isEmpty()) {
            fragment.f4450d = bundle;
        }
    }

    /* renamed from: q */
    public final void m1246q() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "moveto STARTED: " + fragment);
        }
        fragment.f4470x.m1161L();
        fragment.f4470x.m1201y(true);
        fragment.f4444a = 5;
        fragment.f4426I = false;
        fragment.onStart();
        if (fragment.f4426I) {
            LifecycleRegistry lifecycleRegistry = fragment.f4438U;
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (fragment.f4428K != null) {
                fragment.f4439V.m6923a(event);
            }
            bu0 bu0Var = fragment.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(5);
            this.f4690a.dispatchOnFragmentStarted(fragment, false);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onStart()"));
    }

    /* renamed from: r */
    public final void m1247r() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.f4692c;
        if (isLoggingEnabled) {
            Log.d(FragmentManager.TAG, "movefrom STARTED: " + fragment);
        }
        bu0 bu0Var = fragment.f4470x;
        bu0Var.f4506K = true;
        bu0Var.f4512Q.f16548j = true;
        bu0Var.m1197u(4);
        if (fragment.f4428K != null) {
            fragment.f4439V.m6923a(Lifecycle.Event.ON_STOP);
        }
        fragment.f4438U.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        fragment.f4444a = 4;
        fragment.f4426I = false;
        fragment.onStop();
        if (fragment.f4426I) {
            this.f4690a.dispatchOnFragmentStopped(fragment, false);
            return;
        }
        throw new AndroidRuntimeException(ye0.m8295o("Fragment ", fragment, " did not call through to super.onStop()"));
    }

    public C0264s(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, mt2 mt2Var, ClassLoader classLoader, FragmentFactory fragmentFactory, Bundle bundle) {
        this.f4690a = fragmentLifecycleCallbacksDispatcher;
        this.f4691b = mt2Var;
        Fragment m1203a = ((FragmentState) bundle.getParcelable("state")).m1203a(fragmentFactory, classLoader);
        this.f4692c = m1203a;
        m1203a.f4446b = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        m1203a.setArguments(bundle2);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Instantiated fragment " + m1203a);
        }
    }

    public C0264s(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, mt2 mt2Var, Fragment fragment, Bundle bundle) {
        this.f4690a = fragmentLifecycleCallbacksDispatcher;
        this.f4691b = mt2Var;
        this.f4692c = fragment;
        fragment.f4448c = null;
        fragment.f4450d = null;
        fragment.f4467u = 0;
        fragment.f4463q = false;
        fragment.f4458l = false;
        Fragment fragment2 = fragment.f4454h;
        fragment.f4455i = fragment2 != null ? fragment2.f4452f : null;
        fragment.f4454h = null;
        fragment.f4446b = bundle;
        fragment.f4453g = bundle.getBundle("arguments");
    }
}
