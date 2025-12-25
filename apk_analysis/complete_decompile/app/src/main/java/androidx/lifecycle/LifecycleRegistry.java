package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\nR\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m5569d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "provider", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$State;", "state", "", "markState", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "handleLifecycleEvent", "(Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/LifecycleObserver;", "observer", "addObserver", "(Landroidx/lifecycle/LifecycleObserver;)V", "removeObserver", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "currentState", "", "getObserverCount", "()I", "observerCount", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b */
    public final boolean f6492b;

    /* renamed from: c */
    public FastSafeIterableMap f6493c;

    /* renamed from: d */
    public Lifecycle.State f6494d;

    /* renamed from: e */
    public final WeakReference f6495e;

    /* renamed from: f */
    public int f6496f;

    /* renamed from: g */
    public boolean f6497g;

    /* renamed from: h */
    public boolean f6498h;

    /* renamed from: i */
    public final ArrayList f6499i;

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, m5569d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/LifecycleRegistry;", "createUnsafe", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "min", "lifecycle-runtime_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @VisibleForTesting
        @NotNull
        public final LifecycleRegistry createUnsafe(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new LifecycleRegistry(owner, false, null);
        }

        @JvmStatic
        @NotNull
        public final Lifecycle.State min$lifecycle_runtime_release(@NotNull Lifecycle.State state1, @Nullable Lifecycle.State state2) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (state2 != null && state2.compareTo(state1) < 0) {
                return state2;
            }
            return state1;
        }
    }

    @Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, m5569d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "Landroidx/lifecycle/LifecycleObserver;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "initialState", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "", "dispatchEvent", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "a", "Landroidx/lifecycle/Lifecycle$State;", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "state", "Landroidx/lifecycle/LifecycleEventObserver;", "b", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "lifecycleObserver", "lifecycle-runtime_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class ObserverWithState {

        /* renamed from: a, reason: from kotlin metadata */
        public Lifecycle.State state;

        /* renamed from: b, reason: from kotlin metadata */
        public LifecycleEventObserver lifecycleObserver;

        public ObserverWithState(@Nullable LifecycleObserver lifecycleObserver, @NotNull Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(lifecycleObserver);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.state = initialState;
        }

        public final void dispatchEvent(@Nullable LifecycleOwner owner, @NotNull Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.INSTANCE.min$lifecycle_runtime_release(this.state, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull(owner);
            lifecycleEventObserver.onStateChanged(owner, event);
            this.state = targetState;
        }

        @NotNull
        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        @NotNull
        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(@NotNull LifecycleEventObserver lifecycleEventObserver) {
            Intrinsics.checkNotNullParameter(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void setState(@NotNull Lifecycle.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.state = state;
        }
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, z);
    }

    @JvmStatic
    @VisibleForTesting
    @NotNull
    public static final LifecycleRegistry createUnsafe(@NotNull LifecycleOwner lifecycleOwner) {
        return INSTANCE.createUnsafe(lifecycleOwner);
    }

    /* renamed from: a */
    public final Lifecycle.State m1522a(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        ObserverWithState observerWithState;
        Map.Entry ceil = this.f6493c.ceil(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (ceil != null && (observerWithState = (ObserverWithState) ceil.getValue()) != null) {
            state = observerWithState.getState();
        } else {
            state = null;
        }
        ArrayList arrayList = this.f6499i;
        if (!arrayList.isEmpty()) {
            state2 = (Lifecycle.State) AbstractC1726qj.m7053i(arrayList, 1);
        }
        Companion companion = INSTANCE;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.f6494d, state), state2);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NotNull LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        boolean z;
        Intrinsics.checkNotNullParameter(observer, "observer");
        m1523b("addObserver");
        Lifecycle.State state = this.f6494d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(observer, state2);
        if (((ObserverWithState) this.f6493c.putIfAbsent(observer, observerWithState)) != null || (lifecycleOwner = (LifecycleOwner) this.f6495e.get()) == null) {
            return;
        }
        if (this.f6496f == 0 && !this.f6497g) {
            z = false;
        } else {
            z = true;
        }
        Lifecycle.State m1522a = m1522a(observer);
        this.f6496f++;
        while (observerWithState.getState().compareTo(m1522a) < 0 && this.f6493c.contains(observer)) {
            this.f6499i.add(observerWithState.getState());
            Lifecycle.Event upFrom = Lifecycle.Event.INSTANCE.upFrom(observerWithState.getState());
            if (upFrom != null) {
                observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                ArrayList arrayList = this.f6499i;
                arrayList.remove(arrayList.size() - 1);
                m1522a = m1522a(observer);
            } else {
                throw new IllegalStateException("no event up from " + observerWithState.getState());
            }
        }
        if (!z) {
            m1525d();
        }
        this.f6496f--;
    }

    /* renamed from: b */
    public final void m1523b(String str) {
        if (this.f6492b && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(ye0.m8296p("Method ", str, " must be called on the main thread").toString());
        }
    }

    /* renamed from: c */
    public final void m1524c(Lifecycle.State state) {
        Lifecycle.State state2 = this.f6494d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f6494d + " in component " + this.f6495e.get()).toString());
        }
        this.f6494d = state;
        if (!this.f6497g && this.f6496f == 0) {
            this.f6497g = true;
            m1525d();
            this.f6497g = false;
            if (this.f6494d == Lifecycle.State.DESTROYED) {
                this.f6493c = new FastSafeIterableMap();
                return;
            }
            return;
        }
        this.f6498h = true;
    }

    /* renamed from: d */
    public final void m1525d() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f6495e.get();
        if (lifecycleOwner != null) {
            while (this.f6493c.size() != 0) {
                Map.Entry<K, V> eldest = this.f6493c.eldest();
                Intrinsics.checkNotNull(eldest);
                Lifecycle.State state = ((ObserverWithState) eldest.getValue()).getState();
                Map.Entry<K, V> newest = this.f6493c.newest();
                Intrinsics.checkNotNull(newest);
                Lifecycle.State state2 = ((ObserverWithState) newest.getValue()).getState();
                if (state == state2 && this.f6494d == state2) {
                    break;
                }
                this.f6498h = false;
                Lifecycle.State state3 = this.f6494d;
                Map.Entry<K, V> eldest2 = this.f6493c.eldest();
                Intrinsics.checkNotNull(eldest2);
                if (state3.compareTo(((ObserverWithState) eldest2.getValue()).getState()) < 0) {
                    Iterator<Map.Entry<K, V>> descendingIterator = this.f6493c.descendingIterator();
                    Intrinsics.checkNotNullExpressionValue(descendingIterator, "observerMap.descendingIterator()");
                    while (descendingIterator.hasNext() && !this.f6498h) {
                        Map.Entry entry = (Map.Entry) descendingIterator.next();
                        Intrinsics.checkNotNullExpressionValue(entry, "next()");
                        LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
                        ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
                        while (observerWithState.getState().compareTo(this.f6494d) > 0 && !this.f6498h && this.f6493c.contains(lifecycleObserver)) {
                            Lifecycle.Event downFrom = Lifecycle.Event.INSTANCE.downFrom(observerWithState.getState());
                            if (downFrom != null) {
                                this.f6499i.add(downFrom.getTargetState());
                                observerWithState.dispatchEvent(lifecycleOwner, downFrom);
                                this.f6499i.remove(r4.size() - 1);
                            } else {
                                throw new IllegalStateException("no event down from " + observerWithState.getState());
                            }
                        }
                    }
                }
                Map.Entry<K, V> newest2 = this.f6493c.newest();
                if (!this.f6498h && newest2 != 0 && this.f6494d.compareTo(((ObserverWithState) newest2.getValue()).getState()) > 0) {
                    SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.f6493c.iteratorWithAdditions();
                    Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "observerMap.iteratorWithAdditions()");
                    while (iteratorWithAdditions.hasNext() && !this.f6498h) {
                        Map.Entry next = iteratorWithAdditions.next();
                        LifecycleObserver lifecycleObserver2 = (LifecycleObserver) next.getKey();
                        ObserverWithState observerWithState2 = (ObserverWithState) next.getValue();
                        while (observerWithState2.getState().compareTo(this.f6494d) < 0 && !this.f6498h && this.f6493c.contains(lifecycleObserver2)) {
                            this.f6499i.add(observerWithState2.getState());
                            Lifecycle.Event upFrom = Lifecycle.Event.INSTANCE.upFrom(observerWithState2.getState());
                            if (upFrom != null) {
                                observerWithState2.dispatchEvent(lifecycleOwner, upFrom);
                                this.f6499i.remove(r4.size() - 1);
                            } else {
                                throw new IllegalStateException("no event up from " + observerWithState2.getState());
                            }
                        }
                    }
                }
            }
            this.f6498h = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    @NotNull
    /* renamed from: getCurrentState, reason: from getter */
    public Lifecycle.State getF6494d() {
        return this.f6494d;
    }

    public int getObserverCount() {
        m1523b("getObserverCount");
        return this.f6493c.size();
    }

    public void handleLifecycleEvent(@NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        m1523b("handleLifecycleEvent");
        m1524c(event.getTargetState());
    }

    @Deprecated(message = "Override [currentState].")
    @MainThread
    public void markState(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        m1523b("markState");
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NotNull LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        m1523b("removeObserver");
        this.f6493c.remove(observer);
    }

    public void setCurrentState(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        m1523b("setCurrentState");
        m1524c(state);
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        this.f6492b = z;
        this.f6493c = new FastSafeIterableMap();
        this.f6494d = Lifecycle.State.INITIALIZED;
        this.f6499i = new ArrayList();
        this.f6495e = new WeakReference(lifecycleOwner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(@NotNull LifecycleOwner provider) {
        this(provider, true);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
