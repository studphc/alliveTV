package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC1726qj;
import p000.C1597nt;
import p000.C2017ye;
import p000.RunnableC1104d;
import p000.am2;
import p000.au0;
import p000.bu0;
import p000.du0;
import p000.hu0;
import p000.jt0;
import p000.mt2;
import p000.qt0;
import p000.rt0;
import p000.st0;
import p000.tt0;
import p000.ut0;
import p000.vt0;
import p000.wd0;
import p000.xt0;
import p000.ye0;
import p000.zt0;

/* loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* renamed from: T */
    public static boolean f4494T = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG = "FragmentManager";

    /* renamed from: U */
    public static boolean f4495U = true;

    /* renamed from: A */
    public Fragment f4496A;

    /* renamed from: E */
    public ActivityResultLauncher f4500E;

    /* renamed from: F */
    public ActivityResultLauncher f4501F;

    /* renamed from: G */
    public ActivityResultLauncher f4502G;

    /* renamed from: I */
    public boolean f4504I;

    /* renamed from: J */
    public boolean f4505J;

    /* renamed from: K */
    public boolean f4506K;

    /* renamed from: L */
    public boolean f4507L;

    /* renamed from: M */
    public boolean f4508M;

    /* renamed from: N */
    public ArrayList f4509N;

    /* renamed from: O */
    public ArrayList f4510O;

    /* renamed from: P */
    public ArrayList f4511P;

    /* renamed from: Q */
    public du0 f4512Q;

    /* renamed from: R */
    public FragmentStrictMode.Policy f4513R;

    /* renamed from: b */
    public boolean f4516b;

    /* renamed from: e */
    public ArrayList f4519e;

    /* renamed from: g */
    public OnBackPressedDispatcher f4521g;

    /* renamed from: r */
    public final rt0 f4532r;

    /* renamed from: s */
    public final rt0 f4533s;

    /* renamed from: t */
    public final rt0 f4534t;

    /* renamed from: u */
    public final rt0 f4535u;

    /* renamed from: x */
    public FragmentHostCallback f4538x;

    /* renamed from: y */
    public FragmentContainer f4539y;

    /* renamed from: z */
    public Fragment f4540z;

    /* renamed from: a */
    public final ArrayList f4515a = new ArrayList();

    /* renamed from: c */
    public final mt2 f4517c = new mt2(1);

    /* renamed from: d */
    public ArrayList f4518d = new ArrayList();

    /* renamed from: f */
    public final qt0 f4520f = new qt0(this);

    /* renamed from: h */
    public C0246a f4522h = null;

    /* renamed from: i */
    public boolean f4523i = false;

    /* renamed from: j */
    public final C0258m f4524j = new C0258m(this);

    /* renamed from: k */
    public final AtomicInteger f4525k = new AtomicInteger();

    /* renamed from: l */
    public final Map f4526l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m */
    public final Map f4527m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    public final Map f4528n = Collections.synchronizedMap(new HashMap());

    /* renamed from: o */
    public final ArrayList f4529o = new ArrayList();

    /* renamed from: p */
    public final FragmentLifecycleCallbacksDispatcher f4530p = new FragmentLifecycleCallbacksDispatcher(this);

    /* renamed from: q */
    public final CopyOnWriteArrayList f4531q = new CopyOnWriteArrayList();

    /* renamed from: v */
    public final st0 f4536v = new st0(this);

    /* renamed from: w */
    public int f4537w = -1;

    /* renamed from: B */
    public FragmentFactory f4497B = null;

    /* renamed from: C */
    public final tt0 f4498C = new tt0(this);

    /* renamed from: D */
    public final wd0 f4499D = new wd0(16);

    /* renamed from: H */
    public ArrayDeque f4503H = new ArrayDeque();

    /* renamed from: S */
    public final RunnableC1104d f4514S = new RunnableC1104d(20, this);

    /* loaded from: classes.dex */
    public interface BackStackEntry {
        @Nullable
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Nullable
        @Deprecated
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    /* loaded from: classes.dex */
    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Object();

        /* renamed from: a */
        public String f4545a;

        /* renamed from: b */
        public int f4546b;

        public LaunchedFragmentInfo(String str, int i) {
            this.f4545a = str;
            this.f4546b = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4545a);
            parcel.writeInt(this.f4546b);
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChangeCancelled();

        @MainThread
        void onBackStackChangeCommitted(@NonNull Fragment fragment, boolean z);

        @MainThread
        void onBackStackChangeProgressed(@NonNull BackEventCompat backEventCompat);

        @MainThread
        void onBackStackChangeStarted(@NonNull Fragment fragment, boolean z);

        @MainThread
        void onBackStackChanged();
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [rt0] */
    /* JADX WARN: Type inference failed for: r1v14, types: [rt0] */
    /* JADX WARN: Type inference failed for: r1v15, types: [rt0] */
    /* JADX WARN: Type inference failed for: r1v16, types: [rt0] */
    public FragmentManager() {
        final int i = 0;
        this.f4532r = new Consumer(this) { // from class: rt0

            /* renamed from: b */
            public final /* synthetic */ FragmentManager f26128b;

            {
                this.f26128b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f26128b;
                        if (fragmentManager.m1159I()) {
                            fragmentManager.m1185i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f26128b;
                        if (fragmentManager2.m1159I() && num.intValue() == 80) {
                            fragmentManager2.m1189m(false);
                            return;
                        }
                        return;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f26128b;
                        if (fragmentManager3.m1159I()) {
                            fragmentManager3.m1190n(multiWindowModeChangedInfo.getIsInMultiWindowMode(), false);
                            return;
                        }
                        return;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f26128b;
                        if (fragmentManager4.m1159I()) {
                            fragmentManager4.m1195s(pictureInPictureModeChangedInfo.getIsInPictureInPictureMode(), false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i2 = 1;
        this.f4533s = new Consumer(this) { // from class: rt0

            /* renamed from: b */
            public final /* synthetic */ FragmentManager f26128b;

            {
                this.f26128b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f26128b;
                        if (fragmentManager.m1159I()) {
                            fragmentManager.m1185i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f26128b;
                        if (fragmentManager2.m1159I() && num.intValue() == 80) {
                            fragmentManager2.m1189m(false);
                            return;
                        }
                        return;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f26128b;
                        if (fragmentManager3.m1159I()) {
                            fragmentManager3.m1190n(multiWindowModeChangedInfo.getIsInMultiWindowMode(), false);
                            return;
                        }
                        return;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f26128b;
                        if (fragmentManager4.m1159I()) {
                            fragmentManager4.m1195s(pictureInPictureModeChangedInfo.getIsInPictureInPictureMode(), false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i3 = 2;
        this.f4534t = new Consumer(this) { // from class: rt0

            /* renamed from: b */
            public final /* synthetic */ FragmentManager f26128b;

            {
                this.f26128b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f26128b;
                        if (fragmentManager.m1159I()) {
                            fragmentManager.m1185i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f26128b;
                        if (fragmentManager2.m1159I() && num.intValue() == 80) {
                            fragmentManager2.m1189m(false);
                            return;
                        }
                        return;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f26128b;
                        if (fragmentManager3.m1159I()) {
                            fragmentManager3.m1190n(multiWindowModeChangedInfo.getIsInMultiWindowMode(), false);
                            return;
                        }
                        return;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f26128b;
                        if (fragmentManager4.m1159I()) {
                            fragmentManager4.m1195s(pictureInPictureModeChangedInfo.getIsInPictureInPictureMode(), false);
                            return;
                        }
                        return;
                }
            }
        };
        final int i4 = 3;
        this.f4535u = new Consumer(this) { // from class: rt0

            /* renamed from: b */
            public final /* synthetic */ FragmentManager f26128b;

            {
                this.f26128b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f26128b;
                        if (fragmentManager.m1159I()) {
                            fragmentManager.m1185i(false, configuration);
                            return;
                        }
                        return;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManager fragmentManager2 = this.f26128b;
                        if (fragmentManager2.m1159I() && num.intValue() == 80) {
                            fragmentManager2.m1189m(false);
                            return;
                        }
                        return;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManager fragmentManager3 = this.f26128b;
                        if (fragmentManager3.m1159I()) {
                            fragmentManager3.m1190n(multiWindowModeChangedInfo.getIsInMultiWindowMode(), false);
                            return;
                        }
                        return;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManager fragmentManager4 = this.f26128b;
                        if (fragmentManager4.m1159I()) {
                            fragmentManager4.m1195s(pictureInPictureModeChangedInfo.getIsInPictureInPictureMode(), false);
                            return;
                        }
                        return;
                }
            }
        };
    }

    /* renamed from: C */
    public static Fragment m1149C(View view) {
        Fragment fragment;
        while (view != null) {
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            if (tag instanceof Fragment) {
                fragment = (Fragment) tag;
            } else {
                fragment = null;
            }
            if (fragment != null) {
                return fragment;
            }
            Object parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    /* renamed from: D */
    public static HashSet m1150D(C0246a c0246a) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < c0246a.f4596c.size(); i++) {
            Fragment fragment = ((hu0) c0246a.f4596c.get(i)).f18175b;
            if (fragment != null && c0246a.f4602i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    /* renamed from: H */
    public static boolean m1151H(Fragment fragment) {
        if (!fragment.f4424G || !fragment.f4425H) {
            Iterator it = fragment.f4470x.f4517c.m6253e().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null) {
                    z = m1151H(fragment2);
                }
                if (z) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: J */
    public static boolean m1152J(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.f4468v;
        if (fragment.equals(fragmentManager.getPrimaryNavigationFragment()) && m1152J(fragmentManager.f4540z)) {
            return true;
        }
        return false;
    }

    /* renamed from: Z */
    public static void m1153Z(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.f4420C) {
            fragment.f4420C = false;
            fragment.f4434Q = !fragment.f4434Q;
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        f4494T = z;
    }

    @PredictiveBackControl
    public static void enablePredictiveBack(boolean z) {
        f4495U = z;
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view) {
        F f = (F) m1149C(view);
        if (f != null) {
            return f;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @NonNull
    public static FragmentManager findFragmentManager(@NonNull View view) {
        FragmentActivity fragmentActivity;
        Fragment m1149C = m1149C(view);
        if (m1149C != null) {
            if (m1149C.isAdded()) {
                return m1149C.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + m1149C + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                fragmentActivity = null;
                break;
            }
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean isLoggingEnabled(int i) {
        if (!f4494T && !Log.isLoggable(TAG, i)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:140:0x0252. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:174:0x0331. Please report as an issue. */
    /* renamed from: A */
    public final void m1154A(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ArrayList arrayList3;
        mt2 mt2Var;
        mt2 mt2Var2;
        mt2 mt2Var3;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        boolean z = ((C0246a) arrayList4.get(i)).f4611r;
        ArrayList arrayList6 = this.f4511P;
        if (arrayList6 == null) {
            this.f4511P = new ArrayList();
        } else {
            arrayList6.clear();
        }
        ArrayList arrayList7 = this.f4511P;
        mt2 mt2Var4 = this.f4517c;
        arrayList7.addAll(mt2Var4.m6254f());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        int i6 = i;
        boolean z2 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i2) {
                C0246a c0246a = (C0246a) arrayList4.get(i6);
                if (!((Boolean) arrayList5.get(i6)).booleanValue()) {
                    ArrayList arrayList8 = this.f4511P;
                    int i8 = 0;
                    while (true) {
                        ArrayList arrayList9 = c0246a.f4596c;
                        if (i8 < arrayList9.size()) {
                            hu0 hu0Var = (hu0) arrayList9.get(i8);
                            int i9 = hu0Var.f18174a;
                            if (i9 != i7) {
                                if (i9 != 2) {
                                    if (i9 != 3 && i9 != 6) {
                                        if (i9 != 7) {
                                            if (i9 == 8) {
                                                arrayList9.add(i8, new hu0(primaryNavigationFragment, 9, 0));
                                                hu0Var.f18176c = true;
                                                i8++;
                                                primaryNavigationFragment = hu0Var.f18175b;
                                            }
                                        } else {
                                            mt2Var3 = mt2Var4;
                                            i3 = 1;
                                        }
                                    } else {
                                        arrayList8.remove(hu0Var.f18175b);
                                        Fragment fragment = hu0Var.f18175b;
                                        if (fragment == primaryNavigationFragment) {
                                            arrayList9.add(i8, new hu0(9, fragment));
                                            i8++;
                                            mt2Var3 = mt2Var4;
                                            i3 = 1;
                                            primaryNavigationFragment = null;
                                        }
                                    }
                                    mt2Var3 = mt2Var4;
                                    i3 = 1;
                                } else {
                                    Fragment fragment2 = hu0Var.f18175b;
                                    int i10 = fragment2.f4418A;
                                    int size = arrayList8.size() - 1;
                                    boolean z3 = false;
                                    while (size >= 0) {
                                        mt2 mt2Var5 = mt2Var4;
                                        Fragment fragment3 = (Fragment) arrayList8.get(size);
                                        if (fragment3.f4418A == i10) {
                                            if (fragment3 == fragment2) {
                                                i4 = i10;
                                                z3 = true;
                                            } else {
                                                if (fragment3 == primaryNavigationFragment) {
                                                    i4 = i10;
                                                    arrayList9.add(i8, new hu0(fragment3, 9, 0));
                                                    i8++;
                                                    i5 = 0;
                                                    primaryNavigationFragment = null;
                                                } else {
                                                    i4 = i10;
                                                    i5 = 0;
                                                }
                                                hu0 hu0Var2 = new hu0(fragment3, 3, i5);
                                                hu0Var2.f18177d = hu0Var.f18177d;
                                                hu0Var2.f18179f = hu0Var.f18179f;
                                                hu0Var2.f18178e = hu0Var.f18178e;
                                                hu0Var2.f18180g = hu0Var.f18180g;
                                                arrayList9.add(i8, hu0Var2);
                                                arrayList8.remove(fragment3);
                                                i8++;
                                                primaryNavigationFragment = primaryNavigationFragment;
                                            }
                                        } else {
                                            i4 = i10;
                                        }
                                        size--;
                                        i10 = i4;
                                        mt2Var4 = mt2Var5;
                                    }
                                    mt2Var3 = mt2Var4;
                                    i3 = 1;
                                    if (z3) {
                                        arrayList9.remove(i8);
                                        i8--;
                                    } else {
                                        hu0Var.f18174a = 1;
                                        hu0Var.f18176c = true;
                                        arrayList8.add(fragment2);
                                    }
                                }
                                i8 += i3;
                                i7 = i3;
                                mt2Var4 = mt2Var3;
                            } else {
                                mt2Var3 = mt2Var4;
                                i3 = i7;
                            }
                            arrayList8.add(hu0Var.f18175b);
                            i8 += i3;
                            i7 = i3;
                            mt2Var4 = mt2Var3;
                        } else {
                            mt2Var2 = mt2Var4;
                        }
                    }
                } else {
                    mt2Var2 = mt2Var4;
                    int i11 = 1;
                    ArrayList arrayList10 = this.f4511P;
                    ArrayList arrayList11 = c0246a.f4596c;
                    int size2 = arrayList11.size() - 1;
                    while (size2 >= 0) {
                        hu0 hu0Var3 = (hu0) arrayList11.get(size2);
                        int i12 = hu0Var3.f18174a;
                        if (i12 != i11) {
                            if (i12 != 3) {
                                switch (i12) {
                                    case 8:
                                        primaryNavigationFragment = null;
                                        break;
                                    case 9:
                                        primaryNavigationFragment = hu0Var3.f18175b;
                                        break;
                                    case 10:
                                        hu0Var3.f18182i = hu0Var3.f18181h;
                                        break;
                                }
                                size2--;
                                i11 = 1;
                            }
                            arrayList10.add(hu0Var3.f18175b);
                            size2--;
                            i11 = 1;
                        }
                        arrayList10.remove(hu0Var3.f18175b);
                        size2--;
                        i11 = 1;
                    }
                }
                if (!z2 && !c0246a.f4602i) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                i6++;
                arrayList4 = arrayList;
                arrayList5 = arrayList2;
                mt2Var4 = mt2Var2;
            } else {
                mt2 mt2Var6 = mt2Var4;
                this.f4511P.clear();
                if (!z && this.f4537w >= 1) {
                    for (int i13 = i; i13 < i2; i13++) {
                        Iterator it = ((C0246a) arrayList.get(i13)).f4596c.iterator();
                        while (it.hasNext()) {
                            Fragment fragment4 = ((hu0) it.next()).f18175b;
                            if (fragment4 != null && fragment4.f4468v != null) {
                                mt2Var = mt2Var6;
                                mt2Var.m6255g(m1183g(fragment4));
                            } else {
                                mt2Var = mt2Var6;
                            }
                            mt2Var6 = mt2Var;
                        }
                    }
                }
                for (int i14 = i; i14 < i2; i14++) {
                    C0246a c0246a2 = (C0246a) arrayList.get(i14);
                    if (((Boolean) arrayList2.get(i14)).booleanValue()) {
                        c0246a2.m1219e(-1);
                        ArrayList arrayList12 = c0246a2.f4596c;
                        for (int size3 = arrayList12.size() - 1; size3 >= 0; size3--) {
                            hu0 hu0Var4 = (hu0) arrayList12.get(size3);
                            Fragment fragment5 = hu0Var4.f18175b;
                            if (fragment5 != null) {
                                fragment5.f4461o = c0246a2.f4648w;
                                if (fragment5.f4431N != null) {
                                    fragment5.m1137c().f20603a = true;
                                }
                                int i15 = c0246a2.f4601h;
                                int i16 = 8194;
                                int i17 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                                if (i15 != 4097) {
                                    if (i15 != 8194) {
                                        i16 = FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
                                        i17 = FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
                                        if (i15 != 8197) {
                                            if (i15 != 4099) {
                                                if (i15 != 4100) {
                                                    i16 = 0;
                                                }
                                            } else {
                                                i16 = 4099;
                                            }
                                        }
                                    }
                                    i16 = i17;
                                }
                                if (fragment5.f4431N != null || i16 != 0) {
                                    fragment5.m1137c();
                                    fragment5.f4431N.f20608f = i16;
                                }
                                ArrayList arrayList13 = c0246a2.f4610q;
                                ArrayList arrayList14 = c0246a2.f4609p;
                                fragment5.m1137c();
                                jt0 jt0Var = fragment5.f4431N;
                                jt0Var.f20609g = arrayList13;
                                jt0Var.f20610h = arrayList14;
                            }
                            int i18 = hu0Var4.f18174a;
                            FragmentManager fragmentManager = c0246a2.f4645t;
                            switch (i18) {
                                case 1:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.m1171V(fragment5, true);
                                    fragmentManager.m1165P(fragment5);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + hu0Var4.f18174a);
                                case 3:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.m1175a(fragment5);
                                case 4:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.getClass();
                                    m1153Z(fragment5);
                                case 5:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.m1171V(fragment5, true);
                                    fragmentManager.m1158G(fragment5);
                                case 6:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.m1179c(fragment5);
                                case 7:
                                    fragment5.m1144k(hu0Var4.f18177d, hu0Var4.f18178e, hu0Var4.f18179f, hu0Var4.f18180g);
                                    fragmentManager.m1171V(fragment5, true);
                                    fragmentManager.m1184h(fragment5);
                                case 8:
                                    fragmentManager.m1173X(null);
                                case 9:
                                    fragmentManager.m1173X(fragment5);
                                case 10:
                                    fragmentManager.m1172W(fragment5, hu0Var4.f18181h);
                            }
                        }
                    } else {
                        c0246a2.m1219e(1);
                        ArrayList arrayList15 = c0246a2.f4596c;
                        int size4 = arrayList15.size();
                        int i19 = 0;
                        while (i19 < size4) {
                            hu0 hu0Var5 = (hu0) arrayList15.get(i19);
                            Fragment fragment6 = hu0Var5.f18175b;
                            if (fragment6 != null) {
                                fragment6.f4461o = c0246a2.f4648w;
                                if (fragment6.f4431N != null) {
                                    fragment6.m1137c().f20603a = false;
                                }
                                int i20 = c0246a2.f4601h;
                                if (fragment6.f4431N != null || i20 != 0) {
                                    fragment6.m1137c();
                                    fragment6.f4431N.f20608f = i20;
                                }
                                ArrayList arrayList16 = c0246a2.f4609p;
                                ArrayList arrayList17 = c0246a2.f4610q;
                                fragment6.m1137c();
                                jt0 jt0Var2 = fragment6.f4431N;
                                jt0Var2.f20609g = arrayList16;
                                jt0Var2.f20610h = arrayList17;
                            }
                            int i21 = hu0Var5.f18174a;
                            FragmentManager fragmentManager2 = c0246a2.f4645t;
                            switch (i21) {
                                case 1:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1171V(fragment6, false);
                                    fragmentManager2.m1175a(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + hu0Var5.f18174a);
                                case 3:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1165P(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 4:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1158G(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 5:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1171V(fragment6, false);
                                    m1153Z(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 6:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1184h(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 7:
                                    arrayList3 = arrayList15;
                                    fragment6.m1144k(hu0Var5.f18177d, hu0Var5.f18178e, hu0Var5.f18179f, hu0Var5.f18180g);
                                    fragmentManager2.m1171V(fragment6, false);
                                    fragmentManager2.m1179c(fragment6);
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 8:
                                    fragmentManager2.m1173X(fragment6);
                                    arrayList3 = arrayList15;
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 9:
                                    fragmentManager2.m1173X(null);
                                    arrayList3 = arrayList15;
                                    i19++;
                                    arrayList15 = arrayList3;
                                case 10:
                                    fragmentManager2.m1172W(fragment6, hu0Var5.f18182i);
                                    arrayList3 = arrayList15;
                                    i19++;
                                    arrayList15 = arrayList3;
                            }
                        }
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                ArrayList arrayList18 = this.f4529o;
                if (z2 && !arrayList18.isEmpty()) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        linkedHashSet.addAll(m1150D((C0246a) it2.next()));
                    }
                    if (this.f4522h == null) {
                        Iterator it3 = arrayList18.iterator();
                        while (it3.hasNext()) {
                            OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) it3.next();
                            Iterator it4 = linkedHashSet.iterator();
                            while (it4.hasNext()) {
                                onBackStackChangedListener.onBackStackChangeStarted((Fragment) it4.next(), booleanValue);
                            }
                        }
                        Iterator it5 = arrayList18.iterator();
                        while (it5.hasNext()) {
                            OnBackStackChangedListener onBackStackChangedListener2 = (OnBackStackChangedListener) it5.next();
                            Iterator it6 = linkedHashSet.iterator();
                            while (it6.hasNext()) {
                                onBackStackChangedListener2.onBackStackChangeCommitted((Fragment) it6.next(), booleanValue);
                            }
                        }
                    }
                }
                for (int i22 = i; i22 < i2; i22++) {
                    C0246a c0246a3 = (C0246a) arrayList.get(i22);
                    if (booleanValue) {
                        for (int size5 = c0246a3.f4596c.size() - 1; size5 >= 0; size5--) {
                            Fragment fragment7 = ((hu0) c0246a3.f4596c.get(size5)).f18175b;
                            if (fragment7 != null) {
                                m1183g(fragment7).m1240k();
                            }
                        }
                    } else {
                        Iterator it7 = c0246a3.f4596c.iterator();
                        while (it7.hasNext()) {
                            Fragment fragment8 = ((hu0) it7.next()).f18175b;
                            if (fragment8 != null) {
                                m1183g(fragment8).m1240k();
                            }
                        }
                    }
                }
                m1160K(this.f4537w, true);
                int i23 = i;
                Iterator it8 = m1182f(arrayList, i23, i2).iterator();
                while (it8.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController) it8.next();
                    specialEffectsController.updateOperationDirection(booleanValue);
                    specialEffectsController.markPostponedState();
                    specialEffectsController.executePendingOperations();
                }
                while (i23 < i2) {
                    C0246a c0246a4 = (C0246a) arrayList.get(i23);
                    if (((Boolean) arrayList2.get(i23)).booleanValue() && c0246a4.f4647v >= 0) {
                        c0246a4.f4647v = -1;
                    }
                    if (c0246a4.f4612s != null) {
                        for (int i24 = 0; i24 < c0246a4.f4612s.size(); i24++) {
                            ((Runnable) c0246a4.f4612s.get(i24)).run();
                        }
                        c0246a4.f4612s = null;
                    }
                    i23++;
                }
                if (z2) {
                    for (int i25 = 0; i25 < arrayList18.size(); i25++) {
                        ((OnBackStackChangedListener) arrayList18.get(i25)).onBackStackChanged();
                    }
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: B */
    public final int m1155B(String str, int i, boolean z) {
        if (this.f4518d.isEmpty()) {
            return -1;
        }
        if (str == null && i < 0) {
            if (z) {
                return 0;
            }
            return this.f4518d.size() - 1;
        }
        int size = this.f4518d.size() - 1;
        while (size >= 0) {
            C0246a c0246a = (C0246a) this.f4518d.get(size);
            if ((str != null && str.equals(c0246a.f4604k)) || (i >= 0 && i == c0246a.f4647v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (z) {
            while (size > 0) {
                C0246a c0246a2 = (C0246a) this.f4518d.get(size - 1);
                if ((str != null && str.equals(c0246a2.f4604k)) || (i >= 0 && i == c0246a2.f4647v)) {
                    size--;
                } else {
                    return size;
                }
            }
            return size;
        }
        if (size == this.f4518d.size() - 1) {
            return -1;
        }
        return size + 1;
    }

    /* renamed from: E */
    public final ViewGroup m1156E(Fragment fragment) {
        ViewGroup viewGroup = fragment.f4427J;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f4418A > 0 && this.f4539y.onHasView()) {
            View onFindViewById = this.f4539y.onFindViewById(fragment.f4418A);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    /* renamed from: F */
    public final am2 m1157F() {
        Fragment fragment = this.f4540z;
        if (fragment != null) {
            return fragment.f4468v.m1157F();
        }
        return this.f4499D;
    }

    /* renamed from: G */
    public final void m1158G(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.f4420C) {
            fragment.f4420C = true;
            fragment.f4434Q = true ^ fragment.f4434Q;
            m1174Y(fragment);
        }
    }

    /* renamed from: I */
    public final boolean m1159I() {
        Fragment fragment = this.f4540z;
        if (fragment == null) {
            return true;
        }
        if (fragment.isAdded() && this.f4540z.getParentFragmentManager().m1159I()) {
            return true;
        }
        return false;
    }

    /* renamed from: K */
    public final void m1160K(int i, boolean z) {
        HashMap hashMap;
        FragmentHostCallback fragmentHostCallback;
        if (this.f4538x == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!z && i == this.f4537w) {
            return;
        }
        this.f4537w = i;
        mt2 mt2Var = this.f4517c;
        Iterator it = ((ArrayList) mt2Var.f23107b).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            hashMap = (HashMap) mt2Var.f23108c;
            if (!hasNext) {
                break;
            }
            C0264s c0264s = (C0264s) hashMap.get(((Fragment) it.next()).f4452f);
            if (c0264s != null) {
                c0264s.m1240k();
            }
        }
        for (C0264s c0264s2 : hashMap.values()) {
            if (c0264s2 != null) {
                c0264s2.m1240k();
                Fragment fragment = c0264s2.f4692c;
                if (fragment.f4459m && !fragment.m1142h()) {
                    if (fragment.f4461o && !((HashMap) mt2Var.f23109d).containsKey(fragment.f4452f)) {
                        mt2Var.m6257i(fragment.f4452f, c0264s2.m1244o());
                    }
                    mt2Var.m6256h(c0264s2);
                }
            }
        }
        Iterator it2 = mt2Var.m6252d().iterator();
        while (it2.hasNext()) {
            C0264s c0264s3 = (C0264s) it2.next();
            Fragment fragment2 = c0264s3.f4692c;
            if (fragment2.f4429L) {
                if (this.f4516b) {
                    this.f4508M = true;
                } else {
                    fragment2.f4429L = false;
                    c0264s3.m1240k();
                }
            }
        }
        if (this.f4504I && (fragmentHostCallback = this.f4538x) != null && this.f4537w == 7) {
            fragmentHostCallback.onSupportInvalidateOptionsMenu();
            this.f4504I = false;
        }
    }

    /* renamed from: L */
    public final void m1161L() {
        if (this.f4538x == null) {
            return;
        }
        this.f4505J = false;
        this.f4506K = false;
        this.f4512Q.f16548j = false;
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                fragment.f4470x.m1161L();
            }
        }
    }

    /* renamed from: M */
    public final void m1162M(int i, int i2, boolean z) {
        if (i >= 0) {
            m1199w(new au0(this, null, i, i2), z);
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Bad id: "));
    }

    /* renamed from: N */
    public final boolean m1163N(int i, int i2, String str) {
        m1201y(false);
        m1200x(true);
        Fragment fragment = this.f4496A;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean m1164O = m1164O(this.f4509N, this.f4510O, str, i, i2);
        if (m1164O) {
            this.f4516b = true;
            try {
                m1166Q(this.f4509N, this.f4510O);
            } finally {
                m1180d();
            }
        }
        m1178b0();
        boolean z = this.f4508M;
        mt2 mt2Var = this.f4517c;
        if (z) {
            this.f4508M = false;
            Iterator it = mt2Var.m6252d().iterator();
            while (it.hasNext()) {
                C0264s c0264s = (C0264s) it.next();
                Fragment fragment2 = c0264s.f4692c;
                if (fragment2.f4429L) {
                    if (this.f4516b) {
                        this.f4508M = true;
                    } else {
                        fragment2.f4429L = false;
                        c0264s.m1240k();
                    }
                }
            }
        }
        ((HashMap) mt2Var.f23108c).values().removeAll(Collections.singleton(null));
        return m1164O;
    }

    /* renamed from: O */
    public final boolean m1164O(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        boolean z;
        if ((i2 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        int m1155B = m1155B(str, i, z);
        if (m1155B < 0) {
            return false;
        }
        for (int size = this.f4518d.size() - 1; size >= m1155B; size--) {
            arrayList.add((C0246a) this.f4518d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* renamed from: P */
    public final void m1165P(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.f4467u);
        }
        boolean m1142h = fragment.m1142h();
        if (!fragment.f4421D || !m1142h) {
            mt2 mt2Var = this.f4517c;
            synchronized (((ArrayList) mt2Var.f23107b)) {
                ((ArrayList) mt2Var.f23107b).remove(fragment);
            }
            fragment.f4458l = false;
            if (m1151H(fragment)) {
                this.f4504I = true;
            }
            fragment.f4459m = true;
            m1174Y(fragment);
        }
    }

    /* renamed from: Q */
    public final void m1166Q(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!((C0246a) arrayList.get(i)).f4611r) {
                    if (i2 != i) {
                        m1154A(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C0246a) arrayList.get(i2)).f4611r) {
                            i2++;
                        }
                    }
                    m1154A(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m1154A(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0123, code lost:
    
        r1.add(r4);
     */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m1167R(ArrayList arrayList, ArrayList arrayList2, String str) {
        BackStackState backStackState = (BackStackState) this.f4526l.remove(str);
        boolean z = false;
        if (backStackState == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0246a c0246a = (C0246a) it.next();
            if (c0246a.f4648w) {
                Iterator it2 = c0246a.f4596c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = ((hu0) it2.next()).f18175b;
                    if (fragment != null) {
                        hashMap.put(fragment.f4452f, fragment);
                    }
                }
            }
        }
        ArrayList<String> arrayList3 = backStackState.f4388a;
        HashMap hashMap2 = new HashMap(arrayList3.size());
        for (String str2 : arrayList3) {
            Fragment fragment2 = (Fragment) hashMap.get(str2);
            if (fragment2 != null) {
                hashMap2.put(fragment2.f4452f, fragment2);
            } else {
                Bundle m6257i = this.f4517c.m6257i(str2, null);
                if (m6257i != null) {
                    ClassLoader classLoader = getHost().getContext().getClassLoader();
                    Fragment m1203a = ((FragmentState) m6257i.getParcelable("state")).m1203a(getFragmentFactory(), classLoader);
                    m1203a.f4446b = m6257i;
                    if (m6257i.getBundle("savedInstanceState") == null) {
                        m1203a.f4446b.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = m6257i.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    m1203a.setArguments(bundle);
                    hashMap2.put(m1203a.f4452f, m1203a);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (BackStackRecordState backStackRecordState : backStackState.f4389b) {
            backStackRecordState.getClass();
            C0246a c0246a2 = new C0246a(this);
            backStackRecordState.m1131a(c0246a2);
            int i = 0;
            while (true) {
                ArrayList arrayList5 = backStackRecordState.f4375b;
                if (i < arrayList5.size()) {
                    String str3 = (String) arrayList5.get(i);
                    if (str3 != null) {
                        Fragment fragment3 = (Fragment) hashMap2.get(str3);
                        if (fragment3 != null) {
                            ((hu0) c0246a2.f4596c.get(i)).f18175b = fragment3;
                        } else {
                            throw new IllegalStateException("Restoring FragmentTransaction " + backStackRecordState.f4379f + " failed due to missing saved state for Fragment (" + str3 + ")");
                        }
                    }
                    i++;
                }
            }
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            ((C0246a) it3.next()).mo1218a(arrayList, arrayList2);
            z = true;
        }
        return z;
    }

    /* renamed from: S */
    public final void m1168S(Parcelable parcelable) {
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher;
        C0264s c0264s;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f4538x.getContext().getClassLoader());
                this.f4527m.put(str.substring(7), bundle2);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f4538x.getContext().getClassLoader());
                hashMap.put(str2.substring(9), bundle);
            }
        }
        mt2 mt2Var = this.f4517c;
        HashMap hashMap2 = (HashMap) mt2Var.f23109d;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        HashMap hashMap3 = (HashMap) mt2Var.f23108c;
        hashMap3.clear();
        Iterator it = fragmentManagerState.f4550a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            fragmentLifecycleCallbacksDispatcher = this.f4530p;
            if (!hasNext) {
                break;
            }
            Bundle m6257i = mt2Var.m6257i((String) it.next(), null);
            if (m6257i != null) {
                Fragment fragment = (Fragment) this.f4512Q.f16542d.get(((FragmentState) m6257i.getParcelable("state")).f4564b);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v(TAG, "restoreSaveState: re-attaching retained " + fragment);
                    }
                    c0264s = new C0264s(fragmentLifecycleCallbacksDispatcher, mt2Var, fragment, m6257i);
                } else {
                    c0264s = new C0264s(this.f4530p, this.f4517c, this.f4538x.getContext().getClassLoader(), getFragmentFactory(), m6257i);
                }
                Fragment fragment2 = c0264s.f4692c;
                fragment2.f4446b = m6257i;
                fragment2.f4468v = this;
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "restoreSaveState: active (" + fragment2.f4452f + "): " + fragment2);
                }
                c0264s.m1242m(this.f4538x.getContext().getClassLoader());
                mt2Var.m6255g(c0264s);
                c0264s.f4694e = this.f4537w;
            }
        }
        du0 du0Var = this.f4512Q;
        du0Var.getClass();
        Iterator it2 = new ArrayList(du0Var.f16542d.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (hashMap3.get(fragment3.f4452f) == null) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.f4550a);
                }
                this.f4512Q.m4618h(fragment3);
                fragment3.f4468v = this;
                C0264s c0264s2 = new C0264s(fragmentLifecycleCallbacksDispatcher, mt2Var, fragment3);
                c0264s2.f4694e = 1;
                c0264s2.m1240k();
                fragment3.f4459m = true;
                c0264s2.m1240k();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.f4551b;
        ((ArrayList) mt2Var.f23107b).clear();
        if (arrayList != null) {
            for (String str3 : arrayList) {
                Fragment m6250b = mt2Var.m6250b(str3);
                if (m6250b != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v(TAG, "restoreSaveState: added (" + str3 + "): " + m6250b);
                    }
                    mt2Var.m6249a(m6250b);
                } else {
                    throw new IllegalStateException(ye0.m8296p("No instantiated fragment for (", str3, ")"));
                }
            }
        }
        if (fragmentManagerState.f4552c != null) {
            this.f4518d = new ArrayList(fragmentManagerState.f4552c.length);
            int i = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f4552c;
                if (i >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i];
                backStackRecordState.getClass();
                C0246a c0246a = new C0246a(this);
                backStackRecordState.m1131a(c0246a);
                c0246a.f4647v = backStackRecordState.f4380g;
                int i2 = 0;
                while (true) {
                    ArrayList arrayList2 = backStackRecordState.f4375b;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    String str4 = (String) arrayList2.get(i2);
                    if (str4 != null) {
                        ((hu0) c0246a.f4596c.get(i2)).f18175b = mt2Var.m6250b(str4);
                    }
                    i2++;
                }
                c0246a.m1219e(1);
                if (isLoggingEnabled(2)) {
                    StringBuilder m8299s = ye0.m8299s(i, "restoreAllState: back stack #", " (index ");
                    m8299s.append(c0246a.f4647v);
                    m8299s.append("): ");
                    m8299s.append(c0246a);
                    Log.v(TAG, m8299s.toString());
                    PrintWriter printWriter = new PrintWriter(new C2017ye());
                    c0246a.m1222h("  ", printWriter, false);
                    printWriter.close();
                }
                this.f4518d.add(c0246a);
                i++;
            }
        } else {
            this.f4518d = new ArrayList();
        }
        this.f4525k.set(fragmentManagerState.f4553d);
        String str5 = fragmentManagerState.f4554e;
        if (str5 != null) {
            Fragment m6250b2 = mt2Var.m6250b(str5);
            this.f4496A = m6250b2;
            m1194r(m6250b2);
        }
        ArrayList arrayList3 = fragmentManagerState.f4555f;
        if (arrayList3 != null) {
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                this.f4526l.put((String) arrayList3.get(i3), (BackStackState) fragmentManagerState.f4556g.get(i3));
            }
        }
        this.f4503H = new ArrayDeque(fragmentManagerState.f4557h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.os.Parcelable, androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    /* renamed from: T */
    public final Bundle m1169T() {
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        Iterator it = m1181e().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).forcePostponedExecutePendingOperations();
        }
        m1198v();
        m1201y(true);
        this.f4505J = true;
        this.f4512Q.f16548j = true;
        mt2 mt2Var = this.f4517c;
        mt2Var.getClass();
        HashMap hashMap = (HashMap) mt2Var.f23108c;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (C0264s c0264s : hashMap.values()) {
            if (c0264s != null) {
                Fragment fragment = c0264s.f4692c;
                mt2Var.m6257i(fragment.f4452f, c0264s.m1244o());
                arrayList2.add(fragment.f4452f);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "Saved state of " + fragment + ": " + fragment.f4446b);
                }
            }
        }
        HashMap hashMap2 = (HashMap) this.f4517c.f23109d;
        if (hashMap2.isEmpty()) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "saveAllState: no fragments!");
            }
        } else {
            mt2 mt2Var2 = this.f4517c;
            synchronized (((ArrayList) mt2Var2.f23107b)) {
                try {
                    if (((ArrayList) mt2Var2.f23107b).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) mt2Var2.f23107b).size());
                        Iterator it2 = ((ArrayList) mt2Var2.f23107b).iterator();
                        while (it2.hasNext()) {
                            Fragment fragment2 = (Fragment) it2.next();
                            arrayList.add(fragment2.f4452f);
                            if (isLoggingEnabled(2)) {
                                Log.v(TAG, "saveAllState: adding fragment (" + fragment2.f4452f + "): " + fragment2);
                            }
                        }
                    }
                } finally {
                }
            }
            int size = this.f4518d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i = 0; i < size; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState((C0246a) this.f4518d.get(i));
                    if (isLoggingEnabled(2)) {
                        StringBuilder m8299s = ye0.m8299s(i, "saveAllState: adding back stack #", ": ");
                        m8299s.append(this.f4518d.get(i));
                        Log.v(TAG, m8299s.toString());
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            ?? obj = new Object();
            obj.f4554e = null;
            ArrayList arrayList3 = new ArrayList();
            obj.f4555f = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            obj.f4556g = arrayList4;
            obj.f4550a = arrayList2;
            obj.f4551b = arrayList;
            obj.f4552c = backStackRecordStateArr;
            obj.f4553d = this.f4525k.get();
            Fragment fragment3 = this.f4496A;
            if (fragment3 != null) {
                obj.f4554e = fragment3.f4452f;
            }
            arrayList3.addAll(this.f4526l.keySet());
            arrayList4.addAll(this.f4526l.values());
            obj.f4557h = new ArrayList(this.f4503H);
            bundle.putParcelable("state", obj);
            for (String str : this.f4527m.keySet()) {
                bundle.putBundle(AbstractC1726qj.m7038C("result_", str), (Bundle) this.f4527m.get(str));
            }
            for (String str2 : hashMap2.keySet()) {
                bundle.putBundle(AbstractC1726qj.m7038C("fragment_", str2), (Bundle) hashMap2.get(str2));
            }
        }
        return bundle;
    }

    /* renamed from: U */
    public final void m1170U() {
        synchronized (this.f4515a) {
            try {
                if (this.f4515a.size() == 1) {
                    this.f4538x.getHandler().removeCallbacks(this.f4514S);
                    this.f4538x.getHandler().post(this.f4514S);
                    m1178b0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: V */
    public final void m1171V(Fragment fragment, boolean z) {
        ViewGroup m1156E = m1156E(fragment);
        if (m1156E != null && (m1156E instanceof FragmentContainerView)) {
            ((FragmentContainerView) m1156E).setDrawDisappearingViewsLast(!z);
        }
    }

    /* renamed from: W */
    public final void m1172W(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.f4517c.m6250b(fragment.f4452f)) && (fragment.f4469w == null || fragment.f4468v == this)) {
            fragment.f4437T = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: X */
    public final void m1173X(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f4517c.m6250b(fragment.f4452f)) || (fragment.f4469w != null && fragment.f4468v != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.f4496A;
        this.f4496A = fragment;
        m1194r(fragment2);
        m1194r(this.f4496A);
    }

    /* renamed from: Y */
    public final void m1174Y(Fragment fragment) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup m1156E = m1156E(fragment);
        if (m1156E != null) {
            jt0 jt0Var = fragment.f4431N;
            boolean z = false;
            if (jt0Var == null) {
                i = 0;
            } else {
                i = jt0Var.f20604b;
            }
            if (jt0Var == null) {
                i2 = 0;
            } else {
                i2 = jt0Var.f20605c;
            }
            int i5 = i2 + i;
            if (jt0Var == null) {
                i3 = 0;
            } else {
                i3 = jt0Var.f20606d;
            }
            int i6 = i3 + i5;
            if (jt0Var == null) {
                i4 = 0;
            } else {
                i4 = jt0Var.f20607e;
            }
            if (i4 + i6 > 0) {
                int i7 = R.id.visible_removing_fragment_view_tag;
                if (m1156E.getTag(i7) == null) {
                    m1156E.setTag(i7, fragment);
                }
                Fragment fragment2 = (Fragment) m1156E.getTag(i7);
                jt0 jt0Var2 = fragment.f4431N;
                if (jt0Var2 != null) {
                    z = jt0Var2.f20603a;
                }
                if (fragment2.f4431N != null) {
                    fragment2.m1137c().f20603a = z;
                }
            }
        }
    }

    /* renamed from: a */
    public final C0264s m1175a(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "add: " + fragment);
        }
        C0264s m1183g = m1183g(fragment);
        fragment.f4468v = this;
        mt2 mt2Var = this.f4517c;
        mt2Var.m6255g(m1183g);
        if (!fragment.f4421D) {
            mt2Var.m6249a(fragment);
            fragment.f4459m = false;
            if (fragment.f4428K == null) {
                fragment.f4434Q = false;
            }
            if (m1151H(fragment)) {
                this.f4504I = true;
            }
        }
        return m1183g;
    }

    /* renamed from: a0 */
    public final void m1176a0(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C2017ye());
        FragmentHostCallback fragmentHostCallback = this.f4538x;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e(TAG, "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.f4531q.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        this.f4529o.add(onBackStackChangedListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m1177b(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        String str;
        if (this.f4538x == null) {
            this.f4538x = fragmentHostCallback;
            this.f4539y = fragmentContainer;
            this.f4540z = fragment;
            if (fragment != null) {
                addFragmentOnAttachListener(new ut0(fragment));
            } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
                addFragmentOnAttachListener((FragmentOnAttachListener) fragmentHostCallback);
            }
            if (this.f4540z != null) {
                m1178b0();
            }
            if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                this.f4521g = onBackPressedDispatcher;
                LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
                if (fragment != null) {
                    lifecycleOwner = fragment;
                }
                onBackPressedDispatcher.addCallback(lifecycleOwner, this.f4524j);
            }
            if (fragment != null) {
                du0 du0Var = fragment.f4468v.f4512Q;
                HashMap hashMap = du0Var.f16543e;
                du0 du0Var2 = (du0) hashMap.get(fragment.f4452f);
                if (du0Var2 == null) {
                    du0Var2 = new du0(du0Var.f16545g);
                    hashMap.put(fragment.f4452f, du0Var2);
                }
                this.f4512Q = du0Var2;
            } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                this.f4512Q = (du0) new ViewModelProvider(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore(), du0.f16541k).get(du0.class);
            } else {
                this.f4512Q = new du0(false);
            }
            this.f4512Q.f16548j = isStateSaved();
            this.f4517c.f23110e = this.f4512Q;
            Object obj = this.f4538x;
            if ((obj instanceof SavedStateRegistryOwner) && fragment == null) {
                SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) obj).getSavedStateRegistry();
                savedStateRegistry.registerSavedStateProvider("android:support:fragments", new C1597nt(2, this));
                Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
                if (consumeRestoredStateForKey != null) {
                    m1168S(consumeRestoredStateForKey);
                }
            }
            Object obj2 = this.f4538x;
            if (obj2 instanceof ActivityResultRegistryOwner) {
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) obj2).getActivityResultRegistry();
                if (fragment != null) {
                    str = AbstractC1726qj.m7061q(new StringBuilder(), fragment.f4452f, ":");
                } else {
                    str = "";
                }
                String m7038C = AbstractC1726qj.m7038C("FragmentManager:", str);
                this.f4500E = activityResultRegistry.register(AbstractC1726qj.m7057m(m7038C, "StartActivityForResult"), new ActivityResultContracts.StartActivityForResult(), new C0259n(this));
                this.f4501F = activityResultRegistry.register(AbstractC1726qj.m7057m(m7038C, "StartIntentSenderForResult"), new ActivityResultContract(), new C0260o(this));
                this.f4502G = activityResultRegistry.register(AbstractC1726qj.m7057m(m7038C, "RequestPermissions"), new ActivityResultContracts.RequestMultiplePermissions(), new C0257l(this));
            }
            Object obj3 = this.f4538x;
            if (obj3 instanceof OnConfigurationChangedProvider) {
                ((OnConfigurationChangedProvider) obj3).addOnConfigurationChangedListener(this.f4532r);
            }
            Object obj4 = this.f4538x;
            if (obj4 instanceof OnTrimMemoryProvider) {
                ((OnTrimMemoryProvider) obj4).addOnTrimMemoryListener(this.f4533s);
            }
            Object obj5 = this.f4538x;
            if (obj5 instanceof OnMultiWindowModeChangedProvider) {
                ((OnMultiWindowModeChangedProvider) obj5).addOnMultiWindowModeChangedListener(this.f4534t);
            }
            Object obj6 = this.f4538x;
            if (obj6 instanceof OnPictureInPictureModeChangedProvider) {
                ((OnPictureInPictureModeChangedProvider) obj6).addOnPictureInPictureModeChangedListener(this.f4535u);
            }
            Object obj7 = this.f4538x;
            if ((obj7 instanceof MenuHost) && fragment == null) {
                ((MenuHost) obj7).addMenuProvider(this.f4536v);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: b0 */
    public final void m1178b0() {
        synchronized (this.f4515a) {
            try {
                boolean z = true;
                if (!this.f4515a.isEmpty()) {
                    this.f4524j.setEnabled(true);
                    if (isLoggingEnabled(3)) {
                        Log.d(TAG, "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                if (getBackStackEntryCount() <= 0 || !m1152J(this.f4540z)) {
                    z = false;
                }
                if (isLoggingEnabled(3)) {
                    Log.d(TAG, "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.f4524j.setEnabled(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new C0246a(this);
    }

    /* renamed from: c */
    public final void m1179c(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.f4421D) {
            fragment.f4421D = false;
            if (!fragment.f4458l) {
                this.f4517c.m6249a(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "add from attach: " + fragment);
                }
                if (m1151H(fragment)) {
                    this.f4504I = true;
                }
            }
        }
    }

    public void clearBackStack(@NonNull String str) {
        m1199w(new vt0(this, str, 0), false);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(@NonNull String str) {
        this.f4527m.remove(str);
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing fragment result with key " + str);
        }
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(@NonNull String str) {
        xt0 xt0Var = (xt0) this.f4528n.remove(str);
        if (xt0Var != null) {
            xt0Var.f28728a.removeObserver(xt0Var.f28730c);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing FragmentResultListener for key " + str);
        }
    }

    /* renamed from: d */
    public final void m1180d() {
        this.f4516b = false;
        this.f4510O.clear();
        this.f4509N.clear();
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        String m7057m = AbstractC1726qj.m7057m(str, "    ");
        mt2 mt2Var = this.f4517c;
        mt2Var.getClass();
        String str2 = str + "    ";
        HashMap hashMap = (HashMap) mt2Var.f23108c;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C0264s c0264s : hashMap.values()) {
                printWriter.print(str);
                if (c0264s != null) {
                    Fragment fragment = c0264s.f4692c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) mt2Var.f23107b;
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.f4519e;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment3 = (Fragment) this.f4519e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        int size3 = this.f4518d.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                C0246a c0246a = (C0246a) this.f4518d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0246a.toString());
                c0246a.m1222h(m7057m, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f4525k.get());
        synchronized (this.f4515a) {
            try {
                int size4 = this.f4515a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (zt0) this.f4515a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f4538x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f4539y);
        if (this.f4540z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f4540z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f4537w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f4505J);
        printWriter.print(" mStopped=");
        printWriter.print(this.f4506K);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f4507L);
        if (this.f4504I) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f4504I);
        }
    }

    /* renamed from: e */
    public final HashSet m1181e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f4517c.m6252d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C0264s) it.next()).f4692c.f4427J;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, m1157F()));
            }
        }
        return hashSet;
    }

    @MainThread
    public boolean executePendingTransactions() {
        boolean m1201y = m1201y(true);
        Iterator it = m1181e().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).forcePostponedExecutePendingOperations();
        }
        return m1201y;
    }

    /* renamed from: f */
    public final HashSet m1182f(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((C0246a) arrayList.get(i)).f4596c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((hu0) it.next()).f18175b;
                if (fragment != null && (viewGroup = fragment.f4427J) != null) {
                    hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i) {
        mt2 mt2Var = this.f4517c;
        ArrayList arrayList = (ArrayList) mt2Var.f23107b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.f4472z == i) {
                return fragment;
            }
        }
        for (C0264s c0264s : ((HashMap) mt2Var.f23108c).values()) {
            if (c0264s != null) {
                Fragment fragment2 = c0264s.f4692c;
                if (fragment2.f4472z == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        mt2 mt2Var = this.f4517c;
        if (str != null) {
            ArrayList arrayList = (ArrayList) mt2Var.f23107b;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.f4419B)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (C0264s c0264s : ((HashMap) mt2Var.f23108c).values()) {
                if (c0264s != null) {
                    Fragment fragment2 = c0264s.f4692c;
                    if (str.equals(fragment2.f4419B)) {
                        return fragment2;
                    }
                }
            }
        } else {
            mt2Var.getClass();
        }
        return null;
    }

    /* renamed from: g */
    public final C0264s m1183g(Fragment fragment) {
        String str = fragment.f4452f;
        mt2 mt2Var = this.f4517c;
        C0264s c0264s = (C0264s) ((HashMap) mt2Var.f23108c).get(str);
        if (c0264s != null) {
            return c0264s;
        }
        C0264s c0264s2 = new C0264s(this.f4530p, mt2Var, fragment);
        c0264s2.m1242m(this.f4538x.getContext().getClassLoader());
        c0264s2.f4694e = this.f4537w;
        return c0264s2;
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i) {
        if (i == this.f4518d.size()) {
            C0246a c0246a = this.f4522h;
            if (c0246a != null) {
                return c0246a;
            }
            throw new IndexOutOfBoundsException();
        }
        return (BackStackEntry) this.f4518d.get(i);
    }

    public int getBackStackEntryCount() {
        int i;
        int size = this.f4518d.size();
        if (this.f4522h != null) {
            i = 1;
        } else {
            i = 0;
        }
        return size + i;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment m6250b = this.f4517c.m6250b(string);
        if (m6250b != null) {
            return m6250b;
        }
        m1176a0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.f4497B;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.f4540z;
        if (fragment != null) {
            return fragment.f4468v.getFragmentFactory();
        }
        return this.f4498C;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.f4517c.m6254f();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FragmentHostCallback<?> getHost() {
        return this.f4538x;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.f4496A;
    }

    @Nullable
    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.f4513R;
    }

    /* renamed from: h */
    public final void m1184h(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (!fragment.f4421D) {
            fragment.f4421D = true;
            if (fragment.f4458l) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "remove from detach: " + fragment);
                }
                mt2 mt2Var = this.f4517c;
                synchronized (((ArrayList) mt2Var.f23107b)) {
                    ((ArrayList) mt2Var.f23107b).remove(fragment);
                }
                fragment.f4458l = false;
                if (m1151H(fragment)) {
                    this.f4504I = true;
                }
                m1174Y(fragment);
            }
        }
    }

    /* renamed from: i */
    public final void m1185i(boolean z, Configuration configuration) {
        if (z && (this.f4538x instanceof OnConfigurationChangedProvider)) {
            m1176a0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
                if (z) {
                    fragment.f4470x.m1185i(true, configuration);
                }
            }
        }
    }

    public boolean isDestroyed() {
        return this.f4507L;
    }

    public boolean isStateSaved() {
        if (!this.f4505J && !this.f4506K) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public final boolean m1186j(MenuItem menuItem) {
        boolean z;
        if (this.f4537w < 1) {
            return false;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                if (!fragment.f4420C) {
                    if (fragment.onContextItemSelected(menuItem)) {
                        z = true;
                    } else {
                        z = fragment.f4470x.m1186j(menuItem);
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: k */
    public final boolean m1187k(Menu menu, MenuInflater menuInflater) {
        boolean z;
        boolean z2;
        if (this.f4537w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null && fragment.isMenuVisible()) {
                if (!fragment.f4420C) {
                    if (fragment.f4424G && fragment.f4425H) {
                        fragment.onCreateOptionsMenu(menu, menuInflater);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z = z2 | fragment.f4470x.m1187k(menu, menuInflater);
                } else {
                    z = false;
                }
                if (z) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    z3 = true;
                }
            }
        }
        if (this.f4519e != null) {
            for (int i = 0; i < this.f4519e.size(); i++) {
                Fragment fragment2 = (Fragment) this.f4519e.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f4519e = arrayList;
        return z3;
    }

    /* renamed from: l */
    public final void m1188l() {
        boolean z = true;
        this.f4507L = true;
        m1201y(true);
        m1198v();
        FragmentHostCallback fragmentHostCallback = this.f4538x;
        boolean z2 = fragmentHostCallback instanceof ViewModelStoreOwner;
        mt2 mt2Var = this.f4517c;
        if (z2) {
            z = ((du0) mt2Var.f23110e).f16546h;
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z = true ^ ((Activity) this.f4538x.getContext()).isChangingConfigurations();
        }
        if (z) {
            Iterator it = this.f4526l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f4388a.iterator();
                while (it2.hasNext()) {
                    ((du0) mt2Var.f23110e).m4615e((String) it2.next(), false);
                }
            }
        }
        m1197u(-1);
        Object obj = this.f4538x;
        if (obj instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj).removeOnTrimMemoryListener(this.f4533s);
        }
        Object obj2 = this.f4538x;
        if (obj2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj2).removeOnConfigurationChangedListener(this.f4532r);
        }
        Object obj3 = this.f4538x;
        if (obj3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) obj3).removeOnMultiWindowModeChangedListener(this.f4534t);
        }
        Object obj4 = this.f4538x;
        if (obj4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) obj4).removeOnPictureInPictureModeChangedListener(this.f4535u);
        }
        Object obj5 = this.f4538x;
        if ((obj5 instanceof MenuHost) && this.f4540z == null) {
            ((MenuHost) obj5).removeMenuProvider(this.f4536v);
        }
        this.f4538x = null;
        this.f4539y = null;
        this.f4540z = null;
        if (this.f4521g != null) {
            this.f4524j.remove();
            this.f4521g = null;
        }
        ActivityResultLauncher activityResultLauncher = this.f4500E;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.f4501F.unregister();
            this.f4502G.unregister();
        }
    }

    /* renamed from: m */
    public final void m1189m(boolean z) {
        if (z && (this.f4538x instanceof OnTrimMemoryProvider)) {
            m1176a0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                fragment.onLowMemory();
                if (z) {
                    fragment.f4470x.m1189m(true);
                }
            }
        }
    }

    /* renamed from: n */
    public final void m1190n(boolean z, boolean z2) {
        if (z2 && (this.f4538x instanceof OnMultiWindowModeChangedProvider)) {
            m1176a0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                fragment.onMultiWindowModeChanged(z);
                if (z2) {
                    fragment.f4470x.m1190n(z, true);
                }
            }
        }
    }

    /* renamed from: o */
    public final void m1191o() {
        Iterator it = this.f4517c.m6253e().iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.f4470x.m1191o();
            }
        }
    }

    public final void onContainerAvailable(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        Iterator it = this.f4517c.m6252d().iterator();
        while (it.hasNext()) {
            C0264s c0264s = (C0264s) it.next();
            Fragment fragment = c0264s.f4692c;
            if (fragment.f4418A == fragmentContainerView.getId() && (view = fragment.f4428K) != null && view.getParent() == null) {
                fragment.f4427J = fragmentContainerView;
                c0264s.m1231b();
                c0264s.m1240k();
            }
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    /* renamed from: p */
    public final boolean m1192p(MenuItem menuItem) {
        boolean z;
        if (this.f4537w < 1) {
            return false;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                if (!fragment.f4420C) {
                    if (fragment.f4424G && fragment.f4425H && fragment.onOptionsItemSelected(menuItem)) {
                        z = true;
                    } else {
                        z = fragment.f4470x.m1192p(menuItem);
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public void popBackStack() {
        m1199w(new au0(this, null, -1, 0), false);
    }

    @MainThread
    public boolean popBackStackImmediate() {
        return m1163N(-1, 0, null);
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.f4468v == this) {
            bundle.putString(str, fragment.f4452f);
        } else {
            m1176a0(new IllegalStateException(ye0.m8295o("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    /* renamed from: q */
    public final void m1193q(Menu menu) {
        if (this.f4537w < 1) {
            return;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null && !fragment.f4420C) {
                if (fragment.f4424G && fragment.f4425H) {
                    fragment.onOptionsMenuClosed(menu);
                }
                fragment.f4470x.m1193q(menu);
            }
        }
    }

    /* renamed from: r */
    public final void m1194r(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f4517c.m6250b(fragment.f4452f))) {
                fragment.f4468v.getClass();
                boolean m1152J = m1152J(fragment);
                Boolean bool = fragment.f4457k;
                if (bool == null || bool.booleanValue() != m1152J) {
                    fragment.f4457k = Boolean.valueOf(m1152J);
                    fragment.onPrimaryNavigationFragmentChanged(m1152J);
                    bu0 bu0Var = fragment.f4470x;
                    bu0Var.m1178b0();
                    bu0Var.m1194r(bu0Var.f4496A);
                }
            }
        }
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.f4530p.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z);
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.f4531q.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        this.f4529o.remove(onBackStackChangedListener);
    }

    public void restoreBackStack(@NonNull String str) {
        m1199w(new vt0(this, str, 1), false);
    }

    /* renamed from: s */
    public final void m1195s(boolean z, boolean z2) {
        if (z2 && (this.f4538x instanceof OnPictureInPictureModeChangedProvider)) {
            m1176a0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null) {
                fragment.onPictureInPictureModeChanged(z);
                if (z2) {
                    fragment.f4470x.m1195s(z, true);
                }
            }
        }
    }

    public void saveBackStack(@NonNull String str) {
        m1199w(new C0263r(this, str), false);
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        C0264s c0264s = (C0264s) ((HashMap) this.f4517c.f23108c).get(fragment.f4452f);
        if (c0264s != null) {
            Fragment fragment2 = c0264s.f4692c;
            if (fragment2.equals(fragment)) {
                if (fragment2.f4444a <= -1) {
                    return null;
                }
                return new Fragment.SavedState(c0264s.m1244o());
            }
        }
        m1176a0(new IllegalStateException(ye0.m8295o("Fragment ", fragment, " is not currently in the FragmentManager")));
        throw null;
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        this.f4497B = fragmentFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // androidx.fragment.app.FragmentResultOwner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        xt0 xt0Var = (xt0) this.f4528n.get(str);
        if (xt0Var != null) {
            if (xt0Var.f28728a.getF6494d().isAtLeast(Lifecycle.State.STARTED)) {
                xt0Var.onFragmentResult(str, bundle);
                if (!isLoggingEnabled(2)) {
                    Log.v(TAG, "Setting fragment result with key " + str + " and result " + bundle);
                    return;
                }
                return;
            }
        }
        this.f4527m.put(str, bundle);
        if (!isLoggingEnabled(2)) {
        }
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getF6494d() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Bundle bundle;
                Lifecycle.Event event2 = Lifecycle.Event.ON_START;
                FragmentManager fragmentManager = FragmentManager.this;
                String str2 = str;
                if (event == event2 && (bundle = (Bundle) fragmentManager.f4527m.get(str2)) != null) {
                    fragmentResultListener.onFragmentResult(str2, bundle);
                    fragmentManager.clearFragmentResult(str2);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    fragmentManager.f4528n.remove(str2);
                }
            }
        };
        xt0 xt0Var = (xt0) this.f4528n.put(str, new xt0(lifecycle, fragmentResultListener, lifecycleEventObserver));
        if (xt0Var != null) {
            xt0Var.f28728a.removeObserver(xt0Var.f28730c);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + fragmentResultListener);
        }
        lifecycle.addObserver(lifecycleEventObserver);
    }

    public void setStrictModePolicy(@Nullable FragmentStrictMode.Policy policy) {
        this.f4513R = policy;
    }

    /* renamed from: t */
    public final boolean m1196t(Menu menu) {
        boolean z;
        boolean z2;
        if (this.f4537w < 1) {
            return false;
        }
        boolean z3 = false;
        for (Fragment fragment : this.f4517c.m6254f()) {
            if (fragment != null && fragment.isMenuVisible()) {
                if (!fragment.f4420C) {
                    if (fragment.f4424G && fragment.f4425H) {
                        fragment.onPrepareOptionsMenu(menu);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z = fragment.f4470x.m1196t(menu) | z2;
                } else {
                    z = false;
                }
                if (z) {
                    z3 = true;
                }
            }
        }
        return z3;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f4540z;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f4540z)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.f4538x;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f4538x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: u */
    public final void m1197u(int i) {
        try {
            this.f4516b = true;
            for (C0264s c0264s : ((HashMap) this.f4517c.f23108c).values()) {
                if (c0264s != null) {
                    c0264s.f4694e = i;
                }
            }
            m1160K(i, false);
            Iterator it = m1181e().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.f4516b = false;
            m1201y(true);
        } catch (Throwable th) {
            this.f4516b = false;
            throw th;
        }
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f4530p.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }

    /* renamed from: v */
    public final void m1198v() {
        Iterator it = m1181e().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
    }

    /* renamed from: w */
    public final void m1199w(zt0 zt0Var, boolean z) {
        if (!z) {
            if (this.f4538x == null) {
                if (this.f4507L) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f4515a) {
            try {
                if (this.f4538x == null) {
                    if (z) {
                    } else {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f4515a.add(zt0Var);
                    m1170U();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: x */
    public final void m1200x(boolean z) {
        if (!this.f4516b) {
            if (this.f4538x == null) {
                if (this.f4507L) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.f4538x.getHandler().getLooper()) {
                if (!z && isStateSaved()) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.f4509N == null) {
                    this.f4509N = new ArrayList();
                    this.f4510O = new ArrayList();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    /* renamed from: y */
    public final boolean m1201y(boolean z) {
        boolean z2;
        C0246a c0246a;
        m1200x(z);
        if (!this.f4523i && (c0246a = this.f4522h) != null) {
            c0246a.f4646u = false;
            c0246a.m1220f();
            if (isLoggingEnabled(3)) {
                Log.d(TAG, "Reversing mTransitioningOp " + this.f4522h + " as part of execPendingActions for actions " + this.f4515a);
            }
            this.f4522h.m1221g(false, false);
            this.f4515a.add(0, this.f4522h);
            Iterator it = this.f4522h.f4596c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((hu0) it.next()).f18175b;
                if (fragment != null) {
                    fragment.f4460n = false;
                }
            }
            this.f4522h = null;
        }
        boolean z3 = false;
        while (true) {
            ArrayList arrayList = this.f4509N;
            ArrayList arrayList2 = this.f4510O;
            synchronized (this.f4515a) {
                if (this.f4515a.isEmpty()) {
                    z2 = false;
                } else {
                    try {
                        int size = this.f4515a.size();
                        z2 = false;
                        for (int i = 0; i < size; i++) {
                            z2 |= ((zt0) this.f4515a.get(i)).mo1218a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!z2) {
                break;
            }
            this.f4516b = true;
            try {
                m1166Q(this.f4509N, this.f4510O);
                m1180d();
                z3 = true;
            } catch (Throwable th) {
                m1180d();
                throw th;
            }
        }
        m1178b0();
        if (this.f4508M) {
            this.f4508M = false;
            Iterator it2 = this.f4517c.m6252d().iterator();
            while (it2.hasNext()) {
                C0264s c0264s = (C0264s) it2.next();
                Fragment fragment2 = c0264s.f4692c;
                if (fragment2.f4429L) {
                    if (this.f4516b) {
                        this.f4508M = true;
                    } else {
                        fragment2.f4429L = false;
                        c0264s.m1240k();
                    }
                }
            }
        }
        ((HashMap) this.f4517c.f23108c).values().removeAll(Collections.singleton(null));
        return z3;
    }

    /* renamed from: z */
    public final void m1202z(C0246a c0246a, boolean z) {
        if (z && (this.f4538x == null || this.f4507L)) {
            return;
        }
        m1200x(z);
        C0246a c0246a2 = this.f4522h;
        if (c0246a2 != null) {
            c0246a2.f4646u = false;
            c0246a2.m1220f();
            if (isLoggingEnabled(3)) {
                Log.d(TAG, "Reversing mTransitioningOp " + this.f4522h + " as part of execSingleAction for action " + c0246a);
            }
            this.f4522h.m1221g(false, false);
            this.f4522h.mo1218a(this.f4509N, this.f4510O);
            Iterator it = this.f4522h.f4596c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((hu0) it.next()).f18175b;
                if (fragment != null) {
                    fragment.f4460n = false;
                }
            }
            this.f4522h = null;
        }
        c0246a.mo1218a(this.f4509N, this.f4510O);
        this.f4516b = true;
        try {
            m1166Q(this.f4509N, this.f4510O);
            m1180d();
            m1178b0();
            boolean z2 = this.f4508M;
            mt2 mt2Var = this.f4517c;
            if (z2) {
                this.f4508M = false;
                Iterator it2 = mt2Var.m6252d().iterator();
                while (it2.hasNext()) {
                    C0264s c0264s = (C0264s) it2.next();
                    Fragment fragment2 = c0264s.f4692c;
                    if (fragment2.f4429L) {
                        if (this.f4516b) {
                            this.f4508M = true;
                        } else {
                            fragment2.f4429L = false;
                            c0264s.m1240k();
                        }
                    }
                }
            }
            ((HashMap) mt2Var.f23108c).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            m1180d();
            throw th;
        }
    }

    public void popBackStack(@Nullable String str, int i) {
        m1199w(new au0(this, str, -1, i), false);
    }

    @MainThread
    public boolean popBackStackImmediate(@Nullable String str, int i) {
        return m1163N(-1, i, str);
    }

    public void popBackStack(int i, int i2) {
        m1162M(i, i2, false);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i >= 0) {
            return m1163N(i, i2, null);
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Bad id: "));
    }
}
