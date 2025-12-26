package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    public LinkedList f18515a;

    /* renamed from: b */
    public volatile boolean f18516b;

    public ListCompositeDisposable() {
    }

    /* renamed from: a */
    public static void m5271a(LinkedList linkedList) {
        if (linkedList == null) {
            return;
        }
        Iterator it = linkedList.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((Disposable) it.next()).dispose();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean add(Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        if (!this.f18516b) {
            synchronized (this) {
                try {
                    if (!this.f18516b) {
                        LinkedList linkedList = this.f18515a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f18515a = linkedList;
                        }
                        linkedList.add(disposable);
                        return true;
                    }
                } finally {
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "ds is null");
        if (!this.f18516b) {
            synchronized (this) {
                try {
                    if (!this.f18516b) {
                        LinkedList linkedList = this.f18515a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f18515a = linkedList;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "d is null");
                            linkedList.add(disposable);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        for (Disposable disposable2 : disposableArr) {
            disposable2.dispose();
        }
        return false;
    }

    public void clear() {
        if (this.f18516b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f18516b) {
                    return;
                }
                LinkedList linkedList = this.f18515a;
                this.f18515a = null;
                m5271a(linkedList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean delete(Disposable disposable) {
        Objects.requireNonNull(disposable, "Disposable item is null");
        if (this.f18516b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f18516b) {
                    return false;
                }
                LinkedList linkedList = this.f18515a;
                if (linkedList != null && linkedList.remove(disposable)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        if (this.f18516b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f18516b) {
                    return;
                }
                this.f18516b = true;
                LinkedList linkedList = this.f18515a;
                this.f18515a = null;
                m5271a(linkedList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f18516b;
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean remove(Disposable disposable) {
        if (delete(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    public ListCompositeDisposable(Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "resources is null");
        this.f18515a = new LinkedList();
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.f18515a.add(disposable);
        }
    }

    public ListCompositeDisposable(Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "resources is null");
        this.f18515a = new LinkedList();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "Disposable item is null");
            this.f18515a.add(disposable);
        }
    }
}
