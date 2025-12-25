package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import p000.C1868ud;
import p000.r10;

/* loaded from: classes2.dex */
public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* renamed from: a */
    public final String f15652a;

    /* renamed from: b */
    public final GlobalLibraryVersionRegistrar f15653b;

    public DefaultUserAgentPublisher(Set set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f15652a = m4407a(set);
        this.f15653b = globalLibraryVersionRegistrar;
    }

    /* renamed from: a */
    public static String m4407a(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C1868ud c1868ud = (C1868ud) it.next();
            sb.append(c1868ud.f27226a);
            sb.append('/');
            sb.append(c1868ud.f27227b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static Component<UserAgentPublisher> component() {
        return Component.builder(UserAgentPublisher.class).add(Dependency.setOf((Class<?>) C1868ud.class)).factory(new r10(0)).build();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String getUserAgent() {
        Set unmodifiableSet;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.f15653b;
        synchronized (globalLibraryVersionRegistrar.f15655a) {
            unmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.f15655a);
        }
        boolean isEmpty = unmodifiableSet.isEmpty();
        String str = this.f15652a;
        if (isEmpty) {
            return str;
        }
        return str + ' ' + m4407a(globalLibraryVersionRegistrar.m4408a());
    }
}
