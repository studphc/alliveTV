package p000;

import android.os.AsyncTask;
import androidx.recyclerview.widget.C0471f;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.TileList$Tile;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class tn1 implements ThreadUtil$BackgroundCallback {

    /* renamed from: a */
    public final C1540m9 f26900a = new C1540m9(18);

    /* renamed from: b */
    public final Executor f26901b = AsyncTask.THREAD_POOL_EXECUTOR;

    /* renamed from: c */
    public final AtomicBoolean f26902c = new AtomicBoolean(false);

    /* renamed from: d */
    public final sn1 f26903d = new sn1(0, this);

    /* renamed from: e */
    public final /* synthetic */ C0471f f26904e;

    public tn1(C0471f c0471f) {
        this.f26904e = c0471f;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void loadTile(int i, int i2) {
        this.f26900a.m6108r(un1.m7757b(3, i, i2, 0, 0, 0, null));
        if (this.f26902c.compareAndSet(false, true)) {
            this.f26901b.execute(this.f26903d);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void recycleTile(TileList$Tile tileList$Tile) {
        this.f26900a.m6108r(un1.m7757b(4, 0, 0, 0, 0, 0, tileList$Tile));
        if (this.f26902c.compareAndSet(false, true)) {
            this.f26901b.execute(this.f26903d);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void refresh(int i) {
        un1 m7757b = un1.m7757b(1, i, 0, 0, 0, 0, null);
        C1540m9 c1540m9 = this.f26900a;
        synchronized (c1540m9.f22855c) {
            m7757b.f27392g = (un1) c1540m9.f22854b;
            c1540m9.f22854b = m7757b;
        }
        if (this.f26902c.compareAndSet(false, true)) {
            this.f26901b.execute(this.f26903d);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void updateRange(int i, int i2, int i3, int i4, int i5) {
        un1 m7757b = un1.m7757b(2, i, i2, i3, i4, i5, null);
        C1540m9 c1540m9 = this.f26900a;
        synchronized (c1540m9.f22855c) {
            m7757b.f27392g = (un1) c1540m9.f22854b;
            c1540m9.f22854b = m7757b;
        }
        if (this.f26902c.compareAndSet(false, true)) {
            this.f26901b.execute(this.f26903d);
        }
    }
}
