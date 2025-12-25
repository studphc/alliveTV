package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import p000.ExecutorC2014yb;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {

    /* renamed from: h */
    public static final ExecutorC2014yb f6930h = new ExecutorC2014yb();

    /* renamed from: a */
    public final ListUpdateCallback f6931a;

    /* renamed from: b */
    public final AsyncDifferConfig f6932b;

    /* renamed from: c */
    public final Executor f6933c;

    /* renamed from: d */
    public final CopyOnWriteArrayList f6934d;

    /* renamed from: e */
    public List f6935e;

    /* renamed from: f */
    public List f6936f;

    /* renamed from: g */
    public int f6937g;

    /* loaded from: classes.dex */
    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    /* renamed from: a */
    public final void m1604a(List list, Runnable runnable) {
        Iterator it = this.f6934d.iterator();
        while (it.hasNext()) {
            ((ListListener) it.next()).onCurrentListChanged(list, this.f6936f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.f6934d.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f6936f;
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.f6934d.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        int i = this.f6937g + 1;
        this.f6937g = i;
        List<T> list2 = this.f6935e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List list3 = this.f6936f;
        ListUpdateCallback listUpdateCallback = this.f6931a;
        if (list == null) {
            int size = list2.size();
            this.f6935e = null;
            this.f6936f = Collections.emptyList();
            listUpdateCallback.onRemoved(0, size);
            m1604a(list3, runnable);
            return;
        }
        if (list2 == null) {
            this.f6935e = list;
            this.f6936f = Collections.unmodifiableList(list);
            listUpdateCallback.onInserted(0, list.size());
            m1604a(list3, runnable);
            return;
        }
        this.f6932b.getBackgroundThreadExecutor().execute(new RunnableC0465d(this, list2, list, i, runnable));
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f6934d = new CopyOnWriteArrayList();
        this.f6936f = Collections.emptyList();
        this.f6931a = listUpdateCallback;
        this.f6932b = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.f6933c = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.f6933c = f6930h;
        }
    }
}
