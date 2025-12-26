package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import java.util.ArrayList;
import java.util.List;
import p000.C2032yt;

/* loaded from: classes2.dex */
public class ComponentMonitor implements ComponentRegistrarProcessor {
    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : componentRegistrar.getComponents()) {
            String name = component.getName();
            if (name != null) {
                component = component.withFactory(new C2032yt(component, 0, name));
            }
            arrayList.add(component);
        }
        return arrayList;
    }
}
