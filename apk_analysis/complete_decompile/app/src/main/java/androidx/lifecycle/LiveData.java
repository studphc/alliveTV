package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;
import p000.RunnableC1104d;
import p000.wa1;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k */
    public static final Object f6504k = new Object();

    /* renamed from: a */
    public final Object f6505a;

    /* renamed from: b */
    public final SafeIterableMap f6506b;

    /* renamed from: c */
    public int f6507c;

    /* renamed from: d */
    public boolean f6508d;

    /* renamed from: e */
    public volatile Object f6509e;

    /* renamed from: f */
    public volatile Object f6510f;

    /* renamed from: g */
    public int f6511g;

    /* renamed from: h */
    public boolean f6512h;

    /* renamed from: i */
    public boolean f6513i;

    /* renamed from: j */
    public final RunnableC1104d f6514j;

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends wa1 implements LifecycleEventObserver {

        /* renamed from: e */
        public final LifecycleOwner f6515e;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer observer) {
            super(LiveData.this, observer);
            this.f6515e = lifecycleOwner;
        }

        @Override // p000.wa1
        /* renamed from: b */
        public final void mo1531b() {
            this.f6515e.getLifecycle().removeObserver(this);
        }

        @Override // p000.wa1
        /* renamed from: c */
        public final boolean mo1532c(LifecycleOwner lifecycleOwner) {
            if (this.f6515e == lifecycleOwner) {
                return true;
            }
            return false;
        }

        @Override // p000.wa1
        /* renamed from: d */
        public final boolean mo1533d() {
            return this.f6515e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecycleOwner lifecycleOwner2 = this.f6515e;
            Lifecycle.State currentState = lifecycleOwner2.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f28116a);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                m8018a(mo1533d());
                state = currentState;
                currentState = lifecycleOwner2.getLifecycle().getCurrentState();
            }
        }
    }

    public LiveData(T t) {
        this.f6505a = new Object();
        this.f6506b = new SafeIterableMap();
        this.f6507c = 0;
        this.f6510f = f6504k;
        this.f6514j = new RunnableC1104d(26, this);
        this.f6509e = t;
        this.f6511g = 0;
    }

    /* renamed from: a */
    public static void m1528a(String str) {
        if (ArchTaskExecutor.getInstance().isMainThread()) {
        } else {
            throw new IllegalStateException(ye0.m8296p("Cannot invoke ", str, " on a background thread"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m1529b(wa1 wa1Var) {
        if (!wa1Var.f28117b) {
            return;
        }
        if (!wa1Var.mo1533d()) {
            wa1Var.m8018a(false);
            return;
        }
        int i = wa1Var.f28118c;
        int i2 = this.f6511g;
        if (i >= i2) {
            return;
        }
        wa1Var.f28118c = i2;
        wa1Var.f28116a.onChanged(this.f6509e);
    }

    /* renamed from: c */
    public final void m1530c(wa1 wa1Var) {
        if (this.f6512h) {
            this.f6513i = true;
            return;
        }
        this.f6512h = true;
        do {
            this.f6513i = false;
            if (wa1Var != null) {
                m1529b(wa1Var);
                wa1Var = null;
            } else {
                SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.f6506b.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    m1529b((wa1) iteratorWithAdditions.next().getValue());
                    if (this.f6513i) {
                        break;
                    }
                }
            }
        } while (this.f6513i);
        this.f6512h = false;
    }

    @Nullable
    public T getValue() {
        T t = (T) this.f6509e;
        if (t != f6504k) {
            return t;
        }
        return null;
    }

    public boolean hasActiveObservers() {
        if (this.f6507c > 0) {
            return true;
        }
        return false;
    }

    public boolean hasObservers() {
        if (this.f6506b.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isInitialized() {
        if (this.f6509e != f6504k) {
            return true;
        }
        return false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        m1528a("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        wa1 wa1Var = (wa1) this.f6506b.putIfAbsent(observer, lifecycleBoundObserver);
        if (wa1Var != null && !wa1Var.mo1532c(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (wa1Var != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    @MainThread
    public void observeForever(@NonNull Observer<? super T> observer) {
        m1528a("observeForever");
        wa1 wa1Var = new wa1(this, observer);
        wa1 wa1Var2 = (wa1) this.f6506b.putIfAbsent(observer, wa1Var);
        if (!(wa1Var2 instanceof LifecycleBoundObserver)) {
            if (wa1Var2 != null) {
                return;
            }
            wa1Var.m8018a(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.f6505a) {
            if (this.f6510f == f6504k) {
                z = true;
            } else {
                z = false;
            }
            this.f6510f = t;
        }
        if (!z) {
            return;
        }
        ArchTaskExecutor.getInstance().postToMainThread(this.f6514j);
    }

    @MainThread
    public void removeObserver(@NonNull Observer<? super T> observer) {
        m1528a("removeObserver");
        wa1 wa1Var = (wa1) this.f6506b.remove(observer);
        if (wa1Var == null) {
            return;
        }
        wa1Var.mo1531b();
        wa1Var.m8018a(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner lifecycleOwner) {
        m1528a("removeObservers");
        Iterator it = this.f6506b.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((wa1) entry.getValue()).mo1532c(lifecycleOwner)) {
                removeObserver((Observer) entry.getKey());
            }
        }
    }

    @MainThread
    public void setValue(T t) {
        m1528a("setValue");
        this.f6511g++;
        this.f6509e = t;
        m1530c(null);
    }

    public LiveData() {
        this.f6505a = new Object();
        this.f6506b = new SafeIterableMap();
        this.f6507c = 0;
        Object obj = f6504k;
        this.f6510f = obj;
        this.f6514j = new RunnableC1104d(26, this);
        this.f6509e = obj;
        this.f6511g = -1;
    }
}
