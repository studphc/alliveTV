package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ReportFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.RunnableC0006a5;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u0019J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, m5569d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "", "activityStarted$lifecycle_process_release", "()V", "activityStarted", "activityResumed$lifecycle_process_release", "activityResumed", "activityPaused$lifecycle_process_release", "activityPaused", "activityStopped$lifecycle_process_release", "activityStopped", "dispatchPauseIfNeeded$lifecycle_process_release", "dispatchPauseIfNeeded", "dispatchStopIfNeeded$lifecycle_process_release", "dispatchStopIfNeeded", "Landroid/content/Context;", "context", "attach$lifecycle_process_release", "(Landroid/content/Context;)V", "attach", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Companion", "Api29Impl", "lifecycle-process_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {
    public static final long TIMEOUT_MS = 700;

    /* renamed from: a */
    public int f6520a;

    /* renamed from: b */
    public int f6521b;

    /* renamed from: e */
    public Handler f6524e;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i */
    public static final ProcessLifecycleOwner f6519i = new ProcessLifecycleOwner();

    /* renamed from: c */
    public boolean f6522c = true;

    /* renamed from: d */
    public boolean f6523d = true;

    /* renamed from: f */
    public final LifecycleRegistry f6525f = new LifecycleRegistry(this);

    /* renamed from: g */
    public final RunnableC0006a5 f6526g = new RunnableC0006a5(26, this);

    /* renamed from: h */
    public final ProcessLifecycleOwner$initializationListener$1 f6527h = new ReportFragment.ActivityInitializationListener() { // from class: androidx.lifecycle.ProcessLifecycleOwner$initializationListener$1
        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner.this.activityResumed$lifecycle_process_release();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner.this.activityStarted$lifecycle_process_release();
        }
    };

    @RequiresApi(29)
    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Api29Impl;", "", "Landroid/app/Activity;", "activity", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "", "registerActivityLifecycleCallbacks", "(Landroid/app/Activity;Landroid/app/Application$ActivityLifecycleCallbacks;)V", "lifecycle-process_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Api29Impl {

        @NotNull
        public static final Api29Impl INSTANCE = new Object();

        @JvmStatic
        @DoNotInline
        public static final void registerActivityLifecycleCallbacks(@NotNull Activity activity, @NotNull Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    @Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0081T¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5569d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Companion;", "", "Landroidx/lifecycle/LifecycleOwner;", "get", "()Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "", "init$lifecycle_process_release", "(Landroid/content/Context;)V", "init", "", "TIMEOUT_MS", "J", "getTIMEOUT_MS$lifecycle_process_release$annotations", "()V", "Landroidx/lifecycle/ProcessLifecycleOwner;", "newInstance", "Landroidx/lifecycle/ProcessLifecycleOwner;", "lifecycle-process_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @VisibleForTesting
        public static /* synthetic */ void getTIMEOUT_MS$lifecycle_process_release$annotations() {
        }

        @JvmStatic
        @NotNull
        public final LifecycleOwner get() {
            return ProcessLifecycleOwner.f6519i;
        }

        @JvmStatic
        public final void init$lifecycle_process_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ProcessLifecycleOwner.f6519i.attach$lifecycle_process_release(context);
        }
    }

    @JvmStatic
    @NotNull
    public static final LifecycleOwner get() {
        return INSTANCE.get();
    }

    public final void activityPaused$lifecycle_process_release() {
        int i = this.f6521b - 1;
        this.f6521b = i;
        if (i == 0) {
            Handler handler = this.f6524e;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(this.f6526g, 700L);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int i = this.f6521b + 1;
        this.f6521b = i;
        if (i == 1) {
            if (this.f6522c) {
                this.f6525f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.f6522c = false;
            } else {
                Handler handler = this.f6524e;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.f6526g);
            }
        }
    }

    public final void activityStarted$lifecycle_process_release() {
        int i = this.f6520a + 1;
        this.f6520a = i;
        if (i == 1 && this.f6523d) {
            this.f6525f.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.f6523d = false;
        }
    }

    public final void activityStopped$lifecycle_process_release() {
        this.f6520a--;
        dispatchStopIfNeeded$lifecycle_process_release();
    }

    public final void attach$lifecycle_process_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6524e = new Handler();
        this.f6525f.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1
            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
                ReportFragment.ActivityInitializationListener activityInitializationListener;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment reportFragment = ReportFragment.INSTANCE.get(activity);
                    activityInitializationListener = ProcessLifecycleOwner.this.f6527h;
                    reportFragment.setProcessListener(activityInitializationListener);
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ProcessLifecycleOwner.this.activityPaused$lifecycle_process_release();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            @RequiresApi(29)
            public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                final ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.this;
                ProcessLifecycleOwner.Api29Impl.registerActivityLifecycleCallbacks(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(@NotNull Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        ProcessLifecycleOwner.this.activityResumed$lifecycle_process_release();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(@NotNull Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        ProcessLifecycleOwner.this.activityStarted$lifecycle_process_release();
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ProcessLifecycleOwner.this.activityStopped$lifecycle_process_release();
            }
        });
    }

    public final void dispatchPauseIfNeeded$lifecycle_process_release() {
        if (this.f6521b == 0) {
            this.f6522c = true;
            this.f6525f.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void dispatchStopIfNeeded$lifecycle_process_release() {
        if (this.f6520a == 0 && this.f6522c) {
            this.f6525f.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.f6523d = true;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.f6525f;
    }
}
