package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import p000.C2069zt;
import p000.r10;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes2.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a */
    public static final Lazy f15549a = new Lazy(new C2069zt(1));

    /* renamed from: b */
    public static final Lazy f15550b = new Lazy(new C2069zt(2));

    /* renamed from: c */
    public static final Lazy f15551c = new Lazy(new C2069zt(3));

    /* renamed from: d */
    public static final Lazy f15552d = new Lazy(new C2069zt(4));

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)).factory(new r10(1)).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)).factory(new r10(2)).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)).factory(new r10(3)).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory(new r10(4)).build());
    }
}
