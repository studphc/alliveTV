package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Set;
import java.util.concurrent.Executor;
import p000.C0533au;
import p000.C1523lt;
import p000.j01;
import p000.r00;

/* loaded from: classes2.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* renamed from: a */
    public final C0533au f15559a;

    /* renamed from: b */
    public final Context f15560b;

    /* renamed from: c */
    public final Provider f15561c;

    /* renamed from: d */
    public final Set f15562d;

    /* renamed from: e */
    public final Executor f15563e;

    public DefaultHeartBeatController(Context context, String str, Set set, Provider provider, Executor executor) {
        this.f15559a = new C0533au(1, context, str);
        this.f15562d = set;
        this.f15563e = executor;
        this.f15561c = provider;
        this.f15560b = context;
    }

    @NonNull
    public static Component<DefaultHeartBeatController> component() {
        Qualified qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.setOf((Class<?>) HeartBeatConsumer.class)).add(Dependency.requiredProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.required((Qualified<?>) qualified)).factory(new C1523lt(1, qualified)).build();
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        j01 j01Var = (j01) this.f15559a.get();
        if (j01Var.m5378i(currentTimeMillis)) {
            j01Var.m5376g();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task<String> getHeartBeatsHeader() {
        if (!UserManagerCompat.isUserUnlocked(this.f15560b)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.f15563e, new r00(this, 0));
    }

    public Task<Void> registerHeartBeat() {
        if (this.f15562d.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.f15560b)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.f15563e, new r00(this, 1));
    }
}
