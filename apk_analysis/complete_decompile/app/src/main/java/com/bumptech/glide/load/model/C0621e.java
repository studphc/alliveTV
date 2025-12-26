package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.load.model.DataUrlLoader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.e */
/* loaded from: classes.dex */
public final class C0621e implements DataUrlLoader.DataDecoder {
    @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
    public final void close(Object obj) {
        ((InputStream) obj).close();
    }

    @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
    public final Object decode(String str) {
        if (str.startsWith("data:image")) {
            int indexOf = str.indexOf(44);
            if (indexOf != -1) {
                if (str.substring(0, indexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
    }

    @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
    public final Class getDataClass() {
        return InputStream.class;
    }
}
