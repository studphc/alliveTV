package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import p000.b01;
import p000.u00;
import p000.v00;
import p000.ye0;

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a */
    public static final byte[] f8865a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b */
    public static final int[] f8866b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a */
    public static int m2343a(v00 v00Var, ArrayPool arrayPool) {
        boolean z;
        try {
            int mo1987d = v00Var.mo1987d();
            if ((mo1987d & 65496) != 65496 && mo1987d != 19789 && mo1987d != 18761) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + mo1987d);
                }
                return -1;
            }
            int m2345c = m2345c(v00Var);
            if (m2345c == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.get(m2345c, byte[].class);
            try {
                return m2346d(v00Var, bArr, m2345c);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static ImageHeaderParser.ImageType m2344b(v00 v00Var) {
        try {
            int mo1987d = v00Var.mo1987d();
            if (mo1987d == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int mo1991h = (mo1987d << 8) | v00Var.mo1991h();
            if (mo1991h == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int mo1991h2 = (mo1991h << 8) | v00Var.mo1991h();
            if (mo1991h2 == -1991225785) {
                v00Var.skip(21L);
                try {
                    if (v00Var.mo1991h() >= 3) {
                        return ImageHeaderParser.ImageType.PNG_A;
                    }
                    return ImageHeaderParser.ImageType.PNG;
                } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (mo1991h2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            v00Var.skip(4L);
            if (((v00Var.mo1987d() << 16) | v00Var.mo1987d()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int mo1987d2 = (v00Var.mo1987d() << 16) | v00Var.mo1987d();
            if ((mo1987d2 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = mo1987d2 & 255;
            if (i == 88) {
                v00Var.skip(4L);
                if ((v00Var.mo1991h() & 16) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            if (i == 76) {
                v00Var.skip(4L);
                if ((v00Var.mo1991h() & 8) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (DefaultImageHeaderParser$Reader$EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    /* renamed from: c */
    public static int m2345c(v00 v00Var) {
        short mo1991h;
        int mo1987d;
        long j;
        long skip;
        do {
            short mo1991h2 = v00Var.mo1991h();
            if (mo1991h2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) mo1991h2));
                }
                return -1;
            }
            mo1991h = v00Var.mo1991h();
            if (mo1991h == 218) {
                return -1;
            }
            if (mo1991h == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            mo1987d = v00Var.mo1987d() - 2;
            if (mo1991h != 225) {
                j = mo1987d;
                skip = v00Var.skip(j);
            } else {
                return mo1987d;
            }
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder m8302v = ye0.m8302v("Unable to skip enough data, type: ", mo1991h, ", wanted to skip: ", mo1987d, ", but actually skipped: ");
            m8302v.append(skip);
            Log.d("DfltImageHeaderParser", m8302v.toString());
        }
        return -1;
    }

    /* renamed from: d */
    public static int m2346d(v00 v00Var, byte[] bArr, int i) {
        boolean z;
        ByteOrder byteOrder;
        int i2;
        int i3;
        int mo1992i = v00Var.mo1992i(i, bArr);
        if (mo1992i != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + mo1992i);
            }
            return -1;
        }
        short s = 1;
        int i4 = 0;
        byte[] bArr2 = f8865a;
        if (bArr != null && i > bArr2.length) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i5 = 0;
            while (true) {
                if (i5 >= bArr2.length) {
                    break;
                }
                if (bArr[i5] != bArr2[i5]) {
                    z = false;
                    break;
                }
                i5++;
            }
        }
        if (z) {
            u00 u00Var = new u00(bArr, i);
            short m7518c = u00Var.m7518c(6);
            if (m7518c != 18761) {
                if (m7518c != 19789) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) m7518c));
                    }
                    byteOrder = ByteOrder.BIG_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            ByteBuffer byteBuffer = u00Var.f27054a;
            byteBuffer.order(byteOrder);
            if (byteBuffer.remaining() - 10 >= 4) {
                i2 = byteBuffer.getInt(10);
            } else {
                i2 = -1;
            }
            short m7518c2 = u00Var.m7518c(i2 + 6);
            while (i4 < m7518c2) {
                int i6 = (i4 * 12) + i2 + 8;
                short m7518c3 = u00Var.m7518c(i6);
                if (m7518c3 == 274) {
                    short m7518c4 = u00Var.m7518c(i6 + 2);
                    if (m7518c4 >= s && m7518c4 <= 12) {
                        int i7 = i6 + 4;
                        if (byteBuffer.remaining() - i7 >= 4) {
                            i3 = byteBuffer.getInt(i7);
                        } else {
                            i3 = -1;
                        }
                        if (i3 < 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                        } else {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder m8302v = ye0.m8302v("Got tagIndex=", i4, " tagType=", m7518c3, " formatCode=");
                                m8302v.append((int) m7518c4);
                                m8302v.append(" componentCount=");
                                m8302v.append(i3);
                                Log.d("DfltImageHeaderParser", m8302v.toString());
                            }
                            int i8 = i3 + f8866b[m7518c4];
                            if (i8 > 4) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) m7518c4));
                                }
                            } else {
                                int i9 = i6 + 8;
                                if (i9 >= 0 && i9 <= byteBuffer.remaining()) {
                                    if (i8 >= 0 && i8 + i9 <= byteBuffer.remaining()) {
                                        return u00Var.m7518c(i9);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) m7518c3));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i9 + " tagType=" + ((int) m7518c3));
                                }
                            }
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) m7518c4));
                    }
                }
                i4++;
                s = 1;
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        return m2343a(new b01(11, (InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) {
        return m2344b(new b01(11, (InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) {
        return m2344b(new u00((ByteBuffer) Preconditions.checkNotNull(byteBuffer), 0));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) {
        return m2343a(new u00((ByteBuffer) Preconditions.checkNotNull(byteBuffer), 0), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }
}
