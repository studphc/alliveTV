package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.ThreadPoolExecutor;
import p000.RunnableC0552bc;
import p000.oo1;
import p000.ro1;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: j */
    public final ThreadPoolExecutor f6612j;

    /* renamed from: k */
    public volatile RunnableC0552bc f6613k;

    /* renamed from: l */
    public volatile RunnableC0552bc f6614l;

    /* renamed from: m */
    public long f6615m;

    /* renamed from: n */
    public long f6616n;

    /* renamed from: o */
    public Handler f6617o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncTaskLoader(@NonNull Context context) {
        super(context);
        ThreadPoolExecutor threadPoolExecutor = ro1.f26079f;
        this.f6616n = -10000L;
        this.f6612j = threadPoolExecutor;
    }

    /* renamed from: a */
    public final void m1546a() {
        if (this.f6614l == null && this.f6613k != null) {
            if (this.f6613k.f7960j) {
                this.f6613k.f7960j = false;
                this.f6617o.removeCallbacks(this.f6613k);
            }
            if (this.f6615m > 0 && SystemClock.uptimeMillis() < this.f6616n + this.f6615m) {
                this.f6613k.f7960j = true;
                this.f6617o.postAtTime(this.f6613k, this.f6616n + this.f6615m);
                return;
            }
            RunnableC0552bc runnableC0552bc = this.f6613k;
            ThreadPoolExecutor threadPoolExecutor = this.f6612j;
            if (runnableC0552bc.f26084c != ModernAsyncTask$Status.PENDING) {
                int i = oo1.f24848a[runnableC0552bc.f26084c.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    }
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            runnableC0552bc.f26084c = ModernAsyncTask$Status.RUNNING;
            runnableC0552bc.f26082a.getClass();
            threadPoolExecutor.execute(runnableC0552bc.f26083b);
        }
    }

    public void cancelLoadInBackground() {
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f6613k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f6613k);
            printWriter.print(" waiting=");
            printWriter.println(this.f6613k.f7960j);
        }
        if (this.f6614l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f6614l);
            printWriter.print(" waiting=");
            printWriter.println(this.f6614l.f7960j);
        }
        if (this.f6615m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.f6615m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.f6616n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.f6614l != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public abstract D loadInBackground();

    @Override // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        if (this.f6613k == null) {
            return false;
        }
        if (!this.f6630e) {
            this.f6633h = true;
        }
        if (this.f6614l != null) {
            if (this.f6613k.f7960j) {
                this.f6613k.f7960j = false;
                this.f6617o.removeCallbacks(this.f6613k);
            }
            this.f6613k = null;
            return false;
        }
        if (this.f6613k.f7960j) {
            this.f6613k.f7960j = false;
            this.f6617o.removeCallbacks(this.f6613k);
            this.f6613k = null;
            return false;
        }
        RunnableC0552bc runnableC0552bc = this.f6613k;
        runnableC0552bc.f26085d.set(true);
        boolean cancel = runnableC0552bc.f26083b.cancel(false);
        if (cancel) {
            this.f6614l = this.f6613k;
            cancelLoadInBackground();
        }
        this.f6613k = null;
        return cancel;
    }

    public void onCanceled(@Nullable D d) {
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.f6613k = new RunnableC0552bc(this);
        m1546a();
    }

    @Nullable
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.f6615m = j;
        if (j != 0) {
            this.f6617o = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        RunnableC0552bc runnableC0552bc = this.f6613k;
        if (runnableC0552bc != null) {
            try {
                runnableC0552bc.f7959i.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
