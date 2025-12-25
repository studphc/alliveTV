package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import p000.hu0;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    /* renamed from: a */
    public final FragmentFactory f4594a;

    /* renamed from: b */
    public final ClassLoader f4595b;

    /* renamed from: c */
    public final ArrayList f4596c;

    /* renamed from: d */
    public int f4597d;

    /* renamed from: e */
    public int f4598e;

    /* renamed from: f */
    public int f4599f;

    /* renamed from: g */
    public int f4600g;

    /* renamed from: h */
    public int f4601h;

    /* renamed from: i */
    public boolean f4602i;

    /* renamed from: j */
    public boolean f4603j;

    /* renamed from: k */
    public String f4604k;

    /* renamed from: l */
    public int f4605l;

    /* renamed from: m */
    public CharSequence f4606m;

    /* renamed from: n */
    public int f4607n;

    /* renamed from: o */
    public CharSequence f4608o;

    /* renamed from: p */
    public ArrayList f4609p;

    /* renamed from: q */
    public ArrayList f4610q;

    /* renamed from: r */
    public boolean f4611r;

    /* renamed from: s */
    public ArrayList f4612s;

    @Deprecated
    public FragmentTransaction() {
        this.f4596c = new ArrayList();
        this.f4603j = true;
        this.f4611r = false;
        this.f4594a = null;
        this.f4595b = null;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(m1208c(bundle, cls), str);
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (FragmentTransition.supportsTransition()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.f4609p == null) {
                    this.f4609p = new ArrayList();
                    this.f4610q = new ArrayList();
                } else if (!this.f4610q.contains(str)) {
                    if (this.f4609p.contains(transitionName)) {
                        throw new IllegalArgumentException(ye0.m8296p("A shared element with the source name '", transitionName, "' has already been added to the transaction."));
                    }
                } else {
                    throw new IllegalArgumentException(ye0.m8296p("A shared element with the target name '", str, "' has already been added to the transaction."));
                }
                this.f4609p.add(transitionName);
                this.f4610q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (this.f4603j) {
            this.f4602i = true;
            this.f4604k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        m1207b(new hu0(7, fragment));
        return this;
    }

    /* renamed from: b */
    public final void m1207b(hu0 hu0Var) {
        this.f4596c.add(hu0Var);
        hu0Var.f18177d = this.f4597d;
        hu0Var.f18178e = this.f4598e;
        hu0Var.f18179f = this.f4599f;
        hu0Var.f18180g = this.f4600g;
    }

    /* renamed from: c */
    public final Fragment m1208c(Bundle bundle, Class cls) {
        FragmentFactory fragmentFactory = this.f4594a;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.f4595b;
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                if (bundle != null) {
                    instantiate.setArguments(bundle);
                }
                return instantiate;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    @MainThread
    public abstract void commitNow();

    @MainThread
    public abstract void commitNowAllowingStateLoss();

    /* renamed from: d */
    public void mo1209d(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str3 = fragment.f4419B;
                if (str3 != null && !str.equals(str3)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f4419B + " now " + str);
                }
                fragment.f4419B = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.f4472z;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f4472z + " now " + i);
                    }
                    fragment.f4472z = i;
                    fragment.f4418A = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            m1207b(new hu0(i2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        m1207b(new hu0(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.f4602i) {
            this.f4603j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        m1207b(new hu0(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.f4603j;
    }

    public boolean isEmpty() {
        return this.f4596c.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        m1207b(new hu0(3, fragment));
        return this;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return replace(i, cls, bundle, null);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.f4612s == null) {
            this.f4612s = new ArrayList();
        }
        this.f4612s.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i) {
        this.f4607n = i;
        this.f4608o = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i) {
        this.f4605l = i;
        this.f4606m = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [hu0, java.lang.Object] */
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        ?? obj = new Object();
        obj.f18174a = 10;
        obj.f18175b = fragment;
        obj.f18176c = false;
        obj.f18181h = fragment.f4437T;
        obj.f18182i = state;
        m1207b(obj);
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        m1207b(new hu0(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.f4611r = z;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i) {
        this.f4601h = i;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int i) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        m1207b(new hu0(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        mo1209d(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        this.f4597d = i;
        this.f4598e = i2;
        this.f4599f = i3;
        this.f4600g = i4;
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return add(i, m1208c(bundle, cls));
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return replace(i, m1208c(bundle, cls), str);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.f4607n = 0;
        this.f4608o = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.f4605l = 0;
        this.f4606m = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment) {
        mo1209d(i, fragment, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        if (i != 0) {
            mo1209d(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(i, m1208c(bundle, cls), str);
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        mo1209d(i, fragment, str, 1);
        return this;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.f4596c = new ArrayList();
        this.f4603j = true;
        this.f4611r = false;
        this.f4594a = fragmentFactory;
        this.f4595b = classLoader;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.f4427J = viewGroup;
        fragment.f4464r = true;
        return add(viewGroup.getId(), fragment, str);
    }
}
