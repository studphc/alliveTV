package androidx.activity;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.RunnableC0006a5;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\nR\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5569d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "Ljava/util/concurrent/Executor;", "executor", "Lkotlin/Function0;", "", "reportFullyDrawn", "<init>", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "addReporter", "()V", "removeReporter", "callback", "addOnReportDrawnListener", "(Lkotlin/jvm/functions/Function0;)V", "removeOnReportDrawnListener", "fullyDrawnReported", "", "isFullyDrawnReported", "()Z", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,190:1\n1#2:191\n1855#3,2:192\n*S KotlinDebug\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n*L\n154#1:192,2\n*E\n"})
/* loaded from: classes.dex */
public final class FullyDrawnReporter {

    /* renamed from: a */
    public final Executor f487a;

    /* renamed from: b */
    public final Function0 f488b;

    /* renamed from: c */
    public final Object f489c;

    /* renamed from: d */
    public int f490d;

    /* renamed from: e */
    public boolean f491e;

    /* renamed from: f */
    public boolean f492f;

    /* renamed from: g */
    public final ArrayList f493g;

    /* renamed from: h */
    public final RunnableC0006a5 f494h;

    public FullyDrawnReporter(@NotNull Executor executor, @NotNull Function0<Unit> reportFullyDrawn) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(reportFullyDrawn, "reportFullyDrawn");
        this.f487a = executor;
        this.f488b = reportFullyDrawn;
        this.f489c = new Object();
        this.f493g = new ArrayList();
        this.f494h = new RunnableC0006a5(20, this);
    }

    public final void addOnReportDrawnListener(@NotNull Function0<Unit> callback) {
        boolean z;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f489c) {
            if (this.f492f) {
                z = true;
            } else {
                this.f493g.add(callback);
                z = false;
            }
        }
        if (z) {
            callback.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.f489c) {
            if (!this.f492f) {
                this.f490d++;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.f489c) {
            try {
                this.f492f = true;
                Iterator it = this.f493g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f493g.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z;
        synchronized (this.f489c) {
            z = this.f492f;
        }
        return z;
    }

    public final void removeOnReportDrawnListener(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f489c) {
            this.f493g.remove(callback);
        }
    }

    public final void removeReporter() {
        int i;
        synchronized (this.f489c) {
            if (!this.f492f && (i = this.f490d) > 0) {
                int i2 = i - 1;
                this.f490d = i2;
                if (!this.f491e && i2 == 0) {
                    this.f491e = true;
                    this.f487a.execute(this.f494h);
                }
            }
        }
    }
}
