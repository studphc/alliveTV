package com.google.android.exoplayer2.text.cea;

import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Ascii;
import com.hisona.allive.CardPresenter;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.AbstractC1876ul;
import p000.C1589nl;
import p000.C1641ol;
import p000.C1802sl;
import p000.C1913vl;

/* loaded from: classes.dex */
public final class Cea608Decoder extends AbstractC1876ul {
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000;

    /* renamed from: h */
    public final int f11778h;

    /* renamed from: i */
    public final int f11779i;

    /* renamed from: j */
    public final int f11780j;

    /* renamed from: k */
    public final long f11781k;

    /* renamed from: n */
    public List f11784n;

    /* renamed from: o */
    public List f11785o;

    /* renamed from: p */
    public int f11786p;

    /* renamed from: q */
    public int f11787q;

    /* renamed from: r */
    public boolean f11788r;

    /* renamed from: s */
    public boolean f11789s;

    /* renamed from: t */
    public byte f11790t;

    /* renamed from: u */
    public byte f11791u;

    /* renamed from: w */
    public boolean f11793w;

    /* renamed from: x */
    public long f11794x;

    /* renamed from: y */
    public static final int[] f11775y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z */
    public static final int[] f11776z = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: A */
    public static final int[] f11769A = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};

    /* renamed from: B */
    public static final int[] f11770B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: C */
    public static final int[] f11771C = {174, CardPresenter.CARD_HEIGHT, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, HttpStatusCodesKt.HTTP_IM_USED, 234, 238, 244, 251};

    /* renamed from: D */
    public static final int[] f11772D = {193, HttpStatusCodesKt.HTTP_CREATED, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, HttpStatusCodesKt.HTTP_ACCEPTED, HttpStatusCodesKt.HTTP_NOT_AUTHORITATIVE, 235, HttpStatusCodesKt.HTTP_PARTIAL_CONTENT, HttpStatusCodesKt.HTTP_MULTI_STATUS, 239, 212, 217, 249, 219, 171, 187};

    /* renamed from: E */
    public static final int[] f11773E = {195, 227, HttpStatusCodesKt.HTTP_RESET_CONTENT, HttpStatusCodesKt.HTTP_NO_CONTENT, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: F */
    public static final boolean[] f11774F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g */
    public final ParsableByteArray f11777g = new ParsableByteArray();

    /* renamed from: l */
    public final ArrayList f11782l = new ArrayList();

    /* renamed from: m */
    public C1641ol f11783m = new C1641ol(0, 4);

    /* renamed from: v */
    public int f11792v = 0;

    public Cea608Decoder(String str, int i, long j) {
        long j2;
        int i2;
        if (j > 0) {
            j2 = j * 1000;
        } else {
            j2 = -9223372036854775807L;
        }
        this.f11781k = j2;
        if (MimeTypes.APPLICATION_MP4CEA608.equals(str)) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        this.f11778h = i2;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        Log.m3027w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                        this.f11780j = 0;
                        this.f11779i = 0;
                    } else {
                        this.f11780j = 1;
                        this.f11779i = 1;
                    }
                } else {
                    this.f11780j = 0;
                    this.f11779i = 1;
                }
            } else {
                this.f11780j = 1;
                this.f11779i = 0;
            }
        } else {
            this.f11780j = 0;
            this.f11779i = 0;
        }
        m2847c(0);
        m2846b();
        this.f11793w = true;
        this.f11794x = C0643C.TIME_UNSET;
    }

    /* renamed from: a */
    public final ArrayList m2845a() {
        ArrayList arrayList = this.f11782l;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            Cue m6684c = ((C1641ol) arrayList.get(i2)).m6684c(Integer.MIN_VALUE);
            arrayList2.add(m6684c);
            if (m6684c != null) {
                i = Math.min(i, m6684c.positionAnchor);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Cue cue = (Cue) arrayList2.get(i3);
            if (cue != null) {
                if (cue.positionAnchor != i) {
                    cue = (Cue) Assertions.checkNotNull(((C1641ol) arrayList.get(i3)).m6684c(i));
                }
                arrayList3.add(cue);
            }
        }
        return arrayList3;
    }

    /* renamed from: b */
    public final void m2846b() {
        C1641ol c1641ol = this.f11783m;
        c1641ol.f24805g = this.f11786p;
        c1641ol.f24799a.clear();
        c1641ol.f24800b.clear();
        c1641ol.f24801c.setLength(0);
        c1641ol.f24802d = 15;
        c1641ol.f24803e = 0;
        c1641ol.f24804f = 0;
        ArrayList arrayList = this.f11782l;
        arrayList.clear();
        arrayList.add(this.f11783m);
    }

    /* renamed from: c */
    public final void m2847c(int i) {
        int i2 = this.f11786p;
        if (i2 == i) {
            return;
        }
        this.f11786p = i;
        if (i == 3) {
            int i3 = 0;
            while (true) {
                ArrayList arrayList = this.f11782l;
                if (i3 < arrayList.size()) {
                    ((C1641ol) arrayList.get(i3)).f24805g = i;
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            m2846b();
            if (i2 == 3 || i == 1 || i == 0) {
                this.f11784n = Collections.emptyList();
            }
        }
    }

    @Override // p000.AbstractC1876ul
    public Subtitle createSubtitle() {
        List list = this.f11784n;
        this.f11785o = list;
        return new C1913vl(0, (List) Assertions.checkNotNull(list));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:125:0x01c9. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0089 A[SYNTHETIC] */
    @Override // p000.AbstractC1876ul
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte readUnsignedByte;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.f11777g;
        parsableByteArray.reset(array, limit);
        boolean z5 = false;
        while (true) {
            int bytesLeft = parsableByteArray.bytesLeft();
            int i3 = this.f11778h;
            if (bytesLeft >= i3) {
                if (i3 == 2) {
                    readUnsignedByte = -4;
                } else {
                    readUnsignedByte = (byte) parsableByteArray.readUnsignedByte();
                }
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                if ((readUnsignedByte & 2) == 0 && (readUnsignedByte & 1) == this.f11779i) {
                    byte b = (byte) (readUnsignedByte2 & 127);
                    byte b2 = (byte) (readUnsignedByte3 & 127);
                    if (b != 0 || b2 != 0) {
                        boolean z6 = this.f11788r;
                        if ((readUnsignedByte & 4) == 4) {
                            boolean[] zArr = f11774F;
                            if (zArr[readUnsignedByte2] && zArr[readUnsignedByte3]) {
                                z = true;
                                this.f11788r = z;
                                if (!z && (b & 240) == 16) {
                                    if (this.f11789s && this.f11790t == b && this.f11791u == b2) {
                                        this.f11789s = false;
                                    } else {
                                        this.f11789s = true;
                                        this.f11790t = b;
                                        this.f11791u = b2;
                                    }
                                } else {
                                    this.f11789s = false;
                                }
                                if (z) {
                                    if (z6) {
                                        m2846b();
                                        z5 = true;
                                    }
                                } else {
                                    if (1 <= b && b <= 15) {
                                        this.f11793w = false;
                                    } else if ((b & 247) == 20) {
                                        if (b2 != 32 && b2 != 47) {
                                            switch (b2) {
                                                case 37:
                                                case 38:
                                                case 39:
                                                    break;
                                                default:
                                                    switch (b2) {
                                                        case 42:
                                                        case 43:
                                                            this.f11793w = false;
                                                            break;
                                                    }
                                                    z5 = true;
                                                    break;
                                            }
                                        }
                                        this.f11793w = true;
                                    }
                                    if (this.f11793w) {
                                        int i4 = b & 224;
                                        if (i4 == 0) {
                                            this.f11792v = (b >> 3) & 1;
                                        }
                                        if (this.f11792v == this.f11780j) {
                                            if (i4 == 0) {
                                                int i5 = b & 247;
                                                if (i5 == 17 && (b2 & 240) == 48) {
                                                    this.f11783m.m6682a((char) f11771C[b2 & Ascii.f14464SI]);
                                                } else {
                                                    int i6 = b & 246;
                                                    if (i6 == 18 && (b2 & 224) == 32) {
                                                        this.f11783m.m6683b();
                                                        C1641ol c1641ol = this.f11783m;
                                                        if ((b & 1) == 0) {
                                                            i2 = f11772D[b2 & Ascii.f14467US];
                                                        } else {
                                                            i2 = f11773E[b2 & Ascii.f14467US];
                                                        }
                                                        c1641ol.m6682a((char) i2);
                                                    } else if (i5 == 17 && (b2 & 240) == 32) {
                                                        this.f11783m.m6682a(' ');
                                                        if ((b2 & 1) == 1) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        C1641ol c1641ol2 = this.f11783m;
                                                        c1641ol2.f24799a.add(new C1589nl((b2 >> 1) & 7, c1641ol2.f24801c.length(), z4));
                                                    } else if ((b & 240) == 16 && (b2 & 192) == 64) {
                                                        int i7 = f11775y[b & 7];
                                                        if ((b2 & 32) != 0) {
                                                            i7++;
                                                        }
                                                        C1641ol c1641ol3 = this.f11783m;
                                                        if (i7 != c1641ol3.f24802d) {
                                                            if (this.f11786p != 1 && !c1641ol3.m6686e()) {
                                                                C1641ol c1641ol4 = new C1641ol(this.f11786p, this.f11787q);
                                                                this.f11783m = c1641ol4;
                                                                this.f11782l.add(c1641ol4);
                                                            }
                                                            this.f11783m.f24802d = i7;
                                                        }
                                                        if ((b2 & Ascii.DLE) == 16) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if ((b2 & 1) == 1) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        int i8 = (b2 >> 1) & 7;
                                                        C1641ol c1641ol5 = this.f11783m;
                                                        if (z2) {
                                                            i = 8;
                                                        } else {
                                                            i = i8;
                                                        }
                                                        c1641ol5.f24799a.add(new C1589nl(i, c1641ol5.f24801c.length(), z3));
                                                        if (z2) {
                                                            this.f11783m.f24803e = f11776z[i8];
                                                        }
                                                    } else if (i5 == 23 && b2 >= 33 && b2 <= 35) {
                                                        this.f11783m.f24804f = b2 - 32;
                                                    } else if (i6 == 20 && (b2 & 240) == 32) {
                                                        if (b2 != 32) {
                                                            if (b2 != 41) {
                                                                switch (b2) {
                                                                    case 37:
                                                                        m2847c(1);
                                                                        this.f11787q = 2;
                                                                        this.f11783m.f24806h = 2;
                                                                        break;
                                                                    case 38:
                                                                        m2847c(1);
                                                                        this.f11787q = 3;
                                                                        this.f11783m.f24806h = 3;
                                                                        break;
                                                                    case 39:
                                                                        m2847c(1);
                                                                        this.f11787q = 4;
                                                                        this.f11783m.f24806h = 4;
                                                                        break;
                                                                    default:
                                                                        int i9 = this.f11786p;
                                                                        if (i9 != 0) {
                                                                            if (b2 != 33) {
                                                                                switch (b2) {
                                                                                    case 44:
                                                                                        this.f11784n = Collections.emptyList();
                                                                                        int i10 = this.f11786p;
                                                                                        if (i10 == 1 || i10 == 3) {
                                                                                            m2846b();
                                                                                            break;
                                                                                        }
                                                                                    case 45:
                                                                                        if (i9 == 1 && !this.f11783m.m6686e()) {
                                                                                            C1641ol c1641ol6 = this.f11783m;
                                                                                            ArrayList arrayList = c1641ol6.f24800b;
                                                                                            arrayList.add(c1641ol6.m6685d());
                                                                                            c1641ol6.f24801c.setLength(0);
                                                                                            c1641ol6.f24799a.clear();
                                                                                            int min = Math.min(c1641ol6.f24806h, c1641ol6.f24802d);
                                                                                            while (arrayList.size() >= min) {
                                                                                                arrayList.remove(0);
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                    case 46:
                                                                                        m2846b();
                                                                                        break;
                                                                                    case 47:
                                                                                        this.f11784n = m2845a();
                                                                                        m2846b();
                                                                                        break;
                                                                                }
                                                                            } else {
                                                                                this.f11783m.m6683b();
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                m2847c(3);
                                                            }
                                                        } else {
                                                            m2847c(2);
                                                        }
                                                    }
                                                }
                                            } else {
                                                C1641ol c1641ol7 = this.f11783m;
                                                int[] iArr = f11770B;
                                                c1641ol7.m6682a((char) iArr[(b & Byte.MAX_VALUE) - 32]);
                                                if ((b2 & 224) != 0) {
                                                    this.f11783m.m6682a((char) iArr[(b2 & Byte.MAX_VALUE) - 32]);
                                                }
                                            }
                                            z5 = true;
                                        }
                                    }
                                }
                            }
                        }
                        z = false;
                        this.f11788r = z;
                        if (!z) {
                        }
                        this.f11789s = false;
                        if (z) {
                        }
                    }
                }
            } else {
                if (z5) {
                    int i11 = this.f11786p;
                    if (i11 == 1 || i11 == 3) {
                        this.f11784n = m2845a();
                        this.f11794x = getPositionUs();
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleInputBuffer dequeueInputBuffer() {
        boolean z;
        if (this.f27310d == null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        ArrayDeque arrayDeque = this.f27307a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        C1802sl c1802sl = (C1802sl) arrayDeque.pollFirst();
        this.f27310d = c1802sl;
        return c1802sl;
    }

    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.f11784n = null;
        this.f11785o = null;
        m2847c(0);
        this.f11787q = 4;
        this.f11783m.f24806h = 4;
        m2846b();
        this.f11788r = false;
        this.f11789s = false;
        this.f11790t = (byte) 0;
        this.f11791u = (byte) 0;
        this.f11792v = 0;
        this.f11793w = true;
        this.f11794x = C0643C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // p000.AbstractC1876ul
    public boolean isNewSubtitleDataAvailable() {
        if (this.f11784n != this.f11785o) {
            return true;
        }
        return false;
    }

    @Override // p000.AbstractC1876ul
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        this.f27311e = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p000.AbstractC1876ul, com.google.android.exoplayer2.decoder.Decoder
    @Nullable
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        SubtitleOutputBuffer availableOutputBuffer;
        SubtitleOutputBuffer dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        long j = this.f11781k;
        if (j == C0643C.TIME_UNSET || this.f11794x == C0643C.TIME_UNSET || getPositionUs() - this.f11794x < j || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.f11784n = Collections.emptyList();
        this.f11794x = C0643C.TIME_UNSET;
        availableOutputBuffer.setContent(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }
}
