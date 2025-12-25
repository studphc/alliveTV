package p000;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class te2 extends ge3 {

    /* renamed from: b */
    public long f26787b;

    /* renamed from: c */
    public long[] f26788c;

    /* renamed from: d */
    public long[] f26789d;

    /* renamed from: q */
    public static Serializable m7491q(int i, ParsableByteArray parsableByteArray) {
        if (i != 0) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i != 11) {
                                    return null;
                                }
                                Date date = new Date((long) Double.longBitsToDouble(parsableByteArray.readLong()));
                                parsableByteArray.skipBytes(2);
                                return date;
                            }
                            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                            ArrayList arrayList = new ArrayList(readUnsignedIntToInt);
                            for (int i2 = 0; i2 < readUnsignedIntToInt; i2++) {
                                Serializable m7491q = m7491q(parsableByteArray.readUnsignedByte(), parsableByteArray);
                                if (m7491q != null) {
                                    arrayList.add(m7491q);
                                }
                            }
                            return arrayList;
                        }
                        return m7492r(parsableByteArray);
                    }
                    HashMap hashMap = new HashMap();
                    while (true) {
                        String m7493s = m7493s(parsableByteArray);
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        if (readUnsignedByte == 9) {
                            return hashMap;
                        }
                        Serializable m7491q2 = m7491q(readUnsignedByte, parsableByteArray);
                        if (m7491q2 != null) {
                            hashMap.put(m7493s, m7491q2);
                        }
                    }
                } else {
                    return m7493s(parsableByteArray);
                }
            } else {
                if (parsableByteArray.readUnsignedByte() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        } else {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
        }
    }

    /* renamed from: r */
    public static HashMap m7492r(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap hashMap = new HashMap(readUnsignedIntToInt);
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            String m7493s = m7493s(parsableByteArray);
            Serializable m7491q = m7491q(parsableByteArray.readUnsignedByte(), parsableByteArray);
            if (m7491q != null) {
                hashMap.put(m7493s, m7491q);
            }
        }
        return hashMap;
    }

    /* renamed from: s */
    public static String m7493s(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new String(parsableByteArray.getData(), position, readUnsignedShort);
    }
}
