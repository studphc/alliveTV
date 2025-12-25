package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {

    /* loaded from: classes.dex */
    public static class Result {
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Result create(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: o72
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Handler handler;
                ProfileInstallerInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = AbstractC1534m3.m6028j(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new RunnableC1613o8(applicationContext, 2), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new Result();
    }
}
