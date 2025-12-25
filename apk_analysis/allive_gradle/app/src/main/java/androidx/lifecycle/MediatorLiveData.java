package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
import p000.xm1;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: l */
    public final SafeIterableMap f6517l;

    public MediatorLiveData() {
        this.f6517l = new SafeIterableMap();
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        if (liveData != null) {
            xm1 xm1Var = new xm1(liveData, observer);
            xm1 xm1Var2 = (xm1) this.f6517l.putIfAbsent(liveData, xm1Var);
            if (xm1Var2 != null && xm1Var2.f28628b != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            }
            if (xm1Var2 == null && hasActiveObservers()) {
                liveData.observeForever(xm1Var);
                return;
            }
            return;
        }
        throw new NullPointerException("source cannot be null");
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Iterator it = this.f6517l.iterator();
        while (it.hasNext()) {
            xm1 xm1Var = (xm1) ((Map.Entry) it.next()).getValue();
            xm1Var.f28627a.observeForever(xm1Var);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Iterator it = this.f6517l.iterator();
        while (it.hasNext()) {
            xm1 xm1Var = (xm1) ((Map.Entry) it.next()).getValue();
            xm1Var.f28627a.removeObserver(xm1Var);
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        xm1 xm1Var = (xm1) this.f6517l.remove(liveData);
        if (xm1Var != null) {
            xm1Var.f28627a.removeObserver(xm1Var);
        }
    }

    public MediatorLiveData(T t) {
        super(t);
        this.f6517l = new SafeIterableMap();
    }
}
