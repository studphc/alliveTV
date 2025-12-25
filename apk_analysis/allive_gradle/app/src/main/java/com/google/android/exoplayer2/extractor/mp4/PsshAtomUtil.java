package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;
import p000.AbstractC1386kc;
import p000.AbstractC1726qj;
import p000.h71;

/* loaded from: classes.dex */
public final class PsshAtomUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [byte[], java.io.Serializable] */
    /* renamed from: a */
    public static h71 m2560a(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.limit() < 32) {
            return null;
        }
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != 1886614376) {
            return null;
        }
        int m5518b = AbstractC1386kc.m5518b(parsableByteArray.readInt());
        if (m5518b > 1) {
            AbstractC1726qj.m7036A(m5518b, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
        if (m5518b == 1) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt != parsableByteArray.bytesLeft()) {
            return null;
        }
        ?? r2 = new byte[readUnsignedIntToInt];
        parsableByteArray.readBytes(r2, 0, readUnsignedIntToInt);
        return new h71(uuid, m5518b, r2);
    }

    public static byte[] buildPsshAtom(UUID uuid, @Nullable byte[] bArr) {
        return buildPsshAtom(uuid, null, bArr);
    }

    public static boolean isPsshAtom(byte[] bArr) {
        if (m2560a(bArr) != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public static byte[] parseSchemeSpecificData(byte[] bArr, UUID uuid) {
        h71 m2560a = m2560a(bArr);
        if (m2560a == null) {
            return null;
        }
        UUID uuid2 = (UUID) m2560a.f17965b;
        if (!uuid.equals(uuid2)) {
            Log.m3027w("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + uuid2 + ".");
            return null;
        }
        return (byte[]) m2560a.f17966c;
    }

    @Nullable
    public static UUID parseUuid(byte[] bArr) {
        h71 m2560a = m2560a(bArr);
        if (m2560a == null) {
            return null;
        }
        return (UUID) m2560a.f17965b;
    }

    public static int parseVersion(byte[] bArr) {
        h71 m2560a = m2560a(bArr);
        if (m2560a == null) {
            return -1;
        }
        return m2560a.f17964a;
    }

    public static byte[] buildPsshAtom(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }
}
