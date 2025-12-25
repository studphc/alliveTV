package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0010a9;
import p000.u02;
import p000.v02;
import p000.w02;
import p000.x02;

@Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0004$%&'B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\fH\u0007¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0007¢\u0006\u0004\b#\u0010\"¨\u0006("}, m5569d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "Ljava/lang/Runnable;", "fallbackOnBackPressed", "Landroidx/core/util/Consumer;", "", "onHasEnabledCallbacksChanged", "<init>", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "(Ljava/lang/Runnable;)V", "Landroid/window/OnBackInvokedDispatcher;", "invoker", "", "setOnBackInvokedDispatcher", "(Landroid/window/OnBackInvokedDispatcher;)V", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "addCallback", "(Landroidx/activity/OnBackPressedCallback;)V", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "(Landroidx/activity/OnBackPressedCallback;)Landroidx/activity/Cancellable;", "addCancellableCallback", "Landroidx/lifecycle/LifecycleOwner;", "owner", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V", "hasEnabledCallbacks", "()Z", "Landroidx/activity/BackEventCompat;", "backEvent", "dispatchOnBackStarted", "(Landroidx/activity/BackEventCompat;)V", "dispatchOnBackProgressed", "onBackPressed", "()V", "dispatchOnBackCancelled", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "w02", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,430:1\n1747#2,3:431\n533#2,6:434\n533#2,6:440\n533#2,6:446\n533#2,6:452\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n114#1:431,3\n233#1:434,6\n251#1:440,6\n271#1:446,6\n290#1:452,6\n*E\n"})
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    public final Runnable f503a;

    /* renamed from: b */
    public final Consumer f504b;

    /* renamed from: c */
    public final ArrayDeque f505c;

    /* renamed from: d */
    public OnBackPressedCallback f506d;

    /* renamed from: e */
    public final OnBackInvokedCallback f507e;

    /* renamed from: f */
    public OnBackInvokedDispatcher f508f;

    /* renamed from: g */
    public boolean f509g;

    /* renamed from: h */
    public boolean f510h;

    @RequiresApi(33)
    @Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "dispatcher", "", "priority", "callback", "", "registerOnBackInvokedCallback", "(Ljava/lang/Object;ILjava/lang/Object;)V", "unregisterOnBackInvokedCallback", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function0;", "onBackInvoked", "Landroid/window/OnBackInvokedCallback;", "createOnBackInvokedCallback", "(Lkotlin/jvm/functions/Function0;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Api33Impl {

        @NotNull
        public static final Api33Impl INSTANCE = new Object();

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback createOnBackInvokedCallback(@NotNull Function0<Unit> onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new C0010a9(1, onBackInvoked);
        }

        @DoNotInline
        public final void registerOnBackInvokedCallback(@NotNull Object dispatcher, int priority, @NotNull Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(priority, (OnBackInvokedCallback) callback);
        }

        @DoNotInline
        public final void unregisterOnBackInvokedCallback(@NotNull Object dispatcher, @NotNull Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    @RequiresApi(34)
    @Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001Jq\u0010\u000e\u001a\u00020\r2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "backEvent", "", "onBackStarted", "onBackProgressed", "Lkotlin/Function0;", "onBackInvoked", "onBackCancelled", "Landroid/window/OnBackInvokedCallback;", "createOnBackAnimationCallback", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Api34Impl {

        @NotNull
        public static final Api34Impl INSTANCE = new Object();

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback createOnBackAnimationCallback(@NotNull final Function1<? super BackEventCompat, Unit> onBackStarted, @NotNull final Function1<? super BackEventCompat, Unit> onBackProgressed, @NotNull final Function0<Unit> onBackInvoked, @NotNull final Function0<Unit> onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public void onBackProgressed(@NotNull BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public void onBackStarted(@NotNull BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    Function1.this.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    @Metadata(m5568d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, m5569d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: a */
        public final Lifecycle f515a;

        /* renamed from: b */
        public final OnBackPressedCallback f516b;

        /* renamed from: c */
        public Cancellable f517c;

        /* renamed from: d */
        public final /* synthetic */ OnBackPressedDispatcher f518d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.f518d = onBackPressedDispatcher;
            this.f515a = lifecycle;
            this.f516b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            this.f515a.removeObserver(this);
            this.f516b.removeCancellable(this);
            Cancellable cancellable = this.f517c;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.f517c = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f517c = this.f518d.addCancellableCallback$activity_release(this.f516b);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.f517c;
                if (cancellable != null) {
                    cancellable.cancel();
                    return;
                }
                return;
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    @JvmOverloads
    public OnBackPressedDispatcher() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* renamed from: a */
    public final void m145a() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.f506d;
        if (onBackPressedCallback2 == null) {
            ArrayDeque arrayDeque = this.f505c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallback).getIsEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = 0;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.f506d = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackCancelled();
        }
    }

    @MainThread
    public final void addCallback(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    @NotNull
    public final Cancellable addCancellableCallback$activity_release(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f505c.add(onBackPressedCallback);
        w02 w02Var = new w02(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(w02Var);
        m149e();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new x02(0, this, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 1));
        return w02Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* renamed from: b */
    public final void m146b(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.f506d;
        if (onBackPressedCallback2 == null) {
            ArrayDeque arrayDeque = this.f505c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallback).getIsEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = 0;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackProgressed(backEventCompat);
        }
    }

    /* renamed from: c */
    public final void m147c(BackEventCompat backEventCompat) {
        Object obj;
        ArrayDeque arrayDeque = this.f505c;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                obj = listIterator.previous();
                if (((OnBackPressedCallback) obj).getIsEnabled()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        this.f506d = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEventCompat);
        }
    }

    /* renamed from: d */
    public final void m148d(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f508f;
        OnBackInvokedCallback onBackInvokedCallback = this.f507e;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z && !this.f509g) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f509g = true;
            } else if (!z && this.f509g) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f509g = false;
            }
        }
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackCancelled() {
        m145a();
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(@NotNull BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        m146b(backEvent);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(@NotNull BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        m147c(backEvent);
    }

    /* renamed from: e */
    public final void m149e() {
        boolean z = this.f510h;
        ArrayDeque arrayDeque = this.f505c;
        boolean z2 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((OnBackPressedCallback) it.next()).getIsEnabled()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.f510h = z2;
        if (z2 != z) {
            Consumer consumer = this.f504b;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                m148d(z2);
            }
        }
    }

    @MainThread
    /* renamed from: hasEnabledCallbacks, reason: from getter */
    public final boolean getF510h() {
        return this.f510h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    @MainThread
    public final void onBackPressed() {
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedCallback onBackPressedCallback2 = this.f506d;
        if (onBackPressedCallback2 == null) {
            ArrayDeque arrayDeque = this.f505c;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    onBackPressedCallback = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallback).getIsEnabled()) {
                        break;
                    }
                } else {
                    onBackPressedCallback = 0;
                    break;
                }
            }
            onBackPressedCallback2 = onBackPressedCallback;
        }
        this.f506d = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f503a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(@NotNull OnBackInvokedDispatcher invoker) {
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        this.f508f = invoker;
        m148d(this.f510h);
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable, @Nullable Consumer<Boolean> consumer) {
        OnBackInvokedCallback createOnBackInvokedCallback;
        this.f503a = runnable;
        this.f504b = consumer;
        this.f505c = new ArrayDeque();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                createOnBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new u02(this, 0), new u02(this, 1), new v02(this, 0), new v02(this, 1));
            } else {
                createOnBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new v02(this, 2));
            }
            this.f507e = createOnBackInvokedCallback;
        }
    }

    @MainThread
    public final void addCallback(@NotNull LifecycleOwner owner, @NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getF6494d() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        m149e();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new x02(0, this, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runnable);
    }

    @JvmOverloads
    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this(runnable, null);
    }
}
