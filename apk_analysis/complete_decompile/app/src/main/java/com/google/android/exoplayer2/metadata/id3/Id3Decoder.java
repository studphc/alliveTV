package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import p000.AbstractC1726qj;
import p000.ee0;
import p000.w11;

/* loaded from: classes.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    public static final FramePredicate NO_FRAMES_PREDICATE = new ee0(7);

    /* renamed from: a */
    public final FramePredicate f10762a;

    /* loaded from: classes.dex */
    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public Id3Decoder() {
        this(null);
    }

    /* renamed from: a */
    public static ApicFrame m2672a(ParsableByteArray parsableByteArray, int i, int i2) {
        int m2689r;
        String lowerCase;
        byte[] copyOfRange;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            lowerCase = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, C0643C.ISO88591_NAME));
            if ("image/jpg".equals(lowerCase)) {
                lowerCase = MimeTypes.IMAGE_JPEG;
            }
            m2689r = 2;
        } else {
            m2689r = m2689r(0, bArr);
            lowerCase = Ascii.toLowerCase(new String(bArr, 0, m2689r, C0643C.ISO88591_NAME));
            if (lowerCase.indexOf(47) == -1) {
                lowerCase = "image/".concat(lowerCase);
            }
        }
        int i4 = bArr[m2689r + 1] & 255;
        int i5 = m2689r + 2;
        int m2688q = m2688q(bArr, i5, readUnsignedByte);
        String str = new String(bArr, i5, m2688q - i5, m2686o);
        int m2685n = m2685n(readUnsignedByte) + m2688q;
        if (i3 <= m2685n) {
            copyOfRange = Util.EMPTY_BYTE_ARRAY;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, m2685n, i3);
        }
        return new ApicFrame(lowerCase, str, i4, copyOfRange);
    }

    /* renamed from: b */
    public static ChapterFrame m2673b(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) {
        long j;
        long j2;
        int position = parsableByteArray.getPosition();
        int m2689r = m2689r(position, parsableByteArray.getData());
        String str = new String(parsableByteArray.getData(), position, m2689r - position, C0643C.ISO88591_NAME);
        parsableByteArray.setPosition(m2689r + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            j = -1;
        } else {
            j = readUnsignedInt;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            j2 = -1;
        } else {
            j2 = readUnsignedInt2;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame m2676e = m2676e(i2, parsableByteArray, z, i3, framePredicate);
            if (m2676e != null) {
                arrayList.add(m2676e);
            }
        }
        return new ChapterFrame(str, readInt, readInt2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    /* renamed from: c */
    public static ChapterTocFrame m2674c(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) {
        boolean z2;
        boolean z3;
        int position = parsableByteArray.getPosition();
        int m2689r = m2689r(position, parsableByteArray.getData());
        String str = new String(parsableByteArray.getData(), position, m2689r - position, C0643C.ISO88591_NAME);
        parsableByteArray.setPosition(m2689r + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((readUnsignedByte & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int m2689r2 = m2689r(position2, parsableByteArray.getData());
            strArr[i4] = new String(parsableByteArray.getData(), position2, m2689r2 - position2, C0643C.ISO88591_NAME);
            parsableByteArray.setPosition(m2689r2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame m2676e = m2676e(i2, parsableByteArray, z, i3, framePredicate);
            if (m2676e != null) {
                arrayList.add(m2676e);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    /* renamed from: d */
    public static CommentFrame m2675d(int i, ParsableByteArray parsableByteArray) {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int m2688q = m2688q(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, m2688q, m2686o);
        int m2685n = m2685n(readUnsignedByte) + m2688q;
        return new CommentFrame(str, str2, m2680i(m2686o, bArr2, m2685n, m2688q(bArr2, m2685n, readUnsignedByte)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x018d, code lost:
    
        if (r14 == 67) goto L133;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame m2676e(int i, ParsableByteArray parsableByteArray, boolean z, int i2, FramePredicate framePredicate) {
        int i3;
        int readUnsignedInt24;
        int i4;
        String str;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str2;
        Id3Frame binaryFrame;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        if (i >= 3) {
            i3 = parsableByteArray.readUnsignedByte();
        } else {
            i3 = 0;
        }
        if (i == 4) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
            if (!z) {
                readUnsignedInt24 = (((readUnsignedInt24 >> 24) & 255) << 21) | (readUnsignedInt24 & 255) | (((readUnsignedInt24 >> 8) & 255) << 7) | (((readUnsignedInt24 >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
        } else {
            readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        }
        int i7 = readUnsignedInt24;
        if (i >= 3) {
            i4 = parsableByteArray.readUnsignedShort();
        } else {
            i4 = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && i3 == 0 && i7 == 0 && i4 == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i7;
        if (position > parsableByteArray.limit()) {
            Log.m3027w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            str = "Id3Decoder";
            i5 = position;
            i6 = i4;
            if (!framePredicate.evaluate(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3)) {
                parsableByteArray.setPosition(i5);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i5 = position;
            i6 = i4;
        }
        if (i == 3) {
            if ((i6 & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i6 & 64) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i6 & 32) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            z6 = z2;
            z5 = false;
        } else {
            if (i == 4) {
                if ((i6 & 64) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((i6 & 8) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((i6 & 4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((i6 & 2) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if ((i6 & 1) != 0) {
                    z6 = true;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            z6 = false;
        }
        if (!z2 && !z3) {
            if (z4) {
                i7--;
                parsableByteArray.skipBytes(1);
            }
            if (z6) {
                i7 -= 4;
                parsableByteArray.skipBytes(4);
            }
            int i8 = i7;
            if (z5) {
                i8 = m2690s(i8, parsableByteArray);
            }
            int i9 = i8;
            try {
                try {
                    if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || i3 == 88)) {
                        binaryFrame = m2682k(i9, parsableByteArray);
                    } else if (readUnsignedByte == 84) {
                        binaryFrame = m2681j(i9, parsableByteArray, m2687p(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                    } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || i3 == 88)) {
                        binaryFrame = m2684m(i9, parsableByteArray);
                    } else if (readUnsignedByte == 87) {
                        binaryFrame = m2683l(i9, parsableByteArray, m2687p(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                    } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && i3 == 86) {
                        binaryFrame = m2679h(i9, parsableByteArray);
                    } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (i3 == 66 || i == 2)) {
                        binaryFrame = m2677f(i9, parsableByteArray);
                    } else if (i == 2) {
                        if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                            binaryFrame = m2672a(parsableByteArray, i9, i);
                        }
                        if (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (i3 == 77 || i == 2)) {
                            binaryFrame = m2675d(i9, parsableByteArray);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && i3 == 80) {
                            binaryFrame = m2673b(parsableByteArray, i9, i, z, i2, framePredicate);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && i3 == 67) {
                            binaryFrame = m2674c(parsableByteArray, i9, i, z, i2, framePredicate);
                        } else if (readUnsignedByte != 77 && readUnsignedByte2 == 76 && readUnsignedByte3 == 76 && i3 == 84) {
                            binaryFrame = m2678g(i9, parsableByteArray);
                        } else {
                            String m2687p = m2687p(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3);
                            byte[] bArr = new byte[i9];
                            parsableByteArray.readBytes(bArr, 0, i9);
                            binaryFrame = new BinaryFrame(m2687p, bArr);
                        }
                    } else {
                        if (readUnsignedByte == 65) {
                            if (readUnsignedByte2 == 80) {
                                if (readUnsignedByte3 == 73) {
                                }
                            }
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 77) {
                        }
                        String m2687p2 = m2687p(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3);
                        byte[] bArr2 = new byte[i9];
                        parsableByteArray.readBytes(bArr2, 0, i9);
                        binaryFrame = new BinaryFrame(m2687p2, bArr2);
                    }
                    if (binaryFrame == null) {
                        str2 = str;
                        try {
                            Log.m3027w(str2, "Failed to decode frame: id=" + m2687p(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3) + ", frameSize=" + i9);
                        } catch (UnsupportedEncodingException unused) {
                            Log.m3027w(str2, "Unsupported character encoding");
                            parsableByteArray.setPosition(i5);
                            return null;
                        }
                    }
                    parsableByteArray.setPosition(i5);
                    return binaryFrame;
                } catch (Throwable th) {
                    parsableByteArray.setPosition(i5);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused2) {
                str2 = str;
            }
        } else {
            Log.m3027w(str, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.setPosition(i5);
            return null;
        }
    }

    /* renamed from: f */
    public static GeobFrame m2677f(int i, ParsableByteArray parsableByteArray) {
        byte[] copyOfRange;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int m2689r = m2689r(0, bArr);
        String str = new String(bArr, 0, m2689r, C0643C.ISO88591_NAME);
        int i3 = m2689r + 1;
        int m2688q = m2688q(bArr, i3, readUnsignedByte);
        String m2680i = m2680i(m2686o, bArr, i3, m2688q);
        int m2685n = m2685n(readUnsignedByte) + m2688q;
        int m2688q2 = m2688q(bArr, m2685n, readUnsignedByte);
        String m2680i2 = m2680i(m2686o, bArr, m2685n, m2688q2);
        int m2685n2 = m2685n(readUnsignedByte) + m2688q2;
        if (i2 <= m2685n2) {
            copyOfRange = Util.EMPTY_BYTE_ARRAY;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, m2685n2, i2);
        }
        return new GeobFrame(str, m2680i, m2680i2, copyOfRange);
    }

    /* renamed from: g */
    public static MlltFrame m2678g(int i, ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        int readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i2 = ((i - 10) * 8) / (readUnsignedByte + readUnsignedByte2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int readBits = parsableBitArray.readBits(readUnsignedByte);
            int readBits2 = parsableBitArray.readBits(readUnsignedByte2);
            iArr[i3] = readBits;
            iArr2[i3] = readBits2;
        }
        return new MlltFrame(readUnsignedShort, readUnsignedInt24, readUnsignedInt242, iArr, iArr2);
    }

    /* renamed from: h */
    public static PrivFrame m2679h(int i, ParsableByteArray parsableByteArray) {
        byte[] copyOfRange;
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int m2689r = m2689r(0, bArr);
        String str = new String(bArr, 0, m2689r, C0643C.ISO88591_NAME);
        int i2 = m2689r + 1;
        if (i <= i2) {
            copyOfRange = Util.EMPTY_BYTE_ARRAY;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, i2, i);
        }
        return new PrivFrame(str, copyOfRange);
    }

    /* renamed from: i */
    public static String m2680i(String str, byte[] bArr, int i, int i2) {
        if (i2 > i && i2 <= bArr.length) {
            return new String(bArr, i, i2 - i, str);
        }
        return "";
    }

    /* renamed from: j */
    public static TextInformationFrame m2681j(int i, ParsableByteArray parsableByteArray, String str) {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, m2688q(bArr, 0, readUnsignedByte), m2686o));
    }

    /* renamed from: k */
    public static TextInformationFrame m2682k(int i, ParsableByteArray parsableByteArray) {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int m2688q = m2688q(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, m2688q, m2686o);
        int m2685n = m2685n(readUnsignedByte) + m2688q;
        return new TextInformationFrame("TXXX", str, m2680i(m2686o, bArr, m2685n, m2688q(bArr, m2685n, readUnsignedByte)));
    }

    /* renamed from: l */
    public static UrlLinkFrame m2683l(int i, ParsableByteArray parsableByteArray, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, m2689r(0, bArr), C0643C.ISO88591_NAME));
    }

    /* renamed from: m */
    public static UrlLinkFrame m2684m(int i, ParsableByteArray parsableByteArray) {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String m2686o = m2686o(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int m2688q = m2688q(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, m2688q, m2686o);
        int m2685n = m2685n(readUnsignedByte) + m2688q;
        return new UrlLinkFrame("WXXX", str, m2680i(C0643C.ISO88591_NAME, bArr, m2685n, m2689r(m2685n, bArr)));
    }

    /* renamed from: n */
    public static int m2685n(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* renamed from: o */
    public static String m2686o(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return C0643C.ISO88591_NAME;
                }
                return "UTF-8";
            }
            return "UTF-16BE";
        }
        return C0643C.UTF16_NAME;
    }

    /* renamed from: p */
    public static String m2687p(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* renamed from: q */
    public static int m2688q(byte[] bArr, int i, int i2) {
        int m2689r = m2689r(i, bArr);
        if (i2 != 0 && i2 != 3) {
            while (m2689r < bArr.length - 1) {
                if ((m2689r - i) % 2 == 0 && bArr[m2689r + 1] == 0) {
                    return m2689r;
                }
                m2689r = m2689r(m2689r + 1, bArr);
            }
            return bArr.length;
        }
        return m2689r;
    }

    /* renamed from: r */
    public static int m2689r(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* renamed from: s */
    public static int m2690s(int i, ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int i2 = position;
        while (true) {
            int i3 = i2 + 1;
            if (i3 < position + i) {
                if ((data[i2] & 255) == 255 && data[i3] == 0) {
                    System.arraycopy(data, i2 + 2, data, i3, (i - (i2 - position)) - 2);
                    i--;
                }
                i2 = i3;
            } else {
                return i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if ((r10 & 1) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0089, code lost:
    
        if ((r10 & 128) != 0) goto L45;
     */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m2691t(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i3;
        int i4;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                boolean z2 = true;
                if (parsableByteArray.bytesLeft() >= i2) {
                    if (i >= 3) {
                        readUnsignedInt24 = parsableByteArray.readInt();
                        readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                        i3 = parsableByteArray.readUnsignedShort();
                    } else {
                        readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                        readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                        i3 = 0;
                    }
                    if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i3 == 0) {
                        parsableByteArray.setPosition(position);
                        return true;
                    }
                    if (i == 4 && !z) {
                        if ((8421504 & readUnsignedInt242) != 0) {
                            parsableByteArray.setPosition(position);
                            return false;
                        }
                        readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                    }
                    if (i == 4) {
                        if ((i3 & 64) != 0) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                    } else {
                        if (i == 3) {
                            if ((i3 & 32) != 0) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                        } else {
                            i4 = 0;
                            z2 = false;
                        }
                        if (z2) {
                            i4 += 4;
                        }
                        if (readUnsignedInt242 < i4) {
                            parsableByteArray.setPosition(position);
                            return false;
                        }
                        if (parsableByteArray.bytesLeft() < readUnsignedInt242) {
                            parsableByteArray.setPosition(position);
                            return false;
                        }
                        parsableByteArray.skipBytes((int) readUnsignedInt242);
                    }
                } else {
                    parsableByteArray.setPosition(position);
                    return true;
                }
            } catch (Throwable th) {
                parsableByteArray.setPosition(position);
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @Nullable
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(@Nullable FramePredicate framePredicate) {
        this.f10762a = framePredicate;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Metadata decode(byte[] bArr, int i) {
        w11 w11Var;
        boolean z = true;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        if (parsableByteArray.bytesLeft() < 10) {
            Log.m3027w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
            if (readUnsignedInt24 == 4801587) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(1);
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
                if (readUnsignedByte == 2) {
                    if ((readUnsignedByte2 & 64) != 0) {
                        Log.m3027w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    }
                    w11Var = new w11(readUnsignedByte, readSynchSafeInt, readUnsignedByte >= 4 && (readUnsignedByte2 & 128) != 0);
                } else {
                    if (readUnsignedByte == 3) {
                        if ((readUnsignedByte2 & 64) != 0) {
                            int readInt = parsableByteArray.readInt();
                            parsableByteArray.skipBytes(readInt);
                            readSynchSafeInt -= readInt + 4;
                        }
                    } else if (readUnsignedByte == 4) {
                        if ((readUnsignedByte2 & 64) != 0) {
                            int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                            parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                            readSynchSafeInt -= readSynchSafeInt2;
                        }
                        if ((readUnsignedByte2 & 16) != 0) {
                            readSynchSafeInt -= 10;
                        }
                    } else {
                        AbstractC1726qj.m7036A(readUnsignedByte, "Skipped ID3 tag with unsupported majorVersion=", "Id3Decoder");
                    }
                    w11Var = new w11(readUnsignedByte, readSynchSafeInt, readUnsignedByte >= 4 && (readUnsignedByte2 & 128) != 0);
                }
                if (w11Var != null) {
                    return null;
                }
                int position = parsableByteArray.getPosition();
                int i2 = w11Var.f28039a;
                int i3 = i2 == 2 ? 6 : 10;
                boolean z2 = w11Var.f28040b;
                int i4 = w11Var.f28041c;
                if (z2) {
                    i4 = m2690s(i4, parsableByteArray);
                }
                parsableByteArray.setLimit(position + i4);
                if (m2691t(parsableByteArray, i2, i3, false)) {
                    z = false;
                } else if (i2 != 4 || !m2691t(parsableByteArray, 4, i3, true)) {
                    AbstractC1726qj.m7036A(i2, "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
                    return null;
                }
                while (parsableByteArray.bytesLeft() >= i3) {
                    Id3Frame m2676e = m2676e(i2, parsableByteArray, z, i3, this.f10762a);
                    if (m2676e != null) {
                        arrayList.add(m2676e);
                    }
                }
                return new Metadata(arrayList);
            }
            Log.m3027w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(readUnsignedInt24))));
        }
        w11Var = null;
        if (w11Var != null) {
        }
    }
}
