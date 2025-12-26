package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;
import p000.dx0;

/* loaded from: classes2.dex */
public class HeartBeatConsumerComponent {
    public static Component<?> create() {
        return Component.intoSet(new dx0(18), (Class<dx0>) HeartBeatConsumer.class);
    }
}
