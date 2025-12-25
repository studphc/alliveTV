package p000;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class zn1 {
    /* renamed from: a */
    public static v90 m8417a(yn1 yn1Var) {
        long j;
        yn1Var.skip(4);
        int readUnsignedShort = yn1Var.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            yn1Var.skip(6);
            int i = 0;
            while (true) {
                if (i < readUnsignedShort) {
                    int mo7516a = yn1Var.mo7516a();
                    yn1Var.skip(4);
                    j = yn1Var.mo7517b();
                    yn1Var.skip(4);
                    if (1835365473 == mo7516a) {
                        break;
                    }
                    i++;
                } else {
                    j = -1;
                    break;
                }
            }
            if (j != -1) {
                yn1Var.skip((int) (j - yn1Var.getPosition()));
                yn1Var.skip(12);
                long mo7517b = yn1Var.mo7517b();
                for (int i2 = 0; i2 < mo7517b; i2++) {
                    int mo7516a2 = yn1Var.mo7516a();
                    long mo7517b2 = yn1Var.mo7517b();
                    long mo7517b3 = yn1Var.mo7517b();
                    if (1164798569 == mo7516a2 || 1701669481 == mo7516a2) {
                        return new v90(mo7517b2 + j, mo7517b3);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* renamed from: b */
    public static MetadataList m8418b(InputStream inputStream) {
        xn1 xn1Var = new xn1(inputStream);
        v90 m8417a = m8417a(xn1Var);
        xn1Var.skip((int) (m8417a.f27676a - xn1Var.f28658d));
        long j = m8417a.f27677b;
        ByteBuffer allocate = ByteBuffer.allocate((int) j);
        int read = inputStream.read(allocate.array());
        if (read == j) {
            return MetadataList.getRootAsMetadataList(allocate);
        }
        throw new IOException("Needed " + j + " bytes, got " + read);
    }
}
