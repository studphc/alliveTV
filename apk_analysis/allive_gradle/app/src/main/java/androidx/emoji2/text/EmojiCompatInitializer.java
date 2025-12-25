package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import p000.AbstractC1774ru;
import p000.a80;
import p000.w00;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Boolean create(@NonNull Context context) {
        EmojiCompat.Config config = new EmojiCompat.Config(new C0240g(context));
        config.setMetadataLoadStrategy(1);
        EmojiCompat.init(config);
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                w00.m7954a(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                w00.m7955b(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                w00.m7956c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onResume(LifecycleOwner lifecycleOwner) {
                Handler handler;
                EmojiCompatInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = AbstractC1774ru.m7303a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new a80(0), 500L);
                lifecycle.removeObserver(this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                w00.m7958e(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                w00.m7959f(this, lifecycleOwner);
            }
        });
        return Boolean.TRUE;
    }
}
