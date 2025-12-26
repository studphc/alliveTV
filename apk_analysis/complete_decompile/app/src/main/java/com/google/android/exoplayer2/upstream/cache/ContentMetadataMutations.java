package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ContentMetadataMutations {

    /* renamed from: a */
    public final HashMap f12634a = new HashMap();

    /* renamed from: b */
    public final ArrayList f12635b = new ArrayList();

    public static ContentMetadataMutations setContentLength(ContentMetadataMutations contentMetadataMutations, long j) {
        return contentMetadataMutations.set(ContentMetadata.KEY_CONTENT_LENGTH, j);
    }

    public static ContentMetadataMutations setRedirectedUri(ContentMetadataMutations contentMetadataMutations, @Nullable Uri uri) {
        if (uri == null) {
            return contentMetadataMutations.remove(ContentMetadata.KEY_REDIRECTED_URI);
        }
        return contentMetadataMutations.set(ContentMetadata.KEY_REDIRECTED_URI, uri.toString());
    }

    /* renamed from: a */
    public final void m2996a(String str, Serializable serializable) {
        this.f12634a.put((String) Assertions.checkNotNull(str), Assertions.checkNotNull(serializable));
        this.f12635b.remove(str);
    }

    public Map<String, Object> getEditedValues() {
        HashMap hashMap = new HashMap(this.f12634a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> getRemovedValues() {
        return Collections.unmodifiableList(new ArrayList(this.f12635b));
    }

    public ContentMetadataMutations remove(String str) {
        this.f12635b.add(str);
        this.f12634a.remove(str);
        return this;
    }

    public ContentMetadataMutations set(String str, String str2) {
        m2996a(str, str2);
        return this;
    }

    public ContentMetadataMutations set(String str, long j) {
        m2996a(str, Long.valueOf(j));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [byte[], java.io.Serializable] */
    public ContentMetadataMutations set(String str, byte[] bArr) {
        m2996a(str, Arrays.copyOf(bArr, bArr.length));
        return this;
    }
}
