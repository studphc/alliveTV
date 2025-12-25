package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import p000.C2017ye;
import p000.hu0;
import p000.zt0;

/* renamed from: androidx.fragment.app.a */
/* loaded from: classes.dex */
public final class C0246a extends FragmentTransaction implements FragmentManager.BackStackEntry, zt0 {

    /* renamed from: t */
    public final FragmentManager f4645t;

    /* renamed from: u */
    public boolean f4646u;

    /* renamed from: v */
    public int f4647v;

    /* renamed from: w */
    public boolean f4648w;

    public C0246a(FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null);
        this.f4647v = -1;
        this.f4648w = false;
        this.f4645t = fragmentManager;
    }

    @Override // p000.zt0
    /* renamed from: a */
    public final boolean mo1218a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f4602i) {
            this.f4645t.f4518d.add(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int commit() {
        return m1221g(false, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int commitAllowingStateLoss() {
        return m1221g(true, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void commitNow() {
        disallowAddToBackStack();
        this.f4645t.m1202z(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f4645t.m1202z(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: d */
    public final void mo1209d(int i, Fragment fragment, String str, int i2) {
        super.mo1209d(i, fragment, str, i2);
        fragment.f4468v = this.f4645t;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction detach(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f4468v;
        if (fragmentManager != null && fragmentManager != this.f4645t) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.detach(fragment);
    }

    /* renamed from: e */
    public final void m1219e(int i) {
        if (!this.f4602i) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Bump nesting in " + this + " by " + i);
        }
        ArrayList arrayList = this.f4596c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            hu0 hu0Var = (hu0) arrayList.get(i2);
            Fragment fragment = hu0Var.f18175b;
            if (fragment != null) {
                fragment.f4467u += i;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Bump nesting of " + hu0Var.f18175b + " to " + hu0Var.f18175b.f4467u);
                }
            }
        }
    }

    /* renamed from: f */
    public final void m1220f() {
        ArrayList arrayList = this.f4596c;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            hu0 hu0Var = (hu0) arrayList.get(size);
            if (hu0Var.f18176c) {
                if (hu0Var.f18174a == 8) {
                    hu0Var.f18176c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = hu0Var.f18175b.f4418A;
                    hu0Var.f18174a = 2;
                    hu0Var.f18176c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        hu0 hu0Var2 = (hu0) arrayList.get(i2);
                        if (hu0Var2.f18176c && hu0Var2.f18175b.f4418A == i) {
                            arrayList.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    /* renamed from: g */
    public final int m1221g(boolean z, boolean z2) {
        if (!this.f4646u) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new C2017ye());
                m1222h("  ", printWriter, true);
                printWriter.close();
            }
            this.f4646u = true;
            boolean z3 = this.f4602i;
            FragmentManager fragmentManager = this.f4645t;
            if (z3) {
                this.f4647v = fragmentManager.f4525k.getAndIncrement();
            } else {
                this.f4647v = -1;
            }
            if (z2) {
                fragmentManager.m1199w(this, z);
            }
            return this.f4647v;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final CharSequence getBreadCrumbShortTitle() {
        if (this.f4607n != 0) {
            return this.f4645t.getHost().getContext().getText(this.f4607n);
        }
        return this.f4608o;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final int getBreadCrumbShortTitleRes() {
        return this.f4607n;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final CharSequence getBreadCrumbTitle() {
        if (this.f4605l != 0) {
            return this.f4645t.getHost().getContext().getText(this.f4605l);
        }
        return this.f4606m;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final int getBreadCrumbTitleRes() {
        return this.f4605l;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final int getId() {
        return this.f4647v;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final String getName() {
        return this.f4604k;
    }

    /* renamed from: h */
    public final void m1222h(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f4604k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f4647v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f4646u);
            if (this.f4601h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f4601h));
            }
            if (this.f4597d != 0 || this.f4598e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f4597d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f4598e));
            }
            if (this.f4599f != 0 || this.f4600g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f4599f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f4600g));
            }
            if (this.f4605l != 0 || this.f4606m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f4605l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f4606m);
            }
            if (this.f4607n != 0 || this.f4608o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f4607n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f4608o);
            }
        }
        ArrayList arrayList = this.f4596c;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                hu0 hu0Var = (hu0) arrayList.get(i);
                switch (hu0Var.f18174a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + hu0Var.f18174a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(hu0Var.f18175b);
                if (z) {
                    if (hu0Var.f18177d != 0 || hu0Var.f18178e != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(hu0Var.f18177d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(hu0Var.f18178e));
                    }
                    if (hu0Var.f18179f != 0 || hu0Var.f18180g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(hu0Var.f18179f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(hu0Var.f18180g));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction hide(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f4468v;
        if (fragmentManager != null && fragmentManager != this.f4645t) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.hide(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final boolean isEmpty() {
        return this.f4596c.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction remove(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f4468v;
        if (fragmentManager != null && fragmentManager != this.f4645t) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.remove(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        FragmentManager fragmentManager = fragment.f4468v;
        FragmentManager fragmentManager2 = this.f4645t;
        if (fragmentManager == fragmentManager2) {
            if (state == Lifecycle.State.INITIALIZED && fragment.f4444a > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
            }
            if (state != Lifecycle.State.DESTROYED) {
                return super.setMaxLifecycle(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + fragmentManager2);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment != null && (fragmentManager = fragment.f4468v) != null && fragmentManager != this.f4645t) {
            throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.setPrimaryNavigationFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction show(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f4468v;
        if (fragmentManager != null && fragmentManager != this.f4645t) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.show(fragment);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f4647v >= 0) {
            sb.append(" #");
            sb.append(this.f4647v);
        }
        if (this.f4604k != null) {
            sb.append(" ");
            sb.append(this.f4604k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [hu0, java.lang.Object] */
    public C0246a(C0246a c0246a) {
        super(c0246a.f4645t.getFragmentFactory(), c0246a.f4645t.getHost() != null ? c0246a.f4645t.getHost().getContext().getClassLoader() : null);
        Iterator it = c0246a.f4596c.iterator();
        while (it.hasNext()) {
            hu0 hu0Var = (hu0) it.next();
            ArrayList arrayList = this.f4596c;
            ?? obj = new Object();
            obj.f18174a = hu0Var.f18174a;
            obj.f18175b = hu0Var.f18175b;
            obj.f18176c = hu0Var.f18176c;
            obj.f18177d = hu0Var.f18177d;
            obj.f18178e = hu0Var.f18178e;
            obj.f18179f = hu0Var.f18179f;
            obj.f18180g = hu0Var.f18180g;
            obj.f18181h = hu0Var.f18181h;
            obj.f18182i = hu0Var.f18182i;
            arrayList.add(obj);
        }
        this.f4597d = c0246a.f4597d;
        this.f4598e = c0246a.f4598e;
        this.f4599f = c0246a.f4599f;
        this.f4600g = c0246a.f4600g;
        this.f4601h = c0246a.f4601h;
        this.f4602i = c0246a.f4602i;
        this.f4603j = c0246a.f4603j;
        this.f4604k = c0246a.f4604k;
        this.f4607n = c0246a.f4607n;
        this.f4608o = c0246a.f4608o;
        this.f4605l = c0246a.f4605l;
        this.f4606m = c0246a.f4606m;
        if (c0246a.f4609p != null) {
            ArrayList arrayList2 = new ArrayList();
            this.f4609p = arrayList2;
            arrayList2.addAll(c0246a.f4609p);
        }
        if (c0246a.f4610q != null) {
            ArrayList arrayList3 = new ArrayList();
            this.f4610q = arrayList3;
            arrayList3.addAll(c0246a.f4610q);
        }
        this.f4611r = c0246a.f4611r;
        this.f4647v = -1;
        this.f4648w = false;
        this.f4645t = c0246a.f4645t;
        this.f4646u = c0246a.f4646u;
        this.f4647v = c0246a.f4647v;
        this.f4648w = c0246a.f4648w;
    }
}
