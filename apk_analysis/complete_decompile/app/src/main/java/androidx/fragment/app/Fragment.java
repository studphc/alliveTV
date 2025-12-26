package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;
import p000.RunnableC0006a5;
import p000.RunnableC1104d;
import p000.b01;
import p000.bu0;
import p000.et0;
import p000.ft0;
import p000.gt0;
import p000.ht0;
import p000.it0;
import p000.jt0;
import p000.pu0;
import p000.ye0;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {

    /* renamed from: d0 */
    public static final Object f4417d0 = new Object();

    /* renamed from: A */
    public int f4418A;

    /* renamed from: B */
    public String f4419B;

    /* renamed from: C */
    public boolean f4420C;

    /* renamed from: D */
    public boolean f4421D;

    /* renamed from: E */
    public boolean f4422E;

    /* renamed from: F */
    public boolean f4423F;

    /* renamed from: G */
    public boolean f4424G;

    /* renamed from: H */
    public boolean f4425H;

    /* renamed from: I */
    public boolean f4426I;

    /* renamed from: J */
    public ViewGroup f4427J;

    /* renamed from: K */
    public View f4428K;

    /* renamed from: L */
    public boolean f4429L;

    /* renamed from: M */
    public boolean f4430M;

    /* renamed from: N */
    public jt0 f4431N;

    /* renamed from: O */
    public Handler f4432O;

    /* renamed from: P */
    public final ft0 f4433P;

    /* renamed from: Q */
    public boolean f4434Q;

    /* renamed from: R */
    public LayoutInflater f4435R;

    /* renamed from: S */
    public boolean f4436S;

    /* renamed from: T */
    public Lifecycle.State f4437T;

    /* renamed from: U */
    public LifecycleRegistry f4438U;

    /* renamed from: V */
    public pu0 f4439V;

    /* renamed from: W */
    public final MutableLiveData f4440W;

    /* renamed from: X */
    public SavedStateViewModelFactory f4441X;

    /* renamed from: Y */
    public SavedStateRegistryController f4442Y;

    /* renamed from: Z */
    public final int f4443Z;

    /* renamed from: a */
    public int f4444a;

    /* renamed from: a0 */
    public final AtomicInteger f4445a0;

    /* renamed from: b */
    public Bundle f4446b;

    /* renamed from: b0 */
    public final ArrayList f4447b0;

    /* renamed from: c */
    public SparseArray f4448c;

    /* renamed from: c0 */
    public final gt0 f4449c0;

    /* renamed from: d */
    public Bundle f4450d;

    /* renamed from: e */
    public Boolean f4451e;

    /* renamed from: f */
    public String f4452f;

    /* renamed from: g */
    public Bundle f4453g;

    /* renamed from: h */
    public Fragment f4454h;

    /* renamed from: i */
    public String f4455i;

    /* renamed from: j */
    public int f4456j;

    /* renamed from: k */
    public Boolean f4457k;

    /* renamed from: l */
    public boolean f4458l;

    /* renamed from: m */
    public boolean f4459m;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mPreviousWho;

    /* renamed from: n */
    public boolean f4460n;

    /* renamed from: o */
    public boolean f4461o;

    /* renamed from: p */
    public boolean f4462p;

    /* renamed from: q */
    public boolean f4463q;

    /* renamed from: r */
    public boolean f4464r;

    /* renamed from: s */
    public boolean f4465s;

    /* renamed from: t */
    public boolean f4466t;

    /* renamed from: u */
    public int f4467u;

    /* renamed from: v */
    public FragmentManager f4468v;

    /* renamed from: w */
    public FragmentHostCallback f4469w;

    /* renamed from: x */
    public bu0 f4470x;

    /* renamed from: y */
    public Fragment f4471y;

    /* renamed from: z */
    public int f4472z;

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.fragment.app.FragmentManager, bu0] */
    public Fragment() {
        this.f4444a = -1;
        this.f4452f = UUID.randomUUID().toString();
        this.f4455i = null;
        this.f4457k = null;
        this.f4470x = new FragmentManager();
        this.f4425H = true;
        this.f4430M = true;
        this.f4433P = new ft0(0, this);
        this.f4437T = Lifecycle.State.RESUMED;
        this.f4440W = new MutableLiveData();
        this.f4445a0 = new AtomicInteger();
        this.f4447b0 = new ArrayList();
        this.f4449c0 = new gt0(this);
        m1140f();
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str) {
        return instantiate(context, str, null);
    }

    /* renamed from: a */
    public final void m1136a(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        jt0 jt0Var = this.f4431N;
        if (jt0Var != null) {
            jt0Var.f20623u = false;
        }
        if (this.f4428K != null && (viewGroup = this.f4427J) != null && (fragmentManager = this.f4468v) != null) {
            SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager);
            orCreateController.markPostponedState();
            if (z) {
                this.f4469w.getHandler().post(new RunnableC1104d(19, orCreateController));
            } else {
                orCreateController.executePendingOperations();
            }
            Handler handler = this.f4432O;
            if (handler != null) {
                handler.removeCallbacks(this.f4433P);
                this.f4432O = null;
            }
        }
    }

    /* renamed from: b */
    public FragmentContainer mo1133b() {
        return new ht0(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [jt0, java.lang.Object] */
    /* renamed from: c */
    public final jt0 m1137c() {
        if (this.f4431N == null) {
            ?? obj = new Object();
            obj.f20611i = null;
            Object obj2 = f4417d0;
            obj.f20612j = obj2;
            obj.f20613k = null;
            obj.f20614l = obj2;
            obj.f20615m = null;
            obj.f20616n = obj2;
            obj.f20619q = null;
            obj.f20620r = null;
            obj.f20621s = 1.0f;
            obj.f20622t = null;
            this.f4431N = obj;
        }
        return this.f4431N;
    }

    /* renamed from: d */
    public final int m1138d() {
        Lifecycle.State state = this.f4437T;
        if (state != Lifecycle.State.INITIALIZED && this.f4471y != null) {
            return Math.min(state.ordinal(), this.f4471y.m1138d());
        }
        return state.ordinal();
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f4472z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f4418A));
        printWriter.print(" mTag=");
        printWriter.println(this.f4419B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f4444a);
        printWriter.print(" mWho=");
        printWriter.print(this.f4452f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f4467u);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f4458l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f4459m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f4462p);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f4463q);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f4420C);
        printWriter.print(" mDetached=");
        printWriter.print(this.f4421D);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f4425H);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f4424G);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f4422E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f4430M);
        if (this.f4468v != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f4468v);
        }
        if (this.f4469w != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f4469w);
        }
        if (this.f4471y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f4471y);
        }
        if (this.f4453g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f4453g);
        }
        if (this.f4446b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f4446b);
        }
        if (this.f4448c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f4448c);
        }
        if (this.f4450d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f4450d);
        }
        int i8 = 0;
        Fragment m1139e = m1139e(false);
        if (m1139e != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(m1139e);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f4456j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            z = false;
        } else {
            z = jt0Var.f20603a;
        }
        printWriter.println(z);
        jt0 jt0Var2 = this.f4431N;
        if (jt0Var2 == null) {
            i = 0;
        } else {
            i = jt0Var2.f20604b;
        }
        if (i != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            jt0 jt0Var3 = this.f4431N;
            if (jt0Var3 == null) {
                i7 = 0;
            } else {
                i7 = jt0Var3.f20604b;
            }
            printWriter.println(i7);
        }
        jt0 jt0Var4 = this.f4431N;
        if (jt0Var4 == null) {
            i2 = 0;
        } else {
            i2 = jt0Var4.f20605c;
        }
        if (i2 != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            jt0 jt0Var5 = this.f4431N;
            if (jt0Var5 == null) {
                i6 = 0;
            } else {
                i6 = jt0Var5.f20605c;
            }
            printWriter.println(i6);
        }
        jt0 jt0Var6 = this.f4431N;
        if (jt0Var6 == null) {
            i3 = 0;
        } else {
            i3 = jt0Var6.f20606d;
        }
        if (i3 != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            jt0 jt0Var7 = this.f4431N;
            if (jt0Var7 == null) {
                i5 = 0;
            } else {
                i5 = jt0Var7.f20606d;
            }
            printWriter.println(i5);
        }
        jt0 jt0Var8 = this.f4431N;
        if (jt0Var8 == null) {
            i4 = 0;
        } else {
            i4 = jt0Var8.f20607e;
        }
        if (i4 != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            jt0 jt0Var9 = this.f4431N;
            if (jt0Var9 != null) {
                i8 = jt0Var9.f20607e;
            }
            printWriter.println(i8);
        }
        if (this.f4427J != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f4427J);
        }
        if (this.f4428K != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f4428K);
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f4470x + ":");
        this.f4470x.dump(AbstractC1726qj.m7057m(str, "  "), fileDescriptor, printWriter, strArr);
    }

    /* renamed from: e */
    public final Fragment m1139e(boolean z) {
        String str;
        if (z) {
            FragmentStrictMode.onGetTargetFragmentUsage(this);
        }
        Fragment fragment = this.f4454h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.f4468v;
        if (fragmentManager != null && (str = this.f4455i) != null) {
            return fragmentManager.f4517c.m6250b(str);
        }
        return null;
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public final void m1140f() {
        this.f4438U = new LifecycleRegistry(this);
        this.f4442Y = SavedStateRegistryController.create(this);
        this.f4441X = null;
        ArrayList arrayList = this.f4447b0;
        gt0 gt0Var = this.f4449c0;
        if (!arrayList.contains(gt0Var)) {
            if (this.f4444a >= 0) {
                gt0Var.mo4992a();
            } else {
                arrayList.add(gt0Var);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.fragment.app.FragmentManager, bu0] */
    /* renamed from: g */
    public final void m1141g() {
        m1140f();
        this.mPreviousWho = this.f4452f;
        this.f4452f = UUID.randomUUID().toString();
        this.f4458l = false;
        this.f4459m = false;
        this.f4462p = false;
        this.f4463q = false;
        this.f4465s = false;
        this.f4467u = 0;
        this.f4468v = null;
        this.f4470x = new FragmentManager();
        this.f4469w = null;
        this.f4472z = 0;
        this.f4418A = 0;
        this.f4419B = null;
        this.f4420C = false;
        this.f4421D = false;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        jt0 jt0Var = this.f4431N;
        if (jt0Var != null && (bool = jt0Var.f20618p) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        jt0 jt0Var = this.f4431N;
        if (jt0Var != null && (bool = jt0Var.f20617o) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.f4453g;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.f4469w != null) {
            return this.f4470x;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " has not been attached yet."));
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (applicationContext instanceof ContextWrapper) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            } else {
                application = null;
                break;
            }
        }
        if (application == null && FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.f4468v != null) {
            if (this.f4441X == null) {
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (applicationContext instanceof ContextWrapper) {
                        if (applicationContext instanceof Application) {
                            application = (Application) applicationContext;
                            break;
                        }
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    } else {
                        application = null;
                        break;
                    }
                }
                if (application == null && FragmentManager.isLoggingEnabled(3)) {
                    Log.d(FragmentManager.TAG, "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.f4441X = new SavedStateViewModelFactory(application, this, getArguments());
            }
            return this.f4441X;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Nullable
    public Object getEnterTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        return jt0Var.f20611i;
    }

    @Nullable
    public Object getExitTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        return jt0Var.f20613k;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.f4468v;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final int getId() {
        return this.f4472z;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.f4435R;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(null);
        this.f4435R = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f4438U;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.f4471y;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.f4468v;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not associated with a fragment manager."));
    }

    @Nullable
    public Object getReenterTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        Object obj = jt0Var.f20614l;
        if (obj == f4417d0) {
            return getExitTransition();
        }
        return obj;
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.f4422E;
    }

    @Nullable
    public Object getReturnTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        Object obj = jt0Var.f20612j;
        if (obj == f4417d0) {
            return getEnterTransition();
        }
        return obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f4442Y.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        return jt0Var.f20615m;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        jt0 jt0Var = this.f4431N;
        if (jt0Var == null) {
            return null;
        }
        Object obj = jt0Var.f20616n;
        if (obj == f4417d0) {
            return getSharedElementEnterTransition();
        }
        return obj;
    }

    @NonNull
    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    @Nullable
    public final String getTag() {
        return this.f4419B;
    }

    @Nullable
    @Deprecated
    public final Fragment getTargetFragment() {
        return m1139e(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.f4456j;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.f4430M;
    }

    @Nullable
    public View getView() {
        return this.f4428K;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        pu0 pu0Var = this.f4439V;
        if (pu0Var != null) {
            return pu0Var;
        }
        throw new IllegalStateException(ye0.m8295o("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.f4440W;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.f4468v != null) {
            if (m1138d() != Lifecycle.State.INITIALIZED.ordinal()) {
                HashMap hashMap = this.f4468v.f4512Q.f16544f;
                ViewModelStore viewModelStore = (ViewModelStore) hashMap.get(this.f4452f);
                if (viewModelStore == null) {
                    ViewModelStore viewModelStore2 = new ViewModelStore();
                    hashMap.put(this.f4452f, viewModelStore2);
                    return viewModelStore2;
                }
                return viewModelStore;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* renamed from: h */
    public final boolean m1142h() {
        if (this.f4467u > 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.f4424G;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public void mo1134i(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4470x.m1161L();
        this.f4466t = true;
        this.f4439V = new pu0(this, getViewModelStore(), new RunnableC0006a5(18, this));
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.f4428K = onCreateView;
        if (onCreateView != null) {
            this.f4439V.m6924b();
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(FragmentManager.TAG, "Setting ViewLifecycleOwner on View " + this.f4428K + " for Fragment " + this);
            }
            ViewTreeLifecycleOwner.set(this.f4428K, this.f4439V);
            ViewTreeViewModelStoreOwner.set(this.f4428K, this.f4439V);
            ViewTreeSavedStateRegistryOwner.set(this.f4428K, this.f4439V);
            this.f4440W.setValue(this.f4439V);
            return;
        }
        if (this.f4439V.f25303e == null) {
            this.f4439V = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public final boolean isAdded() {
        if (this.f4469w != null && this.f4458l) {
            return true;
        }
        return false;
    }

    public final boolean isDetached() {
        return this.f4421D;
    }

    public final boolean isHidden() {
        boolean isHidden;
        if (!this.f4420C) {
            FragmentManager fragmentManager = this.f4468v;
            if (fragmentManager == null) {
                return false;
            }
            Fragment fragment = this.f4471y;
            fragmentManager.getClass();
            if (fragment == null) {
                isHidden = false;
            } else {
                isHidden = fragment.isHidden();
            }
            if (!isHidden) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInLayout() {
        return this.f4463q;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        boolean isMenuVisible;
        if (this.f4425H) {
            if (this.f4468v == null) {
                return true;
            }
            Fragment fragment = this.f4471y;
            if (fragment == null) {
                isMenuVisible = true;
            } else {
                isMenuVisible = fragment.isMenuVisible();
            }
            if (isMenuVisible) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRemoving() {
        return this.f4459m;
    }

    public final boolean isResumed() {
        if (this.f4444a >= 7) {
            return true;
        }
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.f4468v;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    public final boolean isVisible() {
        View view;
        if (isAdded() && !isHidden() && (view = this.f4428K) != null && view.getWindowToken() != null && this.f4428K.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public final et0 m1143j(ActivityResultContract activityResultContract, Function function, ActivityResultCallback activityResultCallback) {
        if (this.f4444a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            it0 it0Var = new it0(this, function, atomicReference, activityResultContract, activityResultCallback);
            if (this.f4444a >= 0) {
                it0Var.mo4992a();
            } else {
                this.f4447b0.add(it0Var);
            }
            return new et0(atomicReference, activityResultContract);
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    /* renamed from: k */
    public final void m1144k(int i, int i2, int i3, int i4) {
        if (this.f4431N == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        m1137c().f20604b = i;
        m1137c().f20605c = i2;
        m1137c().f20606d = i3;
        m1137c().f20607e = i4;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        this.f4426I = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context context) {
        this.f4426I = true;
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.f4426I = false;
            onAttach(activity);
        }
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.f4426I = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        this.f4426I = true;
        Bundle bundle3 = this.f4446b;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.f4470x.m1168S(bundle2);
            bu0 bu0Var = this.f4470x;
            bu0Var.f4505J = false;
            bu0Var.f4506K = false;
            bu0Var.f4512Q.f16548j = false;
            bu0Var.m1197u(1);
        }
        bu0 bu0Var2 = this.f4470x;
        if (bu0Var2.f4537w < 1) {
            bu0Var2.f4505J = false;
            bu0Var2.f4506K = false;
            bu0Var2.f4512Q.f16548j = false;
            bu0Var2.m1197u(1);
        }
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @MainThread
    @Deprecated
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i = this.f4443Z;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.f4426I = true;
    }

    @MainThread
    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.f4426I = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.f4426I = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @MainThread
    public void onHiddenChanged(boolean z) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.f4426I = true;
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.f4426I = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.f4426I = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @MainThread
    @Deprecated
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @MainThread
    @Deprecated
    public void onOptionsMenuClosed(@NonNull Menu menu) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.f4426I = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @MainThread
    @Deprecated
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.f4426I = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.f4426I = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.f4426I = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.f4426I = true;
    }

    public void postponeEnterTransition() {
        m1137c().f20623u = true;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return m1143j(activityResultContract, new b01(14, this), activityResultCallback);
    }

    public void registerForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] strArr, int i) {
        if (this.f4469w != null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f4502G != null) {
                parentFragmentManager.f4503H.addLast(new FragmentManager.LaunchedFragmentInfo(this.f4452f, i));
                parentFragmentManager.f4502G.launch(strArr);
                return;
            }
            parentFragmentManager.f4538x.onRequestPermissionsFromFragment(this, strArr, i);
            return;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to an activity."));
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " does not have any arguments."));
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to a context."));
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to a host."));
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException(ye0.m8295o("Fragment ", this, " is not attached to any Fragment or host"));
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    @NonNull
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        m1137c().f20618p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        m1137c().f20617o = Boolean.valueOf(z);
    }

    public void setArguments(@Nullable Bundle bundle) {
        if (this.f4468v != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f4453g = bundle;
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        m1137c().f20619q = sharedElementCallback;
    }

    public void setEnterTransition(@Nullable Object obj) {
        m1137c().f20611i = obj;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        m1137c().f20620r = sharedElementCallback;
    }

    public void setExitTransition(@Nullable Object obj) {
        m1137c().f20613k = obj;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.f4424G != z) {
            this.f4424G = z;
            if (isAdded() && !isHidden()) {
                this.f4469w.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(@Nullable SavedState savedState) {
        Bundle bundle;
        if (this.f4468v == null) {
            if (savedState == null || (bundle = savedState.f4474a) == null) {
                bundle = null;
            }
            this.f4446b = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.f4425H != z) {
            this.f4425H = z;
            if (this.f4424G && isAdded() && !isHidden()) {
                this.f4469w.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(@Nullable Object obj) {
        m1137c().f20614l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.f4422E = z;
        FragmentManager fragmentManager = this.f4468v;
        if (fragmentManager != null) {
            if (z) {
                fragmentManager.f4512Q.m4613c(this);
                return;
            } else {
                fragmentManager.f4512Q.m4618h(this);
                return;
            }
        }
        this.f4423F = true;
    }

    public void setReturnTransition(@Nullable Object obj) {
        m1137c().f20612j = obj;
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        m1137c().f20615m = obj;
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        m1137c().f20616n = obj;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment fragment, int i) {
        FragmentManager fragmentManager;
        if (fragment != null) {
            FragmentStrictMode.onSetTargetFragmentUsage(this, fragment, i);
        }
        FragmentManager fragmentManager2 = this.f4468v;
        if (fragment != null) {
            fragmentManager = fragment.f4468v;
        } else {
            fragmentManager = null;
        }
        if (fragmentManager2 != null && fragmentManager != null && fragmentManager2 != fragmentManager) {
            throw new IllegalArgumentException(ye0.m8295o("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.m1139e(false)) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.f4455i = null;
            this.f4454h = null;
        } else if (this.f4468v != null && fragment.f4468v != null) {
            this.f4455i = fragment.f4452f;
            this.f4454h = null;
        } else {
            this.f4455i = null;
            this.f4454h = fragment;
        }
        this.f4456j = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        FragmentStrictMode.onSetUserVisibleHint(this, z);
        boolean z2 = false;
        if (!this.f4430M && z && this.f4444a < 5 && this.f4468v != null && isAdded() && this.f4436S) {
            FragmentManager fragmentManager = this.f4468v;
            C0264s m1183g = fragmentManager.m1183g(this);
            Fragment fragment = m1183g.f4692c;
            if (fragment.f4429L) {
                if (fragmentManager.f4516b) {
                    fragmentManager.f4508M = true;
                } else {
                    fragment.f4429L = false;
                    m1183g.m1240k();
                }
            }
        }
        this.f4430M = z;
        if (this.f4444a < 5 && !z) {
            z2 = true;
        }
        this.f4429L = z2;
        if (this.f4446b != null) {
            this.f4451e = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(@NonNull Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        Intent intent2 = intent;
        if (this.f4469w != null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
            }
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f4501F != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
                    }
                    intent2.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
                }
                IntentSenderRequest build = new IntentSenderRequest.Builder(intentSender).setFillInIntent(intent2).setFlags(i3, i2).build();
                parentFragmentManager.f4503H.addLast(new FragmentManager.LaunchedFragmentInfo(this.f4452f, i));
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Fragment " + this + "is launching an IntentSender for result ");
                }
                parentFragmentManager.f4501F.launch(build);
                return;
            }
            parentFragmentManager.f4538x.onStartIntentSenderFromFragment(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        if (this.f4431N != null && m1137c().f20623u) {
            if (this.f4469w == null) {
                m1137c().f20623u = false;
            } else if (Looper.myLooper() != this.f4469w.getHandler().getLooper()) {
                this.f4469w.getHandler().postAtFrontOfQueue(new ft0(1, this));
            } else {
                m1136a(true);
            }
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f4452f);
        if (this.f4472z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f4472z));
        }
        if (this.f4419B != null) {
            sb.append(" tag=");
            sb.append(this.f4419B);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public final Bundle f4474a;

        public SavedState(Bundle bundle) {
            this.f4474a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeBundle(this.f4474a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f4474a = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            Fragment newInstance = FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new InstantiationException(ye0.m8296p("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (java.lang.InstantiationException e2) {
            throw new InstantiationException(ye0.m8296p("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException(ye0.m8296p("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException(ye0.m8296p("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    @NonNull
    public final String getString(@StringRes int i, @Nullable Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, @NonNull TimeUnit timeUnit) {
        m1137c().f20623u = true;
        Handler handler = this.f4432O;
        ft0 ft0Var = this.f4433P;
        if (handler != null) {
            handler.removeCallbacks(ft0Var);
        }
        FragmentManager fragmentManager = this.f4468v;
        if (fragmentManager != null) {
            this.f4432O = fragmentManager.getHost().getHandler();
        } else {
            this.f4432O = new Handler(Looper.getMainLooper());
        }
        this.f4432O.removeCallbacks(ft0Var);
        this.f4432O.postDelayed(ft0Var, timeUnit.toMillis(j));
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return m1143j(activityResultContract, new b01(15, activityResultRegistry), activityResultCallback);
    }

    public void startActivity(@NonNull Intent intent, @Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent intent, int i, @Nullable Bundle bundle) {
        if (this.f4469w != null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.f4500E != null) {
                parentFragmentManager.f4503H.addLast(new FragmentManager.LaunchedFragmentInfo(this.f4452f, i));
                if (bundle != null) {
                    intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
                }
                parentFragmentManager.f4500E.launch(intent);
                return;
            }
            parentFragmentManager.f4538x.onStartActivityFromFragment(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException(ye0.m8295o("Fragment ", this, " not attached to Activity"));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.f4469w;
        if (fragmentHostCallback != null) {
            LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.f4470x.f4520f);
            return onGetLayoutInflater;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        this.f4426I = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.f4426I = true;
    }

    @ContentView
    public Fragment(@LayoutRes int i) {
        this();
        this.f4443Z = i;
    }
}
