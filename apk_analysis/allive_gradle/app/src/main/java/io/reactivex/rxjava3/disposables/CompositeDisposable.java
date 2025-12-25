package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {

    /* renamed from: a */
    public OpenHashSet f18506a;

    /* renamed from: b */
    public volatile boolean f18507b;

    public CompositeDisposable() {
    }

    /* renamed from: a */
    public static void m5268a(OpenHashSet openHashSet) {
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : openHashSet.keys()) {
            if (obj instanceof Disposable) {
                try {
                    ((Disposable) obj).dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
    public boolean add(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        if (!this.f18507b) {
            synchronized (this) {
                try {
                    if (!this.f18507b) {
                        OpenHashSet openHashSet = this.f18506a;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet();
                            this.f18506a = openHashSet;
                        }
                        openHashSet.add(disposable);
                        return true;
                    }
                } finally {
                }
            }
        }
        disposable.dispose();
        return false;
    }

    public boolean addAll(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        if (!this.f18507b) {
            synchronized (this) {
                try {
                    if (!this.f18507b) {
                        OpenHashSet openHashSet = this.f18506a;
                        if (openHashSet == null) {
                            openHashSet = new OpenHashSet(disposableArr.length + 1);
                            this.f18506a = openHashSet;
                        }
                        for (Disposable disposable : disposableArr) {
                            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
                            openHashSet.add(disposable);
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
        if (this.f18507b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f18507b) {
                    return;
                }
                OpenHashSet openHashSet = this.f18506a;
                this.f18506a = null;
                m5268a(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean delete(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        if (this.f18507b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f18507b) {
                    return false;
                }
                OpenHashSet openHashSet = this.f18506a;
                if (openHashSet != null && openHashSet.remove(disposable)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        if (this.f18507b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f18507b) {
                    return;
                }
                this.f18507b = true;
                OpenHashSet openHashSet = this.f18506a;
                this.f18506a = null;
                m5268a(openHashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f18507b;
    }

    @Override // io.reactivex.rxjava3.disposables.DisposableContainer
    public boolean remove(@NonNull Disposable disposable) {
        if (delete(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    public int size() {
        int i = 0;
        if (this.f18507b) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.f18507b) {
                    return 0;
                }
                OpenHashSet openHashSet = this.f18506a;
                if (openHashSet != null) {
                    i = openHashSet.size();
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CompositeDisposable(@NonNull Disposable... disposableArr) {
        Objects.requireNonNull(disposableArr, "disposables is null");
        this.f18506a = new OpenHashSet(disposableArr.length + 1);
        for (Disposable disposable : disposableArr) {
            Objects.requireNonNull(disposable, "A Disposable in the disposables array is null");
            this.f18506a.add(disposable);
        }
    }

    public CompositeDisposable(@NonNull Iterable<? extends Disposable> iterable) {
        Objects.requireNonNull(iterable, "disposables is null");
        this.f18506a = new OpenHashSet();
        for (Disposable disposable : iterable) {
            Objects.requireNonNull(disposable, "A Disposable item in the disposables sequence is null");
            this.f18506a.add(disposable);
        }
    }
}
