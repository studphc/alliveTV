package com.google.common.reflect;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p000.C1593np;

/* loaded from: classes2.dex */
public final class ClassPath {

    /* renamed from: b */
    public static final Logger f15220b = Logger.getLogger(ClassPath.class.getName());

    /* renamed from: c */
    public static final Splitter f15221c = Splitter.m3784on(" ").omitEmptyStrings();

    /* renamed from: a */
    public final ImmutableSet f15222a;

    /* loaded from: classes2.dex */
    public static final class ClassInfo extends ResourceInfo {

        /* renamed from: c */
        public final String f15223c;

        public ClassInfo(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            Logger logger = ClassPath.f15220b;
            this.f15223c = str.substring(0, str.length() - 6).replace('/', '.');
        }

        public String getName() {
            return this.f15223c;
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.f15223c);
        }

        public String getSimpleName() {
            String str = this.f15223c;
            int lastIndexOf = str.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.inRange('0', '9').trimLeadingFrom(str.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return str;
            }
            return str.substring(packageName.length() + 1);
        }

        public boolean isTopLevel() {
            if (this.f15223c.indexOf(36) == -1) {
                return true;
            }
            return false;
        }

        public Class<?> load() {
            try {
                return this.f15225b.loadClass(this.f15223c);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.f15223c;
        }
    }

    /* loaded from: classes2.dex */
    public static class ResourceInfo {

        /* renamed from: a */
        public final String f15224a;

        /* renamed from: b */
        public final ClassLoader f15225b;

        public ResourceInfo(File file, String str, ClassLoader classLoader) {
            this.f15224a = (String) Preconditions.checkNotNull(str);
            this.f15225b = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            if (!this.f15224a.equals(resourceInfo.f15224a) || this.f15225b != resourceInfo.f15225b) {
                return false;
            }
            return true;
        }

        public final String getResourceName() {
            return this.f15224a;
        }

        public int hashCode() {
            return this.f15224a.hashCode();
        }

        public String toString() {
            return this.f15224a;
        }

        public final URL url() {
            ClassLoader classLoader = this.f15225b;
            String str = this.f15224a;
            URL resource = classLoader.getResource(str);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(str);
        }
    }

    public ClassPath(ImmutableSet immutableSet) {
        this.f15222a = immutableSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static ImmutableMap m4276a(ClassLoader classLoader) {
        ImmutableList m3902of;
        String str;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            newLinkedHashMap.putAll(m4276a(parent));
        }
        if (classLoader instanceof URLClassLoader) {
            m3902of = ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
        } else if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str2 : Splitter.m3784on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
                try {
                    try {
                        builder.add((ImmutableList.Builder) new File(str2).toURI().toURL());
                    } catch (SecurityException unused) {
                        builder.add((ImmutableList.Builder) new URL("file", (String) null, new File(str2).getAbsolutePath()));
                    }
                } catch (MalformedURLException e) {
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str2);
                    if (valueOf.length() != 0) {
                        str = "malformed classpath entry: ".concat(valueOf);
                    } else {
                        str = new String("malformed classpath entry: ");
                    }
                    f15220b.log(level, str, (Throwable) e);
                }
            }
            m3902of = builder.build();
        } else {
            m3902of = ImmutableList.m3902of();
        }
        UnmodifiableIterator it = m3902of.iterator();
        while (it.hasNext()) {
            URL url = (URL) it.next();
            if (url.getProtocol().equals("file")) {
                File m4278c = m4278c(url);
                if (!newLinkedHashMap.containsKey(m4278c)) {
                    newLinkedHashMap.put(m4278c, classLoader);
                }
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    /* renamed from: b */
    public static ImmutableSet m4277b(File file, Manifest manifest) {
        String str;
        if (manifest == null) {
            return ImmutableSet.m3971of();
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str2 : f15221c.split(value)) {
                try {
                    URL url = new URL(file.toURI().toURL(), str2);
                    if (url.getProtocol().equals("file")) {
                        builder.add((ImmutableSet.Builder) m4278c(url));
                    }
                } catch (MalformedURLException unused) {
                    String valueOf = String.valueOf(str2);
                    if (valueOf.length() != 0) {
                        str = "Invalid Class-Path entry: ".concat(valueOf);
                    } else {
                        str = new String("Invalid Class-Path entry: ");
                    }
                    f15220b.warning(str);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: c */
    public static File m4278c(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ClassPath from(ClassLoader classLoader) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator it = m4276a(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.add((ImmutableSet.Builder) new C0973a((File) entry.getKey(), (ClassLoader) entry.getValue()));
        }
        ImmutableSet build = builder.build();
        HashSet hashSet = new HashSet();
        UnmodifiableIterator it2 = build.iterator();
        while (it2.hasNext()) {
            hashSet.add(((C0973a) it2.next()).f15242a);
        }
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        UnmodifiableIterator it3 = build.iterator();
        while (it3.hasNext()) {
            C0973a c0973a = (C0973a) it3.next();
            c0973a.getClass();
            ImmutableSet.Builder builder3 = ImmutableSet.builder();
            File file = c0973a.f15242a;
            hashSet.add(file);
            c0973a.m4302a(file, hashSet, builder3);
            builder2.addAll((Iterable) builder3.build());
        }
        return new ClassPath(builder2.build());
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.f15222a).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.f15222a;
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.f15222a).filter(ClassInfo.class).filter(new C1593np(0)).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1);
        sb.append(str);
        sb.append('.');
        String sb2 = sb.toString();
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getName().startsWith(sb2)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }
}
