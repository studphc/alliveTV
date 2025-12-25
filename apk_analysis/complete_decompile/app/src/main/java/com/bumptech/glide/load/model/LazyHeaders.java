package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.s71;

/* loaded from: classes.dex */
public final class LazyHeaders implements Headers {

    /* renamed from: a */
    public final Map f8791a;

    /* renamed from: b */
    public volatile Map f8792b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: d */
        public static final Map f8793d;

        /* renamed from: a */
        public boolean f8794a = true;

        /* renamed from: b */
        public Map f8795b = f8793d;

        /* renamed from: c */
        public boolean f8796c = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", Collections.singletonList(new s71(property)));
            }
            f8793d = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: a */
        public final void m2336a() {
            if (this.f8794a) {
                this.f8794a = false;
                HashMap hashMap = new HashMap(this.f8795b.size());
                for (Map.Entry entry : this.f8795b.entrySet()) {
                    hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
                }
                this.f8795b = hashMap;
            }
        }

        public Builder addHeader(@NonNull String str, @NonNull String str2) {
            return addHeader(str, new s71(str2));
        }

        public LazyHeaders build() {
            this.f8794a = true;
            return new LazyHeaders(this.f8795b);
        }

        public Builder setHeader(@NonNull String str, @Nullable String str2) {
            return setHeader(str, str2 == null ? null : new s71(str2));
        }

        public Builder addHeader(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.f8796c && "User-Agent".equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            m2336a();
            List list = (List) this.f8795b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f8795b.put(str, list);
            }
            list.add(lazyHeaderFactory);
            return this;
        }

        public Builder setHeader(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            m2336a();
            if (lazyHeaderFactory == null) {
                this.f8795b.remove(str);
            } else {
                List list = (List) this.f8795b.get(str);
                if (list == null) {
                    list = new ArrayList();
                    this.f8795b.put(str, list);
                }
                list.clear();
                list.add(lazyHeaderFactory);
            }
            if (this.f8796c && "User-Agent".equalsIgnoreCase(str)) {
                this.f8796c = false;
            }
            return this;
        }
    }

    public LazyHeaders(Map map) {
        this.f8791a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public final HashMap m2335a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f8791a.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String buildHeader = ((LazyHeaderFactory) list.get(i)).buildHeader();
                if (!TextUtils.isEmpty(buildHeader)) {
                    sb.append(buildHeader);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f8791a.equals(((LazyHeaders) obj).f8791a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.f8792b == null) {
            synchronized (this) {
                try {
                    if (this.f8792b == null) {
                        this.f8792b = Collections.unmodifiableMap(m2335a());
                    }
                } finally {
                }
            }
        }
        return this.f8792b;
    }

    public int hashCode() {
        return this.f8791a.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f8791a + '}';
    }
}
