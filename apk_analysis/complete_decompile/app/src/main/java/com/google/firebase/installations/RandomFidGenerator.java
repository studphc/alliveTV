package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes2.dex */
public class RandomFidGenerator {

    /* renamed from: a */
    public static final byte f15582a = Byte.parseByte("01110000", 2);

    /* renamed from: b */
    public static final byte f15583b = Byte.parseByte("00001111", 2);

    @NonNull
    public String createRandomFid() {
        UUID randomUUID = UUID.randomUUID();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[17]);
        wrap.putLong(randomUUID.getMostSignificantBits());
        wrap.putLong(randomUUID.getLeastSignificantBits());
        byte[] array = wrap.array();
        byte b = array[0];
        array[16] = b;
        array[0] = (byte) ((b & f15583b) | f15582a);
        return new String(Base64.encode(array, 11), Charset.defaultCharset()).substring(0, 22);
    }
}
