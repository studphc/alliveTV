package com.google.firebase.components;

import java.util.List;
import p000.C1255h3;

/* loaded from: classes2.dex */
public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new C1255h3(10);

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
