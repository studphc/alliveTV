package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Iterator;
import p000.zr2;

/* loaded from: classes.dex */
public final class DataBufferUtils {

    @NonNull
    @KeepForSdk
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";

    @NonNull
    @KeepForSdk
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(@NonNull DataBuffer<E> dataBuffer) {
        zr2 zr2Var = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        try {
            Iterator<E> it = dataBuffer.iterator();
            while (it.hasNext()) {
                zr2Var.add(it.next().freeze());
            }
            return zr2Var;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(@NonNull DataBuffer<?> dataBuffer) {
        if (dataBuffer != null && dataBuffer.getCount() > 0) {
            return true;
        }
        return false;
    }

    public static boolean hasNextPage(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata != null && metadata.getString(KEY_NEXT_PAGE_TOKEN) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasPrevPage(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata != null && metadata.getString(KEY_PREV_PAGE_TOKEN) != null) {
            return true;
        }
        return false;
    }
}
