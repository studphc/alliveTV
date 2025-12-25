package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.ClassPath;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;
import p000.AbstractC1726qj;

/* renamed from: com.google.common.reflect.a */
/* loaded from: classes2.dex */
public final class C0973a {

    /* renamed from: a */
    public final File f15242a;

    /* renamed from: b */
    public final ClassLoader f15243b;

    public C0973a(File file, ClassLoader classLoader) {
        this.f15242a = (File) Preconditions.checkNotNull(file);
        this.f15243b = (ClassLoader) Preconditions.checkNotNull(classLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m4302a(File file, HashSet hashSet, ImmutableSet.Builder builder) {
        try {
            if (!file.exists()) {
                return;
            }
            if (file.isDirectory()) {
                HashSet hashSet2 = new HashSet();
                hashSet2.add(file.getCanonicalFile());
                m4303b(file, "", hashSet2, builder);
                return;
            }
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator it = ClassPath.m4277b(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File file2 = (File) it.next();
                        if (hashSet.add(file2.getCanonicalFile())) {
                            m4302a(file2, hashSet, builder);
                        }
                    }
                    m4304c(jarFile, builder);
                    jarFile.close();
                } catch (Throwable th) {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (SecurityException e) {
            Logger logger = ClassPath.f15220b;
            String valueOf = String.valueOf(file);
            String valueOf2 = String.valueOf(e);
            logger.warning(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 16, "Cannot access ", valueOf, ": ", valueOf2));
        }
    }

    /* renamed from: b */
    public final void m4303b(File file, String str, HashSet hashSet, ImmutableSet.Builder builder) {
        String str2;
        Object resourceInfo;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            Logger logger = ClassPath.f15220b;
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Cannot read directory ");
            sb.append(valueOf);
            logger.warning(sb.toString());
            return;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (file2.isDirectory()) {
                File canonicalFile = file2.getCanonicalFile();
                if (hashSet.add(canonicalFile)) {
                    m4303b(canonicalFile, AbstractC1726qj.m7059o(str, name, "/", AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(1, str), name)), hashSet, builder);
                    hashSet.remove(canonicalFile);
                }
            } else {
                String valueOf2 = String.valueOf(str);
                String valueOf3 = String.valueOf(name);
                if (valueOf3.length() != 0) {
                    str2 = valueOf2.concat(valueOf3);
                } else {
                    str2 = new String(valueOf2);
                }
                if (!str2.equals("META-INF/MANIFEST.MF")) {
                    boolean endsWith = str2.endsWith(".class");
                    ClassLoader classLoader = this.f15243b;
                    if (endsWith) {
                        resourceInfo = new ClassPath.ClassInfo(file2, str2, classLoader);
                    } else {
                        resourceInfo = new ClassPath.ResourceInfo(file2, str2, classLoader);
                    }
                    builder.add((ImmutableSet.Builder) resourceInfo);
                }
            }
        }
    }

    /* renamed from: c */
    public final void m4304c(JarFile jarFile, ImmutableSet.Builder builder) {
        Object resourceInfo;
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                File file = new File(jarFile.getName());
                String name = nextElement.getName();
                boolean endsWith = name.endsWith(".class");
                ClassLoader classLoader = this.f15243b;
                if (endsWith) {
                    resourceInfo = new ClassPath.ClassInfo(file, name, classLoader);
                } else {
                    resourceInfo = new ClassPath.ResourceInfo(file, name, classLoader);
                }
                builder.add((ImmutableSet.Builder) resourceInfo);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0973a)) {
            return false;
        }
        C0973a c0973a = (C0973a) obj;
        if (!this.f15242a.equals(c0973a.f15242a) || !this.f15243b.equals(c0973a.f15243b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f15242a.hashCode();
    }

    public final String toString() {
        return this.f15242a.toString();
    }
}
