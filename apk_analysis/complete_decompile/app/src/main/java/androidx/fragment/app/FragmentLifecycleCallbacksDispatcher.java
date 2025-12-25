package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0018J/\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u0013J\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b \u0010\u0013J\u001d\u0010!\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0013J\u001d\u0010\"\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\"\u0010\u0013J%\u0010$\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0018J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0013J\u001d\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0013J\u001d\u0010'\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b'\u0010\u0013¨\u0006)"}, m5569d2 = {"Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "cb", "", "recursive", "", "registerFragmentLifecycleCallbacks", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Z)V", "unregisterFragmentLifecycleCallbacks", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;)V", "Landroidx/fragment/app/Fragment;", "f", "onlyRecursive", "dispatchOnFragmentPreAttached", "(Landroidx/fragment/app/Fragment;Z)V", "dispatchOnFragmentAttached", "Landroid/os/Bundle;", "savedInstanceState", "dispatchOnFragmentPreCreated", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V", "dispatchOnFragmentCreated", "dispatchOnFragmentActivityCreated", "Landroid/view/View;", "v", "dispatchOnFragmentViewCreated", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V", "dispatchOnFragmentStarted", "dispatchOnFragmentResumed", "dispatchOnFragmentPaused", "dispatchOnFragmentStopped", "outState", "dispatchOnFragmentSaveInstanceState", "dispatchOnFragmentViewDestroyed", "dispatchOnFragmentDestroyed", "dispatchOnFragmentDetached", "androidx/fragment/app/k", "fragment_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FragmentLifecycleCallbacksDispatcher {

    /* renamed from: a */
    public final FragmentManager f4492a;

    /* renamed from: b */
    public final CopyOnWriteArrayList f4493b;

    public FragmentLifecycleCallbacksDispatcher(@NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.f4492a = fragmentManager;
        this.f4493b = new CopyOnWriteArrayList();
    }

    public final void dispatchOnFragmentActivityCreated(@NotNull Fragment f, @Nullable Bundle savedInstanceState, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentActivityCreated(f, savedInstanceState, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentActivityCreated(fragmentManager, f, savedInstanceState);
            }
        }
    }

    public final void dispatchOnFragmentAttached(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Context context = fragmentManager.getHost().getContext();
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentAttached(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentAttached(fragmentManager, f, context);
            }
        }
    }

    public final void dispatchOnFragmentCreated(@NotNull Fragment f, @Nullable Bundle savedInstanceState, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentCreated(f, savedInstanceState, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentCreated(fragmentManager, f, savedInstanceState);
            }
        }
    }

    public final void dispatchOnFragmentDestroyed(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentDestroyed(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentDestroyed(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentDetached(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentDetached(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentDetached(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentPaused(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentPaused(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentPaused(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentPreAttached(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Context context = fragmentManager.getHost().getContext();
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentPreAttached(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentPreAttached(fragmentManager, f, context);
            }
        }
    }

    public final void dispatchOnFragmentPreCreated(@NotNull Fragment f, @Nullable Bundle savedInstanceState, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentPreCreated(f, savedInstanceState, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentPreCreated(fragmentManager, f, savedInstanceState);
            }
        }
    }

    public final void dispatchOnFragmentResumed(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentResumed(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentResumed(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentSaveInstanceState(@NotNull Fragment f, @NotNull Bundle outState, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentSaveInstanceState(f, outState, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentSaveInstanceState(fragmentManager, f, outState);
            }
        }
    }

    public final void dispatchOnFragmentStarted(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentStarted(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentStarted(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentStopped(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentStopped(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentStopped(fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentViewCreated(@NotNull Fragment f, @NotNull View v, @Nullable Bundle savedInstanceState, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentViewCreated(f, v, savedInstanceState, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentViewCreated(fragmentManager, f, v, savedInstanceState);
            }
        }
    }

    public final void dispatchOnFragmentViewDestroyed(@NotNull Fragment f, boolean onlyRecursive) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = this.f4492a;
        Fragment fragment = fragmentManager.f4540z;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.f4530p.dispatchOnFragmentViewDestroyed(f, true);
        }
        Iterator it = this.f4493b.iterator();
        while (it.hasNext()) {
            C0256k c0256k = (C0256k) it.next();
            if (!onlyRecursive || c0256k.f4682b) {
                c0256k.f4681a.onFragmentViewDestroyed(fragmentManager, f);
            }
        }
    }

    public final void registerFragmentLifecycleCallbacks(@NotNull FragmentManager.FragmentLifecycleCallbacks cb, boolean recursive) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.f4493b.add(new C0256k(cb, recursive));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        r4.f4493b.remove(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void unregisterFragmentLifecycleCallbacks(@NotNull FragmentManager.FragmentLifecycleCallbacks cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        synchronized (this.f4493b) {
            int size = this.f4493b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (((C0256k) this.f4493b.get(i)).f4681a == cb) {
                    break;
                } else {
                    i++;
                }
            }
        }
    }
}
